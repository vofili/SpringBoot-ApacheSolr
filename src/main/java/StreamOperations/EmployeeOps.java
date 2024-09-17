package StreamOperations;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeOps {

//implement a function to reverse each column of a mmatrix

    static int[][] doMatrixColumnReverse(int[][] input){
                int rows=input.length;
                int cols=input[0].length;

                for(int i = 0; i < cols; i++){
                    for (int j = 0,k=rows-1; j <  k; j++,k--){
                        int temp = input[j][i];
                        input[j][i]= input[k][i];
                        input[k][i]= temp;
                    }
                }

                return input;
    }

    //implement a function to rotate a square matrix counter clockwise
    static int[][] doMatrixTranspose(int[][] input){
        int rows = input.length;
        int cols = input[0].length;

        for(int i = 0; i < rows; i++){
            for(int j = i; j < cols;j++){
                int temp = input[i][j];
                input[i][j] = input[j][i];
                input[j][i]= temp;
            }
        }

        return input;
    }

    public static void main(String[] args) {

        int [][] nums = {{3,4,5},{6,7,8},{9,10,11}};

        var trans = doMatrixTranspose(nums);

        for(int[] x: trans){
            System.out.println(Arrays.toString(x));
        }

        var rev = doMatrixColumnReverse(nums);

        System.out.printf("%s %x %o %n","=",12, 11);

        for(int x[]: rev){
            System.out.println(Arrays.toString(x));
        }

    }
}
