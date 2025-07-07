class Solution {
    public int maxEvents(int[][] events) {
        Arrays.sort(events,(a,b)->a[0]-b[0]);
        PriorityQueue<Integer> minheap=new PriorityQueue<>();
        int i=0;
        int total=events.length;
        int day=1;
        int maxevents=0;
        int lastday=0;
        for(int[] event:events){
            lastday=Math.max(lastday,event[1]);
        }
        while(day<=lastday){
            while(i<total && events[i][0]==day){
                minheap.add(events[i][1]);
                i++;
            }
            while(!minheap.isEmpty() && minheap.peek()<day){
                minheap.poll();
            }
            if(!minheap.isEmpty()){
                minheap.poll();
                maxevents++;
            }
            day++;
        }
        return maxevents;
    }
}
