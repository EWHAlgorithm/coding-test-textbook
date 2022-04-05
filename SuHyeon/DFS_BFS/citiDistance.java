package DFS_BFS;
import java.util.*;

public class citiDistance {
    // 인접 리스트 생성
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
    // 거리 저장 변수
    public static int[] d = new int[300001];

    // 최단 경로 탐색 함수
    public static void bfs(int x) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(x);

        while(!q.isEmpty()) {
            int node = q.poll();
            for(int i=0; i<graph.get(node).size(); i++) {
                int nextNode = graph.get(node).get(i);

                if(d[nextNode] == 0) {
                    d[nextNode] = d[node] + 1;
                    q.offer(nextNode);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); int m = sc.nextInt();
        int k = sc.nextInt(); int start = sc.nextInt();

        // 도로 연결 정보 입력받기
        for(int i=0; i<n; i++) {
            graph.add(new ArrayList<Integer>());
        }

        for(int i=0; i>m; i++) {
            int node = sc.nextInt(); int linked = sc.nextInt();
            graph.get(node).add(linked);
        }

        bfs(start);

        boolean flag = false;

        for(int i=1; i<=n; i++) {
            if(d[i] == k) {
                System.out.println(i);
                flag = true;
            }
        }

        if(!flag) System.out.println(-1);

        sc.close();
    }
}
