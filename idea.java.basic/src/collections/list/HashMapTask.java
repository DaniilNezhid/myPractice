package collections.list;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.stream.IntStream;

public class HashMapTask {
    private static final int HIGH_VALUE = 5;
    private Map<String, ArrayList<Integer>> journal = new HashMap<>();

    private void addStudentAndRateIt(String nameStudent, int rate) {
        ArrayList<Integer> scores;
        if (rate > HIGH_VALUE) {
            rate = HIGH_VALUE;
        }

        scores = getStudentScores(nameStudent);
        scores.add(rate);

        journal.put(nameStudent, scores);

    }

    private ArrayList<Integer> getStudentScores(String nameStudent) {
        ArrayList<Integer> scores;
        if (journal.containsKey(nameStudent)) {
            scores = journal.get(nameStudent);
        } else {
            scores = new ArrayList<>();
        }
        return scores;
    }

    private double average(String studentName) {
        double sumNumber = 0;
        if (journal.containsKey(studentName)) {
            OptionalDouble average = journal.get(studentName).stream()
                    .mapToDouble(m -> m)
                    .average();

            if (average.isPresent()) {
                System.out.println(average.getAsDouble());
            }
            return average.getAsDouble();
        } else {
            System.out.println("There's no such student!");
            return sumNumber;
        }
    }

    public static void main(String[] args) {
        HashMapTask test = new HashMapTask();

        test.addStudentAndRateIt("Lisa", HIGH_VALUE);
        test.addStudentAndRateIt("Oleg", 4);
        test.addStudentAndRateIt("Lilia", 3);
        test.addStudentAndRateIt("Jack", 4);
        test.addStudentAndRateIt("Bob", 4);
        test.addStudentAndRateIt("Bob", HIGH_VALUE);

        test.average("Bob");

        System.out.println(test.journal);
    }
}
