import java.util.Arrays;

public class FindPairs {

    // ข้อ 6: การค้นหาคู่จำนวนที่มีผลรวมเท่ากับ k

    // =========================================================
    // วิธีที่ 1: Brute Force
    // =========================================================

    // แนวคิด: ใช้ลูปสองชั้นเพื่อค้นหาคู่จำนวนที่มีผลรวมเท่ากับ k
    static void findPairsBruteForce(int[] arr, int k) {

        for (int i = 0; i < arr.length; i++) {

            for (int j = i + 1; j < arr.length; j++) {

                if (arr[i] + arr[j] == k) {

                    System.out.println(
                            "Pair found: (" + arr[i] + ", " + arr[j] + ")"
                    );
                }
            }
        }
    }

    // Pseudocode
    // เริ่ม
    // รับค่า int[] arr, int k
    // ใช้ลูปสองชั้นเพื่อตรวจสอบคู่จำนวนที่มีผลรวมเท่ากับ k
    // ถ้าพบคู่จำนวนที่ตรงกับเงื่อนไข
    //     แสดงคู่จำนวนนั้น
    // สิ้นสุด

    // Time Complexity: O(n²) - เนื่องจากต้องตรวจสอบทุกคู่จำนวนในอาร์เรย์
    // Space Complexity: O(1) - เนื่องจากใช้ตัวแปรเพียงไม่กี่ตัว


    // =========================================================
    // วิธีที่ 2: Recursive Two-Pointer
    // =========================================================

    // แนวคิด: ใช้ตัวชี้สองตัว (left และ right)
    // เริ่มจากตำแหน่งแรกและสุดท้ายของอาร์เรย์ที่เรียงลำดับแล้ว

    static void findPairsRecursive(int[] arr, int left, int right, int k) {

        // ถ้า left มากกว่าหรือเท่ากับ right ให้หยุด
        if (left >= right) {
            return;
        }

        // คำนวณผลรวมของค่าที่ตำแหน่ง left และ right
        int sum = arr[left] + arr[right];

        // ถ้าผลรวมเท่ากับ k แสดงคู่จำนวน
        if (sum == k) {

            System.out.println(
                    "Pair found: (" + arr[left] + ", " + arr[right] + ")"
            );

            // ขยับทั้งสองตัว
            findPairsRecursive(arr, left + 1, right - 1, k);

        // ถ้าผลรวมน้อยกว่า k ให้เลื่อน left ไปทางขวา
        } else if (sum < k) {

            findPairsRecursive(arr, left + 1, right, k);

        // ถ้าผลรวมมากกว่า k ให้เลื่อน right ไปทางซ้าย
        } else {

            findPairsRecursive(arr, left, right - 1, k);
        }
    }

    // Pseudocode
    // เริ่ม
    // รับค่า int[] arr, int left, int right, int k
    // ถ้า left >= right
    //     ส่งคืน
    // คำนวณ sum = arr[left] + arr[right]
    // ถ้า sum == k
    //     แสดงคู่จำนวนนั้น
    //     เรียกเมธอด findPairsRecursive กับ arr, left + 1, right - 1, k
    // ถ้า sum < k
    //     เรียกเมธอด findPairsRecursive กับ arr, left + 1, right, k
    // อื่น ๆ
    //     เรียกเมธอด findPairsRecursive กับ arr, left, right - 1, k
    // สิ้นสุด

    // Time Complexity: O(n) - เพราะต้องอ่านค่าทุกตัวในอาร์เรย์จำนวน n ตัว
    // Space Complexity: O(n) - เนื่องจากต้องเก็บ stack frame ของการเรียกเมธอดซ้ำ ๆ


    // =========================================================
    // วิธีที่ 3: Binary Search
    // =========================================================

    // แนวคิด: ใช้ลูปอ่านค่าทุกตัวในอาร์เรย์
    // แล้วใช้การค้นหาแบบ Binary Search
    // เพื่อตรวจสอบว่าค่าที่ต้องการมีอยู่ในอาร์เรย์หรือไม่

