class Solution {
    public boolean completePrime(int num) {

        if (!isPrime(num)) return false;

        
        int pow10 = 10;
        while (pow10 <= num) {
            int suffix = num % pow10;   
            if (!isPrime(suffix)) return false;
            pow10 *= 10;
        }

        
        int divisor = 1;
        while (divisor <= num) divisor *= 10;
        divisor /= 10;

        int temp = num;
        while (divisor > 1) {
            int prefix = temp / divisor;   
            if (!isPrime(prefix)) return false;
            divisor /= 10;
        }

        return true;
    }

    public boolean isPrime(int val) {
        if (val < 2) return false;
        for (int i = 2; i * i <= val; i++) {
            if (val % i == 0) return false;
        }
        return true;
    }
}
