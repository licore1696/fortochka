import reader.*;
import writer.*;
import java.util.*;
import Calc.*;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the file name: ");
        String fileName = scanner.nextLine();
        String fileExtension = fileName.substring(fileName.lastIndexOf(".") + 1);

        if(fileExtension.equals("zip")){fileName=UnzipFile.unzip(fileName);fileExtension = fileName.substring(fileName.lastIndexOf(".") + 1);}
        System.out.println("File encrypted?(y/n)");
        String enc=scanner.nextLine();
        if(enc.equalsIgnoreCase("y")){

            String key="PeShVmYq3t6w9z$C&F)J@NcQfTjWnZr4";//scanner.nextLine();
            FileDecrypter.decryptFile(fileName,key);
            fileExtension = fileName.substring(fileName.lastIndexOf(".") + 1);

}
        String expression="";
        if (fileExtension.equalsIgnoreCase("txt")) {
            Reader  reader = new ReaderTXT(fileName);
            reader.readFile();
            expression = reader.getExpression();

            System.out.println("Expression: " + expression);

        } else if (fileExtension.equalsIgnoreCase("xml")) {
            Reader  reader = new ReaderXML(fileName);
            reader.readFile();
            expression = reader.getExpression();

            System.out.println("Expression: " + expression);

        } else if (fileExtension.equalsIgnoreCase("json")) {
           Reader  reader = new ReaderJSON(fileName);
            reader.readFile();
            expression = reader.getExpression();

            System.out.println("Expression: " + expression);

        }

        expression= Proces.CALC(expression);

        System.out.println("Enter file name with extension:");
        String fileName1 = scanner.nextLine();
        String[] parts = fileName1.split("\\.");
        String name = parts[0];
        String extension2 = parts[1];
        System.out.println("File name: " + name);
        System.out.println("File extension: " + extension2);

        if (extension2.equalsIgnoreCase("txt")) {
            FileHandler.writeToTXT(expression,name);

        } else if (extension2.equalsIgnoreCase("json")) {
            FileHandler.writeToJSON(expression, name);

        } else if (extension2.equalsIgnoreCase("xml")) {
            FileHandler.writeToXML(expression, name);

        } else {
            System.out.println("Invalid file extension. Supported extensions are: txt, json, xml.");
        }
        System.out.println("Do you want to compress file?(y/n)");
        String choice=scanner.nextLine();
        if(choice.equalsIgnoreCase("y")){
            ZIP.archiveFile(fileName1,name);
        }
        System.out.println("Do you want to encrypt the file?(y/n)");
        String wr_enc=scanner.nextLine();
        if(wr_enc.equalsIgnoreCase("y")){
            System.out.println("write a key");
            String code="PeShVmYq3t6w9z$C&F)J@NcQfTjWnZr4"; //scanner.nextLine();
            FileEncrypter.encryptFile(fileName1, code);

        }

    }}


