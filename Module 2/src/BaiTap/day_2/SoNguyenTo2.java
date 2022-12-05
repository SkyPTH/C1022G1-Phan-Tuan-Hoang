package BaiTap.day_2;
public class SoNguyenTo2 {
    public static void main(String[] args) {
        int count = 0;

        short i = 2;
        while (i < 100) {
            int count2 = 0;
            for (short j = 1; j <= i; j++) {
                if (i % j == 0) {
                    count2++;
                }
            }
            if (count2 == 2) {
                System.out.println(i);
                count++;

            }
            i++;
        }

    }
}

