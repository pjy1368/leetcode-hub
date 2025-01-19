class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Point> pq = new PriorityQueue<>();
        for (int[] point : points) {
            pq.add(new Point(point));
        }
        
        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            Point point = pq.poll();
            result[i] = point.value;
        }
        
        return result;
    }
}

class Point implements Comparable<Point> {
    int[] value;
    int powerSum;
    
    public Point(int[] value) {
        this.value = value;
        this.powerSum = value[0] * value[0] + value[1] * value[1];
    }

    @Override
    public int compareTo(Point o) {
        return this.powerSum - o.powerSum;
    }
}
