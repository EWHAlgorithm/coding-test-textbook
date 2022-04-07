package DFS_BFS;

import java.lang.reflect.Array;
import java.util.*;

/**
 * 1~N번까지의 도시와 M개의 단방향 도로 존재
 * 특정 도시 X로부터 출발하여 도달할 수 있는 모든 도시 중
 * 최단 거리가 정확히 K인 모든 도시의 번호 출력
 * 최단 거리 => bfs 이용!
 */

public class Q15 {
    // 최단 거리 저장할 리스트 변수 선언
    public static int[] distance = new int[300001];
    // 그래프 저장할 변수 선언
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    public static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);

        while(!q.isEmpty()) {
            int prevCity = q.poll();

            // 현재 큐에서 꺼낸 도시와 연결된 도시 찾아가며 거리 업데이트하기
            for(int i=0; i<graph.get(prevCity).size(); i++){
                int nextCity = graph.get(prevCity).get(i);

                // 최단 거리 업데이트
                if(distance[nextCity] == 0) {
                    distance[nextCity] = distance[prevCity] + 1;
                    q.offer(nextCity);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cityNum = sc.nextInt(); int edgeNum = sc.nextInt();
        int k = sc.nextInt(); int start = sc.nextInt();

        // 도시 추가
        for(int i=0; i<=cityNum; i++) {
            graph.add(new ArrayList<Integer>());
        }

        // 도시 연결 정보 저장
        for(int i=0; i<edgeNum; i++) {
            int city = sc.nextInt();
            int linked = sc.nextInt();
            graph.get(city).add(linked);
        }

        bfs(start);

        // 최단거리가 k인 도시 출력 (없는 경우 flag == false로 -1 출력
        boolean flag = false;
        for(int i=1; i<=cityNum; i++) {
            if(distance[i] == k) {
                System.out.println(i + " ");
                flag = true;
            }
        }

        if(flag == false) System.out.println(-1);

        sc.close();
    }
}
