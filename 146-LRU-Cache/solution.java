public class LRUCache {
    class LRUNode {
        int key;
        int value;
        LRUNode older;
        LRUNode newer;

        public LRUNode(int key, int value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return key + " : " + value;
        }
    }

    int capacity;
    int size;
    LRUNode latest;
    LRUNode oldest;
    Map<Integer, LRUNode> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        latest = null;
        oldest = null;
        map = new HashMap<>();
    }

    public int get(int key) {
        if (size == 0) {
            System.out.println("Cache is Empty");
            return -1;
        }

        if (map.containsKey(key)) {
            int value = map.get(key).value;
            del(key);
            append(key, value);
            return value;
        } else {
            return -1;
        }
    }

    public void set(int key, int value) {
        if (map.containsKey(key)) {
            del(key);
            append(key, value);
        } else {
            if (size == capacity) {
                int oldestKey = oldest.key;
                del(oldestKey);
                append(key,value);
            }else{
                append(key,value);
            }
        }
    }

    private void append(int key, int value) {
        LRUNode newNode = new LRUNode(key, value);

        if (size == 0) {
            latest = newNode;
            oldest = newNode;
        } else {
            newNode.older = latest;
            latest.newer = newNode;
            latest = newNode;
        }

        map.put(key, newNode);
        size++;
    }

    private void del(int key) {
        LRUNode curr = map.get(key);

        if (curr == null)
            return;

        if (curr == latest)
            latest = latest.older;

        if (curr == oldest)
            oldest = oldest.newer;

        if (curr.newer != null)
            curr.newer.older = curr.older;

        if (curr.older != null)
            curr.older.newer = curr.newer;

        map.remove(key);
        size--;
    }
}