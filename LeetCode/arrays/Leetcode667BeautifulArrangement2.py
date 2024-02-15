class Solution(object):

    # 前k个数组成k-1个 distinct 数，从k到n再组成相差为1的数组。
    # k为奇数时，后续数组为升序
    # k为偶数时，后续数组为降序
    def constructArray(self, n, k):
        """
        :type n: int
        :type k: int
        :rtype: List[int]
        """
        ans = []
        p = 1
        q = n
        for i in range(0, k):
            if i % 2 == 0:
                ans.append(p)
                p += 1
            else:
                ans.append(q)
                q -= 1

        if k % 2 == 0:
            for i in range(k, n):
                ans.append(q)
                q -= 1
        else:
            for i in range(k, n):
                ans.append(p)
                p += 1
        return ans
