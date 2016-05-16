public class Solution {
    public boolean isAdditiveNumber(String num) {
        for (int i = 0; i < num.length() - 2; i++) {
            for (int j = 1; i + j < num.length(); j++) {
                int firstEnd = i;
                int secondEnd = i + j;

                if (validSum(num, 0, firstEnd, secondEnd))
                    return true;
            }
        }

        return false;
    }

    private boolean validSum(String num, int start, int firstEnd, int secondEnd) {
        String firstStr = num.substring(start, firstEnd + 1);
        if (firstStr.length() > 1 && firstStr.startsWith("0"))
            return false;

        String secondStr = num.substring(firstEnd + 1, secondEnd + 1);
        if (secondStr.length() > 1 && secondStr.startsWith("0"))
            return false;

        long sum = Long.parseLong(firstStr) + Long.parseLong(secondStr);
        String sumStr = String.valueOf(sum);
        String remaining = num.substring(secondEnd + 1);

        if (remaining.startsWith(sumStr)) {
//            System.out.println(firstStr + " + " + secondStr + " = " + sumStr);

            if (secondEnd + sumStr.length() == num.length() - 1)
                return true;

            return validSum(num, firstEnd + 1, secondEnd, secondEnd + sumStr.length());
        }

        return false;
    }
}