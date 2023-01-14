package reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import java.io.IOException;

public class ReaderTXT implements Reader{
    private String fileName;
    private String expression;
    private List<Variable> variables;

    public ReaderTXT(String fileName) {
        this.fileName = fileName;
        this.variables = new ArrayList<Variable>();
    }

    public void readFile() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            this.expression = br.readLine();
            String[] variableNames = br.readLine().split(" ");
            String[] variableValues = br.readLine().split(" ");
            for (int i = 0; i < variableNames.length; i++) {
                variables.add(new Variable(variableNames[i], variableValues[i]));
            }
            this.expression=replaceVariables(this.expression,this.getVariables());
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public String getExpression() {
        return expression;
    }

    public List<Variable> getVariables() {
        return variables;
    }
    public String replaceVariables(String expression, List<Variable> variables) {
        for(Variable variable : variables) {
            expression = expression.replace(variable.getName(), variable.getValue());
        }
        return expression;
    }
}