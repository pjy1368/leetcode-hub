import java.util.*;

class Solution {

    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;

        boolean[][] visited = new boolean[n][m];

        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(sr, sc));
        visited[sr][sc] = true;

        int beginColor = image[sr][sc];
        while (!queue.isEmpty()) {
            Point current = queue.poll();
            image[current.x][current.y] = color;

            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    continue;
                }

                if (visited[nx][ny] || image[nx][ny] != beginColor) {
                    continue;
                }

                queue.offer(new Point(nx, ny));
                visited[nx][ny] = true;
            }
        }
        return image;
    }
}

class Point {

    int x, y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}