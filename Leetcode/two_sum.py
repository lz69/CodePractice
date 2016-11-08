class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        for i, ni in enumerate(nums):
            for j, nj in enumerate(nums[i+1:len(nums)]):
                if ni + nj == target:
                    return [i, i+j+1]
s = Solution()
print(s.twoSum([3,2,4], 6))

class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        dict1={}
        for i,v in enumerate(nums):
            dict1[v]=i
        for j in range(len(nums)):
            t=target-nums[j]
            if t in dict1 and dict1[t]!=j:
                return [dict1[t],j]
