class Solution(object):
    def buildArray(self, target, n):
        """
        :type target: List[int]
        :type n: int
        :rtype: List[str]
        """
        push = "Push"
        pop = "Pop"

        ans = []

        if n < len(target):
            return ans

        pointerTarget = 0
        pointerStream = 0

        while pointerTarget < len(target) and pointerStream <= n - 1:
            ans.append(push)
            pointerStream += 1

            if pointerStream == target[pointerTarget]:
                pointerTarget += 1
            else:
                ans.append(pop)

        return ans