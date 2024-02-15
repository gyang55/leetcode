class Solution:
    @classmethod
    def solve(cls, n):
        ans = []
        ans.append(n)
        while n != 1:
            if n % 2 == 0:
                n = n / 2
            else:
                n = 3 * n + 1
            ans.append(n)
        for i in range(0, len(ans)):
            print(ans[i])
        return len(ans)


