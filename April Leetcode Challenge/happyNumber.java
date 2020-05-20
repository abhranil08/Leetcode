class happyNumber {
    public int sum(int n)
    {
        int s=0;
        while(n>0)
        {
            s+=(n%10)*(n%10);
            n=n/10;
        }
        return s;
    }
    public boolean isHappy(int n) {
        HashSet<Integer> h=new HashSet<>();
        while(sum(n)!=1)
        {
            int a=sum(n);
            if(h.contains(a))
                return false;
            h.add(a);
            n=a;
        }
        return true;
        
    }
}
