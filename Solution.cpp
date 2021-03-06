
#include <vector>
using namespace std;

class Solution {
    inline static const int LAND = 0;
    inline static const int WATER = 1;
    size_t rows;
    size_t columns;

public:
    int closedIsland(vector<vector<int>>&grid) {
        rows = grid.size();
        columns = grid[0].size();
        int countClosedIslands = 0;

        for (int r = 1; r < rows - 1; r++) {
            for (int c = 1; c < columns - 1; c++) {
                if (grid[r][c] == LAND && isAreaOfClosedIsland(grid, r, c)) {
                    countClosedIslands++;
                }
            }
        }
        return countClosedIslands;
    }

private:
    bool isAreaOfClosedIsland(vector<vector<int>>&grid, int r, int c) {
        if (r < 0 || r == rows || c < 0 || c == columns) {
            return false;
        }
        if (grid[r][c] == WATER) {
            return true;
        }

        grid[r][c] = WATER;
        bool up = isAreaOfClosedIsland(grid, r - 1, c);
        bool down = isAreaOfClosedIsland(grid, r + 1, c);
        bool left = isAreaOfClosedIsland(grid, r, c - 1);
        bool right = isAreaOfClosedIsland(grid, r, c + 1);

        return up && down && left && right;
    }
};
