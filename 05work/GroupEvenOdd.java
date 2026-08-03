import java.util.Scanner;

public class GroupEvenOdd {
    //วิธีที่ 1: Recursive Two-Pointer
    //แนวคิด: ใช้ตัวชี้สองตัว (left และ right) เริ่มจากตำแหน่งแรกและสุดท้ายของสตริง
    // ตรวจสอบว่าตัวอักษรที่ตำแหน่ง left เป็นตัวเลขหรือไม่ ถ้าใช่ให้เพิ่มลงในกลุ่มคู่ ถ้าไม่ใช่ให้เพิ่มลงในกลุ่มคี่
    static void groupEvenOddRecursive(
            String s,
            int left,
            int right,
            StringBuilder even,
            StringBuilder odd) {

        if (left > right) {
            return;
        }

        char c = s.charAt(left);

        if (Character.isDigit(c)) {

            int digit = Character.getNumericValue(c);

            if (digit % 2 == 0) {
                even.append(c);
            } else {
                odd.append(c);
            }
        }

        groupEvenOddRecursive(
                s,
                left + 1,
                right,
                even,
                odd
        );
    }


    // Pseudocode
    // เริ่ม
    // รับค่า String s, int left, int right, StringBuilder even, StringBuilder odd
    // ถ้า left > right
    //  ส่งคืน
    // รับตัวอักษรที่ตำแหน่ง left
    // ถ้าตัวอักษรเป็นตัวเลข
    //  แปลงเป็นตัวเลข
    //  ถ้าเลขคู่
    //   เพิ่มเข้าไปใน even
    //  ถ้าเลขคี่
    //   เพิ่มเข้าไปใน odd
    // เรียกเมธอด groupEvenOddRecursive กับ s, left + 1, right, even, odd
    // สิ้นสุด

    // Time Complexity: O(n) - เพราะต้องอ่านตัวอักษรทุกตัวใน String จำนวน n ตัว
    // Space Complexity: O(n) - เนื่องจากต้องเก็บ stack frame ของการเรียกเมธอดซ้ำ ๆ และ StringBuilder สำหรับเก็บผลลัพธ์

    //วิธีที่ 2: Iterative Two-Pointer
    //แนวคิด: ใช้ลูปอ่านตัวอักษรทุกตัวในสตริงและตรวจสอบว่าตัวอักษรนั้นเป็นตัวเลขหรือไม่

    static void groupEvenOddIterative(
            String s,
            StringBuilder even,
            StringBuilder odd) {

        for (char c : s.toCharArray()) {

            if (Character.isDigit(c)) {

                int digit = Character.getNumericValue(c);

                if (digit % 2 == 0) {
                    even.append(c);
                } else {
                    odd.append(c);
                }
            }
        }
    }
    // Pseudocode
    // เริ่ม
    // รับค่า String s, StringBuilder even, StringBuilder odd
    // ใช้ลูปอ่านตัวอักษรทุกตัวใน s
    //  ถ้าตัวอักษรเป็นตัวเลข
    //   แปลงเป็นตัวเลข
    //   ถ้าเลขคู่
    //    เพิ่มเข้าไปใน even
    //   ถ้าเลขคี่
    //    เพิ่มเข้าไปใน odd
    // สิ้นสุด

    // Time Complexity: O(n) - เพราะต้องอ่านตัวอักษรทุกตัวใน String จำนวน n ตัว
    // Space Complexity: O(n) - เนื่องจาก StringBuilder สำหรับเก็บผลลัพธ์


    //วิธีที่ 3: Extra Array
    //แนวคิด: สร้างอาร์เรย์สองตัวเพื่อเก็บตัวเลขคู่และตัวเลขคี่ จากนั้นใช้ลูปอ่านตัวอักษรทุกตัวในสตริง
    static void groupEvenOddExtraArray(
            String s,
            StringBuilder even,
            StringBuilder odd) {

        char[] evenArray = new char[s.length()];
        char[] oddArray = new char[s.length()];

        int evenIndex = 0;
        int oddIndex = 0;

        for (char c : s.toCharArray()) {

            if (Character.isDigit(c)) {

                int digit = Character.getNumericValue(c);

                if (digit % 2 == 0) {
                    evenArray[evenIndex++] = c;
                } else {
                    oddArray[oddIndex++] = c;
                }
            }
        }

        even.append(evenArray, 0, evenIndex);
        odd.append(oddArray, 0, oddIndex);
    }

