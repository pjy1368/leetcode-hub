class Solution {

    private int[] rangeX = {-1, 0, 1, 0};
    private int[] rangeY = {0, -1, 0, 1};

    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        boolean[][] visited = new boolean[m][n];
        int answer = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    DFS(grid, visited, m, n, i, j);
                    answer++;
                }
            }
        }
        return answer;
    }

    private void DFS(char[][] grid, boolean[][] visited, int m, int n, int x, int y) {
        for (int i = 0; i < 4; i++) {
            int dx = x + rangeX[i];
            int dy = y + rangeY[i];

            if (dx < 0 || dy < 0 || dx >= m || dy >= n) {
                continue;
            }

            if (grid[dx][dy] == '0') {
                continue;
            }

            if (!visited[dx][dy]) {
                visited[dx][dy] = true;
                DFS(grid, visited, m, n, dx, dy);
            }
        }
    }
}