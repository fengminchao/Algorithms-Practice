
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Function;

/**
 * Created by ybao on 17/3/20.
 */
public class Ex127 {

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = new ArrayList<>();
        String[] words = {"hot", "dot", "dog", "log", "cog"};
        wordList.addAll(Arrays.asList(words));
        int length = new Ex127().ladderLength(beginWord, endWord, wordList);
        System.out.println(length);
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        List<String> lists = new CopyOnWriteArrayList<>(wordList);
        int result = bfs(endWord, lists, queue, 1);
        return result;
    }

    public int bfs(String endWord, List<String> wordList, Queue<String> queue, int deep) {
        for (String s : queue){
            if (s.equals(endWord)){
                return deep;
            }
        }
        if (queue.size() == 0) {
            return 0;
        }

        int size = queue.size();

        for (int i = 0;i < size;i++) {
            String s = queue.poll();
            for (String word : wordList) {
                if (judge(s,word)){
                    queue.add(word);
                    wordList.remove(word);
                }
            }
        }
        return bfs(endWord,wordList,queue,++deep);
    }

    public boolean judge(String word, String transWord) {
        int diff = 0;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) != transWord.charAt(i)){
                diff++;
            }
        }
        return diff == 1;
    }
}
