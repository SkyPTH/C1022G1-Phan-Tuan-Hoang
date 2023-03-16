package BaiTap.quan_li_sp;

public class test6 {
    public static int findMissingNumber(int[] arr) {
        boolean[] marked = new boolean[arr.length + 1];
        for (int i : arr) {
            marked[i] = true;
        }
        for (int i = 0; i < marked.length; i++) {
            if (!marked[i]) {
                return i;
            }
        }
        return -1; // không tìm thấy số nào
    }
//    public static int findMissingNumber(int[] a) {
//
//        boolean[] m = new boolean[a.length + 1];
//        for (int i : a) {
//            m[i] = true;
//        }
//        for (int i = 0; i < m.length; i++) {
//            if (!m[i]) {
//                return i;
//            }
//        }
//        return -1;
//    }

    public static void main(String[] args) {
        int[] n = {2, 3, 1, 0};

        findMissingNumber(n);
    }
}