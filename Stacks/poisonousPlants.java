/*
There are a number of plants in a garden. Each of these plants has been treated with some amount of pesticide. After each day, if any plant has more pesticide than the plant on its left, being weaker than the left one, it dies.

You are given the initial values of the pesticide in each of the plants. Print the number of days after which no plant dies, i.e. the time after which there are no plants with more pesticide content than the plant to their left.

For example, pesticide levels . Using a -indexed array, day  plants  and  die leaving . On day , plant  of the current array dies leaving . As there is no plant with a higher concentration of pesticide than the one to its left, plants stop dying after day .

Function Description
Complete the function poisonousPlants in the editor below. It must return an integer representing the number of days until plants no longer die from pesticide.

poisonousPlants has the following parameter(s):

p: an array of integers representing pesticide levels in each plant
Input Format

The first line contains an integer , the size of the array p.
The next line contains  space-separated integers p[i].

Constraints
1<=n<=10^5
1<=p[i]<=10^9


Output Format

Output an integer equal to the number of days after which no plants die.

Sample Input

7
6 5 8 4 7 10 9
Sample Output

2
Explanation

Initially all plants are alive.

Plants = {(6,1), (5,2), (8,3), (4,4), (7,5), (10,6), (9,7)}

Plants[k] = (i,j) => jth plant has pesticide amount = i.

After the 1st day, 4 plants remain as plants 3, 5, and 6 die.

Plants = {(6,1), (5,2), (4,4), (9,7)}

After the 2nd day, 3 plants survive as plant 7 dies.




Plants = {(6,1), (5,2), (4,4)}

After the 2nd day the plants stop dying.

*/




import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class poisonousPlants {

    // Complete the poisonousPlants function below.
    static int poisonousPlants(int[] p) {
        List<List<Integer>> allstacks = new ArrayList<List<Integer>>();
        
        int flag = p[0];
        List<Integer> ll=new ArrayList<>();
        ll.add(p[0]);
        allstacks.add(ll);

        for(int j=1;j<p.length;j++)
        {
            int i=p[j];
            if(i<=flag)
                ll.add(i);
            else
                {
                    ll=new ArrayList<>();
                    ll.add(i);
                    allstacks.add(ll);
                }            
            flag=i;
        }

        int day=0;
        boolean index = false;

        do {
            day++;
            index=false;
            for(int i=allstacks.size()-1;i>0;i--)
            {
                List<Integer> current = allstacks.get(i);
                current.remove(0);

                List<Integer> before = allstacks.get(i-1);

                if(current.size()==0)
                    allstacks.remove(i);
                else if(current.get(0)<=before.get(before.size()-1))
                {
                    before.addAll(current);
                    allstacks.remove(i);
                }
                index=true;
            }
        }while(index);
        return day-1;


    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] p = new int[n];

        String[] pItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int pItem = Integer.parseInt(pItems[i]);
            p[i] = pItem;
        }

        int result = poisonousPlants(p);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
