package collections.list;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.TreeMap;
import java.time.format.DateTimeParseException;

public class TreeMapTask {
    private Map<LocalDate, String> myCollection = new TreeMap<>();

    private void addTask(String date, String task) {
        myCollection.put(converterDate(date), task);
    }

    private void findTask(String date) {
        if ((converterDate(date)) != null && myCollection.containsKey(converterDate(date))) {
            System.out.println(myCollection.get(converterDate(date)));
        } else System.out.println("We didn't find anything. You may have entered the date incorrectly. (dd-MM-yyyy)");
    }

    public LocalDate converterDate(String date) {
        try {
            return LocalDate.parse(date, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        } catch (DateTimeParseException e) {
            System.out.println("Enter the date in the format dd-MM-yyyy!");
        }
        return null;
    }

    public static void main(String[] args) {

        TreeMapTask test = new TreeMapTask();

        test.addTask("12-11-2004", "Hello1");
        test.addTask("12-11-2014", "Hello2");
        test.addTask("30-09-2022", "Hello3");
        test.addTask("21-03-2010", "Hello4");
        test.addTask("07-11-2004", "Hello4");

        test.findTask("12-11-2004");

        System.out.println(test.myCollection);
    }
}
