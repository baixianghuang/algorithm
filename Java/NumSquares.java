NumSquares {
    public int numSquares(int n) {
        // BFS
        if(n <= 0) { return 0; }
        LinkedList<Pair<Integer, Integer>> queue = new LinkedList<>();
        queue.addLast(new Pair<>(n, 0));
        boolean[] visited = new boolean[n+1];
        visited[n] = true;

        while(!queue.isEmpty()){
            Pair<Integer, Integer> cur = queue.poll();
            int val = cur.getKey();
            int step = cur.getValue();
//            if (val == 0) { return step; }  // move this step to the for loop to enhance performance
            for (int i = 1; val - i*i >= 0 ; i++) {
                int a = val - i*i;
                if (a == 0) { return step + 1; }
                if (!visited[a]) {
                    queue.offer(new Pair<>(a,step+1));
                    visited[a] = true;
                }
            }
        }
        throw new IllegalStateException("No Solution.");
    }
}
