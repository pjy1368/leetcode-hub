import java.math.*;

class Solution {
    public int myAtoi(String s) {
        // Step 1 - 공백 제거
        String step1 = removeSpaces(s);
        
        if (step1.isEmpty()) {
            return 0;
        }

        // Step 2 - 부호 판단
        boolean isNegative = (step1.charAt(0) == '-');
        String step2 = removeFirstSign(step1);

        // Step 3 - 숫자만 읽기
        int start = -1;
        int end = -1;
        for (int i = 0; i < step2.length(); i++) {
            char c = step2.charAt(i);

            if (Character.isDigit(c)) {
                if (start == -1) {
                    if (c != '0') {
                        start = i;
                        end = i;
                    }
                } else {
                    end = i;
                }
            } else {
                break;
            }
        }

        if (start == -1) {
            return 0;
        }

        String step3 = step2.substring(start, end + 1);

        // Step 4 - Int 범위 확인하기
        BigInteger bigInteger = new BigInteger(step3);
        if (isNegative) {
            bigInteger = bigInteger.negate();
        }

        if (bigInteger.compareTo(BigInteger.valueOf(Integer.MIN_VALUE)) <= 0) {
            return Integer.MIN_VALUE;
        }
        if (bigInteger.compareTo(BigInteger.valueOf(Integer.MAX_VALUE)) >= 0) {
            return Integer.MAX_VALUE;
        }

        int step4 = Integer.parseInt(step3);
        return isNegative ? -step4 : step4;
    }

    public String removeSpaces(String s) {
        return s.stripLeading();
    }

    private String removeFirstSign(String s) {
        if (s.charAt(0) == '-' || s.charAt(0) == '+') {
            return s.substring(1, s.length());
        }
        return s;
    }
}