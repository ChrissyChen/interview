/**
 * Definition for a Record
 * class Record {
 *     public int id, score;
 *     public Record(int id, int score){
 *         this.id = id;
 *         this.score = score;
 *     }
 * }
 */
public class Solution {
    /**
     * @param results a list of <student_id, score>
     * @return find the average of 5 highest scores for each person
     * Map<Integer, Double> (student_id, average_score)
     */
    public Map<Integer, Double> highFive(Record[] results) {
        // Write your code here
        Map<Integer, Double> result = new HashMap<>();
        if (results == null || results.length == 0) {
            return result;
        }
        
        Map<Integer, PriorityQueue<Integer>> hash = new HashMap<>();
        for (int i = 0; i < results.length; i++) {
            int id = results[i].id;
            if (!hash.containsKey(id)) {
                hash.put(id, new PriorityQueue<Integer>());
            }
            
            PriorityQueue<Integer> minHeap = hash.get(id);
            if (minHeap.size() < 5) {
                minHeap.add(results[i].score);
            } else {
                if (results[i].score > minHeap.peek()) {
                    minHeap.poll();
                    minHeap.add(results[i].score);
                }
            }
        }
        
        for (Map.Entry<Integer, PriorityQueue<Integer>> entry : hash.entrySet()) {
            int id = entry.getKey();
            PriorityQueue<Integer> scores = entry.getValue();
            double average = 0;
            for (int i = 0; i < 5; i++) {
                average += scores.poll();
            }
            average /= 5.0;
            
            result.put(id, average);
        }
        
        return result;
    }
}