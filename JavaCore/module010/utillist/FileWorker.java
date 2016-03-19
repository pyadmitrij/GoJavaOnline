package module010.utillist;

import java.io.*;

public class FileWorker {

    public void writeFile(String fileName, String text) {
        File file = new File(fileName);
        try {
            if(!file.exists())
                file.createNewFile();
            PrintWriter out = new PrintWriter(file.getAbsoluteFile());
            try {
                out.print(text);
            }
            finally {
                out.close();
            }
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String readFile(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        StringBuilder sb = new StringBuilder();
        existsFile(fileName);
        try {
            BufferedReader in = new BufferedReader(new FileReader(file.getAbsoluteFile()));
            try {
                String str;
                while ((str = in.readLine()) != null) {
                    sb.append(str);
                }
            }
            finally {
                in.close();
            }
        } catch (IOException e) {
            throw new RuntimeException();
        }
        return sb.toString();
    }

    public void existsFile(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        if(!file.exists())
            throw new FileNotFoundException(file.getName());
    }
}
