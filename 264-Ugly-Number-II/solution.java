public class Solution {
    public int nthUglyNumber(int n) {
        // create an array list of ugly numbers
        ArrayList<Integer> rst = new ArrayList<Integer>();

        // initialization: add 1 into rst
        rst.add(1);

        /**
         * create three pointers in rst
         * for 3,5 and 7
         */
        int curr2 = 0;
        int curr3 = 0;
        int curr5 = 0;

        int min = 1;

        while(rst.size()<=n) {
            /**
             * considering 3 currs represent 3 sequences
             * each cursor pointed to number in rst to be used as base to multiply 2,3 or 5
             * in each iteration the min number is the min possible ugly number within 3 sequences
             * after that cursor is used, move that cursor front by 1 so new ugly number in that seq
             * could be used in min comparison next time.
             * The other cursor will stay in their previous min position, wait for their multiply to be the new min
             */
            int e2 = rst.get(curr2) * 2;
            int e3 = rst.get(curr3) * 3;
            int e5 = rst.get(curr5) * 5;

            // pick min of 3 new multiplies to be result ugly number
            min = Math.min(Math.min(e2,e3),e5);

            // move cursor forward so new multiplies are generated based on previous min
            if(min.equals(e2))
                curr2 ++;

            if(min.equals(e3))
                curr3++;

            if(min.equals(e5))
                curr5++;

            // add min into rst last in order to avoid screw ups of indexes
            rst.add(min);
        }

        return min;
    }
}