import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.DataOutputStream;
import java.math.BigInteger;
import java.net.Socket;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Base64;

public class Functions {

    public Functions(){

    }

    public byte[] hashPassword(String pwd){
        String hashedText = "";
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(pwd.getBytes());
            BigInteger no = new BigInteger(1, messageDigest);
            hashedText = no.toString(16);
            while (hashedText.length() < 32) {
                hashedText = "0" + hashedText;
            }

        } catch (Exception e) {
            System.err.println(e.toString());
        }

        return hashedText.getBytes();
    }

    public String encrypt(byte[] data, byte[] pwd){
        byte[] encryptedData = null;

        try{
            Cipher mCipher = Cipher.getInstance(Constants.SELECTED_CIPHER);
            SecretKey mKey = new SecretKeySpec(pwd, "AES");
            mCipher.init(Cipher.ENCRYPT_MODE, mKey);
            encryptedData = mCipher.doFinal(data);
            encryptedData = Base64.getEncoder().encode(encryptedData);
        }catch(Exception e){
            System.err.println(e.toString());
        }

        return new String(encryptedData);
    }

    public String decrypt(byte[] data, byte[] pwd){
        byte[] decryptedData = null;

        try{
            Cipher mCipher = Cipher.getInstance(Constants.SELECTED_CIPHER);
            SecretKey mKey = new SecretKeySpec(pwd, "AES");
            mCipher.init(Cipher.DECRYPT_MODE, mKey);
            decryptedData = mCipher.doFinal(data);
        }catch(Exception e){
            System.out.println(e.toString());
        }
        return new String(decryptedData);
    }

    public void sendMessage(String msg){
        Constants.wait = true;
        try{
            Socket mSocket = new Socket("localhost", Constants.SERVER_SOCKET);
            DataOutputStream outputStream = new DataOutputStream(mSocket.getOutputStream());
            outputStream.writeUTF(msg);
            outputStream.close();
            mSocket.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
