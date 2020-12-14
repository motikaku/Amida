import java.util.*;
import java.security.SecureRandom;

public class AmidaTest2{
	public static void main(String args[]){
		int tate = 5;
		int maxSwaps = 5*(5-1)/2;
		int maxYoko = maxSwaps;
		SecureRandom ran = new SecureRandom(); 
		int d[] = new int[maxSwaps+1];
		for(int i=0; i<maxSwaps+1; i++){
			d[i]=0;
		}
		
		
		for(int i=0; i<6; i++){
			int yoko = ran.nextInt(maxYoko);
			aa1 Amida = new aa1(tate, yoko);
			int[][] M = Amida.bodMat();
			for(int j=0; j<tate; j++){
				for(int k=0; k<tate; k++){
					if (M[j][k] == -1)
						System.out.print('*');
					else
						System.out.print(M[j][k]);
				}
				System.out.println();
			}
			System.out.println();
			int x = Amida.bod();
			for(int j=0; j<maxSwaps+1; j++){
				if(j == x) d[j]++;
			}
		}
		for(int i=0; i<maxSwaps+1; i++){
			System.out.println("d["+i+"] = " + d[i]);
		}
		
	}
}
