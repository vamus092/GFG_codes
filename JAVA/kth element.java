int kthElement(int k, vector<int>& arr1, vector<int>& arr2) {
        
        int n1 = arr1.size();
        int n2 = arr2.size();
        
        int ans,p1=0,p2=0,cnt=1;
        
        if(arr1[0] < arr2[0]){
            p1 = 1;
            ans = arr1[0];
        }
        else{
            p2 = 1;
            ans = arr2[0];
        }
        
        while(p1 < n1 && p2 < n2 && cnt < k){
            if(arr1[p1] < arr2[p2]){
                p1++;
                cnt++;
                ans = arr1[p1-1];
            }
            else{
                p2++;
                cnt++;
                ans = arr2[p2-1];
            }
        }
        while(p1 < n1 && cnt < k){
                p1++;
                cnt++;
                ans = arr1[p1-1];   
            }
        while(p2 < n2 && cnt < k){
                p2++;
                cnt++;
                ans = arr2[p2-1];
            }
        
        return ans;
    }
