class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> diff = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (diff.containsKey(nums[i])) {
                return new int[] {diff.get(nums[i]), i};
            }
            diff.put(target - nums[i], i);
        }
        return new int[2];
    }
}
