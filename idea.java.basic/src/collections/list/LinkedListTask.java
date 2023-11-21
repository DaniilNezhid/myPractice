package collections.list;

import java.util.*;

public class LinkedListTask {

    private List<String> myList = new LinkedList<>();

    public void addString(String text) {
        myList.add(text);
    }

    public List<String> removeDuplicate(List<String> list) {
        List<String> collectList = Collections.emptyList();
        if (!(list.isEmpty())) {
           collectList = list.stream().distinct().toList();
        }
        return collectList;
    }

    public static void main(String[] args) {

        LinkedListTask test = new LinkedListTask();

        test.addString("b Hello Two");
        test.addString("b Hello Two");
        test.addString("c Hello One");
        test.addString("a Hello Three");

        List<String> strings = test.removeDuplicate(test.myList);
        System.out.println(strings);


        Collections.sort(test.myList);

        System.out.println(test.myList);
    }

}