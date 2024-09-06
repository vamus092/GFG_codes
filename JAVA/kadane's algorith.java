class Solution {
    long maxSubarraySum(int[] arr) {
        long maxsum=arr[0];
        long currsum=0;
        
        for(int i=0;i<arr.length;i++){
            currsum+=arr[i];
            if(currsum>maxsum) maxsum=currsum;
            if(currsum<0) currsum=0;
        }
        return maxsum;
    }
}
