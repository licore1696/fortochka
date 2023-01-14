package reader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReaderJSON implements Reader{
    private String fileName;
    private List<Variable> variables;
    private String expression;

    public ReaderJSON(String fileName) {
        this.fileName = fileName;
        this.variables = new ArrayList<Variable>();
    }

    public void readFile() {
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader(fileName));
            JSONObject jsonObject = (JSONObject) obj;
            this.expression = (String) jsonObject.get("expression");
            org.json.simple.JSONArray jsonVariables = (org.json.simple.JSONArray) jsonObject.get("variables");
            for (Object o : jsonVariables) {
                JSONObject jsonVariable = (JSONObject) o;
                String name = (String) jsonVariable.get("name");
                String value = (String) jsonVariable.get("value");
                variables.add(new Variable(name, value));
            }
            this.expression=replaceVariables(this.expression,this.getVariables());
        } catch (IOException | ParseException e) {
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