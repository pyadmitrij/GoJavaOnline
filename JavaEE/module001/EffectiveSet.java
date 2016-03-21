package module001;

import java.util.Random;
import java.util.Set;

public class EffectiveSet {

    private Set<Integer> set;
    private int size;
    private String name;
    private int experiments = 1;
    private long time = 0;

    private Random random = new Random();
    private int value = random.nextInt();

    public EffectiveSet(Set<Integer> set, int size, String name) {
        this.set = set;
        this.size = size;
        this.name = name;
    }

    private Set<Integer> populateSet(Set<Integer> set) {
        set.clear();
        for (int i = 0; i < size; i++)
            set.add(i);
        return set;
    }

    public OutRow output() {
        set = populateSet(set);
        return new OutRow(name, timeAdd(), null, timeRemove(), timeContains(), timePopulate(), null, null);
    }

    public long timeAdd() {
        time = -System.currentTimeMillis();
        for (int i = 0; i < experiments; i++)
            for (int j = 0; j < size; j++)
                set.add(j);
        time += System.currentTimeMillis();
        return time / experiments;
    }

    public long timeRemove() {
        time = -System.currentTimeMillis();
        for (int i = 0; i < experiments; i++)
            for (int j = 0; j < size; j++)
                set.remove(j);
        time += System.currentTimeMillis();
        return time / experiments;
    }

    public long timeContains() {
        time = -System.currentTimeMillis();
        for (int i = 0; i < experiments; i++)
            set.contains(i);
        time += System.currentTimeMillis();
        return time / experiments;
    }

    public long timePopulate() {
        time = -System.currentTimeMillis();
        for (int i = 0; i < experiments; i++)
            populateSet(set);
        time += System.currentTimeMillis();
        return time / experiments;
    }
}
