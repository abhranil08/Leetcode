class Solution {
    public int findComplement(int num) {
        int n=num,length=0;
        while(n>0)
        {
            length++;
            n/=2;
        }
        int mask=(1<<length)-1;
        
        // xor of a bit and one will toggle the bit.
        return num^mask;
    }
}
