class Solution {
    public int subarraySum(int[] nums, int k) {
        int sum = 0, res = 0;
        HashMap<Integer,Integer> h = new HashMap<>();
        h.put(0,1);
        for(int i=0;i<nums.length;i++)
        {
            sum += nums[i];
            int removeSum = sum-k;
            if(h.containsKey(removeSum))
                res += h.get(removeSum);

            h.put(sum, h.getOrDefault(sum,0)+1);          
        }
        System.out.println(h.get(k));
        return res;       
    }
}
