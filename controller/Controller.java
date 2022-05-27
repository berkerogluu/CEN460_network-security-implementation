import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.time.LocalTime;
import java.util.Base64;
import java.util.Timer;
import java.util.TimerTask;

public class Controller {

    private Core core;
    private Functions functions;
    private Socket mSocket;

    public Controller(Core c, Functions f){
        core = c;
        functions = f;
    }

    public void init(){
        // Default Cipher
        Constants.SELECTED_CIPHER = Constants.CIPHER_ECB;

        core.mChatView.getECBSetBtn().addActionListener(e ->{
            Constants.SELECTED_CIPHER = Constants.CIPHER_ECB;
            core.mChatView.getLblCipherType().setText("Selected Cipher-> ECB");
        });

        core.mChatView.getCBCSetBtn().addActionListener(e->{
            Constants.SELECTED_CIPHER = Constants.CIPHER_CBC;
            core.mChatView.getLblCipherType().setText("Selected Cipher-> CBC");
        });

        // Send Message Button Listener
        core.mChatView.getSendButton().addActionListener(e->{
            String key = core.mChatView.getSecretKey().getText();
            String msg = core.mChatView.getMsgTxtField().getText();

            // Encrypt Message and Send
            String encryptedMsg = functions.encrypt(msg.getBytes(), functions.hashPassword(key));
            sendMessage(encryptedMsg);
            core.mChatView.getMsgTxtField().setText("");
        });

        // Incoming Message Listener (using threads to avoid gui break)
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    mSocket = new Socket("localhost", Constants.SERVER_SOCKET);
                    while(true) {
                        DataInputStream inputStream = new DataInputStream(new BufferedInputStream(mSocket.getInputStream()));
                        //core.mChatView.getChatTextArea().append(inputStream.readUTF() + "\n");
                        //core.mChatView.getChatTextArea().append(functions.decrypt(inputStream.readAllBytes(), core.mChatView.getSecretKey().getText().getBytes()));
                        System.out.println(functions.decrypt(Base64.getDecoder().decode(inputStream.readUTF().getBytes()), core.mChatView.getSecretKey().getText().getBytes()));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();

        // SecretKey Input Placeholder Listener
        core.mChatView.getSecretKey().addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                core.mChatView.getSecretKey().setText("");
            }
        });
    }

    public void sendMessage(String msg){
        try{
            //Socket mSocket = new Socket("localhost", Constants.SERVER_SOCKET);
            DataOutputStream outputStream = new DataOutputStream(mSocket.getOutputStream());
            outputStream.writeUTF(msg);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
