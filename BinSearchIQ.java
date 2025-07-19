import java.util.*;
class BinSearchIQ {
    public static void main (String args[]){
        Scanner sc = new Scanner(System.in);
        //Ceiling of a number.Q) is arr[2,3,5,9,14,16,18] and target number is 15.
        //so Celing of a number means find smallest elemnt in array which is greater than or equal to the number 
        int[] arrForCeiling = {1,4,34,45,56,67,78,89};
        int targetForCeiling = 2;
        System.out.println("In array "+Arrays.toString(arrForCeiling)+"the ceiling of a "+ targetForCeiling+ " is "+ceilingOfANumber(arrForCeiling,targetForCeiling));

        //Find the floor of a number which is Greatest number less or equal to than the target.
        int[] arrForFLoor = {1,4,34,45,56,67,78,89};
        int targetForFloor=23;
        System.out.println("In array "+Arrays.toString(arrForFLoor)+"The floor of a "+targetForFloor + " is "+floorOfANumber(arrForFLoor,targetForFloor));
        
        //find the smallest letter greater than the target. and letter are in non decreasing order
        //https://leetcode.com/problems/find-smallest-letter-greater-than-target/description/
        char[] letter = {'c','f','j'};
        char targetOfSmallestLetter = 'c';
        System.out.println(nextGreatestLetter(letter,targetOfSmallestLetter));

        // Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.If target is not found in the array, return [-1, -1]
        //https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
        int[] nums={1,3,5,5,6,7,8};
         int targetToFindStartAndEnd=5;
        int [] ans = {-1,-1};
        ans[0] = searchStartAndEndPosition(nums,targetToFindStartAndEnd,true);
        if(ans[0]!=-1){
            ans[1]=searchStartAndEndPosition(nums,targetToFindStartAndEnd,false);
        }
        System.out.println("The postion of the target element "+targetToFindStartAndEnd+"in array "+Arrays.toString(nums)+" is "+Arrays.toString(ans));
        
    }   
    static int ceilingOfANumber(int[] arr , int target){
        int start =0;
        int end=arr.length;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(target<arr[mid]){
                end=mid-1;
            }else if(target>arr[mid]){
                start=mid+1;
            }else{
                return arr[mid];
            }
        }
        return arr[start];
    } 
    static int floorOfANumber(int[] arr , int target){
        int start =0;
        int end=arr.length;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(target<arr[mid]){
                end=mid-1;
            }else if(target>arr[mid]){
                start=mid+1;
            }else{
                return arr[mid];
            }
        }
        return arr[end];
    } 
    static char nextGreatestLetter(char[] letters, char target){
        int start=0;
        int end=letters.length-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(target<letters[mid]){
                end=mid-1;
            }else{
                start=mid+1;
            }
        }
        return letters[start % letters.length];
    }
    static int searchStartAndEndPosition(int[] nums,int target,boolean startIndex){
        int ans = -1;
        int start=0;
        int end = nums.length-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(target<nums[mid]){
                end=mid-1;
            }else if(target>nums[mid]){
                start=mid+1;
            }else{
                ans=mid;
                if(startIndex){
                    end=mid-1;
                }else{
                    start=mid+1;
                }
            }
        }
        return ans;
    }
    

    
    
}