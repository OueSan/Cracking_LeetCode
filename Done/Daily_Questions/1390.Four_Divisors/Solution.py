def sieve_of_eratosthenes(m):
    """Return a list of all prime numbers up to m (inclusive)."""
    if m < 2:
        return []

    # Initialize a boolean array of length m+1 (index 0..m)
    is_prime = [True] * (m + 1)
    is_prime[0] = is_prime[1] = False  # 0 and 1 are not prime

    # Eliminate non-primes
    for p in range(2, int(m**0.5) + 1):
        if is_prime[p]:
            for multiple in range(p * p, m + 1, p):
                is_prime[multiple] = False

    # Collect all primes
    primes = [i for i, prime in enumerate(is_prime) if prime]
    return primes


class Solution:
    def sumFourDivisors2(self, nums: List[int]) -> int:
        max_num = max(nums)
        primes = sieve_of_eratosthenes(max_num)
        primes_set = set(primes)

        sum_of_divisors_dict = dict()
        sum_of_divisors = 0
        for num in nums:
            if num in sum_of_divisors_dict:
                sum_of_divisors += sum_of_divisors_dict[num]
                continue
            if num in primes_set:
                continue
            for p in primes:
                if p * p >= num:
                    break
                if num % p == 0:
                    n_1 = num // p
                    if n_1 in primes_set or n_1 == p * p:
                        new_sum = 1 + num + p + n_1
                        sum_of_divisors_dict[num] = new_sum
                        sum_of_divisors += new_sum
                    break
        return sum_of_divisors
        


    def sumFourDivisors(self, nums: List[int]) -> int:
        max_num = max(nums)
        primes = sieve_of_eratosthenes(max_num)
        primes_set = set(primes)

        sum_of_divisors = 0
        for num in nums:
            if num in primes_set:
                continue
            for p in primes:
                if p * p >= num:
                    break
                if num % p == 0:
                    n_1 = num // p
                    if n_1 in primes_set or n_1 == p * p:
                        sum_of_divisors += 1 + num + p + n_1
                    break
        return sum_of_divisors
        