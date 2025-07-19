import java.util.*;
public class sortingAlgo {
    public static void main(String[] args){
        int[] arrForBubbleSort={12,23,34,21,1,3};
        int[] arr2={1,2,3,4,5,6};
        System.out.println("Doing Bubble sort");        
        doBubbleSort(arrForBubbleSort);
        System.out.println();

        int[] arrForSelectionSort={12,23,34,21,1,3};
        System.out.println("Doing Selection sort"); 
        doSelectionSort(arrForSelectionSort);
        System.out.println();

        int[] arrForInsertionSort={12,23,34,21,1,3};
        System.out.println("Doing Insertion sort"); 
        doInsertionSort(arrForInsertionSort);
        System.out.println();

    }   
    //Bubble sort
    static void doBubbleSort(int[] arr){
        for(int i=0;i<arr.length;i++){
            System.out.println(Arrays.toString(arr));
            boolean swapped=false;
            for(int j=1;j<arr.length-i;j++){
                if(arr[j]<arr[j-1]){
                    swapped=true;
                    swapItems(arr,j,j-1);
                }
            }
            if(!swapped){
                break;
            }
        }
    } 
    //bubble sort end
    
    //Selection sort
    static void doSelectionSort(int[] arr){
        System.out.println(Arrays.toString(arr));
        for (int i=0;i<arr.length;i++){
            int last=arr.length-i-1;
            int max=getMaxForSelectionSort(arr,0,last);
            System.out.println("Max is"+arr[max]+"last is"+arr[last]);
            swapItems(arr,max,last);
            System.out.println(Arrays.toString(arr));
        }
    }
    static int getMaxForSelectionSort(int[] arr,int start,int last){
        int max=start;
        for(int i=start;i<=last;i++){
            if(arr[max]<arr[i]){
                max=i;
            }
        }
        return max;
    }
    //Selection sort end

    //Insertion Sort
    static void doInsertionSort(int[] arr){
        
        for(int i=0;i<arr.length-1;i++){
            
            for(int j=i+1;j>0;j--){
                if(arr[j]<arr[j-1]){
                    swapItems(arr,j,j-1);
                }else{
                    break;
                }
                
            }
            System.out.println(Arrays.toString(arr));
        }
        
    }


    static void swapItems(int[] arr,int first,int second){
        int temp=arr[first];
        arr[first]=arr[second];
        arr[second]=temp;
        
    }
}