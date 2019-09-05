import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=15 lang=java
 *
 * [15] 三数之和
 */
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        sort(nums);
        List<List<Integer>> list = new LinkedList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            // ??
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int s = nums[i] + nums[j] + nums[k];
                if (s == 0) {
                    List<Integer> r = new LinkedList<>();
                    r.add(nums[i]);
                    r.add(nums[j]);
                    r.add(nums[k]);
                    list.add(r);
                    // ??
                    while (j < k && nums[j] == nums[j + 1]) {
                        j++;
                    }
                    // ??
                    while (j < k && nums[k] == nums[k - 1]) {
                        k--;
                    }
                    j++;
                    k--;

                } else if (s < 0) {
                    k--;
                } else {

                    j++;
                }
            }
        }
        return list;
    }

    public void sort(int[] nums) {
        for (int i = nums.length / 2 - 1; i >= 0; i--) {
            adjustHeap(nums, nums.length, i);
        }
        for (int i = nums.length - 1; i >= 1; i--) {
            swap(nums, 0, i);
            adjustHeap(nums, i, 0);
        }
    }

    public void adjustHeap(int[] heap, int len, int i) {
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

    public void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
