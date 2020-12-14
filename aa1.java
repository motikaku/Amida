import java.util.*;
import java.security.SecureRandom;


class aa1{
	static int v;
	static int h;
	static int[] A;
	
	
	public aa1(int _v, int _h){
		v = _v;
		h = _h;
		A = new int[h];
		SecureRandom S = new SecureRandom();
		for(int i=0; i<h; i++){
			A[i] = S.nextInt(v-1);
		}
	}
	
	public static int getV(){ return v; }
	public static int getH(){ return h; }
	public static int[] getA(){ return A; }
	
	/**
	 * (n,n)の正方行列式a*bの演算用のメソッド
	 * @param a 左から掛ける行列
	 * @param b 右から掛ける行列
	 * @param n 行列の次元
	 */
	public static int[][] multiplyMat(int[][] a,int[][] b, int n){
		int calc[][] = new int[n][n];
		for(int x=0; x<n; x++){
			for(int y=0; y<n; y++){
				for(int s=0; s<n; s++){
					calc[x][y] += a[x][s] * b[s][y];
				}
			}
		}
		return calc;
	}
	
	private static void swaprow(int[][] M, int a){
		int B[] = M[a];
		M[a] = M[a+1];
		M[a+1] = B;
	}
	
	public static int[][] getMat(){
		int[][] mat = new int[v][v];
		for(int i=0; i<v; i++){
			for(int j=0; j<v; j++){
				mat[i][j] = i==j ? 1:0;
			}
		}
		for(int i=0; i<A.length; i++){
			swaprow(mat, A[i]);
		}
		return mat;
	}
	
	
	public static int bod(){
		int i, j;
		int count = 0;
		boolean bh;
		boolean bv[] = new boolean[v];
		int[][] M = getMat();
		
		for(i=0; i<v; i++){
			bv[i] = false;
		}
		for(i=0; i<v; i++){
			for(j=0, bh=false; j<v; j++){
				if(M[i][j] == 1){
					bh = true;
					bv[j] =true;
				}else if (!bh && !bv[j]){
					count++;
				}
			}
		}
		return count;
	}
	
	
	public static int[][] bodMat(){
		int i, j;
		int count = 0;
		boolean bh;
		boolean bv[] = new boolean[v];
		int[][] M = getMat();
		
		for(i=0; i<v; i++){
			bv[i] = false;
		}
		for(i=0; i<v; i++){
			for(j=0, bh=false; j<v; j++){
				if(M[i][j] == 1){
					bh = true;
					bv[j] =true;
				}else if (!bh && !bv[j]){
					M[i][j] = -1;
					count++;
				}
			}
		}
		return M;
	}
		

}
