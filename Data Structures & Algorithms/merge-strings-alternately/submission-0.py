class Solution:
    def mergeAlternately(self, word1: str, word2: str) -> str:
        
        first = True

        i = 0
        j = 0
        merged = ""

        while i < len(word1) and j < len(word2):
            if first:
                merged = merged + word1[i]
                i+=1
            else:
                merged = merged + word2[j]
                j+=1
            first = not first
        while i < len(word1):
            merged = merged + word1[i]
            i+=1
        while  j < len(word2):
            merged = merged + word2[j]
            j+=1
        return merged


