import java.util.Scanner;

public class homework {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入行数：");
        int row = scanner.nextInt();
        int[][] a=createArray(row);
        printArray(a);
        scanner.close();
    }
    /**
     *  创建一个不规则二维数组
     *  第一行row列
     *  第二行row - 1列
     *  ...
     *  最后一行1列
     *	数组元素值都为默认值
     * @param row 行数
     * @return 创建好的不规则数组
     */
    public static int[][] createArray(int row){
        if(row<=0){
            return null;
        }
        int [][]array = new int[row][];
        for(int i=0;i<row;i++){
            array[i] = new int[row-i];
        }
        return array;
    }

    /**
     * 逐行打印出二维数组，数组元素之间以空格分开
     * @param a
     */
    public static  void printArray(int[][] a){
        if(a==null) return;
        for(int [] arr:a){
            for(int v:arr){
                System.out.print(v+" ");
            }
            System.out.println();
        }
    }

}
