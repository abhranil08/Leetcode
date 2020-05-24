class pair {
    int first;
    int second;
    pair(int first, int second)
    {
        this.first=first;
        this.second=second;
    }
}
class intervalListIntersection {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        ArrayList<int[]> answer = new ArrayList<>();
        int ptr1 = 0, ptr2 = 0;
        while(ptr1<A.length && ptr2<B.length)
        {
            int start = Math.max(A[ptr1][0],B[ptr2][0]);
            int end = Math.min(A[ptr1][1],B[ptr2][1]);
            if(start<=end)
                answer.add(new int[]{start,end});
            if(A[ptr1][1]<B[ptr2][1])
                ptr1++;
            else
                ptr2++;
        }
        return answer.toArray(new int[answer.size()][2]);
    }
}
