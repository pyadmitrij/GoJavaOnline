package module001;

public class OutRow {

    private Object o1;
    private Object o2;
    private Object o3;
    private Object o4;
    private Object o5;
    private Object o6;
    private Object o7;
    private Object o8;

    public OutRow(Object o1, Object o2, Object o3, Object o4, Object o5, Object o6, Object o7, Object o8) {
        this.o1 = o1;
        this.o2 = o2;
        this.o3 = o3;
        this.o4 = o4;
        this.o5 = o5;
        this.o6 = o6;
        this.o7 = o7;
        this.o8 = o8;
    }

    public Object getO1() {
        return o1;
    }

    public Object getO2() {
        return o2;
    }

    public Object getO3() {
        return o3;
    }

    public Object getO4() {
        return o4;
    }

    public Object getO5() {
        return o5;
    }

    public Object getO6() {
        return o6;
    }

    public Object getO7() {
        return o7;
    }

    public Object getO8() {
        return o8;
    }

    @Override
    public String toString() {
        return String.format("%15s %15s %15s %15s %15s %15s %15s %15s %n", o1, o2, o3, o4, o5, o6, o7, o8);
    }
}
