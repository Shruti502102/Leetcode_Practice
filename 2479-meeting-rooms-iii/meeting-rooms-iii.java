class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings,(a,b)->a[0]-b[0]);
        PriorityQueue<int[]> busyrooms=new PriorityQueue<>(
            (a,b)->a[0]==b[0]?a[1]-b[1]:a[0]-b[0]);
        PriorityQueue<Integer> idlerooms=new PriorityQueue<>();
        for(int i=0;i<n;i++){
            idlerooms.offer(i);
        }
        int [] count=new int[n];
        for(int[] meeting:meetings){
            int start=meeting[0],end=meeting[1];
            while(!busyrooms.isEmpty() && busyrooms.peek()[0]<=start){
                idlerooms.offer(busyrooms.poll()[1]);
            }
            int roomid;
            if(!idlerooms.isEmpty()){
                roomid=idlerooms.poll();
                busyrooms.offer(new int[] {end,roomid});
            }
            else{
                int[] busyroom=busyrooms.poll();
                roomid=busyroom[1];
                busyrooms.offer(new int[]  {busyroom[0]+end-start,roomid});

            }
            count[roomid]++;
        }
        int mostBookedRoom=0;
        for(int i=0;i<n;i++){
            if(count[mostBookedRoom]<count[i]){
                mostBookedRoom=i;
            }
        }
        return mostBookedRoom;
    }
}
