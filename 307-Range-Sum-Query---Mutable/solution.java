public class NumArray {
    class BinaryIndexTreeNode {
        int start;
        int end;
        int sum;

        BinaryIndexTreeNode left;
        BinaryIndexTreeNode right;
    }

    int sum[];
    int nums[];
    BinaryIndexTreeNode root = new BinaryIndexTreeNode();

    public NumArray(int[] nums) {
        if (nums.length == 0)
            return;
        
        this.nums = nums;
        sum = new int[nums.length];

        sum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i];
        }

        root = buildTree(sum, 0, nums.length - 1);
        System.out.println();
    }

    void update(int i, int val) {
        int delta = val - nums[i];

        updateSum(i, delta, root);
        
        nums[i] = val;
    }

    public void updateSum(int i, int delta, BinaryIndexTreeNode root) {
        if (root.start == i && root.end == i) {
            root.sum += delta;
            return;
        }

        root.sum += delta;
        int mid = root.start + (root.end - root.start) / 2;

        if (i <= mid) {
            updateSum(i, delta, root.left);
        } else {
            updateSum(i, delta, root.right);
        }
    }

    public int sumRange(int i, int j) {
        return searchSum(i, j, root);
    }

    public int searchSum(int start, int end, BinaryIndexTreeNode root) {
        if (start == root.start && end == root.end)
            return root.sum;

        int mid = root.start + (root.end - root.start) / 2;

        if (end <= mid) {
            return searchSum(start, end, root.left);
        } else if (start >= mid + 1) {
            return searchSum(start, end, root.right);
        } else {
            return searchSum(start, mid, root.left) + searchSum(mid + 1, end, root.right);
        }
    }

    public BinaryIndexTreeNode buildTree(int sum[], int start, int end) {
        BinaryIndexTreeNode root = new BinaryIndexTreeNode();
        root.start = start;
        root.end = end;

        root.sum = sum[end];
        if (start > 0)
            root.sum -= sum[start - 1];

        if (start != end) {
            int mid = start + (end - start) / 2;

            root.left = buildTree(sum, start, mid);
            root.right = buildTree(sum, mid + 1, end);
        }

        return root;
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.update(1, 10);
// numArray.sumRange(1, 2);