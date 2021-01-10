/**
在柠檬水摊上，每一杯柠檬水的售价为 5 美元。
顾客排队购买你的产品，（按账单 bills 支付的顺序）一次购买一杯。
每位顾客只买一杯柠檬水，然后向你付 5 美元、10 美元或 20 美元。你必须给每个顾客正确找零，也就是说净交易是每位顾客向你支付 5 美元。
注意，一开始你手头没有任何零钱。
如果你能给每位顾客正确找零，返回 true ，否则返回 false 。
 */
class Solution {
    public boolean lemonadeChange(int[] bills) {
        // 统计5元和10元的个数，20元不用统计肯定找不出去
        int five = 0,ten = 0;
        for (int i=0;i<bills.length;i++) {
            //如果付5元就直接five++，不用找钱
            if(bills[i]==5) {
                five++;
            }
            //如果付10元，手上没有5元钞票直接返回false
            if(bills[i]==10&&five==0) return false;
            //如果付10元，手上有5元钞票，ten++，five--
            if(bills[i]==10&&five!=0) {
                five--;
                ten++;
            }
            //如果付20元，找零15元
            if(bills[i]==20) {
                //手上有10元和5元，则ten--，five--
                if(ten>0&&five>0) {
                    five--;
                    ten--;
                }//手上没有10元，但是有超过2张5元，five--
                else if(ten==0&&five>2){
                    five=five-3;
                }//都不满足返回false
                else{
                    return false;
                }
            };
        }
        return true;
    }
}