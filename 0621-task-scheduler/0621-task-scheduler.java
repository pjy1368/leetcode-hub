class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        for (char task : tasks) {
            map.put(task, map.getOrDefault(task, 0) + 1);
        }

        PriorityQueue<Task> pq = new PriorityQueue<>((a, b) -> {
            if (a.waitingCount != b.waitingCount) {
                return a.waitingCount - b.waitingCount;
            }
            return map.get(b.task) - map.get(a.task);
        });

        for (char task : map.keySet()) {
            pq.offer(new Task(task, 0));
        }

        int answer = 0;
        while (!pq.isEmpty()) {
            List<Task> temp = new ArrayList<>();
            int size = pq.size();

            boolean taskExecuted = false;

            if (pq.peek().waitingCount == 0) {
                Task task = pq.poll();
                map.put(task.task, map.get(task.task) - 1);
                if (map.get(task.task) > 0) {
                    temp.add(new Task(task.task, n));
                }
                taskExecuted = true;
            }

            for (int i = 0; i < size - (taskExecuted ? 1 : 0); i++) {
                Task task = pq.poll();
                task.waitingCount = Math.max(0, task.waitingCount - 1);
                temp.add(task);
            }

            pq.addAll(temp);
            answer++;
        }
        return answer;
    }
}

class Task {
    char task;
    int waitingCount;

    public Task(char task, int waitingCount) {
        this.task = task;
        this.waitingCount = waitingCount;
    }
}