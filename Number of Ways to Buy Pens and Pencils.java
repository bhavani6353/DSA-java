/*


You are given an integer total indicating the amount of money you have. You are also given two integers cost1 and cost2 indicating the price of a pen and pencil respectively. You can spend part or all of your money to buy multiple quantities (or none) of each kind of writing utensil.

Return the number of distinct ways you can buy some number of pens and pencils.

 

Example 1:

Input: total = 20, cost1 = 10, cost2 = 5
Output: 9
Explanation: The price of a pen is 10 and the price of a pencil is 5.
- If you buy 0 pens, you can buy 0, 1, 2, 3, or 4 pencils.
- If you buy 1 pen, you can buy 0, 1, or 2 pencils.
- If you buy 2 pens, you cannot buy any pencils.
The total number of ways to buy pens and pencils is 5 + 3 + 1 = 9.
Example 2:

Input: total = 5, cost1 = 10, cost2 = 10
Output: 1
Explanation: The price of both pens and pencils are 10, which cost more than total, so you cannot buy any writing utensils. Therefore, there is only 1 way: buy 0 pens and 0 pencils.
*/

class Solution {
    public long waysToBuyPensPencils(int total, int cost1, int cost2) {
        if(total<cost1 && total<cost2)
            return 1;
        if(total<cost1 || total<cost2)
            return total<cost1?total/cost2+1:total/cost1+1;
        int k=total/cost1;
        long count=0;
        for(int i=0;i<=k;i++){
            count+=((long)total-(long)i*cost1)/(long)cost2+1;
        }
        return count;
    }
}


