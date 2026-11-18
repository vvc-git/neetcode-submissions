class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> frequency = new HashMap<>();
        int[] result = new int[k];
        List<Integer>[] bucket = new ArrayList[nums.length + 1];

        // first pass
        for (int num : nums) {
            frequency.put(num, frequency.getOrDefault(num, 0) + 1);
        }

        for (int i = 0; i < bucket.length; i++) {
            bucket[i] = new ArrayList<>();
        }

        // second pass
        for (Map.Entry<Integer, Integer> entry : frequency.entrySet()) {
            Integer freq = entry.getValue();
            Integer val  = entry.getKey();
            bucket[freq].add(val);
        }

        // third pass
        int idxResult = 0;
        for (int i = nums.length; i > 0; i--) {
            for (Integer value : bucket[i]) {
                result[idxResult] = value;
                idxResult++;
                if (idxResult == k)
                    return result;
            }
        }        
        return result;
    
    }
}
