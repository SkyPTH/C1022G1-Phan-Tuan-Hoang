package BaiTap;

public class test {
    public static void main(String[] args) {
        String s1 = "aacbb";
        String s2 = "abbacc";
        String s3 = "";
        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    s3 += s1.charAt(i);
                    s2 = s2.substring(0, j) + s2.substring(j + 1);
                  break;
                    }
                }
            } System.out.println(s3);
        }
    }

