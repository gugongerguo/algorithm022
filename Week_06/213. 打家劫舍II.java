/*问题拆分，不偷第一家剩下家的最大值m1，不偷最后一家剩下家的最大值m2,取max(m1,m2)
dp方程：dp[i]=max(dp[i-1],nums[i]+dp[i-2]);
*/
class Solution {
    public int rob(int[] nums) {
        if(nums.length==1) return nums[0];
        //不偷第一家
        int m1 = robProcess(nums,1,nums.length-1);
        //不偷最后一家
        int m2 = robProcess(nums,0,nums.length-2);
        return Math.max(m1,m2);
    }

    public int robProcess(int[] nums,int start,int end) {
        int prepre=0,pre=0,tmp=0;
        for(int i=start;i<=end;i++){
            tmp = prepre;
            prepre = pre;
            pre = Math.max(prepre,nums[i]+tmp);
        }
        return pre;
    }
}