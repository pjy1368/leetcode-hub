class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[] rangeX = {-1, 0, 1, 0};
        int[] rangeY = {0, -1, 0, 1};

        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j, 0});
                }
            }
        }

        int answer = 0;
        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            for (int i = 0; i < 4; i++) {
                int dx = current[0] + rangeX[i];
                int dy = current[1] + rangeY[i];

                if (dx < 0 || dy < 0 || dx >= m || dy >= n) {
                    continue;
                }

                if (grid[dx][dy] == 1) {
                    grid[dx][dy] = 2;
                    queue.offer(new int[]{dx, dy, current[2] + 1});
                }
            }
            
            answer = Math.max(answer, current[2]);
        }

        boolean isRotten = false;
        boolean isFresh = false;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    isFresh = true;
                }
                if (grid[i][j] == 2) {
                    isRotten = true;
                }
            }
        }

        if (isRotten && isFresh) {
            answer = -1;
        }

        return answer;
    }
}