 int[]freq = new int[26];
        
        for(char c:s.toCharArray()){
            if(Character.isAlphabetic(c)){
              if(c>='A' && c<='Z')freq[c-'A']++;
              else freq[c-'a']++;  
            }
            
        }
        for(int ele:freq){
            if(ele==0)return false; 
        }
        
        return true;
    }
