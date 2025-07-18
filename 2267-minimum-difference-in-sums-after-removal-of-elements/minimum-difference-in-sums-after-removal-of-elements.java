import java.util.PriorityQueue;
public class Solution{
    public long minimumDifference(int[] nums){
        int n=nums.length/3;
        int total=nums.length;
        long[] left=new long[total];
        long leftSum=0;
        PriorityQueue<Integer> maxHeap=new PriorityQueue<>((a,b)->b-a);
        for(int i=0;i<2*n;i++){
            maxHeap.offer(nums[i]);
            leftSum+=nums[i];
            if(maxHeap.size()>n){
                leftSum-=maxHeap.poll();
            }
            if(i>=n-1){
                left[i]=leftSum;
            }
        }
        long[] right=new long[total];
        long rightSum=0;
        PriorityQueue<Integer> minHeap=new PriorityQueue<>();
        for(int i=total-1;i>=n;i--){
            minHeap.offer(nums[i]);
            rightSum+=nums[i];
            if(minHeap.size()>n){
                rightSum-=minHeap.poll();
            }
            if(i<=2*n){
                right[i]=rightSum;
            }
        }
        long result=Long.MAX_VALUE;
        for(int i=n-1;i<2*n;i++){
            result=Math.min(result,left[i]-right[i+1]);
        }
        return result;
    }
}