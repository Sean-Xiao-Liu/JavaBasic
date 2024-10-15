package LeetCode;

public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        int count = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == '1'){
                    ++count;
                    flipIslands(i,j,grid);
                }
            }
        }
        return count;
    }


    public void flipIslands(int i,int j,char[][] grid){ // make the return type to be void instead of boolean
        if (!(i < 0 || i >= grid.length || j < 0 || j >= grid[i].length)) {
            while (grid[i][j] == '1') { // the input type is char, not int
                grid[i][j] = '0';
                flipIslands(i - 1, j, grid);
                flipIslands(i + 1, j, grid);
                flipIslands(i, j - 1, grid);
                flipIslands(i, j + 1, grid);
            }
        }
    }

    public static void main(String[] args) {
        NumberOfIslands test = new NumberOfIslands();
        char[][] grid = {{'1','1','1','0'},{'1','1','0','0'},{'1','0','0','0'},{'0','0','0','1'}};
        int count = test.numIslands(grid);
        System.out.println("The number of island is: " + count);
    }
}
