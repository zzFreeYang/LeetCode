package DFS;

/**
 * 给定一个包含了一些 0 和 1 的非空二维数组 grid
 * 岛屿 是由一些相邻的 1 (代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在水平或者竖直方向上相邻。你可以假设 grid 的四个边缘都被 0（代表水）包围着。
 * 找到给定的二维数组中最大的岛屿面积。(如果没有岛屿，则返回面积为 0 。)
 */
public class MaxAreaofIsland_695 {

    public static void main(String[] args) {
        int[][] grid = {{1,1,0,0,0},{1,1,0,0,0},{0,0,0,1,1},{0,0,0,1,1}};
        //-------------------- start --------------------------------
        if (grid.length == 0 || grid[0].length == 0) {
//            return 0;
        }
        int res = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 1) {
                    int a = dfs(grid, r, c);
                    res = Math.max(res, a);
                }
            }
        }
//        return res;
        System.out.println(res);
    }

    static int dfs(int[][] grid,int r,int c){

        if (!(0 <= r && r < grid.length
                && 0 <= c && c < grid[0].length)) {
            return 0;
        }
        if(grid[r][c] != 1){
            return 0;
        }
        grid[r][c] = 2;  //计算过的就是2
        return 1
                + dfs(grid,r-1,c)
                + dfs(grid,r+1,c)
                + dfs(grid,r,c-1)
                + dfs(grid,r,c+1);
    }
}
