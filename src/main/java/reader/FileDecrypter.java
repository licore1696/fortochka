package reader;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.spec.SecretKeySpec;

public class FileDecrypter {
    public static String decryptFile(String fileName, String key) {
        try {
            SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);

            String originalFileName = fileName.substring(0, fileName.lastIndexOf(".enc"));
            try (FileInputStream fileInputStream = new FileInputStream(fileName);
                 FileOutputStream fileOutputStream = new FileOutputStream(originalFileName)) {

                byte[] input = new byte[64];
                int bytesRead;

                while ((bytesRead = fileInputStream.read(input)) != -1) {
                    byte[] output = cipher.update(input, 0, bytesRead);
                    if (output != null) {
                        fileOutputStream.write(output);
                    }
                }
                byte[] output = cipher.doFinal();
                if (output != null) {
                    fileOutputStream.write(output);
                }
                System.out.println("File decrypted successfully and saved as " + originalFileName);
                return originalFileName;
            }
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException e) {
            System.out.println("Invalid key or algorithm used for decryption: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error reading or writing to file: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("An error occurred during decryption: " + e.getMessage());
        }
   return fileName;
    }
}