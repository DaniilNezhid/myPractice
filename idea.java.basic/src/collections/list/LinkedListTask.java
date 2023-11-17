package collections.list;

import java.util.*;

public class LinkedListTask {

    private List<String> myList = new LinkedList<>();

    public void addString(String text) {
        myList.add(text);
    }

    public void removeDuplicate(List<String> list) {
        if (!(list.isEmpty())) {
            Set<String> noDuplicate = new HashSet<>(list);
            list.clear();
            list.addAll(noDuplicate);
        }
    }

    public static void main(String[] args) {

        LinkedListTask test = new LinkedListTask();

        test.addString("b Hello Two");
        test.addString("b Hello Two");
        test.addString("c Hello One");
        test.addString("a Hello Three");

        test.removeDuplicate(test.myList);

        Collections.sort(test.myList);

        System.out.println(test.myList);
    }

}