class Solution:
    def kthCharacter(self, k: int) -> str:
        word="a"
        while len(word)<k:
            newpart=""
            for letter in word:
                nextletter=chr((ord(letter)-ord('a')+1)%26+ord('a'))
                newpart=newpart+nextletter
            word=word+newpart
        return word[k-1]
        