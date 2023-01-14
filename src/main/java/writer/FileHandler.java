package writer;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class FileHandler {
    public static void writeToTXT(String string, String fileName) {
        try (FileWriter file = new FileWriter(fileName + ".txt")) {
            file.write(string);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeToJSON(String string, String fileName) {
        ObjectMapper mapper = new ObjectMapper();
        try (FileWriter file = new FileWriter(fileName + ".json")) {
            mapper.writeValue(file, string);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeToXML(String string, String fileName) {
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.newDocument();
            Element rootElement = doc.createElement("answer");
            rootElement.appendChild(doc.createTextNode(string));
            doc.appendChild(rootElement);
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(fileName + ".xml"));
            transformer.transform(source, result);
        } catch (ParserConfigurationException | TransformerException e) {
            e.printStackTrace();
        }

    }
}