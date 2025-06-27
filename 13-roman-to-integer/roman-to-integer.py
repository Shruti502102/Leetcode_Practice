class Solution(object):
    def romanToInt(self, s):
        sum = 0
        pre = 0
        value = {'I': 1, 'V': 5, 'X': 10, 'L': 50, 'C': 100, 'D': 500, 'M': 1000}
        
        for c in s:
            current = value[c]
            sum += (current - 2 * pre) if (current > pre) else current
            pre = current
        return sum
        