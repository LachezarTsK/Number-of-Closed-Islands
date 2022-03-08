
public class Solution {

    private static final int LAND = 0;
    private static final int WATER = 1;
    private static final int CLOSED_ISLAND = 2;
    private int rows;
    private int columns;

    public int closedIsland(int[][] grid) {
        rows = grid.length;
        columns = grid[0].length;
        int countClosedIslands = 0;

        for (int r = 1; r < rows - 1; r++) {
            for (int c = 1; c < columns - 1; c++) {
                if (grid[r][c] == 0 && isAreaOfClosedIsland(grid, r, c)) {
                    countClosedIslands++;
                }
            }
        }
        return countClosedIslands;
    }

    private boolean isAreaOfClosedIsland(int[][] grid, int r, int c) {
        if (r < 0 || r == rows || c < 0 || c == columns) {
            return false;
        }
        if (grid[r][c] == WATER || grid[r][c] == CLOSED_ISLAND) {
            return true;
        }

        // 'grid[r][c] = WATER' will also work. 'CLOSED_ISLAND' is for the sake of completeness.
        grid[r][c] = CLOSED_ISLAND;
        boolean up = isAreaOfClosedIsland(grid, r - 1, c);
        boolean down = isAreaOfClosedIsland(grid, r + 1, c);
        boolean left = isAreaOfClosedIsland(grid, r, c - 1);
        boolean right = isAreaOfClosedIsland(grid, r, c + 1);

        return up && down && left && right;
    }
}
