import java.util.Scanner;

public class ScoreArray {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int[] score = new int[5];
        int total = 0;
        double average;

        // มีข้อผิดพลาด: ใช้ <= ทำให้เข้าถึง score[5]
        for (int i = 0; i <= score.length; i++) {
            System.out.print("Enter score " + (i + 1) + ": ");
            score[i] = input.nextInt();
            total += score[i];
        }

        average = total / 5.0;

        System.out.println("Total score = " + total);
        System.out.println("Average score = " + average);

        input.close();
    }
}