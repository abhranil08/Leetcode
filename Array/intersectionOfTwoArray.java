/*

Given two arrays, write a function to compute their intersection.

Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2,2]
Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [4,9]
Note:

Each element in the result should appear as many times as it shows in both arrays.
The result can be in any order.
Follow up:

What if the given array is already sorted? How would you optimize your algorithm?
What if nums1's size is small compared to nums2's size? Which algorithm is better?
What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?

*/

/*

Time: 0(max(nums1,nums2))
Space: 0(max(nums1,nums2))

*/

class intersectionOfTwoArray {
    public HashMap<Integer,Integer> createHash(int nums[],HashMap<Integer,Integer> h)
    {
       for(int i:nums)
        {
            if(!h.containsKey(i))
                h.put(i,1);
            else
                h.put(i,h.get(i)+1);
        } 
        return h;   
    }
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> h1=new HashMap<>();
        HashMap<Integer,Integer> h2=new HashMap<>();
        h1 = createHash(nums1,h1);
        h2 = createHash(nums2,h2);
        List<Integer> ans = new ArrayList<>();
        for(Map.Entry<Integer,Integer> iterator : h1.entrySet())
        {
            if(h2.containsKey(iterator.getKey()))
            {
                int n=Math.min(iterator.getValue(),h2.get(iterator.getKey()));
                while(n-->0)
                    ans.add(iterator.getKey());
            }
                
        }
        //System.out.println(ans);
        int ar[]=new int[ans.size()];
        for(int i=0;i<ans.size();i++)
            ar[i]=ans.get(i);
        return ar;
        
        
    }
}
