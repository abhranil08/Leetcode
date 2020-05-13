class Solution {
    public String removeKdigits(String num, int k) {
        if(k==num.length())
            return "0";
        
        StringBuilder str=new StringBuilder(num);
        for(int i=0;i<k;i++)
        {
            int j=0;
            while(j<str.length()-1 && str.charAt(j)<=str.charAt(j+1))
                j++;
            str.delete(j,j+1);
            
        }
        while(str.length()>1 && str.charAt(0)=='0')
            str.delete(0,1);
        
        if(str.length()==0)
            return "0";
        
        return str.toString();
            
            
                  
        }
}
