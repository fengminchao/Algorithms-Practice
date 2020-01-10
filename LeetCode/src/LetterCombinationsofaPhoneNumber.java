import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ybao on 17/3/16.
 */
public class LetterCombinationsofaPhoneNumber {

    public static void main(String[] args) {
        List<String> list = new LetterCombinationsofaPhoneNumber().letterCombinations("23");
        System.out.println(list);
    }

    public List<String> letterCombinations(String digits) {
        Map<Character,char[]> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        if (digits == null || digits.length() == 0){
            return list;
        }
        char[] n2 = {'a','b','c'};
        char[] n3 = {'d','e','f'};
        char[] n4 = {'g','h','i'};
        char[] n5 = {'j','k','l'};
        char[] n6 = {'m','n','o'};
        char[] n7 = {'p','q','r','s'};
        char[] n8 = {'t','u','v'};
        char[] n9 = {'w','x','y','z'};
        map.put('2',n2);
        map.put('3',n3);
        map.put('4',n4);
        map.put('5',n5);
        map.put('6',n6);
        map.put('7',n7);
        map.put('8',n8);
        map.put('9',n9);

        return readDigitsAt(digits,0,list,map);
    }

    private List<String> readDigitsAt(String digits, int i, List<String> list,Map<Character,char[]> map) {
        if (i >= digits.length()){
            return list;
        }
        if (!map.containsKey(digits.charAt(i))){
            readDigitsAt(digits,i + 1,list,map);
        }else {
            if (list.size() == 0){
                for (int k = 0; k < map.get(digits.charAt(i)).length;k ++){
                    list.add(String.valueOf(map.get(digits.charAt(i))[k]));
                }

                return readDigitsAt(digits,i + 1,list,map);
            }
            List<String> sumList = new ArrayList<>();
            for (int j = 0;j < list.size();j ++){
                for (int k = 0;k < map.get(digits.charAt(i)).length;k ++){
                    sumList.add(list.get(j) + (map.get(digits.charAt(i)))[k]);
                }
            }
            return readDigitsAt(digits,i + 1,sumList,map);
        }
        return list;
    }
}
