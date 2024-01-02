class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {

        HashMap<Integer, Integer> map =  new HashMap<>();
        List<List<Integer>> out = new ArrayList<>();
        out.add(new ArrayList<>());

        int max = 0;
        for(int i=0; i < nums.length; i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i], map.get(nums[i])+1);
                max = Math.max(max, map.get(nums[i]));
            }            
            else{
                map.put(nums[i], map.getOrDefault(nums[i],0)+1);
                out.get(0).add(nums[i]);
            }        
        }

        int k = 0;
        while(k < max){

            List<Integer> p1 = new ArrayList<>();

            for(int i=0; i < out.get(0).size(); i++){
                
                int ele = out.get(0).get(i);
                if(map.containsKey(ele) && map.get(ele) != 1)
                {
                    p1.add(ele);
                    map.put(ele, map.get(ele)-1);
                }
            }

            if(p1.size() > 0) out.add(p1);
            k++;
        }
        

        return out;
    }
}
