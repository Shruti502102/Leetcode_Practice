class Solution:
    def isPalindrome(self, s: str) -> bool:
        cleaned=''
        for c in s:
            if c.isalnum():
                cleaned=cleaned+c.lower()
        return cleaned==cleaned[::-1]
        