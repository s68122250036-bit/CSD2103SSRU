import java.util.Scanner;

public class MinMaxArray {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int[] numbers = new int[10];

        // รับข้อมูล
        for (int i = 0; i < numbers.length; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            numbers[i] = input.nextInt();
        }

        // กำหนดค่าเริ่มต้น
        int min = numbers[0];
        int max = numbers[0];

        // หาค่าน้อยที่สุดและมากที่สุด
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] < min) {
                min = numbers[i];
            }

            if (numbers[i] > max) {
                max = numbers[i];
            }
        }

        // แสดงผล
        System.out.println("Minimum number = " + min);
        System.out.println("Maximum number = " + max);

        input.close();
    }
}