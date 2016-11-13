package io.github.satr.training;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomValueGenerator {
    private final int range;
    private Random random = new Random();
    private List<Integer> list = new ArrayList<>();

    public RandomValueGenerator(int treeHeight) {
        list.add(0);//exclude 0
        range = ((Double)(Math.pow(2, treeHeight) * 2f)).intValue() + 10;
    }

    public int getRange() {
        return range;
    }

    public int getNextValue() {
        for(;;) {
            int value = random.nextInt(range);
            if(!list.contains(value))
            {
                list.add(value);
                return value;
            }
        }
    }
}
