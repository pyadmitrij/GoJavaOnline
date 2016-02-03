package module008.utillist;

import java.util.List;

public class ListPrintSort<T> {

    public void printList(List<T> list) {
        int[] index = {0};
        list
                .stream()
                .forEach(element -> System.out.println(index[0]++ + " - " + String.valueOf(element)));
    }

    public List<T> sortList(List<T> list) {

        for (int i = 0; i < list.size(); i++)
            for (int j = i + 1; j < list.size(); j++) {
                String name1 = list.get(i).toString();
                String name2 = list.get(j).toString();
                if (name1.compareTo(name2) > 0) {
                    T temp = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, temp);
                }
            }
        return list;
    }
}
