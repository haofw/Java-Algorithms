package intern;
import java.util.*;
//1 .给一个randBetween(double d1, double d2) 返回一个矩形中任意一个点 输入输出自己定义
//2. 给一堆矩形， 用randBetween输出这堆矩形中一个点   面积？
//follow up: 如果call这个func很多次怎么办
public class Matrix {
	public static double randBetween(double d1, double d2) {
		Random rand = new Random();
		double ret = rand.nextDouble(); //new Random().nextDouble(): randomly generates a number between 0 and 1.
		ret = ret *(d2 - d1) + d1;
		return ret;
	}
	public static double[] rand(double[] ma) {
		// ma: 2 points to create a rectangle (using diagonal) 
		//point ld: (ma[0],ma[1]) point ru: (ma[2], ma[3]) point lu: (ma[0], ma[3]) rd: (ma[2], ma[1]);
		// return a point (ret[0], ret[1])
		double[] ret = new double[2];
		double x = randBetween(ma[0], ma[2]);
		double y = randBetween(ma[1], ma[3]);
		ret[0] = x;
		ret[1] = y;
		return ret;
	}
	public static double[] rand1(double[][] mas) {
//		int num = mas.length;
//		Random rand = new Random();
//		int index = rand.nextInt(num);
//		double[] ret = rand(mas[index]);
		double area = 0;
		double[] ar = new double[mas.length];
		for(int i = 0; i< mas.length; i++) {
			area += (mas[i][2] - mas[i][0]) * (mas[i][3] - mas[i][1]);
			ar[i] = area;
		}
		double choose = randBetween(0, area);
		int index = 0;
		for(int i = 0; i< ar.length-1; i++) {
			if(choose > ar[i] && choose <= ar[i+1]) {
				index = i+1;
				break;
			}
		}
		double[] ret = rand(mas[index]);
		return ret;
	}
	public static void main(String[] args) {
		double[] ma = {0.2,0.5, 1.2, 3.8};
		double[] ret = rand(ma);
		double[][] mas = {{0.2,0.5, 1.2, 3.8},{1.3,0.5,2.0,1.0},{2.2,3.5,3.3,4.0},{4.0,4.0,6.0,7.0}};
		ret = rand1(mas);
		System.out.print(ret[0] + "," + ret[1]);
	}
}
