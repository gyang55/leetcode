#从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
# Definition for a binary tree node.
import collections


class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    def levelOrder(self, root: TreeNode):
        if not root: return []
        res,queue = [], collections.deque()
        queue.append(root)
        while queue:
            temp=[]
            for _ in range(len(queue)):
                node = queue.popleft()
                temp.append(node.val)
                if node.left:queue.append(node.left)
                if node.right: queue.append(node.right)
            res.append(temp)
        return res