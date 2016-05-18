class LRUNode {
    int key;
    int value;
    LRUNode newer;
    LRUNode older;

    LRUNode(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

public class LRUCache {
    int capacity;
    LRUNode latest;
    LRUNode oldest;
    int currSize;
    Map<Integer, LRUNode> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        oldest = null;
        latest = null;
        currSize = 0;
        map = new HashMap<>();
    }

    public int get(int key) {
        if (map.get(key) == null)
            return -1;
            
        // refresh node for key to latest
        LRUNode tmp = map.get(key);
        int value = tmp.value;
        deleteNode(key);
        appendNode(key, value);

        return map.get(key).value;
    }

    public void set(int key, int value) {
        if (map.get(key) != null) {
            deleteNode(key);
            appendNode(key, value);
        } else {
            if (currSize < capacity) {
                appendNode(key, value);
            } else {
                int oldestKey = oldest.key;
                deleteNode(oldestKey);
                appendNode(key, value);
            }
        }
    }

    private void appendNode(int key, int value) {
        LRUNode tmp = new LRUNode(key, value);

        if (currSize == 0) {
            oldest = tmp;
            latest = tmp;
        } else {
            tmp.older = latest;
            latest.newer = tmp;
            latest = tmp;
        }

        map.put(key, tmp);
        currSize++;
    }

    private void deleteNode(int key) {
        LRUNode toDelete = map.get(key);

        if (toDelete.newer != null) {
            toDelete.newer.older = toDelete.older;
        }

        if (toDelete.older != null) {
            toDelete.older.newer = toDelete.newer;
        }

        if (toDelete == oldest)
            oldest = toDelete.newer;

        if (toDelete == latest)
            latest = toDelete.older;

        map.remove(key);
        currSize--;
    }
}