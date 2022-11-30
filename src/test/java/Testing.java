import java.util.HashMap;

public class Testing {
    public static void main(String[] args) {
        System.out.println(solution("LVIII"));
        String roma = "CVI";
        int i = 1;
        int v = 5;
        int x = 10;
        int l = 50;
        int c = 100;
        int d = 500;
        int m = 1000;
//        for (int i = 0; i < roma.length(); i++) {
//            System.out.println(roma.charAt(i));
//        }
//        HashMap<Character,Integer> romaNumber = new HashMap<>();
//        romaNumber.put('I',1);
//        romaNumber.put('V',5);
//        romaNumber.put('X',10);
//        romaNumber.put('L',50);
//        romaNumber.put('C',100);
//        romaNumber.put('D',500);
//        romaNumber.put('m',1000);
//        int sum=0;
//        for (int j = 0; j < roma.length(); j++) {
//            if(j+1< roma.length() && romaNumber.get(j)> romaNumber.get(j+1)){
//                sum -= romaNumber.get(roma.charAt(j));
//            }else {
//                sum += romaNumber.get(roma.charAt(j));
//            }
//        }
//        System.out.println(sum);

    }

    public static int solution(String s){
        HashMap<Character,Integer> romaNumber = new HashMap<>();
        romaNumber.put('I',1);
        romaNumber.put('V',5);
        romaNumber.put('X',10);
        romaNumber.put('L',50);
        romaNumber.put('C',100);
        romaNumber.put('D',500);
        romaNumber.put('m',1000);
        int sum=0;
//        LVIII
        for (int i = 0; i < s.length(); i++) {
            if(i+1< s.length() && romaNumber.get(s.charAt(i))< romaNumber.get(s.charAt(i+1))){
                sum -= romaNumber.get(s.charAt(i));
            }else {
                sum += romaNumber.get(s.charAt(i));
            }
        }

        return sum;
    }

    public static int romanToInt(String s) {
        HashMap<Character,Integer> romaNumber = new HashMap<>();
        romaNumber.put('I',1);
        romaNumber.put('V',5);
        romaNumber.put('X',10);
        romaNumber.put('L',50);
        romaNumber.put('C',100);
        romaNumber.put('D',500);
        romaNumber.put('M',1000);
        int sum= 0;
        for(int i = 0; i < s.length();i ++){
            if(i+1<s.length() && romaNumber.get(s.charAt(i))>romaNumber.get(s.charAt(i+1))){
                sum-=romaNumber.get(s.charAt(i));
            }else{
                sum += romaNumber.get(s.charAt(i));
            }
        }
        return sum;
    }

    public static int solution2(String s){
        int ans = 0, num = 0;
        for (int i = s.length()-1; i >= 0; i--) {
            switch(s.charAt(i)) {
                case 'I': num = 1; break;
                case 'V': num = 5; break;
                case 'X': num = 10; break;
                case 'L': num = 50; break;
                case 'C': num = 100; break;
                case 'D': num = 500; break;
                case 'M': num = 1000; break;
            }
            if (4 * num < ans) ans -= num;
            else ans += num;
        }
        return ans;

    }

//    Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
//
//            Symbol       Value
//    I             1
//    V             5
//    X             10
//    L             50
//    C             100
//    D             500
//    M             1000
//    For example, 2 is written as II in Roman numeral, just two ones added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.
}
