package reader;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipInputStream;
import java.util.zip.*;

public class UnzipFile {

    public static String unzip(String fileName) {
        byte[] buffer = new byte[1024];
        String newFileName = null;
        try {
            //get the zip file content
            ZipInputStream zis =
                    new ZipInputStream(new FileInputStream(fileName));
            //get the first entry
            ZipEntry ze = zis.getNextEntry();
            newFileName = ze.getName();
            FileOutputStream fos = new FileOutputStream(newFileName);

            int len;
            while ((len = zis.read(buffer)) > 0) {
                fos.write(buffer, 0, len);
            }

            fos.close();
            zis.closeEntry();
            zis.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return newFileName;
    }
}