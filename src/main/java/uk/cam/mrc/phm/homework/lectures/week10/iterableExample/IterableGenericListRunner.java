package uk.cam.mrc.phm.homework.lectures.week10.iterableExample;

import java.util.Iterator;

public class IterableGenericListRunner {
    public static void main(String[] args) {
        IterableGenericList<String> stringList = new IterableGenericList<>();
        stringList.add("a");
        stringList.add("b");
        stringList.add("c");

        //for-each loop
        for (String item : stringList) {
            System.out.println(item);
        }

        //Iterator alternative
        for (Iterator<String> it = stringList.iterator(); it.hasNext(); ) {
            String next = it.next();
            System.out.println(next);
        }

        //Todo - please write a while loop and use hasNext() and next() methods to print the stringList
        int i = 0;
        while (i < stringList.count) {
            System.out.println(stringList.get(i));
            i++;
        }

        // actual answer
        Iterator<String> it = stringList.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
