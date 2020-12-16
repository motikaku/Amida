import java.util.*;
import java.security.SecureRandom;


class aa1{
	static int v;
	static int h;
	static int[] A;
	
	/**
	 * 1�̂��݂�������\���R���X�g���N�^
	 * {@code 0}����{@code v-2}�̊ԂŁC���_�������_����{@code h}�񐶐������
	 * @param v {@code int}�^�D�c�_�̖{��
	 * @param h {@code int}�^�D���_�̖{��
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
	 * �c�_�̖{��{@code v}�̃Q�b�^�[
	 */
	public static int getV(){ return v; }
	/**
	 * ���_�̖{��{@code h}�̃Q�b�^�[
	 */
	public static int getH(){ return h; }
	/**
	 * ���_�̔z�u�ꏊ��\��{@code int}�^�z��{@code A}�̃Q�b�^�[
	 */
	public static int[] getA(){ return A; }
	
	/**
	 * (n,n)�̐����s�񓯎m�̐�a*b�̉��Z�p�̃��\�b�h
	 * @param a {@code int[][]}�^�D������|����s��
	 * @param b {@code int[][]}�^�D�E����|����s��
	 * @param n {@code int}�^�D�s��̎���
	 * @return {@code int[][]}�^��Ԃ�
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
	 * �s��{@code M}�ׂ̗荇���s���������郁�\�b�h�D
	 * {@code a}�Ԗڂ̍s��{@code a+1}�Ԗڂ̍s����������D
	 * @param M {@code int[][]}�^�D�����s���\���񎟌��z��
	 * @param a {@code int}�^�D��������s��0���琔���ĉ��Ԗڂ���\��
	 */
	private static void swaprow(int[][] M, int a){
		int B[] = M[a];
		M[a] = M[a+1];
		M[a+1] = B;
	}
	
	/**
	 * ���݂������̍s��\����Ԃ����\�b�h�D
	 * @return {@code int[][]}�^��Ԃ��D{@code v}�����̒u����\�������s���\��
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
	 * ���݂��������ŒZ�ŉ��x�̌݊��ōP���ʑ��ɏo���邩�i���݂�������length�j
	 * ��{@code int}�^�ŕԂ����\�b�h
	 * @return {@code int}�^�ł��݂�������length��Ԃ��D
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
	 * ���݂������̍s��\���̃g���[�X��Ԃ����\�b�h�D
	 * @return {@code int}�^�D���݂������̍s��\���̃g���[�X
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
	 * ���݂������̍s��\�����炠�݂�������length�������₷���s�����郁�\�b�h
	 * �e�s��{@code 1}�̗v�f�̉E���̗v�f�Ɖ����̗v�f�����ׂ�{@code 0}�C
	 * ����ȊO�̗v�f��{@code -1}�ɂȂ��Ă���D
	 * @return {@code int[][]}�^�D�����s��
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
