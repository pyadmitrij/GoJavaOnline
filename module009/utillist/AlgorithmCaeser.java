package module009.utillist;

public class AlgorithmCaeser {

    public String encode(String text, int key) {
        char[] array = converToChar(text);
        for(int i = 0; i<array.length; i++)
            array[i] = (char) (int) (array[i] + key);
        return String.valueOf(array);
    }

    public String decode(String text, int key) {
        char[] array = converToChar(text);
        for(int i = 0; i<array.length; i++)
            array[i] = (char) (int) (array[i] - key);
        return String.valueOf(array);
    }

    private char[] converToChar(String text) {
        StringBuilder string = new StringBuilder();
        string.append(text);
        string.reverse();
        return string.toString().toCharArray();
    }
}

