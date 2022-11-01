package DP;

import java.util.*;
import java.io.*;
public class boj_1915_가장큰정사각형 {

		public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int N, M;
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			String word;
			int[][] arr = new int[N + 2][M + 2];
			int[][] DP = new int[N + 2][M + 2];
			for (int i = 1; i <= N; i++) {
				word = br.readLine();
				for (int j = 1; j <= M; j++) {
					arr[i][j] = Integer.parseInt(word.charAt(j - 1) + "");
					DP[i][j] = arr[i][j];
				}
			}
			int max = 0;
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= M; j++) {
					if(arr[i][j]==0) continue;
					if (arr[i - 1][j - 1] == 1 && arr[i - 1][j] == 1 && arr[i][j - 1] == 1) {
						DP[i][j] = Math.min(DP[i-1][j], DP[i-1][j-1]);
	                    DP[i][j] = Math.min(DP[i][j],  DP[i][j-1]) + 1;
	                    


					}
					max = Math.max(max, DP[i][j]);
				}

			}
			
			System.out.println(max*max);
			
			
			
			

	}

}
