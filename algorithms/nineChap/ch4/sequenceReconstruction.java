public class Solution {
    /**
     * @param org a permutation of the integers from 1 to n
     * @param seqs a list of sequences
     * @return true if it can be reconstructed only one or false
     */
    public boolean sequenceReconstruction(int[] org, int[][] seqs) {
        // Write your code here
        Map<Integer, Set<Integer>> map = new HashMap<Integer, Set<Integer>>();  //neighbors
        Map<Integer, Integer> indegree = new HashMap<Integer, Integer>();
    	
        for (int num : org) {
            map.put(num, new HashSet<Integer>());
            indegree.put(num, 0);
        }

        int n = org.length;
        int count = 0;
        for (int[] seq : seqs) {  //for 每个小array
            if (seq.length == 0) {  //跟答案不同的地方
                continue;
            }
            count += seq.length;
            if (seq[0] <= 0 || seq[0] > n)  //判断小array里的每个元素是否在[1，n]
                return false;                                //之间，因为org的每个元素是在[1，n]的，是1到n的排列
            for (int i = 1; i < seq.length; i++) { 
                if (seq[i] <= 0 || seq[i] > n) //判断小array里的每个元素是否在[1，n]之间
                    return false;
                if (map.get(seq[i - 1]).add(seq[i]))  //array里前一个元素的neighbor里加入后一个元素
                    indegree.put(seq[i], indegree.get(seq[i]) + 1);
            }
        }

        // case: [1], []
        if (count < n)
            return false;
		
        Queue<Integer> q = new ArrayDeque<Integer>();
        for (int key : indegree.keySet()) 
            if (indegree.get(key) == 0)
                q.add(key);
		
        int cnt = 0;
        while (q.size() == 1) {  //最后若是唯一的路径，那么一定是连成一条linkedlist.如果queue里放了两个及以上，说明路径不唯一。
            int ele = q.poll();
            for (int next : map.get(ele)) {
                indegree.put(next, indegree.get(next) - 1);
                if (indegree.get(next) == 0) q.add(next);
            }
            if (ele != org[cnt]) {
                return false;
            }
            cnt++;
        }
		
        return cnt == org.length;
    }
}