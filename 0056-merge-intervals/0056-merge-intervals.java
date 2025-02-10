class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> intervalList = new ArrayList<>(Arrays.asList(intervals));

        int idx = 0;
        while (idx < intervalList.size() - 1) {
            int[] first = intervalList.get(idx);
            int[] second = intervalList.get(idx + 1);

            int a = first[0];
            int b = first[1];
            int c = second[0];
            int d = second[1];

            if (a <= c && c <= b && b <= d) {
                intervalList.add(idx + 2, new int[]{a, d});
                intervalList.remove(idx + 1);
                intervalList.remove(idx);
            } else if (a <= b && b == c && c <= d) {
                intervalList.add(idx + 2, new int[]{a, d});
                intervalList.remove(idx + 1);
                intervalList.remove(idx);
            } else if (a <= c && c <= d && d <= b) {
                intervalList.add(idx + 2, new int[]{a, b});
                intervalList.remove(idx + 1);
                intervalList.remove(idx);
            } else {
                idx++;
            }
        }
        return intervalList.toArray(new int[intervalList.size()][]);
    }
}