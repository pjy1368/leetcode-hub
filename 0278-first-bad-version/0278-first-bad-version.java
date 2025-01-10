/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        return search(n);
    }

    private int search(int n) {
        int left = 1;
        int right = n;
        int bad = 0;

        while (left <= right) {
            int mid = (left + right) >>> 1;

            if (isBadVersion(mid)) {
                bad = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return bad;
    }
}