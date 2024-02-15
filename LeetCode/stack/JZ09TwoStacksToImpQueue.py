class CQueue(object):

    def __init__(self):
        self.stack1 = []
        self.stack2 = []

    def appendTail(self, value: int) -> None:
        """
        :type value: int
        :rtype: None
        """
        while self.stack1:
            self.stack2.append(self.stack1.pop())
        self.stack1.append(value)
        while self.stack2:
            self.stack1.append(self.stack2.pop())

    def deleteHead(self)-> int:
        """
        :rtype: int
        """
        if not self.stack1: return  -1
        return self.stack2.pop()


