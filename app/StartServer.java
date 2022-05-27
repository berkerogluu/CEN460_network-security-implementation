import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class StartServer {

    public static void main(String[] args){
        System.out.println("Server Started!");

        String input = "";
        try {
            ServerSocket mServer = new ServerSocket(Constants.SERVER_SOCKET);
            while(true) {
                Socket mSocket = mServer.accept();
                DataOutputStream outputStream = new DataOutputStream(mSocket.getOutputStream());
                DataInputStream inputStream = new DataInputStream(new BufferedInputStream(mSocket.getInputStream()));

                while (true) {
                    inputStream.mark(1);
                    if (inputStream.read() == -1) break;
                    inputStream.reset();
                    input = inputStream.readUTF();
                    outputStream.writeUTF(input);

                    System.out.println(input);
                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
