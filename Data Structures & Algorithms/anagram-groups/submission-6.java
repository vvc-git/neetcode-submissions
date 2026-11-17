class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        Map<String, List<String>> anagrams = new HashMap<>();
        List<List<String>> result = new ArrayList<>();


        for (String str : strs) {
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String key = new String(array);

            if (anagrams.containsKey(key)) {
                anagrams.get(key).add(str);
            } else {
                List<String> newL = new ArrayList<>();
                newL.add(str);
                anagrams.put(key, newL);
            }
        }

        for (List<String> values : anagrams.values()) {
            result.add(values);
        }
        return result;
        
    }
}
