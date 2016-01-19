package module008.listutils;

import com.sun.org.apache.xpath.internal.SourceTree;
import module008.file.File;

import java.util.List;

public class ListPrint {

    public static void printList(List<? extends Object> list) {

        list.stream().forEach(element -> System.out.println(element.toString()));
    }
}
