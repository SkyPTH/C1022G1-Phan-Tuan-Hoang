import java.util.Scanner;

public class Bai1 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n;
        do {
            System.out.println("Nhập số nguyên dương n");
            n = Integer.parseInt(scanner.nextLine());
        } while (n>=5000);
        int sum=0;
        for (int i=1; i<=n;i++){
            if(n%i==0 && i%2==0){
                sum=sum+i;
//                System.out.println(i);
            }
        }
        System.out.println(sum);

    }
}
