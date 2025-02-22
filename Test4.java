package Exp1;

public class Test4 {
	public static void main(String[] args) {
		 printStar(3);
	     printStar(5);
	     printStar(7);
	}
	public static void printStar(int n) {
        for (int i = 0; i < n; i++) {
            if(n < 7){//以打印7行的起始端为参照，补齐打印其他行图形前面的空格
                for (int x = 0; x < 7 - n; x++) {
                    System.out.print("  ");
                }
            }
            int k = 0;
            for (int j=0;j<i;j++) {//打印i次空格，每次打印2个
                System.out.print("  ");                
            }
            for (int j = 0; j < 2 * (n - i) - 1; j++) {//打印2(n-i)个星号+空格
                System.out.print("* ");
            }
            System.out.println();//换行
        }
	}
}
