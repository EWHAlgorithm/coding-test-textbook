import java.util.*;

public class BFSEx {
    // 방문 정보 저장할 리스트
    public static boolean[] visited = new boolean[9];
    // 그래프 저장할 인접 리스트 생성
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();

    // BFS 함수 정의
    public static void bfs(int n) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(n); // 노드 큐에 집어넣기
        visited[n] = true; // 현재 노드 방문 처리

        while(!q.isEmpty()) {
            int next = q.poll();
            System.out.print(next + " ");
            // 현재 노드와 연결되어 있으면서 방문하지 않은 노드들 큐에 삽입
            for(int i=0; i<graph.get(next).size(); i++) {
                int linked = graph.get(next).get(i);
                if(!visited[linked]) {
                    q.offer(linked);
                    visited[linked] = true;
                }
            }
        }
    }
    
    public static void main(String[] args) {
        // 그래프 노드 초기화
        for(int i=0; i<9; i++) {
            graph.add(new ArrayList<Integer>());
        }

        // 연결 정보 저장
        graph.get(1).add(2);
        graph.get(1).add(3);
        graph.get(1).add(8);

        graph.get(2).add(1);
        graph.get(2).add(7);

        graph.get(3).add(1);
        graph.get(3).add(4);
        graph.get(3).add(5);

        graph.get(4).add(3);
        graph.get(4).add(5);

        graph.get(5).add(3);
        graph.get(5).add(4);

        graph.get(6).add(7);

        graph.get(7).add(2);
        graph.get(7).add(6);
        graph.get(7).add(8);

        graph.get(8).add(1);
        graph.get(8).add(7);

        bfs(1);
    }
    
}
