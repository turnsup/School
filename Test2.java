package Exp1;
import java.util.Scanner;

public class Test2 {
	public static void main(String[] args) {
		 int n = (int)(Math.random() * 100 + 1); 
	        Scanner s = new Scanner(System.in);
	        int guess;
	        do{
	            System.out.print("请输入猜的数字[1,100]：");
	            guess = s.nextInt();
	            if(guess < 1 || guess > 100){
	                System.out.print("所猜数的范围不正确，");
	                continue;
	            }
	            if (guess > n)
	                System.out.println("猜大了");
	            else if(guess < n)
	                System.out.println("猜小了");
	        }while(guess != n);
	        System.out.println("恭喜你，猜对啦！");

	}

}
