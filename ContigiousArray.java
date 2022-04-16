/*


Given a binary array nums, return the maximum length of a contiguous subarray with an equal number of 0 and 1.

 

Example 1:

Input: nums = [0,1]
Output: 2
Explanation: [0, 1] is the longest contiguous subarray with an equal number of 0 and 1.
Example 2:

Input: nums = [0,1,0]
Output: 2
Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.

*/



class Solution {
    public int findMaxLength(int[] nums) {
        int count=0,max=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,-1);
        for(int i=0;i<nums.length;i++){
            count=count+((nums[i]==1)?1:-1);
            if(map.containsKey(count))
                max=Math.max(max,i-map.get(count));
            else
                map.put(count,i);
        }
        return max;
    }
}
