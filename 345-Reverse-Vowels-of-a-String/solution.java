public class Solution {
    public String reverseVowels(String s) {
        Set<Character> set = new HashSet();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');
        
        char[] charArray = s.toCharArray();
        List<Character> vowels = new ArrayList();
        
        
        for (char c : charArray) {
            if (set.contains(c))
                vowels.add(0,c);
        }
        
        int curr=0;
        for (int i=0; i<charArray.length; i++) {
            char c = charArray[i];
            
            if (set.contains(c))
                charArray[i] = vowels.get(curr++);
        }
        
        return String.valueOf(charArray);
    }
}