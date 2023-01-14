package writer;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZIP {
    public static void archiveFile(String fileName,String name) {
        try (FileInputStream fileInputStream = new FileInputStream(fileName);
             FileOutputStream fileOutputStream = new FileOutputStream(name + ".zip");
             ZipOutputStream zipOutputStream = new ZipOutputStream(fileOutputStream)) {

            ZipEntry zipEntry = new ZipEntry(fileName);
            zipOutputStream.putNextEntry(zipEntry);

            byte[] buffer = new byte[1024];
            int length;

            while ((length = fileInputStream.read(buffer)) > 0)
            {
                zipOutputStream.write(buffer, 0, length);
            }
            System.out.println("File archived successfully to " + name + ".zip");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}