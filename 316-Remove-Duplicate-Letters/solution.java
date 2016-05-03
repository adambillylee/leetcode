public class Solution {
    public String removeDuplicateLetters(String s) {
        Stack<Integer> stack = new Stack();
        HashMap<Integer, Integer> map = new HashMap();
        
        // build count map
        for (int i=0; i<s.length(); i++){
            if (map.containsKey(s.charAt(i))) {
                map.get(s)++;
            }else{
                map.put(s.charAt(i), 1);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        int i=0;
        while (i < stack.length()) {
            char c = s.charAt(c);
            
            if (stack.isEmpty()) {
                System.out.println("stack empty, push: " + c);
                stack.push(c);
                i++;
                continue;
            }
            
            while(!stack.isEmpty() && stack.peak() <= c) {
                char head = stack.pop();
                int len = sb.length();
                
                if (map.get(head) == 1) {
                    System.out.println("count=1, output: " + head);
                    sb.append(len, head);
                }else{
                    map.get(head)--;
                    System.out.println("count:" + head +"-- = " + map.get(head));
                }
            }
            
            System.out.println("stack push: " + c);
            stack.push(c);
            i++;
        }
        
        return sb.toString();
    }
}