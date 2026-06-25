class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:

        k = 0
        j = 0

        while j < len(nums):

            first = j
            while j < len(nums) and nums[first]==nums[j]:
                j+=1
            nums[k] = nums[first]
            k+=1
            
        return k 
        