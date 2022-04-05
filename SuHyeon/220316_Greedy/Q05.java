import java.util.*;

public class Q05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<Integer> weight = new ArrayList<>();
        
        // 볼링공의 무게 입력 받기
        for(int i=0; i<n; i++) {
            weight.add(sc.nextInt());
        }
        Collections.sort(weight);

        // 현재 선택된 볼링공의 무게와 다르면 조합 수 1 추가하기
        // 일일이 하나씩 추가하기에는 이중 반복문이 되면서 시간복잡도 증가함
        // 달라지는 순간의 인덱스를 찾기!
        //  1 2 2 3 4 4 5 5
        int now = 0;
        int result = 0;
        int comp = 1;
        while(true){
            if(weight.get(now) == m) break;
            else if(weight.get(now) != weight.get(comp)) {
                now++;
                result += n - comp;
            }
            else comp++;
        }

        System.out.println(result);
        sc.close();
    }
}
