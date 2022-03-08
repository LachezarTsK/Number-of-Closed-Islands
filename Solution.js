
/**
 * @param {number[][]} grid
 * @return {number}
 */
var closedIsland = function (grid) {
    this.LAND = 0;
    this.WATER = 1;

    this.rows = grid.length;
    this.columns = grid[0].length;
    let countClosedIslands = 0;

    for (let r = 1; r < this.rows - 1; r++) {
        for (let c = 1; c < this.columns - 1; c++) {
            if (grid[r][c] === this.LAND && isAreaOfClosedIsland(grid, r, c)) {
                countClosedIslands++;
            }
        }
    }
    return countClosedIslands;
};

/**
 * @param {number[][]} grid
 * @param {number} r
 * @param {number} c
 * @return {boolean}
 */
function isAreaOfClosedIsland(grid, r, c) {
    if (r < 0 || r === this.rows || c < 0 || c === this.columns) {
        return false;
    }
    if (grid[r][c] === this.WATER) {
        return true;
    }

    grid[r][c] = this.WATER;
    let up = isAreaOfClosedIsland(grid, r - 1, c);
    let down = isAreaOfClosedIsland(grid, r + 1, c);
    let left = isAreaOfClosedIsland(grid, r, c - 1);
    let right = isAreaOfClosedIsland(grid, r, c + 1);

    return up && down && left && right;
}
