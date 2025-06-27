class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 1;
        int length = digits.length;
        int index = length - 1;
        while (index >= 0) {
            if (digits[index] + carry == 10) {
                digits[index] = 0;
            } else {
                digits[index] = digits[index] + carry;
                return digits;
            }
            index--;
        }

        int result[] = new int[length + 1];
        result[0] = carry;
        for (int position = 0; position < length; position++) {
            result[position + 1] = digits[position];
        }

        return result;
    }
}