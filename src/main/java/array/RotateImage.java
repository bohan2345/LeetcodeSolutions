package array;

/**
 * You are given an n x n 2D matrix representing an image. <br>
 * Rotate the image by 90 degrees (clockwise). <br>
 * Could you do this in-place?
 *
 * @author Bohan Zheng
 */
public class RotateImage {
    public void rotate(int[][] matrix) {
        int len = matrix.length - 1;
        for (int level = 0; level <= (len - 1) / 2; level++) {
            for (int shift = level; shift < len - level; shift++) {
                int tmp = matrix[level][shift];
                matrix[level][shift] = matrix[len - shift][level];
                matrix[len - shift][level] = matrix[len - level][len - shift];
                matrix[len - level][len - shift] = matrix[shift][len - level];
                matrix[shift][len - level] = tmp;
            }
        }
    }
}
