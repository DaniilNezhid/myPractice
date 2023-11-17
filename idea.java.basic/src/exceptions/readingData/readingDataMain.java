import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class readingDataMain {
    public static void main(String[] args) {
        try{
            BufferedReader read = new BufferedReader(new FileReader("/Users/danilnezid/Desktop/numbers.txt"));
            String line;
            int sum = 0;
            while((line = read.readLine()) !=null){
                try {
                    int number = Integer.parseInt(line);
                    sum += number;
                }catch (NumberFormatException e){
                    e.printStackTrace();
                }
            }
            System.out.println("sum: " + sum);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
