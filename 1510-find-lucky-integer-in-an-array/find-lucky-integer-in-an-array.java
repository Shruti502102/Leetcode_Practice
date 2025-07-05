class Solution {
    public int findLucky(int[] arr) {
        HashMap<Integer,Integer> fm=new HashMap<>();
        for(int num:arr){
            fm.put(num,fm.getOrDefault(num,0)+1);
        }
        int result=-1;
        for(int key: fm.keySet()){
            if(key==fm.get(key)){    
                result=Math.max(result,key);
            }
        }
        return result;
    }
}