/**
 * Created by ybao on 16/12/30.
 */
public class Ex1_2_15 {

    public static void main(String[] args) {
        readInts("");
    }

    public static int[] readInts(String name){
        In in = new In(name);
        String input = in.readAll();
        String[] word = input.split("\\s+");
        int[] ints = new int[word.length];
        for (int i = 0;i < ints.length;i ++){
            ints[i] = Integer.parseInt(word[i]);
        }
        return ints;
    }
}
