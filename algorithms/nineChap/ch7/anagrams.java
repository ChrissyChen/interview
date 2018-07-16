public class Solution {
    /**
     * @param strs: A list of strings
     * @return: A list of strings
     */
    public List<String> anagrams(String[] strs) {
        // write your code here
        List<String> result = new ArrayList<>();
        if (strs == null || strs.length == 0) {
            return result;
        }
        
        Map<String, List<String>> map = new HashMap<>();
        int[] count = new int[26];
        
        for (String str : strs) {
            Arrays.fill(count, 0);  // pay attention! cuz count is newed only once.
            char[] ch = str.toCharArray();
            for (char c : ch) {
                count[c - 'a']++;
            }
            
            StringBuilder sb = new StringBuilder();
            for (int i: count) {
                sb.append("#");
                sb.append(i);
            }
            
            String key = sb.toString();
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<String>());
            }
            map.get(key).add(str);
        }
        
        for (List<String> temp : map.values()) {  // pay attention
            if (temp.size() > 1) {
                result.addAll(temp);
            }
        }
        return result;
    }
}