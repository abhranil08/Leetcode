/*
Fruit Into Baskets - GFG
Difficulty: MediumAccuracy: 47.98% Submissions: 31K+ Points: 4
You are visiting a farm that has a single row of fruit trees arranged from left to right. The trees are represented by an integer array fruits of size N, where fruits[i]  is the type of fruit the ith tree produces.
You want to collect as much fruit as possible. However, the owner has some strict rules that you must follow :

You only have two baskets, and each basket can only hold a single type of fruit. There is no limit on the amount of fruit each basket can hold.
Starting from any tree of your choice, you must pick exactly one fruit from every tree (including the start tree) while moving to the right. The picked fruits must fit in one of the baskets.
Once you reach a tree with fruit that cannot fit in your baskets, you must stop.
Given the integer array fruits, return the maximum number of fruits you can pick.


Example 1:

Input:
N = 3
fruits [ ] = { 2, 1, 2 }
Output: 3
Explanation: We can pick from all three trees. 
 

Example 2:

Input:
N = 6
fruits [ ] = { 0, 1, 2, 2, 2, 2 }
Output: 5
Explanation: It's optimal to pick from trees(0-indexed) [1,2,3,4,5].

Your Task:
You don't need to read input or print anything. Your task is to complete function totalFruits() which takes the integer array fruits and its size N as input parameters and returns the maximum number of fruits that you can pick.
Expected Time Complexity: O(N).
Expected Auxiliary Space: O(1).
*/

//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t;
        t = sc.nextInt();
        while (t-- > 0) {

            int N;
            N = sc.nextInt();

            int[] fruits = new int[N];
            for (int i = 0; i < N; i++) fruits[i] = sc.nextInt();

            Solution obj = new Solution();
            int res = obj.totalFruits(N, fruits);

            System.out.println(res);
        }
    }
}
// } Driver Code Ends

// User function Template for Java
class Solution {
    public static int totalFruits(int N, int[] fruits) {
        int l = 0, r = 0;
        
        HashMap<Integer, Integer> hmap = new HashMap<>();
        int maxLength = 0;
        
        while(r<fruits.length){
            int currentFruit = fruits[r];
            if(hmap.containsKey(currentFruit)){
                hmap.put(currentFruit, hmap.get(currentFruit)+1);
            }
            else{
                hmap.put(currentFruit,1);
            }
            
            while(hmap.size()>2){
                int fruitToBeRemoved = fruits[l];
                hmap.put(fruitToBeRemoved, hmap.get(fruitToBeRemoved)-1);
                
                if(hmap.get(fruitToBeRemoved)==0){
                    hmap.remove(fruitToBeRemoved);
                }
                
                l++;
            }
            
            maxLength = Math.max(maxLength, r-l+1);
            r++;
        }
        
        return maxLength;
    }
}
