/*

Problem link: https://leetcode.com/problems/queue-reconstruction-by-height/

Suppose you have a random list of people standing in a queue. 
Each person is described by a pair of integers (h, k), 
where h is the height of the person and k is the number of people in front of this person who have a height greater than or equal to h. 
Write an algorithm to reconstruct the queue.

Note:
The number of people is less than 1,100.

 
Example

Input:
[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]

Output:
[[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]

*/

class queueReconstructionByHeight {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>()
                    {
                        public int compare(int[] obj1, int[] obj2)
                        {
                            if(obj1[0]==obj2[0])
                                return Integer.compare(obj1[1],obj2[1]); // same height, prefer "k"
                            return Integer.compare(obj2[0],obj1[0]); // Else prefer, height
                        }
                    });
                    List<int[]> ans = new LinkedList<>();
                    for(int i=0;i<people.length;i++)
                    ans.add(people[i][1],people[i]);
                    
                    return ans.toArray(people);
    }
}
