/*


You are given an array of strings words. Each element of words consists of two lowercase English letters.

Create the longest possible palindrome by selecting some elements from words and concatenating them in any order. Each element can be selected at most once.

Return the length of the longest palindrome that you can create. If it is impossible to create any palindrome, return 0.

A palindrome is a string that reads the same forward and backward.

 

Example 1:

Input: words = ["lc","cl","gg"]
Output: 6
Explanation: One longest palindrome is "lc" + "gg" + "cl" = "lcggcl", of length 6.
Note that "clgglc" is another longest palindrome that can be created.
Example 2:

Input: words = ["ab","ty","yt","lc","cl","ab"]
Output: 8
Explanation: One longest palindrome is "ty" + "lc" + "cl" + "yt" = "tylcclyt", of length 8.
Note that "lcyttycl" is another longest palindrome that can be created.
Example 3:

Input: words = ["cc","ll","xx"]
Output: 2
Explanation: One longest palindrome is "cc", of length 2.
Note that "ll" is another longest palindrome that can be created, and so is "xx".
 

Constraints:

1 <= words.length <= 105
words[i].length == 2
words[i] consists of lowercase English letters.


*/


class Solution {
    public int longestPalindrome(String[] words) {
        HashMap<String,Integer> hm=new HashMap<>();
        for(String w:words)
            hm.put(w,hm.getOrDefault(w,0)+1);
        int ans=0;
        boolean center=false;
        for(Map.Entry<String,Integer> e:hm.entrySet()){
            String word=e.getKey();
            int count=e.getValue();
            if(word.charAt(0)==word.charAt(1))
            {
                if(count%2==0)
                    ans+=count;
                else{
                    ans+=count-1;
                    center=true;
                }
            }
            else if(word.charAt(0)<word.charAt(1))
            {
                String revs=""+word.charAt(1)+word.charAt(0);
                if(hm.containsKey(revs))
                    ans+=2*Math.min(count,hm.get(revs));
            }
        }
        if(center)
            ans++;
        return 2*ans;
    }
}
