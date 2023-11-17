import java.util.Scanner;

public class arraysMain {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the size of the array: ");
        try {
            String sizeEx = scan.nextLine();
            int size = Integer.parseInt(sizeEx);
            if(size < 0){
                throw new NegativeArraySizeException("The array size must be positive!");
            }
            int[] numsArray = new int[size];

            for (int i = 0; i < size; i++) {
                System.out.println("Enter a value for the element " + i + ":");
                String elementI = scan.nextLine();
                numsArray[i] = Integer.parseInt(elementI);
                if ((i < 0) || (i > size)){
                    throw new ArrayIndexOutOfBoundsException("Index not within array boundaries");
                }
            }
            System.out.println("Great, here's your array: ");
            for(int i = 0; i < numsArray.length; i++){
                System.out.println(i + ") " + numsArray[i]);
            }

        }catch(NumberFormatException e){
            e.printStackTrace();
        }
    }
}
