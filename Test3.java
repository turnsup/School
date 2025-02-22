package Exp1;

public class Test3 {
	public static void main(String[] args) {
		int line = 5;
		 for (int i = 0; i < line; i++) {
	            int k = 0;
	            while(k < i){
	                System.out.print("  ");
	                k++;
	            }
	            for(int j = 0;j < 2 * (line - i) - 1;j++){
	                System.out.print("* ");
	            }
	            System.out.println();
	        }
	}
}
