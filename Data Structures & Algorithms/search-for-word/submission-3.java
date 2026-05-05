class Solution {

    int ROWS;
    int COLS;
    char[][] board;
    boolean[][] visited;


    public boolean dfs(int r, int c, String word) {
        if (word.length() == 0)
            return true;

        if (r < 0 || c < 0 || r >= ROWS || c >= COLS || board[r][c] != word.charAt(0) || visited[r][c]) {
            return false;
        }

        word = word.substring(1, word.length());
        visited[r][c] = true;
        if (dfs(r + 1, c, word) 
            || dfs(r - 1, c, word)
            || dfs(r, c - 1, word)
            || dfs(r, c + 1, word) ) return true;
        visited[r][c] = false;
        return false;
    }

    public boolean exist(char[][] board, String word) {
        this.ROWS = board.length;
        this.COLS = board[0].length;
        this.board = board;
        this.visited = new boolean[ROWS][COLS];

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (dfs(r, c, word)) return true;
            }
        }
        return false;
        
    }
}
