package DFS_BFS;

import java.util.*;

public class BFSEx {
    // 방문 정보 저장할 리스트
    public static boolean[] visited = new boolean[9];
    // 그래프 저장할 인접 리스트 생성
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();

    // BFS 함수 정의
    public static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        // 현재 노드를 큐에 집어 넣고 방문 처리
        q.offer(start);
        visited[start] = true;

        while(!q.isEmpty()) {
            int x = q.poll();
            System.out.print(x + " ");

            for(int i=0; i<graph.get(x).size(); i++) {
                int y = graph.get(x).get(i);
                if(!visited[y]) {
                    q.offer(y);
                    visited[y] = true;
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
