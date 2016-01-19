package module008.listutils;

import module008.file.File;

import java.util.List;

public class ListSort {

    public static List<File> sortList(List<File> list) {
        for(int i=0; i<list.size(); i++)
            for(int j=i+1; j<list.size(); j++) {
                String name1 = list.get(i).toString();
                String name2 = list.get(j).toString();

                if(name1.compareTo(name2) > 0) {
                    File temp = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, temp);
                }
            }
        return list;
    }
}
