import java.util.*;
import java.security.SecureRandom;


class aa1{
	static int v;
	static int h;
	static int[] A;
	
	/**
	 * 1つのあみだくじを表すコンストラクタ
	 * {@code 0}から{@code v-2}の間で，横棒がランダムに{@code h}回生成される
	 * @param v {@code int}型．縦棒の本数
	 * @param h {@code int}型．横棒の本数
	 */
	public aa1(int _v, int _h){
		v = _v;
		h = _h;
		A = new int[h];
		SecureRandom S = new SecureRandom();
		for(int i=0; i<h; i++){
			A[i] = S.nextInt(v-1);
		}
	}
	/**
	 * 縦棒の本数{@code v}のゲッター
	 */
	public static int getV(){ return v; }
	/**
	 * 横棒の本数{@code h}のゲッター
	 */
	public static int getH(){ return h; }
	/**
	 * 横棒の配置場所を表す{@code int}型配列{@code A}のゲッター
	 */
	public static int[] getA(){ return A; }
	
	/**
	 * (n,n)の正方行列同士の積a*bの演算用のメソッド
	 * @param a {@code int[][]}型．左から掛ける行列
	 * @param b {@code int[][]}型．右から掛ける行列
	 * @param n {@code int}型．行列の次元
	 * @return {@code int[][]}型を返す
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
	/**
	 * 行列{@code M}の隣り合う行を交換するメソッド．
	 * {@code a}番目の行と{@code a+1}番目の行を交換する．
	 * @param M {@code int[][]}型．正方行列を表す二次元配列
	 * @param a {@code int}型．交換する行が0から数えて何番目かを表す
	 */
	private static void swaprow(int[][] M, int a){
		int B[] = M[a];
		M[a] = M[a+1];
		M[a+1] = B;
	}
	
	/**
	 * あみだくじの行列表示を返すメソッド．
	 * @return {@code int[][]}型を返す．{@code v}文字の置換を表す正方行列を表す
	 */
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
	
	/**
	 * あみだくじが最短で何度の互換で恒等写像に出来るか（あみだくじのlength）
	 * を{@code int}型で返すメソッド
	 * @return {@code int}型であみだくじのlengthを返す．
	 */
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
	
	
	/**
	 * あみだくじの行列表示のトレースを返すメソッド．
	 * @return {@code int}型．あみだくじの行列表示のトレース
	 */
	public static int calctrace(){
		int i;
		int count = 0;
		int[][] M = getMat();
		
		for(i=0; i<v; i++){
			count += M[i][i];
		}
		return count;
	}
	
	
	/**
	 * あみだくじの行列表示からあみだくじのlengthが数えやすい行列を作るメソッド
	 * 各行の{@code 1}の要素の右側の要素と下側の要素がすべて{@code 0}，
	 * それ以外の要素は{@code -1}になっている．
	 * @return {@code int[][]}型．正方行列
	 */
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
