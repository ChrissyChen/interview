/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * } * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */

public class Solution {
    
    /**
     * @param points: a list of points
     * @param origin: a point
     * @param k: An integer
     * @return: the k closest points
     */
    public Point[] kClosest(Point[] points, Point origin, int k) {
        // write your code here
        Point[] result = new Point[k];
        if (points == null || points.length == 0) {
            return result;
        }
        
        //这个Comparator只在maxHeap里有效，k是初始值，后面可以扩大的
        PriorityQueue<Point> maxHeap = new PriorityQueue<Point>(k, new Comparator<Point>() {  // 从大到小排
            @Override
            public int compare(Point a, Point b) { //记住前减后是从小到大排
                int diff = Double.compare(getDistance(b, origin), getDistance(a, origin));
                if (diff == 0) {
                    diff = b.x - a.x;
                }
                if (diff == 0) {  //如果x坐标相等
                    diff = b.y - a.y;
                }
                return diff;
            }
        });
        
        // for (Point pt : points) {
        //     if (maxHeap.size() < k) {
        //         maxHeap.add(pt);
        //     } else {
        //         if (pt < maxHeap.peek()) {  // error! 要让Point class implement 
        //             maxHeap.poll();  // Comparable, then override compareTo()
        //             maxHeap.add(pt);
        //         }
        //     }
        // }
        for (Point pt : points) {
            maxHeap.add(pt);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        
        for (int i = k - 1; i >= 0; i--) {
            result[i] = maxHeap.poll();
        }
        return result;
    }
    
    private double getDistance(Point point, Point origin) {
        return Math.pow(point.x - origin.x, 2) + Math.pow(point.y - origin.y, 2);
        // pay attention: Math.pow() return double
    }
}