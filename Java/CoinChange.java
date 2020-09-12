class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int[] arr = new int[amount + 1];  // arr[amount] = number of coins
        arr[0] = 0;
        for (int i = 1; i <= amount; i++) {
            arr[i] = Integer.MAX_VALUE;
            for (int n: coins) {
                if (i - n >= 0 && arr[i - n] != Integer.MAX_VALUE) arr[i] = Math.min(arr[i], arr[i - n] + 1);
            }
        }
        return arr[amount] == Integer.MAX_VALUE ? -1 : arr[amount];
    }
}
