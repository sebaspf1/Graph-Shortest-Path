import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class Graph {
	int numberVertices;
	private int[][] graph;
	int start, end;
	
	/**
	 * Initializes graph from text file
	 * 
	 * @param fileName name of file
	 */
	public Graph(String fileName) {
		File input = new File(fileName);
		
		Scanner scanner = null;
		try {
			scanner = new Scanner(input);
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		}
		
		numberVertices = scanner.nextInt();
		graph = new int[numberVertices][numberVertices];
		for(int i = 0; i < numberVertices; i++) {
			for(int j = 0; j < numberVertices; j++) {
				graph[i][j] = scanner.nextInt();
			}
		}
		
		start = scanner.nextInt();
		end = scanner.nextInt();
	}
	
	/**
	 * Returns weight of edge between vertices v and w
	 * 
	 * @param v vertex 1
	 * @param w vertex 2
	 * @return Weight of edge between v and w
	 */
	public int getEdge(int v, int w) {
		return graph[v][w];
	}
	
	/**
	 * Finds closest vertex that has not been visited yet
	 * @param distance Minimum distance from starting point
	 * @param visited Visited array
	 * @return
	 */
	public int findMin(int[] distance, boolean[] visited) {
		int index = -1, min = Integer.MAX_VALUE;
		for(int i = 0; i < numberVertices; i++) {
			if(!visited[i] && distance[i] < min) {
				index = i;
				min = distance[i];
			}
		}
		return index;
	}
	
	/**
	 * Finds shortest path from starting vertex to end
	 * @return Array of previous vertex
	 */
	public int[] shortestPath() {
		boolean[] visited = new boolean[numberVertices];
		int[] distance = new int[numberVertices];
		int[] prev = new int[numberVertices];
		for(int i = 0; i < numberVertices; i++) {
			visited[i] = false;
			distance[i] = Integer.MAX_VALUE;
			prev[i] = -1;
		}
		
		distance[start] = 0;
		for(int i = 0; i < numberVertices - 1; i++) {
			int v = findMin(distance, visited);
			visited[v] = true;
			
			for(int j = 0; j < numberVertices; j++) {
				if(graph[v][j] > 0 && !visited[j] && distance[v] + graph[v][j] < distance[j]) {
					prev[j] = v;
					distance[j] = distance[v] + graph[v][j];
				}
			}
		}
		
		ArrayList<Integer> a = new ArrayList<Integer>();
		int v = end;
		while(v != -1) {
			a.add(v);
			v = prev[v];
		}
		
		int[] path = new int[a.size()];
		for(int i = a.size() - 1; i >= 0; i--)
			path[a.size() - 1 - i] = a.get(i);
		
		return path;
	}
	
	/**
	 * Returns total cost of path
	 * @param path Path in graph
	 * @return Cost of path
	 */
	public int costOfPath(int[] path) {
		int sum = 0;
		for(int i = 1; i < path.length; i++) {
			sum += graph[path[i - 1]][path[i]];
		}
		return sum;
	}
}
