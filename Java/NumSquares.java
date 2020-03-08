NumSquares {
    public int numSquaresBFS(int n) {
        if (n <= 0) { return 0; }
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n+1];
        visited[n] = true;
        queue.offer(n);
        int step = 0;
        while (!queue.isEmpty()) {
            int layerSize = queue.size();
            for (int i = 0; i < layerSize; i++) {
                int val = queue.poll();
                for (int j = 1; val - j*j >= 0; j++) {
                    int a = val - j*j;
                    if (a == 0) { return step+1; }
                    if (!visited[a]) {
                        queue.offer(a);
                        visited[a] = true;
                    }
                }
            }
            step++;
        }
        throw new IllegalArgumentException("No solution due to invalid input");
    }
    
    public int numSquaresBFSApproach2(int n) {
        //using Pair to store the number and the step it takes to reach this number
        if (n <= 0) { return 0; }
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        boolean[] visited = new boolean[n+1];
        visited[n] = true;
        queue.offer(new Pair<>(n, 0));
        while (!queue.isEmpty()) {
            Pair<Integer, Integer> pair = queue.poll();
            int val = pair.getKey();
            int step = pair.getValue();
            System.out.println(pair);
            for (int i = 1; val - i*i >= 0; i++) {
                int a = val - i*i;
                if (a == 0) { return step+1; }
                if (!visited[a]) {
                    queue.offer(new Pair<>(a, step+1));
                    visited[a] = true;
                }
            }
        }
        throw new IllegalArgumentException("No solution due to invalid input");
    }
}
