import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Base64;

public class Functions {

    private SecretKeySpec secretKey;
    private byte[] key;

    public Functions(){

    }

    private void prepareKey(String k){
        MessageDigest sha = null;
        try {
            key = k.getBytes("UTF-8");
            sha = MessageDigest.getInstance("SHA-1");
            key = sha.digest(key);
            key = Arrays.copyOf(key, 16);
            secretKey = new SecretKeySpec(key, "AES");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String encrypt(String msg, String k){
        try{
            prepareKey(k);
            Cipher cipher = Cipher.getInstance(Constants.SELECTED_CIPHER);
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            return Base64.getEncoder().encodeToString(cipher.doFinal(msg.getBytes("UTF-8")));
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public String decrypt(String msg, String k){
        try{
            prepareKey(k);
            Cipher cipher = Cipher.getInstance(Constants.SELECTED_CIPHER);
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            return new String(cipher.doFinal(Base64.getDecoder().decode(msg)));
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public void sendMessage(String msg){

    }
}
