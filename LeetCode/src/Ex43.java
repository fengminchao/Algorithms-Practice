import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by ybao on 17/2/21.
 */
public class Ex43 {

    public static void main(String[] args) {
        Scanner s1 = new Scanner(System.in);
        Scanner s2 = new Scanner(System.in);
        String num1 = s1.nextLine();
        String num2 = s2.nextLine();
        Ex43 ex = new Ex43();
        System.out.println(ex.multiply(num1,num2));
    }

    public String multiply(String num1, String num2) {
        if (num1.length() == 1 && num1.substring(0,1).equals("0") || num2.length() == 1 && num2.substring(0,1).equals("0")){
            return "0";
        }
        StringBuffer sb1 = new StringBuffer(num1).reverse();
        StringBuffer sb2 = new StringBuffer(num2).reverse();

        List<StringBuffer> mulChilds = new ArrayList<>();
        for (int i =0;i < sb2.length();i ++){
            StringBuffer child = new StringBuffer();
            int n2 = Integer.valueOf(sb2.substring(i,i + 1));
            int moreNum = 0;
            for (int j = 0;j < sb1.length();j ++){
                int mul = n2 * Integer.valueOf(sb1.substring(j,j + 1)) + moreNum;

                child.append(mul % 10);
                moreNum = mul / 10;
            }
            if (moreNum > 0){
                child.append(moreNum);
            }
            mulChilds.add(child);
        }

        List<Integer> sums = new ArrayList<>();
        StringBuffer sumSb = new StringBuffer();
        int moreNum = 0;
        for (int i = 0;i < mulChilds.get(mulChilds.size() - 1).length() + sb2.length() - 1;i ++){
            int sum = 0;
            for (int j = 0;j < sb2.length();j ++){
                if (i - j >= 0 && mulChilds.get(j).length() > i - j) {
                    sum += Integer.valueOf(mulChilds.get(j).substring(i - j,i - j + 1));
                }else {
                    continue;
                }
            }
            sum += moreNum;
            sums.add(sum % 10);
            moreNum = sum / 10;
        }
        if (moreNum > 0) {
            sums.add(moreNum);
        }
        for (int i = 0;i < sums.size();i ++){
            sumSb.append(sums.get(i));
        }
        return sumSb.reverse().toString();
    }
}
