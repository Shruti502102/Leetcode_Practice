class Solution {
    public int possibleStringCount(String word) {
        int total=1;
        int i=0;
        while(i<word.length()){
            char currentc=word.charAt(i);
            int count=0;
            while(i<word.length() && word.charAt(i)==currentc){
                count++;
                i++;
            }
            if(count>1){
                total=total+(count-1);
            }
        }
        return total;
        
    }
}