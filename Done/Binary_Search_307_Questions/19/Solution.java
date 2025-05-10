class Solution {
    public static int find(List<Integer> arr, int x){
        int s = 0;
        int e = arr.size() - 1;
        while(s <= e){
            int m = s + (e - s)/2;
            if(arr.get(m) >= x){
                e = m-1;
            }else{
                s = m+1;
            }
        }
        return s;
    }
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> li = new ArrayList<>();
        List<Integer> arr = Arrays.stream(nums).boxed().collect(Collectors.toList());
        
        Collections.sort(arr);
        for(int x : nums){
            int i = find(arr, x);
            li.add(i);
            arr.remove(i);
        }
        return li;
    }
}