import java.util.Scanner;

public class ReverseString {

    // Recursive: กลับข้อความแบบเวียนเกิด
    // ข้อ 1: การกลับลำดับสตริง (Reverse a String)
    
     //วิธีที่ 1: Recursive Algorithm
     //แนวคิด: นำตัวอักษรตัวสุดท้ายของ s มาต่อไว้ข้างหน้า แล้วเรียกเมธอดซ้ำ
     //กับสตริงที่ตัดตัวสุดท้ายออก จนกระทั่งเหลือสตริงว่างหรือ 1 ตัวอักษร (Base Case)
    static String reverseRecursive(String s) {
        if (s.length() <= 1) {
            return s;
        }

        char lastChar = s.charAt(s.length() - 1);
        String rest = s.substring(0, s.length() - 1);

        return lastChar + reverseRecursive(rest);
    }
    // Pseudocode
    // เริ่ม
    // รับค่า String s
    //ถ้าความยาวของ s น้อยกว่าหรือเท่ากับ 1
    //  ส่งคืน s
    //นำตัวอักษรตัวสุดท้ายของ s มาต่อไว้ข้างหน้า
    //เรียกเมธอด reverseRecursive กับสตริงที่ตัดตัวสุดท้ายออก
    //ส่งคืนผลลัพธ์ที่ได้จากการเรียกเมธอด reverseRecursive
    // สิ้นสุด

    // Time Complexity: O(n²) - เนื่องจากแต่ละรอบมีการสร้าง substring ที่มีขนาดลดลงเรื่อย ๆ
    //Space Complexity: O(n) - เนื่องจากต้องเก็บ stack frame ของการเรียกเมธอดซ้ำ ๆ

    // Iterative: กลับข้อความแบบวนลูป
    static String reverseIterative(String s) {
        StringBuilder sb = new StringBuilder(s.length());

        for (int i = s.length() - 1; i >= 0; i--) {
            sb.append(s.charAt(i));
        }

        return sb.toString();
    }
    // Pseudocode
    // เริ่ม
    // รับค่า String s
    // สร้าง StringBuilder sb ขนาดเท่ากับความยาวของ s
    // ใช้ลูป i จากความยาวของ s - 1 ถึง 0
    //  เพิ่มตัวอักษร s.charAt(i) เข้าไปใน sb
    // ส่งคืน sb.toString()
    // สิ้นสุด

    //จำนวนครั้งที่แต่ละอัลกอริทึมประมวลผลตัวอักษร
    // Recursive: n + (n-1) + (n-2) + ... + 1 = n(n+1)/2 = O(n²)
    // Iterative: n = O(n)
    
    // Time Complexity: O(n) - เพราะต้องอ่านตัวอักษรทุกตัวใน String จำนวน n ตัว
    // Space Complexity: O(n) - เนื่องจากต้องเก็บ StringBuilder ที่มีขนาดเท่ากับความยาวของสตริง
    
    //ผลกระทบจากการต่อสตริงด้วยเครื่องหมาย +
    // การต่อสตริงด้วยเครื่องหมาย + จะสร้าง String ใหม่ทุกครั้งที่มีการต่อ ทำให้เกิด overhead ในการจัดการหน่วยความจำและเวลาในการประมวลผลเพิ่มขึ้น
    
    //ความแตกต่างระหว่างการใช้ String และ StringBuilder
    // String เป็น immutable ซึ่งหมายความว่าทุกครั้งที่มีการเปลี่ยนแปลงจะสร้าง String ใหม่ 
    // ในขณะที่ StringBuilder เป็น mutable ทำให้สามารถแก้ไขสตริงได้โดยไม่ต้องสร้างอ็อบเจ็กต์ใหม่
    
    // สรุป: ทั้งสองวิธีสามารถใช้กลับลำดับสตริงได้ แต่การใช้วิธี Iterative จะมีประสิทธิภาพดีกว่าในแง่ของเวลาและพื้นที่ 
    // เนื่องจากไม่ต้องสร้าง stack frame ซ้ำ ๆ และไม่ต้องสร้าง substring ใหม่ทุกครั้ง

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("กรอกข้อความ: ");
        String input = sc.nextLine();

        System.out.println("\nผลลัพธ์");
        System.out.println("Recursive : " + reverseRecursive(input));
        System.out.println("Iterative : " + reverseIterative(input));

        sc.close();
    }
}