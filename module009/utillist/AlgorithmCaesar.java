package module009.utillist;

public class AlgorithmCaesar {

    public String encode(String text, char key) {
        char[] array = convertToChar(text);
        for(int i = 0; i<array.length; i++)
            array[i] = (char) (int) (array[i] + key);
        return String.valueOf(array);
    }

    public String decode(String text, char key) {
        char[] array = convertToChar(text);
        for(int i = 0; i<array.length; i++)
            array[i] = (char) (int) (array[i] - key);
        return String.valueOf(array);
    }

    private char[] convertToChar(String text) {
        StringBuilder string = new StringBuilder();
        string.append(text);
        string.reverse();
        return string.toString().toCharArray();
    }
}

