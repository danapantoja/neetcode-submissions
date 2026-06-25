class Solution {
    public int maxArea(int[] heights) {
        int left =0;
        int right = heights.length-1;
        int max =0;
        while (left < right){
            int lower = Math.min(heights[left], heights[right]);

            int area = lower * (right-left);
            max = Math.max(area, max);
            if (heights[left]<heights[right]){
                left++;
            }else{
                right--;
            }
        }
        return max;
    }
}
