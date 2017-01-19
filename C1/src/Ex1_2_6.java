/**
 * Created by ybao on 16/12/29.
 */
public class Ex1_2_6 {

    public static void main(String[] args) {
        String s1 = "actbyt";
        String s2 = "ytactb";

        if (s1.length() == s2.length()){
            s1 = s1 + s1;
            if (s1.indexOf(s2) < s2.length() && s1.indexOf(s2) > 0){
                System.out.println("s1 is circular rotation to s2");
            }else {
                System.out.println("they are not circular rotation");
            }
        }else {
            System.out.println("they are not circular rotation");
        }
    }


}
