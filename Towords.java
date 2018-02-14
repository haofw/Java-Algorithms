package online_interview;
//import java.util.*;
import java.io.*;
//import java.lang.*;
public class Towords {
	public static String numberToWords(Long num){
	    int len = 1;
	    Long temp = num;
	    for(int i = 1; i < 15; i ++){
	        temp = temp/10;
	        if(temp == 0){
	            len = i;
	            break;
	        }
	    }
	    int[] nu = new int[len];
	    temp = num;
	    for(int i = len - 1; i>= 0 ; i--){
	        nu[i] = (int) (temp % 10);
	        temp = temp / 10;
	    }
	    StringBuilder sb = new StringBuilder();
	    if(len == 1)
	        sb.append(singleWords(nu[0]));
	    else if (len == 2){
	        if(nu[0] == 1)
	            sb.append(singleWords(Math.toIntExact(num)));
	        else{
	            sb.append(singleWords(nu[0]*10));
	            if(nu[1] != 0){
	                sb.append(" ");
	                sb.append(singleWords(nu[1]));
	            }
	        }
	    }
	    else if(len ==3){
	        sb.append(singleWords(nu[0]));
	        sb.append(" Hundred");
	        if(nu[1] != 0 || nu[2] != 0){
	            sb.append(" ");
	            sb.append(numberToWords((long) (nu[1] * 10 + nu[2])));
	        }
	        
	    }
	    else if(len > 3 && len < 7){
	        int fp = 0;
	        int sp = 0;
	        for(int i = 0; i< len - 3; i++)
	            fp = fp*10 + nu[i];
	        for(int i = len - 3; i<len; i++)
	            sp = sp*10 + nu[i];
	        sb.append(numberToWords((long) fp));
	        sb.append(" Thousand");
	        if(sp != 0){
	            sb.append(" ");
	            sb.append(numberToWords((long) sp));
	        }
	    }
	    else if(len >=7 && len < 10){
	        int fp = 0;
	        int sp = 0;
	        for(int i = 0; i< len - 6; i++)
	            fp = fp*10 + nu[i];
	        for(int i = len - 6; i<len; i++)
	            sp = sp*10 + nu[i];
	        sb.append(numberToWords((long) fp));
	        sb.append(" Million");
	        if(sp != 0){
	            sb.append(" ");
	            sb.append(numberToWords((long) sp));
	        }
	    }
	    else if(len >= 10){
	        int fp = 0;
	        int sp = 0;
	        for(int i = 0; i< len - 9; i++)
	            fp = fp*10 + nu[i];
	        for(int i = len - 9; i<len; i++)
	            sp = sp*10 + nu[i];
	        sb.append(numberToWords((long) fp));
	        sb.append(" Billion");
	        if(sp != 0){
	            sb.append(" ");
	            sb.append(numberToWords((long) sp));
	        }
	        
	    }
	    return sb.toString();
	}

	public static String singleWords(int di){
	    if(di == 0)
	        return "Zero";
	    else if(di == 1)
	        return "One";
	    else if(di == 2)
	        return "Two";
	    else if(di == 3)
	        return "Three";
	    else if(di == 4)
	        return "Four";
	    else if(di == 5)
	        return "Five";
	    else if(di == 6)
	        return "Six";
	    else if(di == 7)
	    		return "Seven";
        else if(di == 8)
            return "Eight";
        else if(di == 9)
            return "Nine";
        else if(di == 10)
            return "Ten";
        else if(di == 11)
            return "Eleven";
        else if(di == 12)
            return "Twelve";
        else if(di == 13)
            return "Thirteen";
        else if(di == 14)
            return "Fourteen";
        else if(di == 15)
            return "Fifteen";
        else if(di == 16)
            return "Sixteen";
        else if(di == 17)
            return "Seventeen";
        else if(di == 18)
            return "Eighteen";
        else if(di == 19)
            return "Nineteen";
        else if(di == 20)
            return "Twenty";
        else if(di == 30)
            return "Thirty";
        else if(di == 40)
            return "Forty";
        else if(di == 50)
            return "Fifty";
        else if(di == 60)
            return "Sixty";
        else if(di == 70)
            return "Seventy";
        else if(di == 80)
            return "Eighty";
        else if(di == 90)
            return "Ninety";
        return "";
    }
	public static void main(String[] args) throws IOException{
//        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//        String line;
//        while ((line = in.readLine()) != null) {
//            Long num = Integer.parseInt(line);
//            
//            String ret = new String(numberToWords(num));
//            
//            String out = (ret);
//            
//            System.out.print(out);
//        }
		long num = 999999999999L;
		//String ret = numberToWords(num);
		System.out.print(num +2);
    }
}
