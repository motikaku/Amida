import java.util.*;
import java.security.SecureRandom;

public class AmidaTest2{
	public static void main(String args[]){
		int tate = 5;
		int length = 5*(5-1)/2;
		SecureRandom ran = new SecureRandom(); 
		int yoko = 1 + ran.nextInt(length);
		int d[] = new int[length+1];
		for(int i=0; i<length+1; i++){
			d[i]=0;
		}
		
		
		for(int i=0; i<6; i++){
			aa1 A = new aa1(tate, yoko);
			int[][] Amida = A.getMat();
			for(int j=0; j<tate; j++){
				for(int k=0; k<tate; k++){
					System.out.print(Amida[j][k]);
				}
				System.out.println();
			}
			System.out.println();
			int x = A.bod();
			for(int j=0; j<length+1; j++){
				if(j == x) d[j]++;
			}
		}
		for(int i=0; i<5*(5-1)/2+1; i++){
			System.out.println("d["+i+"] = " + d[i]);
		}
		
	}
}
