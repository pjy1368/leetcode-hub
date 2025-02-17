class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0) return result;
        
        int j = matrix.length;    
        int k = matrix[0].length; 
        
        for (int i = 0; i <= Math.min(j, k) / 2; i++) {
            if (i >= j - i || i >= k - i) break;
            
            // 1. 위쪽: matrix[i][i ~ k-i]
            for (int col = i; col < k - i; col++) {
                result.add(matrix[i][col]);
            }
            
            // 2. 오른쪽: matrix[i+1 ~ j-i][k-i-1]
            for (int row = i + 1; row < j - i; row++) {
                result.add(matrix[row][k - i - 1]);
            }
            
            if (i < j - i - 1 && i < k - i - 1) {
                // 3. 아래쪽: matrix[j-i-1][k-i-2 ~ i]
                for (int col = k - i - 2; col >= i; col--) {
                    result.add(matrix[j - i - 1][col]);
                }
                
                // 4. 왼쪽: matrix[j-i-2 ~ i+1][i]
                for (int row = j - i - 2; row > i; row--) {
                    result.add(matrix[row][i]);
                }
            }
        }
        
        return result;
    }
}
