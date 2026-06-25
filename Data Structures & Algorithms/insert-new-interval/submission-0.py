class Solution:
    def insert(self, intervals: List[List[int]], newInterval: List[int]) -> List[List[int]]:
        new_list = []
        intervals.sort(key=lambda x:x[0])
        i = 0
        while i <len(intervals) and intervals[i][1] <newInterval[0]:
            new_list.append(intervals[i])
            i+=1
        
        while i <len(intervals) and intervals[i][0] <= newInterval[1]:
            newInterval[0] = min(intervals[i][0], newInterval[0])
            newInterval[1] = max(intervals[i][1], newInterval[1])
            i+=1
        #append new interval
        new_list.append(newInterval)
        for j in range(i, len(intervals)):
            new_list.append(intervals[j])
        return new_list