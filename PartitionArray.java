import java.util.Arrays;

public class PartitionArray {

    // ข้อ 5: การแบ่งอาร์เรย์ตามค่า k

    // =========================================================
    // วิธีที่ 1: Recursive Partition
    // =========================================================

    // แนวคิด: ใช้ตัวชี้สองตัว (left และ right) เริ่มจากตำแหน่งแรกและสุดท้ายของอาร์เรย์
    // ตรวจสอบค่าที่ตำแหน่ง left และ right
    // ถ้าค่าที่ตำแหน่ง left น้อยกว่าหรือเท่ากับ k ให้เพิ่ม left
    // ถ้าค่าที่ตำแหน่ง right มากกว่า k ให้ลด right
    // ถ้าพบค่าที่อยู่ผิดฝั่ง ให้สลับค่ากัน

    static void partitionArrayRecursive(int[] arr, int left, int right, int k) {

        // ถ้า left มากกว่าหรือเท่ากับ right ให้หยุด
        if (left >= right) {
            return;
        }

        // ถ้าค่าทางซ้าย <= k ให้เลื่อนไปทางขวา
        if (arr[left] <= k) {

            partitionArrayRecursive(arr, left + 1, right, k);

        // ถ้าค่าทางขวา > k ให้เลื่อนไปทางซ้าย
        } else if (arr[right] > k) {

            partitionArrayRecursive(arr, left, right - 1, k);

        } else {

            // Swap arr[left] และ arr[right]
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            // เรียกตัวเองอีกครั้ง โดยเลื่อนทั้งสองตำแหน่ง
            partitionArrayRecursive(arr, left + 1, right - 1, k);
        }
    }

    // Pseudocode
    // เริ่ม
    // รับค่า int[] arr, int left, int right, int k
    // ถ้า left >= right
    //     ส่งคืน
    // ถ้า arr[left] <= k
    //     เรียกเมธอด partitionArrayRecursive กับ arr, left + 1, right, k
    // ถ้า arr[right] > k
    //     เรียกเมธอด partitionArrayRecursive กับ arr, left, right - 1, k
    // อื่น ๆ
    //     สลับค่า arr[left] และ arr[right]
    //     เรียกเมธอด partitionArrayRecursive กับ arr, left + 1, right - 1, k
    // สิ้นสุด

    // Time Complexity: O(n)
    // เพราะต้องตรวจสอบค่าต่าง ๆ ในอาร์เรย์จำนวน n ตัว

    // Space Complexity: O(n)
    // เนื่องจากมีการเรียกเมธอดแบบ Recursive
    // จึงต้องใช้ Stack Frame ตามจำนวนครั้งที่เรียกซ้ำ


    // =========================================================
    // วิธีที่ 2: Iterative Partition
    // =========================================================

    // แนวคิด: ใช้ลูปและตัวชี้สองตัว
    // left เริ่มจากตำแหน่งแรก
    // right เริ่มจากตำแหน่งสุดท้าย
    // ถ้าค่าทางซ้าย <= k ให้เลื่อน left
    // ถ้าค่าทางขวา > k ให้เลื่อน right
    // ถ้าพบค่าที่อยู่ผิดฝั่ง ให้สลับค่ากัน

    static void partitionArrayIterative(int[] arr, int k) {

        int left = 0;
        int right = arr.length - 1;

        // ทำงานจนกว่า left และ right จะมาบรรจบกัน
        while (left < right) {

            // ขยับ left ไปเรื่อย ๆ ถ้าค่า <= k
            while (left < right && arr[left] <= k) {
                left++;
            }

            // ขยับ right ไปเรื่อย ๆ ถ้าค่า > k
            while (left < right && arr[right] > k) {
                right--;
            }

            // ถ้ายังไม่บรรจบกัน ให้สลับค่า
            if (left < right) {

                // Swap arr[left] และ arr[right]
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
        }
    }

    // Pseudocode
    // เริ่ม
    // รับค่า int[] arr, int k
    // สร้างตัวแปร left = 0 และ right = arr.length - 1
    // ขณะที่ left < right
    //     ขณะที่ left < right และ arr[left] <= k
    //         เพิ่ม left
    //     ขณะที่ left < right และ arr[right] > k
    //         ลด right
    //     ถ้า left < right
    //         สลับค่า arr[left] และ arr[right]
    // สิ้นสุด

    // Time Complexity: O(n)
    // เพราะแต่ละตำแหน่งในอาร์เรย์ถูกตรวจสอบไม่เกินจำนวนครั้งที่จำเป็น

    // Space Complexity: O(1)
    // เนื่องจากใช้ตัวแปร left และ right เท่านั้น


    // =========================================================
    // วิธีที่ 3: Sorting-Based
    // =========================================================

    // แนวคิด: ใช้การเรียงลำดับอาร์เรย์
    // เมื่อเรียงลำดับแล้ว ค่าที่ <= k จะอยู่ด้านหน้า
    // และค่าที่ > k จะอยู่ด้านหลัง
    static void partitionArraySorting(int[] arr, int k) {

        // เรียงลำดับอาร์เรย์จากน้อยไปมาก
        Arrays.sort(arr);
    }

    // Pseudocode
    // เริ่ม
    // รับค่า int[] arr, int k
    // เรียงลำดับ arr จากน้อยไปมาก
    // ค่าที่ <= k จะอยู่ด้านหน้า
    // ค่าที่ > k จะอยู่ด้านหลัง
    // สิ้นสุด

    // Time Complexity: O(n log n)
    // เนื่องจาก Arrays.sort() ใช้เวลา O(n log n)

    // Space Complexity: O(log n)
    // เนื่องจากการเรียงลำดับของ Arrays.sort()
    // อาจมีการใช้ Stack สำหรับการทำงานภายใน


    // =========================================================
    // Main Method
    // =========================================================

    public static void main(String[] args) {

        // กำหนดอาร์เรย์เริ่มต้น
        int[] originalArray = {9, 4, 7, 2, 8, 1, 6, 3, 5};

        // กำหนดค่า k
        int k = 5;

        // -----------------------------------------------------
        // วิธีที่ 1: Recursive Partition
        // -----------------------------------------------------

        int[] array1 = Arrays.copyOf(originalArray, originalArray.length);

        partitionArrayRecursive(
                array1,
                0,
                array1.length - 1,
                k
        );

        System.out.println("วิธีที่ 1: Recursive Partition");
        System.out.println(Arrays.toString(array1));

        // -----------------------------------------------------
        // วิธีที่ 2: Iterative Partition
        // -----------------------------------------------------

        int[] array2 = Arrays.copyOf(originalArray, originalArray.length);

        partitionArrayIterative(array2, k);

        System.out.println("\nวิธีที่ 2: Iterative Partition");
        System.out.println(Arrays.toString(array2));

        // -----------------------------------------------------
        // วิธีที่ 3: Sorting-Based
        // -----------------------------------------------------

        int[] array3 = Arrays.copyOf(originalArray, originalArray.length);

        partitionArraySorting(array3, k);

        System.out.println("\nวิธีที่ 3: Sorting-Based");
        System.out.println(Arrays.toString(array3));

        // -----------------------------------------------------
        // แสดงค่า k
        // -----------------------------------------------------

        System.out.println("\nk = " + k);

        // สรุป
        System.out.println("\nสรุป:");
        System.out.println("Recursive Partition  : Time O(n), Space O(n)");
        System.out.println("Iterative Partition  : Time O(n), Space O(1)");
        System.out.println("Sorting-Based        : Time O(n log n), Space O(log n)");
    }
}