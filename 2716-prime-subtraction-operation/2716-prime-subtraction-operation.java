class Solution {

    public static int[] sieve(int n) {
        // Initialize a boolean array where index represents numbers up to n
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true); // Assume all numbers are prime initially
        isPrime[0] = false; // 0 is not a prime number
        isPrime[1] = false; // 1 is not a prime number

        // Sieve of Eratosthenes algorithm
        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                // Mark all multiples of i as non-prime
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        // Collect all prime numbers into a list
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }

        // Convert the list to an array and return it
        return primes.stream().mapToInt(Integer::intValue).toArray();
    }
    
    public static int binary(int[] arr, int target) {
    int left = 0;
    int right = arr.length - 1;

    while (left <= right) {
        int mid = left + (right - left) / 2;

        // If arr[mid] is less than or equal to target, search in the right half
        if (arr[mid] <= target) {
            left = mid + 1;
        } else {
            // If arr[mid] is greater than target, it could be the result
            right = mid - 1;
        }
    }

    // After the loop, left should point to the smallest prime > target if it exists
    return (left < arr.length) ? left : -1;
}



    public boolean primeSubOperation(int[] nums) {
        int []prime = sieve(1000);
        // for(int i =0; i<prime.length;i++)
        // {
        //     System.out.println(prime[i]);
        // }
        for(int i=nums.length-2;i>=0; i--)
        {
            if(nums[i]>=nums[i+1])
            {
                int diff = nums[i] - nums[i+1];
                int index= binary(prime, diff);
                if(index == -1)
                {
                    return false;
                }
                int pri = prime[index];
                System.out.println(pri);
                if(pri>=nums[i])
                {
                    return false;
                }
                nums[i] -= pri;
            }
        }


        return true;
    }
}