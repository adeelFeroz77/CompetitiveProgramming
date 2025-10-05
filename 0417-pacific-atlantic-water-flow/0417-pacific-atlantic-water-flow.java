class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n = heights.length, m = heights[0].length;
        boolean [][] atlanticVisited = new boolean[n][m];
        boolean [][] pacificVisited = new boolean[n][m];

        for(int i=0; i<n; i++){
            if(!pacificVisited[i][0])
                dfs(i, 0, heights, pacificVisited);
            if(!atlanticVisited[i][m-1])
                dfs(i, m-1, heights, atlanticVisited);
        }

        for(int i=0; i<m; i++){
            if(!pacificVisited[0][i])
                dfs(0, i, heights, pacificVisited);
            if(!atlanticVisited[n-1][i])
                dfs(n-1, i, heights, atlanticVisited);
        }

        List<List<Integer>> ans = new ArrayList<>();

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(atlanticVisited[i][j] && pacificVisited[i][j]){
                    List<Integer> x = new ArrayList<>();
                    x.add(i);
                    x.add(j);
                    ans.add(x);
                }
            }
        }

        return ans;
    }

    public void dfs(int row, int col, int [][] heights, boolean [][] visited) {
        visited[row][col] = true;
        int [] delRow = {-1,0,1,0};
        int [] delCol = {0,1,0,-1};
        int currentHeight = heights[row][col];
        for(int i=0; i<4; i++){
            int newRow = delRow[i] + row;
            int newCol = delCol[i] + col;

            if( newRow >= 0 && newRow < heights.length 
                && newCol >= 0 && newCol < heights[0].length
                && heights[newRow][newCol] >= currentHeight && !visited[newRow][newCol]) {
                    dfs(newRow, newCol, heights, visited);
                }
        }
    }
}