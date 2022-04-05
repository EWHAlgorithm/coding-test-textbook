package DFS_BFS;
import java.util.ArrayList;

public class DFSEx {
    // 방문 정보 저장할 리스트
    public static boolean[] visited = new boolean[9];
    // 그래프 저장할 인접 리스트 생성
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();

    // DFS 정의
    public static void dfs(int n) {
        // 현재 노드 방문처리
        visited[n] = true;
        System.out.print(n + " ");

        // 현재 노드와 연결된 다른 노드 재귀적으로 방문
        for(int i=0; i<graph.get(n).size(); i++) {
            int next = graph.get(n).get(i);
            if(!visited[next]) dfs(next);
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

        dfs(1);
    }
}
