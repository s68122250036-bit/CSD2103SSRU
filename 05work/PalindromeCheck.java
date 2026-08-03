import java.util.Scanner;

public class PalindromeCheck {

    // วิธีที่ 1: Reverse and Compare
    // แนวคิด: กลับลำดับสตริงแล้วเปรียบเทียบกับสตริงเดิม ถ้าเหมือนกันแสดงว่าเป็น Palindrome
    static boolean isPalindromeByReverse(String s) {
        StringBuilder sb = new StringBuilder(s);
        String reversed = sb.reverse().toString();

        return s.equals(reversed);
    }
    // Pseudocode
    // เริ่ม
    // รับค่า String s
    // สร้าง StringBuilder sb จาก s
    // เรียกเมธอด reverse() บน sb
    // ส่งคืนผลลัพธ์ที่ได้จากการเรียกเมธอด toString()
    // สิ้นสุด

    // Time Complexity: O(n) - เพราะต้องอ่านตัวอักษรทุกตัวใน String จำนวน n ตัว
    // Space Complexity: O(n) - เนื่องจากต้องเก็บ StringBuilder ที่มีขนาดเท่ากับความยาวของสตริง

    // วิธีที่ 2: Two-Pointer
    // แนวคิด: ใช้ตัวชี้สองตัว (left และ right) เริ่มจากตำแหน่งแรกและสุดท้ายของสตริง
    // เปรียบเทียบตัวอักษรที่ตำแหน่ง left และ right ถ้าไม่เหมือนกันแสดงว่าไม่ใช่ Palindrome
    static boolean isPalindromeTwoPointer(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
    // Pseudocode
    // เริ่ม
    // รับค่า String s, int left, int right
    // ถ้า left >= right
    //  ส่งคืน true
    // ถ้า s.charAt(left) != s.charAt(right)
    //  ส่งคืน false
    // เรียกเมธอด isPalindromeRecursive กับ s, left + 1, right - 1
    // สิ้นสุด

    //กรณีที่สตริงเป็น Palindrome
    // ตัวอย่าง: "racecar" จะให้ผลลัพธ์เป็น true
    //กรณีที่ตัวอักษรคู่แรกไม่ตรงกัน
    // ตัวอย่าง: "hello" จะให้ผลลัพธ์เป็น false

    //Best-case Time Complexity
    // O(1) - ถ้าตัวอักษรคู่แรกไม่ตรงกัน จะหยุดตรวจสอบทันที
    //Worst-case Time Complexity
    // O(n) - ถ้าตัวอักษรทุกตัวตรงกัน จะต้องตรวจสอบตัวอักษรทุกตัวในสตริง
    // Space Complexity: O(1) - เนื่องจากใช้ตัวแปรสองตัวเท่านั้น
    //ความสามารถในการหยุดทำงานก่อนครบทุกตัวอักษร
    // วิธี Two-Pointer สามารถหยุดทำงานได้ทันทีเมื่อพบว่าตัวอักษรคู่ใดไม่ตรงกัน ในขณะที่วิธี Reverse and Compare ต้องสร้างสตริงใหม่ทั้งหมดก่อนที่จะเปรียบเทียบ

    // สรุป: ทั้งสองวิธีสามารถใช้ตรวจสอบ Palindrome ได้ แต่การใช้วิธี Two-Pointer จะมีประสิทธิภาพดีกว่าในแง่ของเวลาและพื้นที่


    // ลบช่องว่างและสัญลักษณ์ และเปลี่ยนเป็นตัวพิมพ์เล็ก
    static boolean isPalindrome(String s) {
        String cleaned = s
                .replaceAll("[^a-zA-Z0-9]", "")
                .toLowerCase();

        return isPalindromeTwoPointer(cleaned);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("กรอกข้อความ: ");
        String input = sc.nextLine();

        // ทำความสะอาดข้อความ
        String cleaned = input
                .replaceAll("[^a-zA-Z0-9]", "")
                .toLowerCase();

        System.out.println("\nผลลัพธ์");

        // วิธีที่ 1
        if (isPalindromeByReverse(cleaned)) {
            System.out.println("Reverse Method : เป็น Palindrome");
        } else {
            System.out.println("Reverse Method : ไม่เป็น Palindrome");
        }

        // วิธีที่ 2
        if (isPalindromeTwoPointer(cleaned)) {
            System.out.println("Two Pointer    : เป็น Palindrome");
        } else {
            System.out.println("Two Pointer    : ไม่เป็น Palindrome");
        }

        sc.close();
    }
}