package module010.utillist;

import java.io.FileNotFoundException;

public class MainChiper {

    public static void main(String[] args) throws FileNotFoundException {

        FileWorker worker = new FileWorker();
        AlgorithmCaesar algorithm = new AlgorithmCaesar();
        int key = 0;
        String fileName = "text.txt";

        String string = "I love JAVA!!!";
        System.out.println(string);

        string = algorithm.encode(string, key);
        System.out.println(string);
        worker.writeFile(fileName, string);

        string = worker.readFile(fileName);
        string = algorithm.decode(string, key);
        System.out.println(string);
    }
}

