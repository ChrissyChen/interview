
class Pair {
    public String str;
    public int freq;
    public Pair(String str, int freq) {
        this.str = str;
        this.freq = freq;
    }
}

public class Solution {
    private Comparator<Pair> PairComparator = new Comparator<Pair>() {
        public int compare(Pair a, Pair b) {
            if (a.freq - b.freq != 0) {
                return a.freq - b.freq;//数字小的排前面
            }
            return b.str.compareTo(a.str);  // pay attention!字母大的排前面
        }    
    };
    
    /**
     * @param words: an array of string
     * @param k: An integer
     * @return: an array of string
     */
    public String[] topKFrequentWords(String[] words, int k) {
        // write your code here
        if (words == null || words.length == 0) {
            return null;
        }
        
         if (k == 0) {
            return new String[0];
        }
        
        Map<String, Integer> map = new HashMap<>();
        for (String str : words) {
            if (!map.containsKey(str)) {
                map.put(str, 0);
            }
            map.put(str, map.get(str) + 1);
        }
        
        Queue<Pair> minHeap = new PriorityQueue<Pair>(k, PairComparator);
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String str = entry.getKey();
            int freq = entry.getValue();
            Pair p = new Pair(str, freq);
            minHeap.add(p);
            
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        
        String[] result = new String[k];
        for (int i = k - 1; i >= 0; i--) {
            result[i] = minHeap.poll().str;
        }
        return result;
    }
}




