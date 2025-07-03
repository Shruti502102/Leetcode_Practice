class Solution:
    def climbStairs(self, n: int) -> int:
        if n==1:
            return 1
        if n==2:
            return 2
        f=1
        s=2
        for i in range(3,n+1):
            t=f+s
            f=s
            s=t
        return s
        