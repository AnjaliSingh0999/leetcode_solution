class Solution {
    PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder()); // max-heap
    PriorityQueue<Integer> right = new PriorityQueue<>(); // min-heap
    Map<Integer, Integer> delayed = new HashMap<>();
    int leftSize = 0, rightSize = 0;

    public double[] medianSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        double[] result = new double[n - k + 1];

        for (int i = 0; i < n; i++) {
            addNum(nums[i]);
            if (i >= k) {
                removeNum(nums[i - k]);
            }
            if (i >= k - 1) {
                result[i - k + 1] = getMedian(k);
            }
        }

        return result;
    }

    private void addNum(int num) {
        if (left.isEmpty() || num <= left.peek()) {
            left.add(num);
            leftSize++;
        } else {
            right.add(num);
            rightSize++;
        }
        balanceHeaps();
    }

    private void removeNum(int num) {
        delayed.put(num, delayed.getOrDefault(num, 0) + 1);
        if (!left.isEmpty() && num <= left.peek()) {
            leftSize--;
            if (num == left.peek()) prune(left);
        } else {
            rightSize--;
            if (!right.isEmpty() && num == right.peek()) prune(right);
        }
        balanceHeaps();
    }

    private void balanceHeaps() {
        while (leftSize > rightSize + 1) {
            right.add(left.poll());
            leftSize--;
            rightSize++;
            prune(left);
        }

        while (rightSize > leftSize) {
            left.add(right.poll());
            rightSize--;
            leftSize++;
            prune(right);
        }
    }

    private void prune(PriorityQueue<Integer> heap) {
        while (!heap.isEmpty()) {
            int top = heap.peek();
            if (delayed.getOrDefault(top, 0) > 0) {
                heap.poll();
                delayed.put(top, delayed.get(top) - 1);
                if (delayed.get(top) == 0) delayed.remove(top);
            } else break;
        }
    }

    private double getMedian(int k) {
        if (k % 2 == 1) return (double) left.peek();
        return ((double) left.peek() + right.peek()) / 2.0;
    }
}