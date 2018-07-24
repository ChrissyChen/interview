    public class Solution {
    /**
     * @param s: A string
     * @return: Whether the string is a valid palindrome
     */
    public boolean isPalindrome(String s) {
        // write your code here
        if (s == null || s.length() == 0) {
            return true;
        }
        
        int i = 0, j = s.length() - 1;
        while (i < j) {
            while (i < s.length() && !isValid(s.charAt(i))) {
                i++;
            }
            
            if (i == s.length()) { // for string “.,,,”     
                return true; 
            } 
            
            
            while (j >= 0 && !isValid(s.charAt(j))) {
                j--;
            }
            
            if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
                return false;
            } else {
                i++;
                j--;
            }
        }
        return true;
    }
    
    private boolean isValid(char ch) {
        return Character.isLetter(ch) || Character.isDigit(ch);
    }
}