    // Pseudocode
    // เริ่ม
    // รับค่า String s, StringBuilder even, StringBuilder odd
    // สร้างอาร์เรย์ evenArray และ oddArray ขนาดเท่ากับความยาวของ s
    // สร้างตัวแปร evenIndex และ oddIndex = 0
    // ใช้ลูปอ่านตัวอักษรทุกตัวใน s
    //  ถ้าตัวอักษรเป็นตัวเลข
    //   แปลงเป็นตัวเลข
    //   ถ้าเลขคู่
    //    เพิ่มเข้าไปใน evenArray[evenIndex++]
    //   ถ้าเลขคี่
    //    เพิ่มเข้าไปใน oddArray[oddIndex++]
    // เพิ่มค่าใน even จาก evenArray[0] ถึง evenArray[evenIndex - 1]
    // เพิ่มค่าใน odd จาก oddArray[0] ถึง oddArray[oddIndex - 1]
    // สิ้นสุด 

    // Time Complexity: O(n) - เพราะต้องอ่านตัวอักษรทุกตัวใน String จำนวน n ตัว
    // Space Complexity: O(n) - เนื่องจากต้องสร้างอาร์เรย์สองตัวเพื่อเก็บตัวเลขคู่และตัวเลขคี่

    // สรุป: ทั้งสามวิธีสามารถใช้ในการจัดกลุ่มตัวเลขคู่และตัวเลขคี่ได้ แต่การใช้วิธี Iterative Two-Pointer จะมีประสิทธิภาพดีกว่าในแง่ของเวลาและพื้นที่ 
    // เนื่องจากไม่ต้องสร้างอาร์เรย์เพิ่มเติมและไม่ต้องเก็บ stack frame ของการเรียกเมธอดซ้ำ ๆ
    //จำนวนครั้งของการสลับข้อมูลกี่ครั้ง
    // วิธี Recursive และ Iterative จะมีจำนวนครั้งของการสลับข้อมูลเท่ากับจำนวนตัวเลขคู่และตัวเลขคี่ที่พบ ในขณะที่วิธี Extra Array จะไม่ต้องสลับข้อมูลเลย
    //การเปลี่ยนแปลงอาร์เรย์เดิม
    // วิธี Recursive และ Iterative จะเปลี่ยนแปลงอาร์เรย์เดิม ในขณะที่วิธี Extra Array จะสร้างอาร์เรย์ใหม่เพื่อเก็บผลลัพธ์
    //ความเป็น Stable Algorithm
    // วิธี Recursive และ Iterative เป็น Stable Algorithm เพราะรักษาลำดับเดิมของตัวเลขคู่และตัวเลขคี่ ในขณะที่วิธี Extra Array อาจไม่รักษาลำดับเดิม


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("กรอกตัวเลข: ");
        String input = sc.nextLine();


        // =====================================================
        // วิธีที่ 1: Recursive
        // =====================================================
        StringBuilder evenRecursive = new StringBuilder();
        StringBuilder oddRecursive = new StringBuilder();

        groupEvenOddRecursive(
                input,
                0,
                input.length() - 1,
                evenRecursive,
                oddRecursive
        );


        // =====================================================
        // วิธีที่ 2: Iterative
        // =====================================================
        StringBuilder evenIterative = new StringBuilder();
        StringBuilder oddIterative = new StringBuilder();

        groupEvenOddIterative(
                input,
                evenIterative,
                oddIterative
        );


        // =====================================================
        // วิธีที่ 3: Extra Array
        // =====================================================
        StringBuilder evenExtraArray = new StringBuilder();
        StringBuilder oddExtraArray = new StringBuilder();

        groupEvenOddExtraArray(
                input,
                evenExtraArray,
                oddExtraArray
        );


        // =====================================================
        // แสดงผล
        // =====================================================

        System.out.println();
        System.out.println("========== ผลลัพธ์ ==========");

        System.out.println("\nวิธีที่ 1: Recursive");
        System.out.println("เลขคู่: " + evenRecursive);
        System.out.println("เลขคี่: " + oddRecursive);

        System.out.println("\nวิธีที่ 2: Iterative");
        System.out.println("เลขคู่: " + evenIterative);
        System.out.println("เลขคี่: " + oddIterative);

        System.out.println("\nวิธีที่ 3: Extra Array");
        System.out.println("เลขคู่: " + evenExtraArray);
        System.out.println("เลขคี่: " + oddExtraArray);


        sc.close();
    }
}