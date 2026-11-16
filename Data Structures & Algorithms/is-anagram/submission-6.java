class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;

        char[] orderedS = s.toCharArray();
        Arrays.sort(orderedS);
        char[] orderedT = t.toCharArray();
        Arrays.sort(orderedT);
        int i = 0;
        for (char c : orderedS) {
            System.out.println(c);
            if (c != orderedT[i]) {
                return false;
            }
            i++;
        }


        return true;
    }
}
