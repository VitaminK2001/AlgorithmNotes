package 线段树.区域和检索区间修改;

public class Solution {
    class NumArray {
        private int[] segmentTree;
        private int n;
        public NumArray(int[] nums) {
            int n = nums.length;
            segmentTree = new int[n*4];
            build(0, 0, n-1, nums);
        }

        public void update(int index, int val) {
            change(index, val, 0, 0, n-1);
        }

        public int sumRange(int left, int right) {
            return range(left, right, 0, 0, n-1);
        }
        private void build(int node, int s, int e, int[] nums){
            if(s == e){
                segmentTree[node] = nums[s];
                return;
            }
            int m = s + (e-s)/2;
            build(node*2+1, s, m, nums);
            build(node*2+2, m+1, e, nums);
            segmentTree[node] = segmentTree[node*2+1]+segmentTree[node*2+2];
        }
        private void change(int index, int val, int node, int s, int e){ //在s~e的范围内查找index
            if(s == e){
                segmentTree[node] = val;
                return;
            }
            int m = s + (e-s)/2;
            if(index <= m){
                change(index, val, node*2+1, s, m);
            }else {
                change(index, val, node*2+2, m+1, e);
            }
            segmentTree[node] = segmentTree[node*2+1]+segmentTree[node*2+2];
        }
        private int range(int left, int right, int node, int s, int e){ //寻找的是left到right的范围
            if(left == s && right == e){
                return segmentTree[node]; //返回区间和
            }
            int m = s + (e-s)/2;
            if(right <= m){
                return range(left, right, node*2+1, s, m);
            } //没有把right=m时候的right排除在外
            else if(left > m){
                return range(left, right, node*2+2, m+1, e);
            }else {
                return range(left, m, node*2+1, s, m) +
                        range(m+1, right, node*2+2, m+1, e);
            }
        }
    }
}
