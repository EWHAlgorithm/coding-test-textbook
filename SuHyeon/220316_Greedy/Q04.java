import java.util.*;

public class Q04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] li = new int[n];

        for(int i=0; i<n; i++) {
            li[i] = sc.nextInt();
        }
        Arrays.sort(li);

        int min = 1;

        for(int i=0; i<n; i++) {
            if(min < li[i])
                break;
            else
                min += li[i];
        }
        System.out.println(min);
        sc.close();
    }
}
