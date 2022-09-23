class Solution:
    def findRepeatNumber(self, nums: [int]) -> int:
        dic = set()
        for n in nums:
            if n in dic: return n
            dic.add(n)
        return -1