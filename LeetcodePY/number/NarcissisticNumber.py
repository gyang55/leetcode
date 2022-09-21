class Solution:
    def solve(self, n):
        sum = 0
        count = 0
        n1 = n
        n2 = n

        while n1 > 0:
            count += 1
            n1 = n1 // 10

        while n2 > 0:
            sum += (n2 % 10) ** count
            n2 = n2 // 10
        return sum == n