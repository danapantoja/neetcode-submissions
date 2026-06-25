class Solution {
    public int[] sortArray(int[] nums) {
        if (nums.length==1){
            return nums;
        }
        int mid = nums.length/2;

        int[] sortedNums1 = sortArray(Arrays.copyOfRange(nums, 0,mid));
        int[] sortedNums2 = sortArray(Arrays.copyOfRange(nums, mid,nums.length));
        return merge(sortedNums1, sortedNums2);
    }
    public int[] merge(int[] arr1, int[] arr2){
        int[] merged = new int[arr1.length+arr2.length];
        int i =0;
        int j =0;
        int k =0;
        while (i< arr1.length && j<arr2.length){
            if(arr1[i] < arr2[j]){
                merged[k] = arr1[i];
                i++;
            }else{
                merged[k] = arr2[j];
                j++;
            }
            k++;
        }
        while (i< arr1.length){
            merged[k++] = arr1[i++];
        }
        while (j< arr2.length){
            merged[k++] = arr2[j++];
        }
        return merged;
    }
}