package trees.trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Input:
 * board = [
 * {'o','a','a','n'}
 * {'e','t','a','e'}
 * {'i','h','k','r'}
 * {'i','f','l','v']
 * ]
 * words = ["oath","pea","eat","rain"]
 * <p>
 * Output: ["eat","oath"]
 */
public class WordSearchII {

    static int[][] points = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) {
        char[][] board = {
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}};
        String[] words = {"oath","pea","eat","rain"};
        List<String> res = findWords(board, words);
        res.forEach(System.out::println);

    }

    private static List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        if (words == null || words.length == 0) {
            return res;
        }

        Trie trie = insert(words);

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(res, i, j, board, trie);
            }
        }

        return res;
    }

    private static Trie insert(String[] words) {
        Trie root = new Trie();

        for (String word : words) {
            Trie cur = root;
            char[] chars = word.toCharArray();
            for (char c : chars) {
                if(!cur.children.containsKey(c)){
                    cur.children.put(c, new Trie());
                }
                cur = cur.children.get(c);
            }
            cur.word = word;
        }
        return root;
    }

    private static void dfs(List<String> res, int x, int y, char[][] board, Trie root) {
        if (!root.children.containsKey(board[x][y])) {
            return;//no such word starts with board[x][y] as prefix
        }

        Trie child = root.children.get(board[x][y]);

        if (child.word != null) {//it's a word!
            res.add(child.word);
            child.word = null;//make it unvisitable after add to result set, avoid duplicates
        }

        //back track
        char temp = board[x][y];
        board[x][y] = '0';
        for (int[] p : points) {
            int nextX = x + p[0];
            int nextY = y + p[1];
            if (nextX >= 0 && nextX < board.length && nextY >= 0 && nextY < board[0].length && board[nextX][nextY] != '0') {
                dfs(res, nextX, nextY, board, child);
            }
        }
        board[x][y] = temp;//revert back
    }

    static class Trie {
        String word;
        Map<Character, Trie> children;
        // boolean isWord;//don't need isWord, if word!=null then this node is the end of the word

        public Trie() {
            this.word = null;
            this.children = new HashMap<>();
        }
    }
}
