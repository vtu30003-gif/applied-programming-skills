class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int totalSum = 0;
        for (int num : nums) totalSum += num;

        int leftSum = 0;
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            int rightSum = totalSum - leftSum - nums[i];

            int leftPart = i * nums[i] - leftSum;
            int rightPart = rightSum - (n - 1 - i) * nums[i];

            ans[i] = leftPart + rightPart;
            leftSum += nums[i];
        }

        return ans;
    }
}