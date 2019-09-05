import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/*
 * @lc app=leetcode.cn id=38 lang=java
 *
 * [38] 报数
 */
class Solution {
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        Queue<Integer> list = new LinkedList<>();
        Queue<Integer> list2 = new LinkedList<>();
        list.add(1);
        while (n > 1) {
            int tn = 1;

            while (list.size() > 0) {
                int tmp = list.poll();

                while (list.size() > 0) {
                    int s = list.peek();
                    if (s == tmp) {
                        list.poll();
                        tn++;
                    } else {
                        break;
                    }
                }
                list2.add(tn);
                list2.add(tmp);
                tn = 1;
            }
            list = list2;
            list2 = new LinkedList<>();
            n--;
        }
        StringBuilder builder = new StringBuilder();
        while (list.size() > 0) {
            builder.append(list.poll());
        }
        return builder.toString();
    }
}
