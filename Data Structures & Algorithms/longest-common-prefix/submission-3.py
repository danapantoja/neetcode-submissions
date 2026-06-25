class Solution:
    def longestCommonPrefix(self, strs: List[str]) -> str:
        output = ''
        shortest = float('inf')
        for s in strs:
            shortest = min(len(s), shortest)
        
        i = 0
        while i < shortest:

            curr = strs[0][i]
            for word in strs[1:]:
                if word[i]!=curr:
                    return output
            output+=curr
            i+=1
        return output