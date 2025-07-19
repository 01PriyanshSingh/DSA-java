import java.util.*;
class Search {
    public static void main(String args[]){
        int[] arr = {1,4,5,3,65,23,25};
        int target=5;
        String str= "HelloWorld";
        char strTarget='o';
        System.out.println("Postion of element in array is  "+LinearSearchh(arr,target));
        System.out.println("Postion of element in String  is  "+charSearchh(str,strTarget));
        System.out.println("Minimum element in array is "+ minElement(arr));
        System.out.println("Postion of element in array using Binary search after sorting array is   "+binarySearchh(arr,target));

    }

    //Linear Search
    static int LinearSearchh(int[] arr,int target){
        if(arr.length==0) return -1;
        for(int i=0;i<arr.length;i++){
            int c=0;
            if(arr[i]==target) return i;
        }

        return -1;
    }

    //Searching in String
    static int charSearchh(String str,char target){
        for(int i=0;i<str.length();i++){
            if(target==str.charAt(i)){
                return i;
            }
        }
        return -1;
        
    }
    //Find minimum element in array using linear search;
    static int minElement(int[] arr){
        int minInt = Integer.MAX_VALUE;  // 2,147,483,647
         
        if(arr.length==0) return -1;
        for(int i:arr){
            if(i<minInt){
                minInt=i;
            }
        }

        return minInt;
    }
    //Binaryy Searchh
    static int binarySearchh(int[] arr,int target){
        Arrays.sort(arr);
        int start=0;
        int end=arr.length-1;
        while (start<=end){
            int mid=start+(end-start)/2;
            if(target<arr[mid]){
                end=mid-1;
            }else if(target >arr[mid]){
                start=mid+1;
            }else{
                return mid;
            }
        }
        return -1;
    }




}