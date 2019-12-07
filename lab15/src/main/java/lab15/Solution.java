package lab15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public static void main(String[] args) {
//        System.out.println(Arrays.toString(new Solution().twoSum(new int[]{3, 2, 4}, 6)));
        try {
            System.out.println(new Solution().threeSum(new int[]{1,-4,-1,2,2}));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<List<Integer>> threeSum(int[] nums) throws Exception {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums.length < 3) return ans;
        Arrays.sort(nums);
        int pr = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) break;
            if (nums[i] == pr) continue;
            pr = nums[i];
            for (int l = i+1, r = nums.length; l < r;) {
                int sum = nums[i] + nums[l];
                int r2 = Arrays.binarySearch(nums, l+1, r, -sum);
                if (r2 < 0) {
                    l++;
                    r = -(r2+1);
                } else {
                    r = r2;
                    ans.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    while (nums[l] == nums[++l]) if (l < r) break;
                }
            }
        }
        return ans;
    }

    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            int res = Arrays.binarySearch(nums, i + 1, nums.length, target - nums[i]);
            if (res > -1) {
                ans = new int[]{i, res};
                break;
            }
        }
        return ans;
    }
}