class Solution {
    public boolean isRectangleOverlap(int[] a, int[] b) {
         

        int left1 = a[0];
        int bottom1 = a[1];
        int right1 = a[2];
        int top1 = a[3];

        int left2 = b[0];
        int bottom2 = b[1];
        int right2 = b[2];
        int top2 = b[3];

        boolean horizontal = left1 < right2 && left2 < right1;
        boolean vertical = bottom1 < top2 && bottom2 < top1;

        // Both horizontal and vertical overlap are required
        return horizontal && vertical;
    }
}