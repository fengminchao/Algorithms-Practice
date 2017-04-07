import java.util.*;

/**
 * Created by ybao on 17/4/7.
 */
public class Ex49 {

    public static void main(String[] args) {
        String[] str = new String[]{"pad", "dab", "mug", "gum", "geo", "boa", "jag", "mig", "hug", "tee", "lyx", "wac", "box", "win", "rex", "baa", "rap", "mhz", "hep", "bad", "fun", "sub", "fri", "pyx", "leo", "jun", "dun", "sin", "adz", "err", "lbj", "ewe", "sue", "rye", "web", "wig", "man", "sis", "hay", "put", "duo"};
        List<List<String>> list = new Ex49().groupAnagrams(str);
        System.out.println(list);

    }

    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<List<String>>();
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String keyStr = String.valueOf(ca);
            if (!map.containsKey(keyStr)) {
                map.put(keyStr, new ArrayList<String>());
            }
            map.get(keyStr).add(s);
        }
        return new ArrayList<List<String>>(map.values());
    }
}
