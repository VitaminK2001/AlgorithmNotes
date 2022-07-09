package Divide_and_Conquer;
class Solution{
    public static int binarySearch(int [] array, int target){
        if(array == null || array.length == 0){
            return -1;
        }

        int start = 0, end = array.length -1;
        while(start + 1 < end){
            int mid = start + (end - start)/2;
            if(array[mid] == target){
                start = mid;
            }else if(array[mid] < target){
                start = mid;
            }else{
                end = mid;
            }
        }//终止结果start+1=end
        if(array[start] == target){
            return start;
        }
        if(array[end] == target){
            return end;
        }
        return -1;
    }
}

public class 九章算术{
    public static void main(String[] args) {
        int[] array = {5,7,7,8,8,10};
        System.out.println(Solution.binarySearch(array, 8));
    }    
}

