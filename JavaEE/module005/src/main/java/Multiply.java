public class Multiply implements BinaryOperation {

    @Override
    public double result(double v, double v1) {
        return v*v1;
    }

    @Override
    public boolean isUnary() {
        return false;
    }
}