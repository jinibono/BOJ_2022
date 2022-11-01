package GRAPH;

import java.util.*;
import java.io.*;

public class boj_1916_최소비용구하기 {
	static int N;
	static int M;
	static ArrayList<Edge> adj[];
	static int start, end;
	static int dist[];

	static class Edge {
		int index, weight;

		public Edge(int index, int weight) {
			super();
			this.index = index;
			this.weight = weight;
		}

		public Edge() {
			super();
			// TODO Auto-generated constructor stub
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		adj = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			adj[i] = new ArrayList<>();
		}
		int u, v, w;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			u = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			adj[u].add(new Edge(v, w));
		}
		
		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		djik(start);
//		System.out.println(Arrays.toString(dist));
		System.out.println(dist[end]);
	}

	private static void djik(int s) {
		dist = new int[N + 1];
		for (int i = 1; i <= N; i++)
			dist[i] = (int) 1e9;
		PriorityQueue<Edge> pq = new PriorityQueue<>(new Comparator<Edge>() {

			@Override
			public int compare(Edge o1, Edge o2) {
				// TODO Auto-generated method stub
				return o1.weight-o2.weight;
			}
		});
		dist[s] = 0;
		pq.add(new Edge(s, dist[s]));
		while (!pq.isEmpty()) {
			Edge p = pq.poll();
			if(dist[p.index]<p.weight)continue;
			for (Edge y : adj[p.index]) {
				if (dist[y.index] > dist[p.index] + y.weight) {
					dist[y.index] = dist[p.index] + y.weight;
					pq.add(new Edge(y.index, dist[y.index]));
				}
			}
		}
	}

}
