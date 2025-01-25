class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] prerequisite : prerequisites) {
            int a = prerequisite[0];
            int b = prerequisite[1];
            graph.get(b).add(a);
        }

        for (int i = 0; i < numCourses; i++) {
            boolean[] visited = new boolean[numCourses];
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(i);

            while (!queue.isEmpty()) {
                int current = queue.poll();
                visited[current] = true;

                List<Integer> prerequisiteList = graph.get(current);
                for (int prerequisite : prerequisiteList) {
                    if (prerequisite == i) {
                        return false;
                    }
                    if (!visited[prerequisite]) {
                        queue.offer(prerequisite);
                    }
                }
            }
        }
        return true;
    }
}