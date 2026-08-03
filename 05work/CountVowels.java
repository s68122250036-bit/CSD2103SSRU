import java.util.Scanner;

public class CountVowels {

    // Recursive: นับสระแบบเวียนเกิด
    //วิธีที่ 1: Recursive Counting
    //แนวคิด: แบ่งสตริงออกเป็นตัวอักษรตัวแรกและส่วนที่เหลือ แล้วตรวจสอบว่าตัวอักษรตัวแรกเป็นสระหรือพยัญชนะ
    static int countVowelsRecursive(String s) {
        if (s.isEmpty()) {
            return 0;
        }

        char firstChar = Character.toLowerCase(s.charAt(0));

        int count =
                (firstChar == 'a' ||
                 firstChar == 'e' ||
                 firstChar == 'i' ||
                 firstChar == 'o' ||
                 firstChar == 'u') ? 1 : 0;

        return count + countVowelsRecursive(s.substring(1));
    }
     // Pseudocode
    // เริ่ม
    // รับค่า String s
    // ถ้า s ว่าง
    //  ส่งคืน 0
    // ตรวจสอบตัวอักษรตัวแรกของ s ว่าเป็นสระหรือไม่
    //  ถ้าเป็นสระ ส่งคืน 1 + countVowelsRecursive(s.substring(1))
    //  ถ้าไม่เป็นสระ ส่งคืน 0 + countVowelsRecursive(s.substring(1))
    // สิ้นสุด

    // Time Complexity: O(n²) - เนื่องจากแต่ละรอบมีการสร้าง substring ที่มีขนาดลดลงเรื่อย ๆ
    // Space Complexity: O(n) - เนื่องจากต้องเก็บ stack frame ของการเรียกเมธอดซ้ำ ๆ

    // Iterative: นับสระแบบวนลูป
    //วิธีที่ 2: Iterative Counting
    //แนวคิด: ใช้ลูปอ่านตัวอักษรทุกตัวในสตริงและตรวจสอบว่าตัวอักษรนั้นเป็นสระหรือพยัญชนะ
    static int countVowelsIterative(String s) {
        int count = 0;

        for (char c : s.toLowerCase().toCharArray()) {
            if (c == 'a' ||
                c == 'e' ||
                c == 'i' ||
                c == 'o' ||
                c == 'u') {

                count++;
            }
        }

        return count;
    }
     // Pseudocode
    // เริ่ม
    // รับค่า String s
    // สร้างตัวแปร count = 0
    // ใช้ลูปอ่านตัวอักษรทุกตัวใน s
    //  ถ้าตัวอักษรเป็นสระ
    //   เพิ่ม count ด้วย 1
    // ส่งคืน count
    // สิ้นสุด

    // Time Complexity: O(n) - เพราะต้องอ่านตัวอักษรทุกตัวใน String จำนวน n ตัว
    // Space Complexity: O(1) - เนื่องจากใช้ตัวแปร count เพียงตัวเดียว

    // สรุป: ทั้งสองวิธีสามารถใช้ในการนับจำนวนสระในสตริงได้ แต่การใช้วิธี Iterative จะมีประสิทธิภาพดีกว่าในแง่ของเวลาและพื้นที่
    //จำนวน recursive calls
    // วิธี Recursive จะมีจำนวน recursive calls เท่ากับความยาวของสตริง n ในขณะที่วิธี Iterative จะใช้ลูปเพียงครั้งเดียว
    //ความเสี่ยงของ StackOverflowError
    // วิธี Recursive มีความเสี่ยงที่จะเกิด StackOverflowError ถ้าความยาวของสตริงมีค่ามากเกินไป ในขณะที่วิธี Iterative ไม่มีความเสี่ยงนี้
    //ขนาดข้อมูลที่เหมาะสมสำหรับแต่ละวิธี
    // วิธี Recursive เหมาะสำหรับสตริงที่มีความยาวไม่เกิน 1000 ตัวอักษร ในขณะที่วิธี Iterative สามารถจัดการกับสตริงที่มีความยาวมากกว่า 1000 ตัวอักษรได้อย่างปลอดภัย


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("กรอกข้อความ: ");
        String input = sc.nextLine();

        int recursiveResult = countVowelsRecursive(input);
        int iterativeResult = countVowelsIterative(input);

        System.out.println("\nผลลัพธ์");
        System.out.println("Recursive : " + recursiveResult + " ตัว");
        System.out.println("Iterative : " + iterativeResult + " ตัว");

        sc.close();
    }
}