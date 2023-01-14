package writer;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.Key;

public class FileEncrypter {
    public static void encryptFile(String fileName, String key) {
        try (FileInputStream fileInputStream = new FileInputStream(fileName);
             FileOutputStream fileOutputStream = new FileOutputStream(fileName + ".enc")) {

            Key secretKey = new SecretKeySpec(key.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);

            byte[] input = new byte[64];
            int bytesRead;

            while ((bytesRead = fileInputStream.read(input)) != -1) {
                byte[] output = cipher.update(input, 0, bytesRead);
                if (output != null)
                    fileOutputStream.write(output);
            }

            byte[] output = cipher.doFinal();
            if (output != null)
                fileOutputStream.write(output);

            System.out.println("File encrypted successfully and saved as " + fileName + ".enc");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}