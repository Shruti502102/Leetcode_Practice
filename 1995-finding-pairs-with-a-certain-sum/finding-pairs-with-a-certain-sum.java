class FindSumPairs {
    int[] nums1;
    int[] nums2;
    HashMap<Integer,Integer>fm;
    public FindSumPairs(int[] nums1, int[] nums2) {
        this.nums1=nums1;
        this.nums2=nums2;
        fm=new HashMap<>();
        for(int num: nums2){
            fm.put(num,fm.getOrDefault(num,0)+1);
        }       
    }
    
    public void add(int index, int val) {
        int oldvalue=nums2[index];
        int newvalue=oldvalue+val;
        nums2[index]=newvalue;
        fm.put(oldvalue,fm.get(oldvalue)-1);
        if(fm.get(oldvalue)==0){
            fm.remove(oldvalue);
        }
        fm.put(newvalue,fm.getOrDefault(newvalue,0)+1);
        
    }
    
    public int count(int tot) {
        int count=0;
        for(int a:nums1){
            int b=tot-a;
            if (fm.containsKey(b)){
                count=count+fm.get(b);
            }
        }
        return count;
    }
}

/**
 * Your FindSumPairs object will be instantiated and called as such:
 * FindSumPairs obj = new FindSumPairs(nums1, nums2);
 * obj.add(index,val);
 * int param_2 = obj.count(tot);
 */