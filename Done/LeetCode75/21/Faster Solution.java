// class Solution {
//     public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
//         List<List<Integer>> answer = new ArrayList<>();
//         List<Integer> store= new ArrayList<>();
//         Map<Integer,Integer> n1=new HashMap<>();
//         Map<Integer,Integer> n2=new HashMap<>();
//         int len1=nums1.length;
//         int len2=nums2.length;
//         for(int i=0,j=0;i<len1 ||j<len2; i++,j++){
//             if(i<len1) n1.put(nums1[i],n1.getOrDefault(nums1[i],0)+1);
//             if(j<len2) n2.put(nums2[j],n2.getOrDefault(nums2[j],0)+1);
//         }
//         for(int i=0;i<len1;i++){
//             if(!n2.containsKey(nums1[i])) {
//                 if(!store.contains(nums1[i])) store.add(nums1[i]);
//             }
//         }       
//         answer.add(new ArrayList<>(store));
//         store=new ArrayList<>();
//         for(int i=0;i<len2;i++){
//             if(!n1.containsKey(nums2[i]) ){
//                 if(!store.contains(nums2[i])) store.add(nums2[i]);
//             } 
//         } 
//         answer.add(new ArrayList<>(store));
//         return answer;
//     }
// }
import java.util.AbstractList;

class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        return new AbstractList<>() {
            List<Integer> res1, res2;
        private void init() {
            res1 = new ArrayList<>();
            res2 = new ArrayList<>();
            boolean[] v1 = new boolean[2001];
            boolean[] v2 = new boolean[2001];
            for (int num : nums1)
            v1[num + 1000] = true;
            for (int num : nums2)
            v2[num + 1000] = true;
            for (int num : nums1) {
                if (!v2[num + 1000]) {
                    res1.add(num);
                    v2[num + 1000] = true;
                }
            }
            for (int num : nums2) {
                if (!v1[num + 1000]) {
                    res2.add(num);
                    v1[num + 1000] = true;
                }
            }
        }
        @Override
        public List<Integer> get(int index) {
            if (res1 == null)
            init();
            if (index == 0)
            return res1;
            return res2;
        }
        @Override
        public int size() {
            return 2;
            }
        };
    }
}