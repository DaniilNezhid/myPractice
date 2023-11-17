package collections.list;
import java.util.List;
import java.util.ArrayList;

public class ArrayListTask {
    private List<Object> myList = new ArrayList<>();

    private void removeString(List<Object> list) {
        list.removeIf(object -> object instanceof String);
    }

    private void removeNumber(List<Object> list) {
        list.removeIf(object -> object instanceof Number);
    }

    private void removeObject(List<Object> list, Class<?> type) {
        list.removeIf(object -> type.isInstance(object));
    }

    private void swapFirstAndLastElement(List<Object> list) {
        if (!(list.isEmpty())) {
            Object swap = list.get(0);
            list.set(0, list.get(list.size() - 1));
            list.set(list.size() - 1, swap);
        } else System.out.println("Your collection is empty!");
    }

    private void addObject(Object o) {
        myList.add(o);
    }

    public static void main(String[] args) {
        ArrayListTask test = new ArrayListTask();

        ArrayListTask object1 = new ArrayListTask();
        ArrayListTask object2 = new ArrayListTask();
        ArrayListTask object3 = new ArrayListTask();

        test.addObject(object1);
        test.addObject(object2);
        test.addObject(object3);

        test.addObject(1029);
        test.addObject(9);
        test.addObject(147029);

        test.addObject("String 1");
        test.addObject("String 2");
        test.addObject("String 3");

        test.swapFirstAndLastElement(test.myList);

        System.out.println("Before " + test.myList);

        test.removeObject(test.myList, ArrayListTask.class);
        test.removeNumber(test.myList);
        test.removeString(test.myList);

        System.out.println("After " + test.myList);
    }
}
