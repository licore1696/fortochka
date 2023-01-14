package reader;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

import java.util.ArrayList;
import java.util.List;

public class ReaderXML implements Reader {
    private String fileName;
    private List<Variable> variables;
    private String expression;

    public ReaderXML(String fileName) {
        this.fileName = fileName;
        this.variables = new ArrayList<Variable>();
    }

    public void readFile() {
        try {
            File inputFile = new File(fileName);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            this.expression = doc.getElementsByTagName("expression").item(0).getTextContent();
            NodeList nList = doc.getElementsByTagName("variable");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    String name = eElement.getAttribute("name");
                    String value = eElement.getAttribute("value");
                    variables.add(new Variable(name, value));
                }
            }
            this.expression=replaceVariables(this.expression,this.getVariables());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Variable> getVariables() {
        return variables;
    }

    public String getExpression() {
        return expression;
    }

    public String replaceVariables(String expression, List<Variable> variables) {
        for(Variable variable : variables) {
            expression = expression.replace(variable.getName(), variable.getValue());
        }
        return expression;
    }

}