package Fibonacci;

public class 双指针迭代 {

    //针对递归去重的改进，因为我如果要算num的值只需要前面num-1和num-2的值，所以不需要长度为n的数组
    public static int iterate(int num){
        if(num == 0)
            return 0;
        if(num == 1)
            return 1;
        int low = 0, high = 1;
        //从2开始迭代到num个数
        //每次只保存前面两个值的结果
        for(int i = 2; i <= num; ++i){
            int sum = low + high;
            low = high;
            high = sum;
        }
        return high;
    }

    public static void main(String[] args) {
        System.out.println(iterate(9));
    }
}
