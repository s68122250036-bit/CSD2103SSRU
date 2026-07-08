import java.util.Stack;

public class StackCaseStudy {

    public static void main(String[] args) {

        // สร้าง Stack
        Stack<String> stack = new Stack<>();

        // เพิ่มคำสั่งทั้งหมดลงใน Stack
        stack.push("Type Data");
        stack.push("Type Structure");
        stack.push("Delete Structure");
        stack.push("Type Algorithm");
        stack.push("Type Java");

        // แสดงคำสั่งทั้งหมดใน Stack
        System.out.println("< ระบบ Undo ในโปรแกรมจดบันทึก >");
        System.out.println("->คำสั่งทั้งหมดใน Stack");
        System.out.println(stack);

        // Undo คำสั่งล่าสุด 2 ครั้ง พร้อมตรวจสอบว่า Stack ว่างหรือไม่
        System.out.println("\n->Undo คำสั่งล่าสุด");

        for (int i = 1; i <= 2; i++) {
            if (!stack.isEmpty()) {
                String undo = stack.pop();   //  แสดงคำสั่งที่ถูก Undo
                System.out.println("Undo ครั้งที่ " + i + " : " + undo);
            } else {
                System.out.println("Stack ว่าง ไม่สามารถ Undo ได้");
            }
        }

        // แสดงสถานะของ Stack หลัง Undo
        System.out.println("\n->Stack หลังจาก Undo");
        System.out.println(stack);

        //อธิบายหลักการ LIFO
        System.out.println("\n->หลักการทำงานของ Stack");
        System.out.println("LIFO (Last In First Out)");
        System.out.println("ข้อมูลที่ถูกเพิ่มเข้ามาล่าสุด จะถูกนำออกก่อน");
    }
}