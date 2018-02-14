package interview;

public class Sqrt_float {
	public static float sqrt(int input, float tolerance) {
		float ini = input;
		float obj = input;
		while(ini * ini - obj > tolerance) {
			ini = (ini + input/ini)/2;
		}
		return ini;
	}
	public static void main(String[] args) {
		int input = 2;
		float tole = 0.001f;
		System.out.println(sqrt(input,tole));
		System.out.println(sqrt(input,tole) * sqrt(input,tole));
	}
}
