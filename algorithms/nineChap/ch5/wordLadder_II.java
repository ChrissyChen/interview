//OMG!这是我自己写的答案耶！！！虽然虽然花了3小时，都不敢相信AC了！！！太牛了啦！！！
// 06/27/2018 CXL


public class Solution {
    private int shortestSequenceLength;
    
    /*
     * @param start: a string
     * @param end: a string
     * @param dict: a set of string
     * @return: a list of lists of string
     */
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        // write your code here
        List<List<String>> results = new ArrayList<>();
        if (dict == null || dict.size() == 0) {
            return results;
        }
        
        dict.add(start);
        dict.add(end);
        
        Map<String, Integer> endDistance = getDistanceToEnd(start, end, dict);
        
        List<String> sequence = new ArrayList<>();
        sequence.add(start);
        dfs(start, shortestSequenceLength - 1, dict, sequence, results, endDistance);
        return results;
    }
    
    private Map<String, Integer> getDistanceToEnd(String start, String end, 
                                                    Set<String> dict) {
        
        Map<String, Integer> distance = new HashMap<>();
        
        Queue<String> queue = new LinkedList<>();
        Set<String> hash = new HashSet<>();
        queue.add(end);
        hash.add(end);
        
        int dist = 1;  
        shortestSequenceLength = 1;
        distance.put(end, dist);
        while (!queue.isEmpty()) {
            dist++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                for (String nextWord : getNextWords(word, dict)) {
                    if (hash.contains(nextWord)) {
                        continue;
                    }
                    if (nextWord.equals(start)) {
                        shortestSequenceLength = dist;
                    }
                    
                    distance.put(nextWord, dist);
                    queue.add(nextWord);
                    hash.add(nextWord);
                }
            }
        }
        return distance;
    }
    
    private List<String> getNextWords(String word, Set<String> dict) {
        List<String> results = new ArrayList<>();
        int n = word.length();
        for (int i = 0; i < n; i++) {
            for (char ch = 'a'; ch < 'z'; ch++) {
                if (word.charAt(i) == ch) {
                    continue;
                }
                String newWord = replaceWord(word, i, ch);
                if (dict.contains(newWord)) {
                    results.add(newWord);
                }
            }
        }
        return results;
    }
    
    private String replaceWord(String word, int index, char ch) {
        char[] chars = word.toCharArray();
        chars[index] = ch;
        return new String(chars);
    }
    
    private void dfs(String newStart, int remainDistance,
                     Set<String> dict,
                     List<String> sequence,
                     List<List<String>> results,
                     Map<String, Integer> endDistance) {
                         
        if (remainDistance == 0) { // or sequence.size() == shortestSequenceLength
            results.add(new ArrayList<String>(sequence));
            return;
        }                
        
        for (String next : getNextWords(newStart, dict)) {
            int lengthToEnd = endDistance.get(next); 
            if (lengthToEnd != remainDistance) {
                continue;
            }
            sequence.add(next);
            remainDistance--;
            dfs(next, remainDistance, dict, sequence, results, endDistance);
            sequence.remove(sequence.size() - 1);
            remainDistance++;
        }
        
    } 
}