import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class letterMain {

    private void convert(){
        StringBuilder theLetter = new StringBuilder();
        try{
            BufferedReader read = new BufferedReader(new FileReader("/Users/danilnezid/Desktop/letterOne.txt"));
            String line;
            while((line = read.readLine()) != null){
                theLetter.append(line).append("\n");
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
        String content = theLetter.toString();
        startConvert(parsing(content));
    }
    private static List<String> parsing (String text){
       List<String> result = new ArrayList<>();
       String[] lines = text.split("\\n");
       String nameInput = lines[1].substring(5);
       String date = lines[0].substring(6);
       try{
           SimpleDateFormat pattern = new SimpleDateFormat("yyyy-MM-dd");
           Date d = pattern.parse(date);
           pattern.applyPattern("dd.MM.yyyy");
           date = pattern.format(d);
       } catch (Exception e){
           e.printStackTrace();
       }
       String newDate = date;
       String nameOutput = lines[lines.length - 1];
       StringBuilder textLetter = new StringBuilder();
       for (int i = 2; i < (lines.length - 2); i++){
           textLetter.append(lines[i] + "\n");
       }
       String textByLetter = textLetter.toString();
       result.add(newDate);
       result.add(textByLetter);
       result.add(nameOutput);
       result.add(nameInput);
       return result;
    }
    private static void startConvert(List<String> newLetter){
        System.out.println(newLetter.get(1) + "Posted by " + newLetter.get(2) + " for " + newLetter.get(3) + " " + newLetter.get(0));
    }


    public static void main(String[] args) {
        letterMain format = new letterMain();
        format.convert();
    }
}
