import typing


class Solution(object):
    def minOperations(self, logs: typing.List[str]) -> int:
        depth = 0
        for log in logs:
            if log == "./":
                continue
            if log != "../":
                depth += 1
            elif depth:
                depth -= 1
        return depth

