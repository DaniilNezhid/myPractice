import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.text.SimpleDateFormat;

public class aDiaryMain {
    
    private static StringBuffer stringBuffer = new StringBuffer();

    private static void addNewEvent(String text, StringBuffer stringBuffer) {
        stringBuffer.append(getCurrentDate()).append(" - ").append(text + '\n');
    }


    private static String getCurrentDate() {
        String pattern = "YYYY-MM-DD HH:mm:ss";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        return simpleDateFormat.format(new Date());
    }


    private static void printEvents() {
        System.out.println(stringBuffer.toString());
    }

    private static String getEventsText() {
        return stringBuffer.toString();
    }
    private static void getEventsByText(String text){
        if(!text.isEmpty()){
            String[] events = getEventsText().split("\n");
            for(String event : events){
                if(event.contains(text)){
                    System.out.println(event);
                }
            }
        }
    }

    private static List<String> getEventsByDate(String text, String date) {
        if (!text.isEmpty()) {
            return getSearchResult(date, getEvents(text));
        }
        return Collections.emptyList();
    }

    private static List<Event> getEvents(String text) {
        String[] events = text.split("\\n");
        List<Event> result = new ArrayList<>();
        for (String value : events) {
            Event event = new Event();
            String[] parts = value.split(" - ", 2);
            String[] dateAndTime = parts[0].split(" ");
            event.setTime((dateAndTime[1]));
            event.setDate(dateAndTime[0]);
            event.setEvent(parts[1]);
            result.add(event);
        }
        return result;
    }

    private static List<String> getSearchResult(String date, List<Event> result) {
        List<String> strings = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        byte choice;
        for (Event event : result) {
            if(!date.isEmpty() && event.getDate().contains(date)){
                System.out.println("0 - Display date only\n" + "1 - Display only time\n" + "2 - Display only text\n" + "3 - Display all text");
                choice = scan.nextByte();
                switch (choice){
                    case 0:
                        strings.add(event.getDate());
                        break;
                    case 1:
                        strings.add(event.getTime());
                        break;
                    case 2:
                        strings.add(event.getEvent());
                        break;
                    case 3:
                        strings.add(event.getDate() + " " + event.getTime() + " " + event.getEvent());
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + choice);
                }
            }
        }
        return strings;
    }
    private static void exportEventsToFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("textDiary.txt"))){
            writer.print(stringBuffer.toString());
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
    private static void exportEventsToFileByDate(String date) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("text.txt"))){
            writer.print(getEventsByDate(getEventsText(), date));
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    private static void removeEventByDataAndTime(String date){
      if(!date.isEmpty()){
          for(int i = 0; i < stringBuffer.length(); i++){
              int start = stringBuffer.indexOf(date);
              int end = stringBuffer.indexOf("\n", start);
              try {
                  stringBuffer.delete(start , end);
              }catch (StringIndexOutOfBoundsException e){
                  System.out.println(e.getMessage());
                  break;
              }
          }
      }
    }
    public static void main(String[] args) {

        addNewEvent("1Hello World_1", stringBuffer);
        addNewEvent("2Hello World_2", stringBuffer);
        addNewEvent("298Hello World_3", stringBuffer);
//        exportEventsToFileByDate("2023-10-30");
          exportEventsToFile();
//        printEvents();
//        System.out.println(getEventsByDate(getEventsText(), "2023-10-30"));
//        getEventsByText("1H");
//        removeEventByDataAndTime("2023-10-30");
//        printEvents();
    }
}
