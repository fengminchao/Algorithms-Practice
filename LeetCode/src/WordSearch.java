import java.util.Arrays;

/**
 * Given a 2D board and a word, find if the word exists in the grid.
 *
 * The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring.
 * The same letter cell may not be used more than once.
 *
 * Example:
 *
 * board =
 * [
 *   ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]
 *
 * Given word = "ABCCED", return true.
 * Given word = "SEE", return true.
 * Given word = "ABCB", return false.
 */
public class WordSearch {

    public static void main(String[] args){
        char[][] board = {{'A','B','C','E'},{'S','F','E','S'},{'A','D','E','E'}};
        boolean result = new WordSearch().exist(board,"ABCESEEEFS");
        System.out.println(result);
    }

    public boolean exist(char[][] board, String word) {
        if (board.length == 0 || word == null){
            return false;
        }
        boolean[][] paths = new boolean[board.length][board[0].length];
        for (int i = 0;i < board.length;i++){
            for (int j = 0;j < board[0].length;j++){
                boolean result = search(board,word,i,j,0,paths);
                if (result){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean search(char[][] board, String word, int i, int j, int wIndex,boolean[][] paths) {
        if (wIndex == word.length()){
            return true;
        }
        if (i >= board.length || i < 0){
            return false;
        }
        if (j >= board[0].length || j < 0){
            return false;
        }
        if (paths[i][j]){
            return false;
        }
        if (board[i][j] == word.charAt(wIndex)){
            paths[i][j] = true;
            wIndex++;
            boolean totalResult = search(board, word, i, j + 1, wIndex,paths) ||
                    search(board,word,i,j-1,wIndex,paths) ||
                    search(board,word,i+1,j,wIndex,paths) ||
                    search(board,word,i-1,j,wIndex,paths);
            paths[i][j] = false;
            return totalResult;
        }else {
            return false;
        }
    }
}
