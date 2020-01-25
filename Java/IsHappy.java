public class IsHappy {
    private int sumOfDigitSquares(int n) {
        int sum = 0;
        while (n > 0) {
            int d = n%10;
            sum += (d * d);
            n/=10;
        }
        System.out.println(sum);
        return sum;
    }
    
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<Integer>();
        while (set.add(n)) {
            if(sumOfDigitSquares(n) == 1)
                return true;
            n = sumOfDigitSquares(n);
        }
        return false;
    }
}
