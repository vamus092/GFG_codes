class Solution {
    public long nthStair(int n) {
        // Code here
        if(n==1) return 1;
         if(n==0) return 0;
          if(n==2) return 2;
        int dp[]= new int[n+1];
        dp[0]=0;
        dp[1]=1;
        dp[2]=2;
        for(int i=3;i<n+1;i++)
        {
            if(i%2==0)
            {
            dp[i]=dp[i-1]+1;
            }else{
            dp[i]=dp[i-1];
            }
        }
        return (long)dp[n];
    }
}

