class Solution:
    def subarrayBitwiseORs(self, arr: List[int]) -> int:
        all_ors = set() 
        current_ors = set() 
        for num in arr:
            next_ors = {num} 
            for prev_or in current_ors:
                next_ors.add(prev_or | num) 
            all_ors.update(next_ors) 
            current_ors = next_ors 
        return len(all_ors)

        