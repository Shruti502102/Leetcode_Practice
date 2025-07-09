class Solution {
    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        int n=startTime.length;
        List<Integer>freegaps=new ArrayList<>();
        freegaps.add(startTime[0]);
        for(int i=1;i<n;++i){
            freegaps.add(startTime[i]-endTime[i-1]);
        }
        freegaps.add(eventTime-endTime[n-1]);
        int maxfreeduration=0,currentsum=0;
        for(int i=0;i<freegaps.size();++i){
            currentsum+=freegaps.get(i);
            if(i>=k+1){
                currentsum-=freegaps.get(i-(k+1));
            }
            maxfreeduration=Math.max(maxfreeduration,currentsum);
        }
        return maxfreeduration;
    }
}
