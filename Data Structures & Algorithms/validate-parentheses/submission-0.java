class Solution {
    public boolean isValid(String s) {
        
        if (s.length() % 2 != 0) {
            return false;
        }

        StringBuilder sb = new StringBuilder(s);
        int i = 0;

        while (i < sb.length() - 1) {
            char curr = sb.charAt(i);
            char next = sb.charAt(i + 1);

            // Change 2: Check if adjacent characters form a valid pair
            if ((curr == '(' && next == ')') ||
                (curr == '{' && next == '}') ||
                (curr == '[' && next == ']')) {

                // Change 3: Remove the matched pair
                sb.delete(i, i + 2);

                // Change 4: Step back one index (or reset) to check newly adjacent pairs
                i = Math.max(0, i - 1);
            } else {
                i++;
            }
        }

        // Change 5: If string is completely cleared, it was valid
        return sb.length() == 0;
    }
}
