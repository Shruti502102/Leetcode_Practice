class Solution {
    public boolean isPalindrome(int x) {
        String original = Integer.toString(x);
        String rev = new StringBuilder(original).reverse().toString();
        return original.equals(rev);
        
    }
}