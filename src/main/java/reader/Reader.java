package reader;

import java.util.List;

public interface Reader {
    void readFile();
    List<Variable> getVariables();
    String replaceVariables(String expression, List<Variable> variables);
    String getExpression();
}