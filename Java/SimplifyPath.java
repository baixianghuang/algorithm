class SimplifyPath {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        Set<String> omitSet = new HashSet<>(Arrays.asList("", "..", "."));
        for (String s : path.split("/")) {
            if (!omitSet.contains(s)) {
                stack.push(s);
            } else if (s.equals("..") && !stack.isEmpty()) {
                stack.pop();
            }
        }
        StringBuilder builder = new StringBuilder();
        for (String s : stack) {
            builder.append("/").append(s);
        }
        return builder.toString().equals("") ? "/" : builder.toString();
    }
}
