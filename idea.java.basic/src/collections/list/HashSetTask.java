package collections.list;
import java.util.Set;
import java.util.HashSet;

public class HashSetTask {
    private Set<Object> myHashSet = new HashSet<>();

    private void deleteEvenNumbers(Set<Object> list) {
        if (!(list.isEmpty())) {
            list.removeIf(o -> (o instanceof Number) && ((int) o % 2 == 0));
        }
    }

    private void check(Set<Object> list, Object o) {
        boolean notFound = false;
        if (!(list.isEmpty())) {
            for (Object object : list) {
                if (o.equals(object)) {
                    System.out.println("We found: " + object);
                    notFound = true;
                    break;
                }
            }
            if (!(notFound)) {
                System.out.println("Not found");
            }
        }
    }

    private void addObject(Object o) {
        myHashSet.add(o);
    }

    public static void main(String[] args) {
        HashSetTask test = new HashSetTask();

        test.addObject(1029);
        test.addObject(9);
        test.addObject(147029);
        test.addObject(100);
        test.addObject(250);
        test.addObject(200000);

        test.addObject("String 1");
        test.addObject("String 2");
        test.addObject("String 3");

        test.check(test.myHashSet, 9);

        System.out.println("Before " + test.myHashSet);

        test.deleteEvenNumbers(test.myHashSet);

        System.out.println("After " + test.myHashSet);
    }
}
