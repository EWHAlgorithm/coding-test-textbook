package DFS_BFS;
import java.util.*;

/**
 * Node
 */
class Node {
    private int x;
    private int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }
}

public class mazeEscape {
    /**
     * 최소 칸의 개수이므로 bfs 이용!
     */
    public static int n, m;
    public static int[][] maze = new int[200][200];

    // 이동 방향 (상, 하, 좌, 우)
    public static int[] dx = {0, 0, -1, 1};
    public static int[] dy = {1, -1, 0, 0};

    // 미로 탐색 로직
    public static int bfs(int x, int y) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x, y));

        while(!q.isEmpty()) {
            Node node = q.poll();
            int nx = node.getX();
            int ny = node.getY();

            for(int i=0; i<4; i++) {
                nx += dx[i];
                ny += dy[i];

                if(nx < 0 || nx >= n || ny < 0 || ny >= m)
                    continue;
                else if(maze[nx][ny] == 0)
                    continue;
                else if(maze[nx][ny] == 1) {
                    maze[nx][ny] = maze[x][y] + 1;
                    q.offer(new Node(nx, ny));
                }
            }
        }

        return maze[n-1][m-1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        sc.nextLine();

        // 미로 입력받기
        for(int i=0; i<n; i++) {
            String line = sc.nextLine();
            for(int j=0; j<m; j++) {
                maze[i][j] = line.charAt(j) - '0';
            }
        }

        System.out.println(bfs(0, 0));
        sc.close();
        
    }
    
}
