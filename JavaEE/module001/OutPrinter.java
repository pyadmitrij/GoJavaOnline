package module001;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class OutPrinter {

    public static void printToConsole(Map<Object, OutRow> result) {
        for (OutRow row : result.values()) {
            System.out.print(row.toString());
        }
    }

    public static void printToFile(Map<Object, OutRow> result, String fileName, String dir) throws IOException {

        FileWriter outputFile = new FileWriter(new File(dir, fileName));

        for (OutRow row : result.values()) {
            outputFile.write(row.toString());
        }

        outputFile.close();
    }
}
