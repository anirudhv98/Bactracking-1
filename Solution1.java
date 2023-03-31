// Time Complexity : O(2^(m*n))
// Space Complexity : O(m+n)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english

// Your code here along with comments explaining your approach
/*
 * I initially pass pivot as 0 to the helper function. Base condition of helper function : If target = 0, add temp array list to result and
 * return. Else if target less than 0 , return from fn. I have used for loop recursion wherein I execute loop from i = pivot to end of candidates
 * array. I add candidates[i] to temp and call the helper fn with i as pivot and target-candidates[i] as target. Now I backtrack 
 * by removing last element of the temporary array.
 */

 class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        helper(0,candidates,target,new ArrayList<Integer>());
        return result;
    }

    public void helper(int pivot,int []candidates, int target, ArrayList<Integer> temp)
    {
        if(target<0)
        {
            return;
        }
        if(target==0)
        {
            result.add(new ArrayList<>(temp));
            return;
        }
        
        for(int i=pivot;i<candidates.length;i++)
        {
            temp.add(candidates[i]);
            helper(i,candidates,target-candidates[i],temp);
            temp.remove(temp.size()-1);
        }
    }
}