class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        nums.sort()
        output = []
        for k in range(len(nums)-2):
            if k > 0 and nums[k] == nums[k-1]:
                continue
            left = k + 1
            right = len(nums)-1
            while left < right:
                if nums[k] + nums[left] + nums[right] ==0:
                    output.append([nums[left], nums[right], nums[k]])
                    left+=1
                    right-=1
                    while left < right and nums[left] == nums[left - 1]:
                        left+=1
                    while left < right and nums[right] == nums[right + 1]:
                        right-=1
                elif nums[k] + nums[left] + nums[right] <0:
                    left+=1
                else:
                    right-=1
        return output
        