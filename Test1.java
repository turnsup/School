package Exp1;
import java.util.Scanner;

public class Test1 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
        int num;//待输入整数
        int len = 0;//输入数据的位数
        int tmp;
        int reverse = 0;//输入整数的逆序数
        do{
            System.out.println("请输入一个正整数（1~99999）：");
            num = s.nextInt();
        }while(num < 1 || num > 99999);
        tmp = num;
        while(tmp > 0){
            tmp /= 10;
            len++;
        }
        System.out.println("数字的位数是："+len);
        tmp = num;
        while(tmp > 0){
            reverse = reverse * 10 + (tmp % 10);
            tmp /= 10;
        }
        if(reverse == num)
            System.out.println(num + "是回文数");
        else
            System.out.println(num + "不是回文数");

	}
}
