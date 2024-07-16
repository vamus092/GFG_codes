class Solution {
    public String printString(String s, char ch, int count) {
        // code here
        String copy = "";
        int c = 0;
        for(int i =0;i<s.length();i++){
            if(c==count){
                copy +=s.charAt(i);
            }
            if(s.charAt(i) == ch && c<count){
                c +=1;
            }
            
            
        }
        
        return copy;
    }
}
