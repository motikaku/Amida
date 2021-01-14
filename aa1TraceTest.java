//‰¡–_‚ÌÅ‘å–{”‚ğƒ‰ƒ“ƒ_ƒ€‚Éİ’è‚·‚é
public class aa1TraceTest{
	public static void main(String args[]){
		int tate = 50;
		int maxSwaps = tate*(tate-1)/2;
		int maxYoko = maxSwaps * maxSwaps ;
		//SecureRandom ran = new SecureRandom(); 
		MTRandom ran = new MTRandom();
		//int d[] = new int[maxSwaps+1]; 
		int t[] = new int[tate+1];
		/*for(int i=0; i<maxSwaps+1; i++){
			d[i]=0;
		}*/
		for(int i=0; i<tate+1; i++){
			t[i]=0;
		}
		
		
		for(int i=0; i<100000; i++){
			int yoko = ran.nextInt(maxYoko+1);
			aa1 Amida = new aa1(tate, yoko);
			/*int[][] M = Amida.bodMat();
			for(int j=0; j<tate; j++){
				for(int k=0; k<tate; k++){
					if (M[j][k] == -1)
						System.out.print('*');
					else
						System.out.print(M[j][k]);
				}
				System.out.println();
			}
			System.out.println();*/
			int x = Amida.calctrace();
			System.out.println(x);
			if(i%1000==0) System.err.println(i);
			/*for(int j=0; j<maxSwaps+1; j++){
				if(j == x) d[j]++;
			}*/
			//d[x]++;
			//int y = Amida.calctrace();
			//t[y]++;
		}
		/*for(int i=0; i<maxSwaps+1; i++){
			System.out.println("d["+i+"] = " + d[i]);
		}
		System.out.println();
		for(int i=0; i<tate+1; i++){
			System.out.println("t["+i+"] = " + t[i]);
		}*/
		
	}
}