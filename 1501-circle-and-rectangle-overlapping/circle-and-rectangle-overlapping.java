class Solution {
    public boolean checkOverlap(int r, int x, int y,
                                int x1, int y1, int x2, int y2) {

        int closestX = x;
        int closestY = y;

        if (x < x1)
            closestX = x1;
        else if (x > x2)
            closestX = x2;

        if (y < y1)
            closestY = y1;
        else if (y > y2)
            closestY = y2;

        int dx = x - closestX;
        int dy = y - closestY;

        return dx * dx + dy * dy <= r * r;
    }
}