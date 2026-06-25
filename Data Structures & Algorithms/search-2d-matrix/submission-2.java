class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int top = 0;
        int bottom = matrix.length-1;
        
        while (top <=bottom){
            int mid = (top + bottom)/2;
            int left = matrix[mid][0];
            int right = matrix[mid][matrix[0].length-1];
            if (left <= target && target <= right){
                return binarySearch(matrix[mid], target);
            }else if (target < left){
                bottom= mid -1;
            }else{
                top = mid + 1;
            }
        }
        return false;
    }
    public boolean binarySearch(int[] arr, int target){
        int left = 0;
        int right = arr.length-1;
        while(left<=right){
            int mid = (left+right)/2;
            if (arr[mid]==target) return true;
            if (target< arr[mid]){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return false;
    }
}
