public class Solution {
    public String numberToWords(int num) {
        if (num == 0)
            return "Zero";

        StringBuilder sb = new StringBuilder();

        int i = 0;
        String thousands[] = {"", " Thousand ", " Million ", " Billion "};

        while (num > 0) {
            if (num % 1000 != 0) {
                sb.insert(0, thousands[i]);
                sb.insert(0, helper(num % 1000));
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

        while (num > 0) {
            if (num < 20) {
                // for under 20, handle directly
                sb.append(twenty[num]);
                break;
            } else if (num < 100) {
                // for under 100, handles with tens + under twenty
                sb.append(tens[num / 10]).append(twenty[num % 10]);
                break;
            } else {
                // for hundreds, add hundred and solve with recursion
                sb.append(twenty[num / 100]).append(" Hundred ");
                num = num % 100;
            }
        }

        return sb.toString().trim();
    }
}