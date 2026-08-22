class Solution {
    public boolean checkDivisibility(int n) {
        int digitSum = 0;
        int digitProduct = 1;
        int temp = n;

        while (temp > 0) {
            int digit = temp % 10;
            digitSum += digit;
            digitProduct *= digit;
            temp /= 10;
        }

        int totalDenominator = digitSum + digitProduct;

        // Ensure we don't divide by zero if totalDenominator is 0
        if (totalDenominator == 0) {
            return false;
        }

        return n % totalDenominator == 0;
    }
}