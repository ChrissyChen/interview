public class Solution {
    /*
     * @param start: a string
     * @param end: a string
     * @param dict: a set of string
     * @return: An integer
     */
    public int ladderLength(String start, String end, Set<String> dict) {
        // write your code here
        if (dict == null || dict.size() == 0) {
            return 0;
        }
        
        if (start.equals(end)) {
            return 1;
        }
        
        dict.add(start);
        dict.add(end);
        //System.out.println(dict.toString());
        
        int total = 1;
        Queue<String> queue = new LinkedList<>();
        Set<String> hash = new HashSet<>();
        queue.add(start);
        hash.add(start);
        
        while (!queue.isEmpty()) {
            total++;
            int size = queue.size();
            // System.out.println("______");
            // System.out.println(queue.toString());
            
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                System.out.println("word: " + word);
                for (String nextWord : getNextWords(word, dict)) {
                    if (hash.contains(nextWord)) {
                        continue;
                    }
                    if (nextWord.equals(end)) {
                        return total;
                    }
                    queue.add(nextWord);
                    hash.add(nextWord);
                }
            }
        }
        return 0;
    }
    
    // get connections with given word.
    // for example, given word = 'hot', dict = {'hot', 'hit', 'hog'}
    // it will return ['hit', 'hog']
    private List<String> getNextWords(String word, Set<String> dict) {
        List<String> results = new ArrayList<>();
        int n = word.length();
        for (int i = 0; i < n; i++) {
            for (char ch = 'a'; ch <= 'z'; ch++) { // <= 'z'
                if (word.charAt(i) == ch) {
                    continue;
                }
                String newWord = replaceWord(word, i, ch);
                if (dict.contains(newWord)) {
                    results.add(newWord);
                }
            }
        }
        //System.out.println(results.toString());
        return results;
    }
    
    // replace character of a string at given index to a given character
    // return a new string
    private String replaceWord(String word, int index, char ch) {
        char[] chars = word.toCharArray();
        chars[index] = ch;
        return new String(chars);  // pay attention
    }
}
