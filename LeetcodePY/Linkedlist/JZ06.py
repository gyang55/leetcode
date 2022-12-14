# 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。

class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:
    def reversePrint(self, head: ListNode) -> List[int]:
        res = []
        cur = head
        while cur:
            res.append(cur.val)
            cur = cur.next
        res.reverse()
        return res
