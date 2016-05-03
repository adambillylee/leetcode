public class Solution {
    public String removeDuplicateLetters(String s) {
        Stack<Character> stack = new Stack();
        HashMap<Character, Integer> map = new HashMap();

        // build count map
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(s.charAt(i), 1);
            }
        }

        HashSet<Character> set = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (set.contains(c)) {
                map.put(c, map.get(c) - 1);
                continue;
            }

            while (!stack.isEmpty() && c <= stack.peek() && map.get(stack.peek()) > 1) {
                char head = stack.peek();

                stack.pop();
                System.out.println("pop: " + head);
                map.put(head, map.get(head) - 1);
                System.out.println(head + " count: " + map.get(head));
                set.remove(head);
            }

            stack.push(c);
            System.out.println("stack push: " + c);
            set.add(c);
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }

        return sb.toString();
    }
}