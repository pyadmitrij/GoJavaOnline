import java.util.HashMap;
import java.util.Map;

public class BaseCalculator implements Calculator {

    private Map<Character, Operation> operations = new HashMap<>();
    BinaryOperation binOperation;
    UnaryOperation unaryOperation;
    StringBuilder left = new StringBuilder();
    StringBuilder right = new StringBuilder();
    StringBuilder answer = new StringBuilder();
    boolean isLeftFinished = false;
    boolean isRightFinished = false;
    boolean isLeftStarted = false;
    boolean isRightStarted = false;
    boolean noLeftDigitSpotted = false;

    {
        operations.put('+', new Addition());
        operations.put('-', new Subtraction());
    }

    public void read(String expression) {
        answer.append(expression);
        answer.append(" = ");

        for (int i = 0; i < expression.length(); i++) {
            char currentChar = expression.charAt(i);
            if (currentChar >= '0' && currentChar <= '9') {
                if (isLeftFinished || noLeftDigitSpotted) {
                    right.append(currentChar);
                    isRightStarted = true;
                } else {
                    left.append(currentChar);
                    isLeftStarted = true;
                }
            } else if (operations.containsKey(currentChar)) {
                if (isLeftStarted) {
                    isLeftFinished = true;
                } else {
                    noLeftDigitSpotted = true;
                }
                if (operations.get(currentChar).isUnary())
                    unaryOperation = (UnaryOperation) operations.get(currentChar);
                else
                    binOperation = (BinaryOperation) operations.get(currentChar);
            }
        }
    }

    public void addOperation(Character character, Operation newOperation) {
        operations.put(character, newOperation);
    }

    public String getResult() {
        if (unaryOperation != null && noLeftDigitSpotted) {

            answer.append(unaryOperation.result(Double.valueOf(right.toString())));
        } else if (unaryOperation != null && isLeftFinished) {
            answer.append("Wrong expression");
        } else if (binOperation != null && isLeftFinished && isRightStarted) {
            answer.append(binOperation.result(Double.valueOf(left.toString()), Double.valueOf(right.toString())));
        } else {
            answer.append("Wrong expression");
        }
        return answer.toString();
    }
}
