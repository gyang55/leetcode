from treeNode import TreeNode


class Solution(object):
    def __int__(self):
        ans = []

    def sumRootToLeaf(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        self.res = 0
        self.dfs(root, 0)
        return self.res

    def dfs(self, root, preSum):
        if not root: return
        preSum = preSum << 1 | root.val
        if not root.left and not root.right:
            self.res += preSum
        self.dfs(root.left, preSum)
        self.dfs(root.right, preSum)
