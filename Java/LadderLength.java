class LadderLength {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord.equals("") || endWord.equals("") || wordList == null ||
                !wordList.contains(endWord)) {
            return 0;
        }
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int step = 1;
        Set<String> visitedSet = new HashSet<>();
        visitedSet.add(beginWord);

        while (!queue.isEmpty()) {
            int layerSize = queue.size();
            for (int i = 0; i < layerSize; i++) {
                String word = queue.poll();
                for (String s : wordList) {
                    if (isTransfer(word, s)) {
                        if (s.equals(endWord)) {
                            return step+1;
                        }
                        if (!visitedSet.contains(s)) {
                            queue.offer(s);
                            visitedSet.add(s);
                        }
                    }
                }
            }
            step++;
        }
        return 0;
    }
    
    private boolean isTransfer(String a, String b) {
        int cnt = 0;
        for (int i = 0; i < a.length(); i++) {
            char c1 = a.charAt(i);
            char c2 = b.charAt(i);
            if (c1 != c2) { cnt++; }
        }
        return cnt == 1;
    }
}
