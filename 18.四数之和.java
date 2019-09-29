/*
 * @lc app=leetcode.cn id=18 lang=java
 *
 * [18] 四数之和
 */
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums == null) {
            return new LinkedList<>();
        }
        sort(nums);
        List<List<Integer>> list = new LinkedList<>();
        int i = 0;
        while (i < nums.length - 3) {
            while (i > 0 && i < nums.length - 3 && nums[i] == nums[i-1]) {
                i++;
            }
            if (i == nums.length - 3) {
                break;
            }
            int j = i + 1;
            while (j < nums.length - 2) {
                while (j > i + 1 && j < nums.length - 2 && nums[j] == nums[j-1]) {
                    j++;
                }
                if (j == nums.length - 2) {
                    break;
                }
                int k = j + 1;
                int l = nums.length - 1;
                while (k < l) {
                    while (k > j + 1 && k < l && nums[k] == nums[k - 1]) {
                        k++;
                    }
                    while (l < nums.length - 1 && k < l && nums[l] == nums[l + 1]) {
                        l--;
                    }
                    if (k >= l) {
                        break;
                    }
                    int sum = nums[i] + nums[j] + nums[k] + nums[l];
                    if (sum == target) {
                        List<Integer> tmpList = new LinkedList<>();
                        tmpList.add(nums[i]);
                        tmpList.add(nums[j]);
                        tmpList.add(nums[k]);
                        tmpList.add(nums[l]);
                        list.add(tmpList);
                        k++;
                        l--;
                    } else if (sum < target) {
                        l--;
                    } else {
                        k++;
                    }
                }
                j++;
            }
            i++;
        }
        return list;
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

