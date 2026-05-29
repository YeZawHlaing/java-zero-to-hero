package dimensionalArrays;

public class ZipZap {

    public static String convert(String s, int numRows) {
        if (s == null || s.length() == 0 || numRows <= 1) {
            return s;
        }

        int sLength = s.length();
        char[][] arr = new char[numRows][sLength];

        int row = 0;
        int col = 0;
        boolean movingDown = true;

        for (int i = 0; i < sLength; i++) {
            arr[row][col] = s.charAt(i);

            if (movingDown) {
                row++;
                if (row == numRows) {
                    row -= 2;
                    col++;
                    movingDown = false;
                }
            } else {
                row--;
                col++;

                if (row < 0) {
                    row = 1;
                    col--;
                    movingDown = true;
                }
            }
        }

        StringBuilder str = new StringBuilder();
        for (int r = 0; r < numRows; r++) {
            for (int c = 0; c < arr[r].length; c++) {
                // Char arrays default to '\0' (null char), so we only append filled slots
                if (arr[r][c] != '\0') {
                    str.append(arr[r][c]);
                }
            }
        }

        //  Return the built StringBuilder string, not the array object
        return str.toString();
    }

    public static void main(String[] args) {
        int numRows = 3;
        String s = "PAYPALISHIRING";

        // Output will be: PAHNAPLSIIGYIR
        System.out.println(convert(s, numRows));
    }
}