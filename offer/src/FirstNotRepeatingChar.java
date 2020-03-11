public class FirstNotRepeatingChar {
    public int FirstNotRepeatingChar(String str) {
        if (str == null || str.equals("")){
            return -1;
        }
        int[] arr = new int[256];
        for (int i = 0;i < str.length();i++){
            char c = str.charAt(i);
            arr[c]++;
        }
        for (int i = 0;i < str.length();i++){
            char c = str.charAt(i);
            if (arr[c] == 1){
                return i;
            }
        }
        return -1;
    }
}
