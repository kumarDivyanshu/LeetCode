class Solution {
    public double separateSquares(int[][] squares) {
        double minY = Double.MAX_VALUE;
        double maxY = -Double.MAX_VALUE;

        double totalArea = 0.0;
        for (int[] s : squares) {
            minY = Math.min(minY, s[1]);
            maxY = Math.max(maxY, s[1] + s[2]);
            totalArea += 1.0 * s[2] * s[2];
        }

        double half = totalArea / 2.0;
        double precision = 1e-6;

        while (maxY - minY > precision) {
            double midY = (minY + maxY) / 2.0;
            if (areaBelow(squares, midY) >= half) {
                maxY = midY;  
            } else {
                minY = midY;  
            }
        }

        return minY;
    }

    double areaBelow(int[][] squares, double yLine) {
        double area = 0.0;

        for (int[] s : squares) {
            double y = s[1];
            double side = s[2];
            if (y + side <= yLine) {
                area += side * side;
            } else if (y < yLine) {
                area += side * (yLine - y);
            }
        }
        return area;
    }
}
