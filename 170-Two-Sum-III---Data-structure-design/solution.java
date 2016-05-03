public class TwoSum {
    List<Integer> list = new ArrayList();
    
    // Add the number to an internal data structure.
	public void add(int number) {
	    list.add(number);
	}

    // Find if there exists any pair of numbers which sum is equal to the value.
	public boolean find(int value) {
	    HashSet<Integer> set = new HashSet();
	    
	    for (int i : list) {
            if (set.contains(value - i)) {
	            return true;
            }else{
                set.add(i);
            }
	    }
	    
	    return false;
	}
}


// Your TwoSum object will be instantiated and called as such:
// TwoSum twoSum = new TwoSum();
// twoSum.add(number);
// twoSum.find(value);