    static void findPairsBinarySearch(int[] arr, int k) {

        for (int i = 0; i < arr.length; i++) {

            // คำนวณค่าที่ต้องการ
            int complement = k - arr[i];

            // ค้นหา complement ตั้งแต่ตำแหน่ง i + 1
            if (binarySearch(
                    arr,
                    complement,
                    i + 1,
                    arr.length - 1)) {

                System.out.println(
                        "Pair found: (" + arr[i] + ", " + complement + ")"
                );
            }
        }
    }

    // เมธอด Binary Search
    static boolean binarySearch(
            int[] arr,
            int target,
            int left,
            int right) {

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {

                return true;

            } else if (arr[mid] < target) {

                left = mid + 1;

            } else {

                right = mid - 1;
            }
        }

        return false;
    }

    // Pseudocode
    // เริ่ม
    // รับค่า int[] arr, int k
    // ใช้ลูปอ่านค่าทุกตัวใน arr
    //     คำนวณ complement = k - arr[i]
    //     ถ้า binarySearch(arr, complement, i + 1, arr.length - 1) คืนค่า true
    //         แสดงคู่จำนวนนั้น
    // สิ้นสุด

    // Time Complexity: O(n log n) - เนื่องจากต้องใช้การค้นหาแบบ Binary Search สำหรับแต่ละตัวในอาร์เรย์
    // Space Complexity: O(1) - เนื่องจากใช้ตัวแปรเพียงไม่กี่ตัว


    // =========================================================
    // เหตุใด Two-Pointer จึงใช้ได้เมื่ออาร์เรย์เรียงลำดับแล้ว
    // =========================================================

    // Two-Pointer ใช้ได้เมื่ออาร์เรย์เรียงลำดับแล้ว
    // เพราะเราสามารถใช้ตัวชี้สองตัวเพื่อหาคู่จำนวน
    // ที่มีผลรวมเท่ากับ k ได้อย่างมีประสิทธิภาพ

    // หากนำวิธีนี้ไปใช้กับอาร์เรย์ที่ยังไม่เรียงลำดับ
    // จะไม่สามารถหาคู่จำนวนที่มีผลรวมเท่ากับ k ได้อย่างถูกต้อง
    // เนื่องจากค่าที่อยู่ในอาร์เรย์ไม่ได้เรียงลำดับตามขนาด
    // ทำให้การเปรียบเทียบผลรวมของตัวเลขที่ตัวชี้ left และ right
    // อาจไม่สะท้อนถึงความสัมพันธ์ที่แท้จริงของค่าตัวเลขในอาร์เรย์


    // =========================================================
    // Main Method
    // =========================================================

    public static void main(String[] args) {

        // กำหนดอาร์เรย์
        int[] originalArray = {2, 7, 11, 15, 3, 6, 8, 4};

        // กำหนดค่า k
        int k = 10;

        // =====================================================
        // วิธีที่ 1: Brute Force
        // =====================================================

        System.out.println("วิธีที่ 1: Brute Force");

        findPairsBruteForce(originalArray, k);


        // =====================================================
        // วิธีที่ 2: Recursive Two-Pointer
        // =====================================================

        // Two-Pointer ต้องใช้อาร์เรย์ที่เรียงลำดับแล้ว
        int[] sortedArray = Arrays.copyOf(
                originalArray,
                originalArray.length
        );

        Arrays.sort(sortedArray);

        System.out.println("\nอาร์เรย์ที่เรียงลำดับแล้ว:");
        System.out.println(Arrays.toString(sortedArray));

        System.out.println("\nวิธีที่ 2: Recursive Two-Pointer");

        findPairsRecursive(
                sortedArray,
                0,
                sortedArray.length - 1,
                k
        );


        // =====================================================
        // วิธีที่ 3: Binary Search
        // =====================================================

        // Binary Search ต้องใช้อาร์เรย์ที่เรียงลำดับแล้ว
        System.out.println("\nวิธีที่ 3: Binary Search");

        findPairsBinarySearch(
                sortedArray,
                k
        );


        // =====================================================
        // สรุป
        // =====================================================

        System.out.println("\nสรุป:");
        System.out.println(
                "Brute Force          : Time O(n²), Space O(1)"
        );

        System.out.println(
                "Recursive Two-Pointer : Time O(n), Space O(n)"
        );

        System.out.println(
                "Binary Search        : Time O(n log n), Space O(1)"
        );
    }
}