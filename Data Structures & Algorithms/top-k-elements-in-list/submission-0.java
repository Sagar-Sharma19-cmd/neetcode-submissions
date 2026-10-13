class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> m = new HashMap<>();

        // Step 1: Count frequencies
        for (int n : nums) {
            m.put(n, m.getOrDefault(n, 0) + 1);
        }

        // Step 2: Create a max heap based on frequency
        PriorityQueue<Integer> maxHeap =
            new PriorityQueue<>((a, b) -> Integer.compare(m.get(b), m.get(a)));

        maxHeap.addAll(m.keySet());

        // Step 3: Extract the top k frequent elements
        int[] result = new int[k];

        for (int i = 0; i < k; i++) {
            result[i] = maxHeap.poll();
        }

        return result;
    }
}
