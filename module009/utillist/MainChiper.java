package module009.utillist;

public class MainChiper {

    public static void main(String[] args) {

        AlhorithmCaeser alhorithm = new AlhorithmCaeser();

        int key = 1;

        String string = "I love JAVA!!!";

        System.out.println(string);

        System.out.println(alhorithm.encode(string, key));

        System.out.println(alhorithm.decode(string, key));
    }
}

