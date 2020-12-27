class Solution {
    public int nthUglyNumber(int n) {
        int a =0,b=0,c=0;
        int[] list = new int[n];
        list[0] = 1;
        for (int i=1;i<n;i++) {
            list[i] = Math.min(Math.min(list[a]*2,list[b]*3),list[c]*5);
            if(list[a]*2==list[i]) a++;
            if(list[b]*3==list[i]) b++;
            if(list[c]*5==list[i]) c++;
        }
        return list[n-1];
    }
}