class Solution:
    def validPalindrome(self, s: str) -> bool:
        if len(s) <=2: 
            return True        
        
        left = 0
        right = len(s) - 1
        while left < right:
            if s[left] !=s[right]:
                #check if after current left or right deletion we get a palindrome
                return s[left + 1 : right + 1][::-1] == s[left + 1 : right + 1] or s[left: right][::-1] ==s[left: right]
            left+=1
            right-=1
        
        return True
        