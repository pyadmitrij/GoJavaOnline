package module001;

import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String... str) throws IOException {
        int size = 1000000;
        String dir = "D:\\MyProject\\GoJavaEnterprise\\src\\module001";
        String fileName = String.valueOf(size) + ".txt";
        Map<Object, OutRow> temp = effectiveCollection(size);
        OutPrinter.printToConsole(temp);
        OutPrinter.printToFile(temp, fileName, dir);
    }

    public static Map<Object, OutRow> effectiveCollection(int size) {

        List<Integer> arrayList = new ArrayList<Integer>();
        List<Integer> linkedList = new LinkedList<Integer>();
        Set<Integer> hashSet = new HashSet<Integer>();
        Set<Integer> treeSet = new TreeSet<Integer>();

        OutRow arrayListResult = new EffectiveList(arrayList, size, "ArrayList").output();
        OutRow linkedListResult = new EffectiveList(linkedList, size, "LinkedList").output();
        OutRow hashSetResult = new EffectiveSet(hashSet, size, "HashSet").output();
        OutRow treeSetResult = new EffectiveSet(treeSet, size, "TreeSet").output();

        Map<Object, OutRow> result = new LinkedHashMap<Object, OutRow>();

        OutRow names = new OutRow("Type of array", "add", "get", "remove", "contains", "populate", "iterator.add",
                "iterator.remove");
        result.put(names.getO1(), names);
        result.put(arrayListResult.getO1(), arrayListResult);
        result.put(linkedListResult.getO1(), linkedListResult);
        result.put(hashSetResult.getO1(), hashSetResult);
        result.put(treeSetResult.getO1(), treeSetResult);

        return result;
    }
}
