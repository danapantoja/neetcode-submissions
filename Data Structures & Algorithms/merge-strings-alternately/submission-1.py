class Solution:
    def mergeAlternately(self, word1: str, word2: str) -> str:
        
        first = True

        i = 0
        j = 0
        merged =[]

        while i < len(word1) and j < len(word2):
            if first:
                merged.append(word1[i])
                i+=1
            else:
                merged.append(word2[j])
                j+=1
            first = not first
        while i < len(word1):
            merged.append(word1[i])
            i+=1
        while  j < len(word2):
            merged.append(word2[j])
            j+=1
        return ''.join(merged)


