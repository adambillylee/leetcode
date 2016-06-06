public class Solution {
    public String numberToWords(int num) {
        if (num == 0)
            return "Zero";

        StringBuilder sb = new StringBuilder();

        int i = 0;
        String thousands[] = {" Thousand ", " Million ", " Billion "};

        while (num > 0) {
            if (num % 1000 != 0) {
                sb.insert(0, helper(num % 1000));
                sb.insert(0, thousands[i]);
            }

            num /= 1000;
            i++;
        }

        sb.insert(0, helper(num));

        return sb.toString().trim();
    }

    public String helper(int num) {
        StringBuilder sb = new StringBuilder();

        String twenty[] = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
                "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        String tens[] = {"", "", "Twenty ", "Thirty ", "Forty ", "Fifty ", "Sixty ", "Seventy ", "Eighty ", "Ninety "};

        if (num < 20) {
            sb.append(twenty[num]);
        } else if (num < 100) {
            sb.append(tens[num / 10]).append(twenty[num % 10]);
        } else {
            sb.append(twenty[num / 100]).append(" Hundred ");
            sb.append(helper(num % 100));
        }

        return sb.toString().trim();
    }
}