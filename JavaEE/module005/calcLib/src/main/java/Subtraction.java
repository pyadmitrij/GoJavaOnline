/**
 * Created by Dimon on 23.05.2016.
 */
public class Subtraction implements BinaryOperation {

    public boolean isUnary(){
        return false;
    }

    public double result(double left, double right) {
        return left - right;
    }
}
