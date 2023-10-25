import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println("Pascal's Triangle = " + (sol.generateV2(5)));
    }
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> subList = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j <= i; j++) {
                int coef = computePascalCoef(i, j);
                subList.add(coef);
                System.out.print(coef + " ");
//                System.out.println("subList = " + subList);
            }
            list.add(subList);

            System.out.println();
        }
        return list;
    }

    private int computePascalCoef(int row, int col) {
        if(col == 0 || col == row){
            return 1;
        }else{
            int left = computePascalCoef(row - 1, col - 1);
            int right = computePascalCoef(row - 1, col);
            return left + right;
        }
    }
    public List<List<Integer>> generateV1(int numRows) {
        List<List<Integer>> listOfList = new ArrayList<>();
        int[][] triangle = new int[numRows][];
        for (int i = 0; i < numRows; i++) {
            triangle[i] = new int[i + 1];
            triangle[i][0] = 1;
            for (int j = 1; j < i; j++) {
                triangle[i][j] = triangle[i - 1][j - 1] + triangle[i - 1][j];
            }
            triangle[i][i] = 1;
        }
        for ( int[] row : triangle) {
            List<Integer> list = new ArrayList<>();
            for (int elt : row) {
                list.add(elt);
            }
            listOfList.add(list);

        }
        return listOfList;
    }
    public List<List<Integer>> generateV2(int numRows){
        List<List<Integer>> triangle = new ArrayList<>();

        if (numRows == 0) {
            return triangle;
        }

        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        triangle.add(firstRow);

        for (int rowNum = 1; rowNum < numRows; rowNum++) {
            List<Integer> previousRow = triangle.get(rowNum - 1);
            List<Integer> currentRow = new ArrayList<>();

            // First element of the row is always 1
            currentRow.add(1);

            for (int j = 1; j < rowNum; j++) {
                currentRow.add(previousRow.get(j - 1) + previousRow.get(j));
            }

            // Last element of the row is always 1
            currentRow.add(1);

            triangle.add(currentRow);
        }

        return triangle;
    }
}
