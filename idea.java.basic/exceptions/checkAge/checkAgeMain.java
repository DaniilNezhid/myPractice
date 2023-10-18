import java.util.Scanner;


public class checkAgeMain {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter you age please: ");
        try{
            String inputAge = scan.nextLine();
            int age = Integer.parseInt(inputAge);
            if(age <  0 || age > 150){
                throw new InvalidAgeException("Age must be between 0 abd 150!");
            } else System.out.println("Thank you for the input!");
        } catch (NumberFormatException | InvalidAgeException e) {
            e.printStackTrace();
        }
    }
}
