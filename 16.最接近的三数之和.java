/*
 * @lc app=leetcode.cn id=16 lang=java
 *
 * [16] 最接近的三数之和
 */
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int min = 0;
        if (nums.length <= 3) {
            for (int i = 0; i < nums.length; i++) {
                min += nums[i];
            }
            return min;
        }
        sort(nums);
        min = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == target) {
                    return sum;
                } else {
                    if (Math.abs(sum - target) < Math.abs(min - target)) {
                        min = sum;
                    }
                    if (sum < target) {
                        k--;
                    } else {
                        j++;
                    }
                }
            }
        }
        return min;
    }

    public static void sort(int[] nums) {
        for (int i = nums.length / 2 - 1; i >= 0; i--) {
            adjustHeap(nums, nums.length, i);
        }
        for (int i = nums.length - 1; i >= 1; i--) {
            swap(nums, 0, i);
            adjustHeap(nums, i, 0);
        }
    }

    public static void adjustHeap(int[] heap, int len, int i) {
        int tmp = heap[i];
        for (int k = 2 * i + 1; k < len; k = 2 * k + 1) {
            if (k + 1 < len && heap[k + 1] < heap[k]) {
                k++;
            }
            if (heap[k] < tmp) {
                heap[i] = heap[k];
                i = k;
            } else {
                break;
            }
        }
        heap[i] = tmp;
    }

    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
