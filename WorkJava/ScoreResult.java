import java.util.Scanner;

public class ScoreResult {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // รับคะแนนกลางภาค
        System.out.print("Enter midterm score: ");
        int midterm = sc.nextInt();

        // รับคะแนนปลายภาค
        System.out.print("Enter final score: ");
        int finalScore = sc.nextInt();

        // คำนวณคะแนนรวม
        int total = midterm + finalScore;

        // แสดงคะแนนรวม
        System.out.println("Total score = " + total);

        // ตัดสินผลผ่านหรือไม่ผ่าน
        if (total >= 50) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }

        sc.close();
    }
}