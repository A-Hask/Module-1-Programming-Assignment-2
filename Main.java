import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter a 13 to 16 digit credit card number: ");
        long number = reader.nextLong();
        reader.close();
        boolean result = isValid(number);
    }

    public static boolean isValid(long number){
        int numLength = String.valueOf(number).length();
        int[] creditCardInt = new int[numLength];

        for (int i=0; i < numLength; i++){
            String str = String.valueOf(number);
            creditCardInt[i] = Integer.parseInt(str.substring(i, i+1));
        }

        for (int i = creditCardInt.length - 2; i >= 0; i = i - 2){
            int tempValue = creditCardInt[i];
            tempValue = tempValue * 2;
            if (tempValue>9){
                tempValue = tempValue % 10 + 1;
            }
            creditCardInt[i] = tempValue;
        }

        int total = 0;
        for (int i = 0; i < creditCardInt.length; i++){
            total += creditCardInt[i];
        }
        if (total % 10 == 0){
            System.out.println("Credit card!");
            return true;
        } else {
            System.out.println("Not a credit card!");
            return false;
        }
    }
}
