
class Solution {
    public int closedIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    boolean closed = dfs(grid, i, j);
                    if (closed) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
    public boolean dfs(int[][] grid, int row, int col) {
        int m = grid.length;
        int n = grid[0].length;
        if (row < 0 || col < 0 || row >= m || col >= n) {
            return false;
        }
        if (grid[row][col] == 1) {
            return true;
        }
        grid[row][col] = 1;
        boolean down = dfs(grid, row + 1, col);
        boolean up = dfs(grid, row - 1, col);
        boolean right = dfs(grid, row, col + 1);
        boolean left = dfs(grid, row, col - 1);
        return down && up && right && left;
    }
}
