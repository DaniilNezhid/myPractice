package collections.list;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class HashMapTask {
    private Map<String, ArrayList<Integer>> journal = new HashMap<>();

    private void addStudentAndRateIt(String nameStudent, int rate) {
        if (rate > 5) {
            rate = 5;
        }
        if (journal.containsKey(nameStudent)) {
            ArrayList<Integer> scores = journal.get(nameStudent);
            scores.add(rate);
        } else {
            ArrayList<Integer> scores = new ArrayList<>();
            scores.add(rate);
            journal.put(nameStudent, scores);
        }

    }

    private double average(String nameStudent) {
        double sumNumber = 0;
        if (journal.containsKey(nameStudent)) {
            ArrayList<Integer> scores = journal.get(nameStudent);
            for (int number : scores) {
                sumNumber += number;
            }
            double averageScore = sumNumber / scores.size();
            System.out.println(averageScore);
            return averageScore;
        } else {
            System.out.println("There's no such student!");
            return sumNumber;
        }
    }

    public static void main(String[] args) {
        HashMapTask test = new HashMapTask();

        test.addStudentAndRateIt("Lisa", 5);
        test.addStudentAndRateIt("Oleg", 4);
        test.addStudentAndRateIt("Lilia", 3);
        test.addStudentAndRateIt("Jack", 4);
        test.addStudentAndRateIt("Bob", 4);
        test.addStudentAndRateIt("Bob", 5);

        test.average("Bob");

        System.out.println(test.journal);
    }
}
