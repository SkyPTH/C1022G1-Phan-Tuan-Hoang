package BaiTap.quan_li_sp;

public class test5 {
    public static void main(String[] args) {

        boolean flag = false;
        boolean flag2 = false;
        String s = "([}{){]}";
        while (s.length() > 1) {
            if (s.charAt(0) == '(' || s.charAt(0) == '[' || s.charAt(0) == '{') {
                for (int i = 1; i < s.length(); i++) {
                    if (s.charAt(0) == '(' && s.charAt(i) == ')' || s.charAt(0) == '[' && s.charAt(i) == ']' || s.charAt(0) == '{' && s.charAt(0) == '{') {
                        if (s.length() == 2) {
                            flag = true;
                            flag2 = true;
                            break;
                        }
                        s = s.substring(1, i) + s.substring(i + 1);
                        flag = true;
                        break;
                    }
                }
            } else {
                flag = false;
                break;
            }
            if (flag2) {
                break;
            }
        }
        if (s.length() != 0) {
            flag = false;
        }
        if (flag2) {
            flag = true;
        }
        System.out.println(flag);
    }
}
