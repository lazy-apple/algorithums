/**旋转打印矩阵(代码有误)
 * @author LaZY(李志一)
 * @create 2019-07-20 13:00
 */
public class PrintMatrixSpiralOrder_Test {
    public static void spiralOrderPrint(int[][] matrix){
        int tr,tc,dr,dc;
        tr = 0;
        tc = 0;
        dr = matrix.length - 1;
        dc = matrix[0].length - 1;

        while(tc <= dr && tc <= dc){
            print(matrix,tr++,tc++,dr--,dc--);
        }
    }

    public static void print(int[][] arr, int tr, int tc, int dr, int dc){

        int i= tc;
        while(i< dc){
            System.out.println(arr[tr][i++]+" ");
        }

        i = tr;
        while(i < dr -1){
            System.out.println(arr[i++][dc]+" ");
        }

        i = dc;
        while (i > tc-1){
            System.out.println(arr[i--][dr]+" ");
        }

        i = dr;
        while (i > tr){
            System.out.println(arr[tc][i--]+" ");
        }
    }
    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };
        spiralOrderPrint(matrix);

    }
}
