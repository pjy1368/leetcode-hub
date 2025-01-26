import java.math.BigInteger;

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        BigInteger total = BigInteger.ONE;
        Set<Integer> zeroIdxs = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroIdxs.add(i);
                continue;
            }
            total = total.multiply(BigInteger.valueOf(nums[i]));
        }

        if (zeroIdxs.isEmpty()) {
            for (int i = 0; i < nums.length; i++) {
                result[i] = total.divide(BigInteger.valueOf(nums[i])).intValue();
            }
        } else {
            if (zeroIdxs.size() > 1) {
                for (int i = 0; i < nums.length; i++) {
                    result[i] = 0;
                }
            } else {
                for (int i = 0; i < nums.length; i++) {
                    if (zeroIdxs.contains(i)) {
                        result[i] = total.intValue();
                    } else {
                        result[i] = 0;
                    }
                }
            }
        }
        return result;
    }
}