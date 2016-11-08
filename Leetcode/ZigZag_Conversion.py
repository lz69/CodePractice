class Solution(object):
    def convert(self, s, numRows):
        """
        :type s: str
        :type numRows: int
        :rtype: str
        """
        rows = ["" for _ in range(numRows)]
        index = 0
        for c in s:
            rows[index % numRows] += c
            index += 1
        print(rows)
        return "".join(rows)

s = Solution()
print(s.convert("PAYPALISHIRING", 3))
