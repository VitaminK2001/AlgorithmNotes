class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> ans;
        List<Integer> proc;
        int n = arr.length;
        Arrays.sort(arr);
        int nest = Integer.MAX_VAlUE;
        for(int i = 0; i < n-1; ++i){
            int delta = arr[i+1]-arr[i];
            if(delta < min){
                min = delta;
                ans.clear();
                List<Integer> pair = new ArrayList<Integer>();
                pair.add(arr[i]);
                pair.add(arr[i+1]);
                ans.add(pair);
            }else if(delta == best){
                List<Integer> pair = new ArrayList<Integer>();
                pair.add(arr[i]);
                pair.add(arr[i+1]);
                ans.add(pair);
            }
        }
        return ans;
    }
}
