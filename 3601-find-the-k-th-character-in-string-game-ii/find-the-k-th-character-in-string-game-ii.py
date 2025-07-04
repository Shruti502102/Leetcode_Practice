class Solution:
    def kthCharacter(self, k: int, operations: List[int]) -> str:
        l=1
        for o in operations:
            l=l*2
        shift=0
        for i in range(len(operations)-1,-1,-1):
            l//=2
            if operations[i]==0:
                if k>l:
                    k=k-l
            else:
                if k>l:
                    k=k-l
                    shift=shift+1
        return chr((ord('a')-ord('a')+shift)%26+ord('a'))
