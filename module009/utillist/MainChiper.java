package module009.utillist;

public class MainChiper {

    public static void main(String[] args) {

        AlgorithmCaeser algorithm = new AlgorithmCaeser();
        int key = 0;

        String string = "I love JAVA!!!";
        System.out.println(string);

        string = algorithm.encode(string, key);
        System.out.println(string);

        string = algorithm.decode(string, key);
        System.out.println(string);
    }
}

