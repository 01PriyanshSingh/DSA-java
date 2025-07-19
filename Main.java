import java.util.*;
public class Main {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Plear Enter the String.");
        String str= sc.nextLine();
        int sum=0;
        String New_str="";
        for(char ch:str.toCharArray()){
            if(Character.isDigit(ch)){
                sum += ch - '0';
            }else{
                New_str+=ch;
            }
        }
        System.out.println("String is"+New_str);
        System.out.println("Sum is "+sum);

        
    }
}