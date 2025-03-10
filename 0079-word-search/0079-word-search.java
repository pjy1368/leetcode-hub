import java.util.*;

class Solution {
    
    private int[] dx = {-1, 0, 1, 0};
    private int[] dy = {0, 1, 0, -1};

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    boolean[][] visited = new boolean[m][n];
                    if (dfs(board, word, i, j, 0, visited)) {
                        return true;
                    }
                }
            }
        }
        
        return false;
    }

    private boolean dfs(char[][] board, String word, int x, int y, int index, boolean[][] visited) {
        // 현재 위치가 word의 마지막 글자와 일치하면 성공
        if (index == word.length() - 1) {
            return true;
        }
        
        visited[x][y] = true;
        
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            // 유효한 위치이고, 방문하지 않았으며, 다음 글자와 일치하는지 확인
            if (isValid(nx, ny, board) && !visited[nx][ny] && board[nx][ny] == word.charAt(index + 1)) {
                if (dfs(board, word, nx, ny, index + 1, visited)) {
                    return true;
                }
            }
        }
        
        visited[x][y] = false;
        
        return false;
    }
    
    private boolean isValid(int x, int y, char[][] board) {
        return x >= 0 && x < board.length && y >= 0 && y < board[0].length;
    }
}