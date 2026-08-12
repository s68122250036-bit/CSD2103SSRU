public class Node1<T> {

    // ส่วนสร้าง Node
    

    public T value;
    public Node1<T> next;

    public Node1() {
        this.value = null;
        this.next = null;
    }

    public Node1(T value) {
        this.value = value;
        this.next = null;
    }


    
    // ข้อ 2 : Method สำหรับนับจำนวน Node
    

    public static int countNodes(Node1<String> head) {

        int count = 0;
        Node1<String> curr = head;

        while (curr != null) {
            count++;
            curr = curr.next;
        }

        return count;
    }



    // Main
   

    public static void main(String[] args) {

        // สร้าง Node
        Node1<String> p = new Node1<String>("red");
        Node1<String> q = new Node1<String>("green");
        Node1<String> m = new Node1<String>("blue");
        Node1<String> n = new Node1<String>("yellow");

        // แสดงข้อมูลของ Node
        System.out.println("p = " + p);
        System.out.println("p.value = " + p.value);
        System.out.println("p.next before = " + p.next);

        System.out.println("q = " + q);
        System.out.println("q.value = " + q.value);
        System.out.println("q.next = " + q.next);


       
        // เชื่อม Node เข้าด้วยกัน
        

        p.next = q;
        q.next = m;
        m.next = n;

        // กำหนด head
        Node1<String> head = p;

        System.out.println("head = " + head);


       
        // ข้อ 1 : ค้นหา Node ที่มีค่า blue
    

        Node1<String> curr = head;

        while (curr != null) {

            if (curr.value.equals("blue")) {
                System.out.println("พบ Node ที่มีค่า blue");
                System.out.println("blue อยู่ที่ Node = " + curr);
                break;
            }

            curr = curr.next;
        }


        // ข้อ 2 : นับจำนวน Node ใน List
        

        int total = countNodes(head);

        System.out.println("จำนวน Node ใน List = " + total);
    }
}
