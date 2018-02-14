package online_interview;
import java.util.*;
import java.io.*;
class Paren {
    public static int longestValidParentheses(String s) {
        int count = 0;
        int tem = 0;
        //int temp = 0;
        //Stack<Character> stack = new Stack<Character>();
        char[] arr = s.toCharArray();
        String[] chnum = new String[arr.length];
        int[] ret = new int[arr.length];
        for(int i = 0; i< arr.length; i++){
            chnum[i] = i + String.valueOf(arr[i]);
        }
        Stack<String> stack = new Stack<String>();
        for(int i = 0; i< s.length(); i++){
            if(stack.isEmpty()){
                if(s.charAt(i) == '(')
                    stack.push(chnum[i]);
                else
                    continue;
            }
            else{
                if(s.charAt(i) == '(')
                    stack.push(chnum[i]);
                else{
                    ret[i] = 1;
                    String temp = stack.pop();
                    ret[Integer.parseInt(temp.substring(0,1))] = 1;
                    
                }
            }
        }
        for(int i = 0; i< arr.length; i++){
            if(ret[i] != 0)
                tem += ret[i];
            else{
                if(tem > count)
                    count = tem;
                tem = 0;
            }
        }
        if(tem > count)
            count = tem;
        
        return count;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String s = line;
            
            int ret = longestValidParentheses(s);
            
            String out = String.valueOf(ret);
            
            System.out.print(out);
        }
    }
}