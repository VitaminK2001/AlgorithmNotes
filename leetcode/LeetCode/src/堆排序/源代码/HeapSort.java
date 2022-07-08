package 堆排序.源代码;

import java.util.Arrays;

public class HeapSort {
    public int[] sort(int[] sourceArray){
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
        int len = arr.length;
        buildMaxHeap(arr, len);
        for(int i = len-1; i > 0; --i){
            swap(arr, 0, i);
            len--;
            heapify(arr, 0, len);
        }
        return arr;
    }

    private void buildMaxHeap(int[] arr, int len) {
        for(int i = (int)Math.floor(len/2); i >= 0; --i){
            heapify(arr, i, len);
        }
    }

    private void heapify(int[] arr, int i, int len) {
        int left = 2*i+1;
        int right = 2*i+2;
        int largest = i;
        if(left < len && arr[left] > arr[largest]){
            largest = left;
        }
        if(right < len && arr[right] > arr[largest]){
            largest = right;
        }
        if(i != largest){
            swap(arr, i, largest);
            heapify(arr, largest, len); //下标没有改变
        }

    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}

class Main{
    public static void main(String[] args) {
        int[] array = {3,5,2,4,7,6,1,10};
        HeapSort s = new HeapSort();
        int[] a = s.sort(array);
        for(int c : a) {
            System.out.println(c);
        }
    }
}
