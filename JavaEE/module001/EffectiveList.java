package module001;

import java.util.List;
import java.util.ListIterator;
import java.util.Random;

public class EffectiveList {

    private List<Integer> list;
    private int size;
    private String name;
    private int experiments = 1;
    private long time = 0;

    public EffectiveList(List<Integer> list, int size, String name) {
        this.size = size;
        this.list = list;
        this.name = name;
    }

    private List<Integer> populateList(List<Integer> list) {
        list.clear();
        for (int i = 0; i < size; i++)
            list.add(i);
        return list;
    }

    public OutRow output(){
        list = populateList(list);
        return new OutRow(name, timeAdd(), timeGet(), timeRemove(), timeContains(), timePopulate(),
                timeIteratorAdd(), timeIteratorRemove());
    }

    public long timeAdd() {
        time = -System.currentTimeMillis();
        for (int i = 0; i < experiments; i++)
            for (int j = 0; j < size; j++)
                list.add(j);
        time += System.currentTimeMillis();
        return time / experiments;
    }

    public long timeGet() {
        time = -System.currentTimeMillis();
        for (int i = 0; i < experiments; i++)
            for (int j = 0; j < size; j++)
                list.get(j);
        time += System.currentTimeMillis();
        return time / experiments;
    }

    public long timeRemove() {
        time = -System.currentTimeMillis();
        for (int i = 0; i < experiments; i++)
            for (int j = 0; j < size; j++)
                list.remove(j);
        time += System.currentTimeMillis();
        return time / experiments;
    }

    public long timeContains() {
        time = -System.currentTimeMillis();
        for (int i = 0; i < experiments; i++)
            for (int j = 0; j < size; j++)
                list.contains(j);
        time += System.currentTimeMillis();
        return time / experiments;
    }

    public long timePopulate() {
        time = -System.currentTimeMillis();
        for (int i = 0; i < experiments; i++)
            populateList(list);
        time += System.currentTimeMillis();
        return time / experiments;
    }

    public long timeIteratorAdd() {
        ListIterator<Integer> iterator = list.listIterator();
        time = -System.currentTimeMillis();
        for (int i = 0; i < experiments; i++) {
            iterator.next();
            iterator.add(i);
        }
        time += System.currentTimeMillis();
        return time / experiments;
    }

    public long timeIteratorRemove() {
        ListIterator<Integer> iterator = list.listIterator();
        time = -System.currentTimeMillis();
        for (int i = 0; i < experiments; i++) {
            iterator.next();
            iterator.remove();
        }
        time += System.currentTimeMillis();
        return time / experiments;
    }
}