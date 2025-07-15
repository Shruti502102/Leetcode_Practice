class Solution {
    public boolean isValid(String word) {
        if(word.length()<3){
            return false;
        }
        boolean hasVowel=false;
        boolean hasConsonant=false;
        for(int i=0;i<word.length();i++){
            char ch=word.charAt(i);
            if(!Character.isLetterOrDigit(ch)){
                return false;
            }
            if("aeiouAEIOU".indexOf(ch)!=-1){
                hasVowel=true;
            }
            else if(Character.isLetter(ch)){
                hasConsonant=true;

            }
        }
        return hasVowel && hasConsonant;
    }
}