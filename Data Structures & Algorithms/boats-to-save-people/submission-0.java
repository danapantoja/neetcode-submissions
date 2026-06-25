class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int left = 0;
        int right= people.length-1;
        int boats =0;
        while (left<=right){
            int remain = limit - people[right];
            boats++;
            right--;
            if (people[left] <=remain){
                left++;
            }
            
        }
        return boats;
    }
}