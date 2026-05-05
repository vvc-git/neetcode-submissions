class Solution {

    private Set<String> res;
    private boolean[][] visit;
    private char[][] board;

    class NodeTree {
        Character val;
        Map<Character, NodeTree> next = new HashMap<>();
        boolean isEnd = false;
        
        public NodeTree(Character val) {
            this.val = val;
        }
    }

    class PrefixTree {
        NodeTree root;
        public PrefixTree() {
            this.root = new NodeTree('-');
        }

        public void insert(String word) {
            NodeTree node = this.root;

            for (Character c : word.toCharArray()) {
                if (!node.next.containsKey(c)) {
                    node.next.put(c, new NodeTree(c));
                }
                node = node.next.get(c);
            }
            node.isEnd = true;
        }
    }

    // word is the string that we are building
    private void dfs(int r, int c, NodeTree node, String word) {
        int rows = board.length, col = board[0].length;
        // Check if that current node has continuation
        if (r < 0 || c < 0 || r >= rows || c >= col ||
            visit[r][c] || 
            !node.next.containsKey(board[r][c])) {
                return;
            }
        
        // visit its neighbors
        visit[r][c] = true;
        node = node.next.get(board[r][c]);
        word += board[r][c];
        if (node.isEnd) {
            res.add(word);
        }

        dfs(r + 1, c, node, word);
        dfs(r - 1, c, node, word);
        dfs(r, c + 1, node, word);
        dfs(r, c - 1, node, word);

        visit[r][c] = false;
    }
    
    public List<String> findWords(char[][] board, String[] words) {
        this.board = board;
        PrefixTree pt = new PrefixTree();
        
        for (String s : words) {
            pt.insert(s);
        }

        int rows = board.length, col = board[0].length;
        res = new HashSet<>();
        visit = new boolean[rows][col];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < col; j++) {
                dfs(i, j, pt.root, "");
            } 
        }
        return new ArrayList<>(res);
    }
}
