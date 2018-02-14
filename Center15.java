package intern;

public class Center15 {
	public int findC(int[][] ma) {
		int count = 0;
		if(ma == null || ma.length <3 || ma[0].length<3)
			return count;
		for(int i = 0; i< ma.length - 2; i++) {
			for(int j = 0; j<ma[0].length-2; j++) {
				int a = ma[i][j];
				int b = ma[i+1][j];
				int c = ma[i][j+1]; 
				if(ma[i+1][j+1] != 5 || 2*a+b+c != 20 || a + 5+ma[i+2][j+2] != 15 || b + 5+ma[i+1][j+2] != 15 || c + 5 +ma[i+2][j+1] != 15 || a + b + ma[i+2][j] != 15 || a + c + ma[i][j+2] != 15 )
					continue;
				count ++;
			}
		}
		return count;
	}
}
