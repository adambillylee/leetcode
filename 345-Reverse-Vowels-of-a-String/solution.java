public class Solution {
    public String reverseVowels(String s) {
        Set<Character> set = new HashSet();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        
        char[] charArray = s.toCharArray();
        List<Character> vowels = new ArrayList();
        
        
        for (char c : charArray) {
            if (set.include(c))
                vowels.append(0,c);
        }
        
        int curr=0;
        for (int i=0; i<vowels.length; i++) {
            char c = charArray[i];
            
            if (set.include(c))
                charArray[i] = vowels.get(curr++);
        }
        
        return String.valueOf(charArray);
    }
}