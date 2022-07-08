package 堆排序.数组中的第k个最大元素;

//https://leetcode-cn.com/problems/kth-largest-element-in-an-array/solution/shu-zu-zhong-de-di-kge-zui-da-yuan-su-by-leetcode-/
public class Solution {
    //将大根堆的堆顶，移除k次

    //构建大根堆

    //对大根堆进行排序
    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        buildMaxHeap(nums, len);
        for(int i = 0; i < k-1; ++i){ //只移动k-1次，最后剩下来的堆顶元素就是第k大的元素
            swap(nums, 0, len-1);
            len--;
            heapify(nums, 0, len);
        }
        return nums[0];
    }
    private void buildMaxHeap(int[] arr, int len){
        for(int i = (int)Math.floor(len/2); i >= 0; --i){
            heapify(arr, i, len);
        }
    }
    private void heapify(int[] arr, int i, int len){
        int left = i*2+1;
        int right = i*2+2;
        int largest = i;
        if(left < len && arr[left] > arr[largest]){
            largest = left;
        }
        if(right < len && arr[right] > arr[largest]){
            largest = right;
        }
        if(largest!=i){
            swap(arr, largest, i);
            //将左右子树的最大堆构建起来
            heapify(arr, largest, len);
        }
    }
    public void swap(int[] arr, int i, int j){
        int tmp;
        tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
