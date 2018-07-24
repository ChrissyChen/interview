public class TwoSum {
    Map<Integer, Integer> map = new HashMap<>(); //  index, num value
    int index = 0;
    
    /*
     * @param number: An integer
     * @return: nothing
     */
    public void add(int number) {
        // write your code here
        
        // int size = nums.size();
        // error!!! nums.set(size, number);//replace
        
        map.put(index++, number);
    }

    /*
     * @param value: An integer
     * @return: Find if there exists any pair of numbers which sum is equal to the value.
     */
    public boolean find(int value) {
        // write your code here
        
        //error!! add(2) find(4) should return false
        // for (int i = 0; i < nums.size(); i++) {
        //之前的map key 存的是index, value存的是值
        //     if (map.containsValue(value - nums.get(i))) {
        //         return true; 
        //     }
        // }
        // return false;
        
        Iterator<Map.Entry<Integer, Integer>> it = map.entrySet().iterator();

        int first = 0;
        boolean isCheck = false;

        while (it.hasNext()) {
            Map.Entry<Integer, Integer> entry = it.next();
            if (map.containsValue(value - entry.getValue())) {
                // check twice
                if (!isCheck) {
                    first = entry.getKey();
                    isCheck = true;
                }
                else {
                    if (first != entry.getKey()) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}