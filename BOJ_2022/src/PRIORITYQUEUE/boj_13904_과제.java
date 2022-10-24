package PRIORITYQUEUE;

import java.io.*;
import java.util.*;




public class boj_13904_과제 {

	public static class Edge{
		int day,score;
		public Edge(int day,int score) {
			super();
			this.day = day;
			this.score = score;
		}
		public Edge() {
			super();
		}
		
	}

	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int day,score;
		PriorityQueue<Edge> pq = new PriorityQueue<Edge>(new Comparator<Edge>() {

			@Override
			public int compare(Edge o1, Edge o2) {
				if(o1.day==o2.day)
					return o2.score-o1.score;
				return o1.day-o2.day;
			}
		});
		PriorityQueue<Integer> aq = new PriorityQueue<Integer>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o1-o2;
			}
		});
		for(int i=0;i<N;i++)
		{
			st = new StringTokenizer(br.readLine());
			day = Integer.parseInt(st.nextToken());
			score = Integer.parseInt(st.nextToken());
			pq.add(new Edge(day,score));
		}
		int answer = 0;
		
		while(!pq.isEmpty())
		{
			Edge poll = pq.poll();
			
			if(aq.size()<poll.day)
			{
				aq.add(poll.score);
				
			}
			else if(aq.peek()<poll.score)
			{
				aq.poll();
				aq.add(poll.score);
				
			}
			
		}
	
		while(!aq.isEmpty())
		{
			answer+=aq.poll();
		}
		
		System.out.println(answer);
		
		

	}

}
