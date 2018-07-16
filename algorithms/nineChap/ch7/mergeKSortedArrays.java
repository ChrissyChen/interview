class Element {
        public int row, col, val;
        public Element (int row, int col, int val) {
            this.row = row;
            this.col = col;
            this.val = val;
        }
    }

public class Solution {
    
    private Comparator<Element> ElementComparator = new Comparator<Element>() {
        public int compare(Element a, Element b) {
            return a.val - b.val;
        }
    };
    
    
    /**
     * @param arrays: k sorted integer arrays
     * @return: a sorted array
     */
    public int[] mergekSortedArrays(int[][] arrays) {
        // write your code here
        if (arrays == null || arrays.length == 0) {
            return null;
        }
        
        Queue<Element> minHeap = new PriorityQueue<>(arrays.length, ElementComparator);
        int total = 0;
        for (int i = 0; i < arrays.length; i++) {
            if (arrays[i].length > 0) {
                Element el = new Element(i, 0, arrays[i][0]);
                minHeap.add(el);
                total += arrays[i].length;
            }
        }
        
        int[] result = new int[total];
        int index = 0;
        while (!minHeap.isEmpty()) {
            Element elem = minHeap.poll();
            result[index++] = elem.val;
            if (elem.col != arrays[elem.row].length - 1) {//not last element in that row
                elem.col++;
                elem.val = arrays[elem.row][elem.col];
                minHeap.add(elem);
            }
        }
        
        return result;
    }
}