class Solution:
    def atMostNGivenDigitSet(self, digits: List[str], n: int) -> int:
        n_s = str(n)
        n_length = len(n_s)
        digits_length = len(digits)

        # Count numbers have length less than n_s
        res = sum(digits_length ** i for i in range(1, n_length))

        # Count numbers have length equals to n_s
        # but the first digit less than n's first digit
        res += sum(digits_length ** (n_length - 1) for d in digits if d < n_s[0])

        # For remain cases when the numbers have length equals to n_length
        # We try to set the digits of the numbers equal to digit in n as far as possible
        for i, d in enumerate(n_s):
            # When we encouter the index of n that its digit doesn't exist in digtis array
            # we break because we can't build anymore number with this pattern.
            if d not in digits:
                break
            # If the index reach to the last character and current character also exist in digits
            # It means we can build only 1 more number satisfy the requirement
            # and it is n (definitely)
            if i == n_length - 1:
                res += 1
            else:
                # If current character stills exist in digits array
                # It means we'll build a number that all character from left to i similar to character in n
                # So to satify the requirement, the next digit should be less than the next char in n
                # But all digits follow the next digit can be any
                next_d = n_s[i + 1]
                res += sum(digits_length ** (n_length - i - 2)
                           for num in digits if num < next_d)

        return res