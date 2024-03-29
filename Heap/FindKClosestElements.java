/*
658. Find K Closest Elements

Given a sorted integer array arr, two integers k and x, return the k closest integers to x in the array. The result should also be sorted in ascending order.

An integer a is closer to x than an integer b if:

|a - x| < |b - x|, or
|a - x| == |b - x| and a < b
 

Example 1:

Input: arr = [1,2,3,4,5], k = 4, x = 3
Output: [1,2,3,4]
Example 2:

Input: arr = [1,2,3,4,5], k = 4, x = -1
Output: [1,2,3,4]
 

Constraints:

1 <= k <= arr.length
1 <= arr.length <= 104
arr is sorted in ascending order.
-104 <= arr[i], x <= 104

*/

class KClosestComparator implements Comparator<Integer> {
    public int compare(Integer a, Integer b) {
        int diffA = Math.abs(a - x);
        int diffB = Math.abs(b - x);
        if (diffA < diffB) {
            return -1;
        }
        else if( diffA == diffB )
        {
            if( a < b )
                return -1;
            else
                return 1;
        }
        return 1;
    }
    private int x;
    public KClosestComparator(int x) {
        this.x = x;
    }
}
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> closestElements = new ArrayList<>();

        Integer[] intArr = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            intArr[i] = arr[i];
        }

        KClosestComparator comparator = new KClosestComparator(x);
        Arrays.sort(intArr, comparator);
        
        for( int i = 0; i <k;i++)
        closestElements.add(intArr[i].intValue());
        Collections.sort(closestElements);

        return closestElements;
    }
}
