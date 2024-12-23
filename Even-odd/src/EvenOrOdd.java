import java.util.Scanner;
public class EvenOrOdd {
    public boolean isEven(int number) {
        return number % 2 == 0;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EvenOrOdd evenOrOdd = new EvenOrOdd();
        System.out.println("Enter integers one at a time to check if they are even or odd.");
        System.out.println("Type '0' to exit the program.");
        while (true) {
            System.out.print("Enter an integer: ");
            int number = scanner.nextInt();
            if (number == 0) {
                System.out.println("Exiting the program. Thank you!");
                break;
            }
            if (evenOrOdd.isEven(number)) {
                System.out.println(number + " is even.");
            } else {
                System.out.println(number + " is odd.");
            }
        }
        scanner.close();
    }
}
