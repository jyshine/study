
'''
public class Rotation {
  private static int[][] solutionRotation(int[][] matrix, int r) {
      int count = r % 4;

      for (int d = 0; d < count; d++) {
          matrix = rotate(matrix);
      }

      return matrix;
  }

  public static int[][] rotate(int[][] matrix){
      int n = matrix.length;
      int m = matrix[0].length;
      int[][] rotationArry = new int[m][n];

      for (int i = 0; i < n; i++) {
          for (int j = 0; j < m; j++) {
              rotationArry[j][n - 1 - i] = matrix[i][j];
          }
      }
      return rotationArry;
  }


  static void print(int[][] arr) {
      for (int i=0; i<arr.length; i++) {
          for (int j=0; j<arr[i].length; j++) {
              System.out.print(arr[i][j] + " ");
          }
          System.out.println("");
      }
  }

  public static void main(String[] args) {
//        int[][] matrix = {{4, 1, 2}, {7, 3, 4}, {3, 5, 6}};
//        int[][] matrix = {{1, 2}, {3,4}};
      int[][] matrix = {{1,2}, {3,4},{5,6}};
      int[][] rotateArr;
      int count =3;

      rotateArr = solutionRotation(matrix, count);
      print(rotateArr);

  }
}

/*
1,2,3
4,5,6
7,8,9
*/

/*
7,4,1
8,5,2
8,6,3
*/

//(0, 0), (0, 1), (0, 2)
//(0, 2), (1, 2), (2, 2)

//(0, 0), (0, 1), (0, 2)
//(2, 2), (2, 1), (2, 0)

//(0, 0), (0, 1), (0, 2)
//(2, 0), (1, 0), (0, 0)


// (0, 0) -> (0, 2) -> (2, 2) -> (2, 0)
// (0, 1) -> (1, 2) -> (2, 1) -> (1, 0)
// (0, 2) -> (2, 2) -> (2, 0) -> (0, 0)

//col -> index 열 값이 인덱스 값 규칙
//열의 값은 이전 index - 길이;
'''