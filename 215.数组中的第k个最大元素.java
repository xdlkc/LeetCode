/*
 * @lc app=leetcode.cn id=215 lang=java
 *
 * [215] 数组中的第K个最大元素
 */
class Solution {
    public int findKthLargest(int[] nums, int k) {
        return heapFun(nums, k);
    }

    public int heapFun(int[] nums, int k) {
        int[] heap = new int[k];
        for (int i = 0; i < k; i++) {
            heap[i] = nums[i];
        }
        for (int i = heap.length / 2 - 1; i >= 0; i--) {
            ajustHeap(heap, heap.length, i);
        }
        for (int i = k; i < nums.length; i++) {
            if (heap[0] < nums[i]) {
                heap[0] = nums[i];
                ajustHeap(heap, heap.length, 0);
            }
        }
        return heap[0];
    }

    public void ajustHeap(int[] heap, int len, int i) {
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
