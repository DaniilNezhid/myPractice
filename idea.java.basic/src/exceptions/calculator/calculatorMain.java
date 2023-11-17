import java.util.Scanner;

public class calculatorMain {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the first number: ");
        String value1 = scan.next();
        System.out.println("Enter the second number: ");
        String value2 = scan.next();
        try{
            double num1 = Double.parseDouble(value1);
            double num2 = Double.parseDouble(value2);
            System.out.println("Enter the operation (-, +, /, *.): ");
            char operation = scan.next().charAt(0);
            double result;
            switch (operation){
                case '-':
                    result = num1 - num2;
                    System.out.println(result);
                    break;
                case '/':
                    result = num1 / num2;
                    if(0 == num2){
                        throw new ArithmeticException("You can't divide y zero!");
                    }
                    System.out.println(result);
                    break;
                case '*':
                    result = num1 * num2;
                    System.out.println(result);
                    break;
                case '+':
                    result = num1 + num2;
                    System.out.println(result);
                    break;
                default:
                    throw new IllegalArgumentException("Please pick something from: '+', '-', '/', '*'.");
            }
        }catch(NumberFormatException e){
            e.printStackTrace();
        }
    }
}
