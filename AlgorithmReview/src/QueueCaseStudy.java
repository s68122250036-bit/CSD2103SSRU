import java.util.LinkedList;
import java.util.Queue;

public class QueueCaseStudy {

    public static void main(String[] args) {

        // สร้าง Queue
        Queue<String> queue = new LinkedList<>();

        // เพิ่มผู้ป่วย P001 ถึง P005 ลงใน Queue
        queue.add("P001");
        queue.add("P002");
        queue.add("P003");
        queue.add("P004");
        queue.add("P005");

        System.out.println("< ระบบคิวผู้ป่วยในคลินิกสุขภาพ >");
        System.out.println("->คิวทั้งหมด");
        System.out.println(queue);

        // เรียกผู้ป่วยออกจากคิว 2 คน
        System.out.println("\n->ผู้ป่วยที่ได้รับบริการ");
        String served1 = "";
        String served2 = "";
         
        for (int i = 1; i <= 2; i++) {
          if (!queue.isEmpty()) {

        String patient = queue.remove(); // เก็บผู้ป่วยที่ remove ออกมา

          if (i == 1) {
            served1 = patient;
        } else if (i == 2) {
            served2 = patient;
        }

        System.out.println("คนที่ " + i + " : " + patient);

        } else {
        System.out.println("Queue ว่าง");
    }
}

        //  เพิ่มผู้ป่วยใหม่
        String newPatient1 = "P006";
        String newPatient2 = "P007";
        queue.add(newPatient1);
        queue.add(newPatient2);
        System.out.println("\n->เพิ่มผู้ป่วย P006 และ P007 เข้าQueue");
        System.out.println(queue);

        //  แสดงผู้ป่วยคนถัดไป
        System.out.println("\n->ผู้ป่วยคนถัดไป");
        System.out.println(queue.peek());

        // จำนวนผู้ป่วยที่รออยู่
        System.out.println("\n->จำนวนผู้ป่วยที่รออยู่");
        System.out.println(queue.size() + " คน");

        // แสดง Queue หลังดำเนินการทั้งหมด
        System.out.println("\n->แสดงสถานะของ Queue หลังจากดำเนินการทั้งหมด");
        System.out.println("ผู้ป่วยที่ได้รับบริการแล้ว : " + served1 + ", " + served2);
        System.out.println("ผู้ป่วยที่เพิ่มเข้ามา :"+ newPatient1 +","+newPatient2);
        System.out.println("ผู้ป่วยคนถัดไป : " + queue.peek());
        System.out.println("จำนวนผู้ป่วยที่รอ : " + queue.size() + " คน");
        System.out.println("ผู้ป่วยที่กำลังรอ : " + queue);

        System.out.println("\n->ตรวจสอบก่อน remove ว่า Queue ว่างหรือไม่");
        if (!queue.isEmpty()) {
            System.out.println("Queue ไม่ว่าง สามารถ remove() ได้");
        } else {
            System.out.println("Queue ว่าง ไม่สามารถ remove() ได้");
        }

        // อธิบาย FIFO
        System.out.println("\n->หลักการทำงานของ Queue");
        System.out.println("FIFO (First In First Out)");
        System.out.println("ผู้ที่เข้าคิวก่อน จะได้รับบริการก่อน");
    }
}