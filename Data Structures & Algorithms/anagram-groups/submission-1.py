class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        anagrams = defaultdict(list)
        output = []
        for word in strs:
            
            anagrams[''.join(sorted(word))].append(word)
        for key in anagrams:
            output.append(anagrams[key])
        return output
            
