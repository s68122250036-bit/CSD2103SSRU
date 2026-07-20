import java.util.Arrays;

public class MergeSortApp {

    // โค้ดส่วนที่โจทย์ของอาจารย์ให้มา
    public static void sort(int[] values) {
        if (values.length < 2) {
            return;
        }
        
        int middle = values.length / 2;
        int[] left = new int[middle];
        for (int i = 0; i < middle; i++) {
            left[i] = values[i];
        }
        
        int[] right = new int[values.length - middle];
        for (int i = 0; i < values.length - middle; i++) {
            right[i] = values[middle + i];
        }
        
        sort(left);
        sort(right);
        
        // เรียกใช้ฟังก์ชัน merge ที่เราเขียนตอบในข้อ 2
        merge(values, left, right);
    }

    // --- สิ่งที่นักศึกษาต้องตอบในข้อ 2 (ฟังก์ชัน merge) ---
    public static void merge(int[] values, int[] left, int[] right) {
        int i = 0; // index สำหรับ left
        int j = 0; // index สำหรับ right
        int k = 0; // index สำหรับ values

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                values[k] = left[i];
                i++;
            } else {
                values[k] = right[j];
                j++;
            }
            k++;
        }

        while (i < left.length) {
            values[k] = left[i];
            i++;
            k++;
        }

        while (j < right.length) {
            values[k] = right[j];
            j++;
            k++;
        }
    }

    // ส่วนของ Main สำหรับกด Run ทดสอบโปรแกรม
    public static void main(String[] args) {
        // ใช้ข้อมูลชุดเดียวกับโจทย์ข้อ 3
        int[] data = {15, 3, 9, 31, 11, 17, 7, 23}; 
        
        System.out.println("ข้อมูลก่อนเรียงลำดับ: " + Arrays.toString(data));
        
        // เรียกฟังก์ชันเรียงลำดับ
        sort(data); 
        
        System.out.println("ข้อมูลหลังเรียงลำดับ (ด้วย Merge Sort): " + Arrays.toString(data));
    }
}