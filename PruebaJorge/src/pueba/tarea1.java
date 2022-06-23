package pueba;

class Solution {
	public int solution(int[] A) {
		int minimo = 1;
		while(minimo < 100) {
			int i = 0;
			for(i=0; i<A.length; i++) {
				if(A[i] == minimo) break;
			}
			if(i==A.length) return minimo; else minimo++;
		}
		return minimo;
	}
}

public class tarea1 {

	
	
	public static void main(String[] args) {
		
		Solution s = new Solution();
		System.out.println(s.solution(new int[] {1,3,6,4,1,2}));
		System.out.println(s.solution(new int[] {1,2,3}));
		System.out.println(s.solution(new int[] {-1,-3}));
		
	}
	
}
