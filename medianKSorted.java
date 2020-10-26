public class medianKSorted {
    public static void main(String[] args) {
        int[][] nums={{10, 100, 1000}, {5, 55, 555}, {23, 2323, 232323}};
        System.out.print(getMedian(nums));
    }

    static int getMedian(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int lo = Integer.MAX_VALUE;
        int hi = Integer.MIN_VALUE;
        int half = (rows * cols + 1) / 2;

        for (int c = 0; c < cols; c++) {
            lo = Math.min(lo, matrix[0][c]);
            hi = Math.max(hi, matrix[rows - 1][c]);
            System.out.println(lo+" "+hi);
        }

        while (lo < hi) {
            int mid = (lo + hi) >>> 1;
            System.out.println("mid: "+mid);
            if (possible(matrix, mid, half)) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    private static boolean possible(int[][] matrix, int median, int half) {
        int smallerElements = 0;
        for (int[] row : matrix) {
            System.out.println("count smaller: "+countSmallerElements(row, median));
            smallerElements += countSmallerElements(row, median);
        }
        return smallerElements >= half;
    }

    private static int countSmallerElements(int[] arr, int target) {
        int lo = 0;
        int hi = arr.length - 1;
        int upperBound = -1;
        while (lo <= hi) {
            int mid = (lo + hi) >>> 1;
            if (arr[mid] == target) {
                upperBound = mid;
                lo = mid + 1;
            } else if (arr[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return upperBound != -1 ? upperBound + 1 : lo;
    }
}
