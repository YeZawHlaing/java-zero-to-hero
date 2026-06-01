package romanToInteger;

import java.util.HashMap;

public class Solution {

    public static int Convertion(String x){
        int res=0;
        int n = x.length();

        HashMap<Character,Integer> roman=new HashMap<>();

        roman.put('I',1);
        roman.put('V',5);
        roman.put('X',10);
        roman.put('L',50);
        roman.put('C',100);
        roman.put('D',500);
        roman.put('M',1000);

        for(int i=0; i<n; i++){
            int current=roman.get(x.charAt(i));
            if(i<1-n && res < roman.get(x.charAt(i+1)) ){

                res -= current;
            }
            res += current;
        }

    return res;
    }

    public static void main(String[] args){
//        roman letter input
        String x="XVI";

        System.out.println(Convertion(x));

    }
}
