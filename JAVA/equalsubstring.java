class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int diff[] = new int[s.length()];
        for(int i = 0;i<s.length();i++) diff[i] = Math.abs(s.charAt(i) - t.charAt(i));
        int start = 0;
        int count = 0;
        for(int i = 0;i<s.length();i++){
            maxCost -= diff[i];
            while(maxCost < 0){
                maxCost += diff[start++];
            }
            count = Math.max(count, i - start + 1);
        }
        return count;
    }
}
