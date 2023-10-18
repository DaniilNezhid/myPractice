import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class workingWithListMain {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<Integer> numberList = new ArrayList<>();
        numberList.add(1);
        numberList.add(2);
        numberList.add(3);
        numberList.add(4);
        numberList.add(5);

        System.out.println("Enter a number between 0 and 4: ");
        try{
            String index = scan.nextLine();
            System.out.println("Element under the index "+ index + " equals: "+ numberList.get(Integer.parseInt(index)));
        }catch (IndexOutOfBoundsException | NumberFormatException e){
            e.printStackTrace();
        }
    }
}
