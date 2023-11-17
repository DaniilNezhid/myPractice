import java.util.Scanner;
public class divisionMain {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the first number ");
        String number1 = scan.nextLine();
        System.out.println("Enter the second number ");
        String number2 = scan.nextLine();

        try{
            double result = Double.parseDouble(number1) / Double.parseDouble(number2);
            if(0 == Double.parseDouble(number2) || 0 == Double.parseDouble(number1)){
                throw new ArithmeticException("You can't divide y zero!");
            } else {
                System.out.println("Result: " + result);
            }
        }catch(NumberFormatException e){
            System.out.println("You entered an invalid value, use numbers!!!");
        }
    }
}
