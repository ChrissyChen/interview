public class Solution {
    /**
     * @param num: Given the candidate numbers
     * @param target: Given the target number
     * @return: All the combinations that sum to target
     */
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        // write your code here
        List<List<Integer>> results = new ArrayList<>();
        if (num == null || num.length == 0) {
            return results;
        }
        
        Arrays.sort(num);
        dfsHelper(num, 0, new ArrayList<Integer>(), target, results);
        return results;
    }
    
    private void dfsHelper(int[] num, int startIndex, List<Integer> comb,
                           int remainTarget, List<List<Integer>> results) {
        if (remainTarget == 0) {
            results.add(new ArrayList<Integer>(comb));
            return;
        }
        
        for (int i = startIndex; i < num.length; i++) {
            if (num[i] > remainTarget) {
                break;
            }
            if (i != startIndex && num[i] == num[i - 1]) {
                continue;
            }
            comb.add(num[i]);
            dfsHelper(num, i + 1, comb, remainTarget - num[i], results);
            comb.remove(comb.size() - 1);
        }
    }
}