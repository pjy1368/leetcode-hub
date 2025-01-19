class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        int[][] answer = new int[m][n];
        Queue<Point> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    queue.offer(new Point(i, j));
                } else {
                    answer[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        int[] rangeX = {-1, 0, 1, 0};
        int[] rangeY = {0, -1, 0, 1};

        while (!queue.isEmpty()) {
            Point current = queue.poll();
            
            for (int i = 0; i < 4; i++) {
                int dx = current.x + rangeX[i];
                int dy = current.y + rangeY[i];

                if (dx < 0 || dx >= m || dy < 0 || dy >= n) {
                    continue;
                }

                if (answer[dx][dy] > answer[current.x][current.y] + 1) {
                    answer[dx][dy] = answer[current.x][current.y] + 1;
                    queue.offer(new Point(dx, dy));
                }
            }
        }

        return answer;
    }
}

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}