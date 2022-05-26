import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalTime;

public class Controller {

    private Core core;
    private Functions functions;
    public Controller(Core c, Functions f){
        core = c;
        functions = f;
    }

    public void init(){
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
            String encryptedMsg = functions.encrypt(msg, key);
            functions.sendMessage(encryptedMsg);

            core.mChatView.getChatTextArea().append(msg + "\n");
            core.mChatView.getMsgTxtField().setText("");
        });

        // Incoming Messages Listener


        // SecretKey Input Placeholder Listener
        core.mChatView.getSecretKey().addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                core.mChatView.getSecretKey().setText("");
            }
        });

    }
}
