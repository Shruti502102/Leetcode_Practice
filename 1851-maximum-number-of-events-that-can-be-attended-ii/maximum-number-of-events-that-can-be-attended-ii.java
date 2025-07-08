class Solution {
    public int maxValue(int[][] events, int k) {
        Arrays.sort(events,(a,b)->Integer.compare(a[0],b[0]));
        int[][] memo=new int[events.length][ k+1];
        for(int[] row:memo)Arrays.fill(row,-1);
        return dfs(0,k,events,memo);
    }
    private int dfs(int i,int remain,int[][] events,int[][] memo){
        if(i==events.length||remain==0)return 0;
        if(memo[i][remain]!=-1)return memo[i][remain];
        int skip=dfs(i+1,remain,events,memo);
        int next=findnext(events,events[i][1]);
        int take=events[i][2]+dfs(next,remain-1,events,memo);
        return memo[i][remain]=Math.max(skip,take);
        

    }
    private int findnext(int[][] events,int endday){
        int left=0,right=events.length;
        while(left<right){
            int mid=(left+right)/2;
            if(events[mid][0]<=endday){
                left=mid+1;
            }
            else{
                right=mid;
            }
        }
        return left;    
        
    }
}