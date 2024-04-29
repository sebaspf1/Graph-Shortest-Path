import javax.swing.*;
import java.awt.*;

public class GraphDisplay extends JPanel
{
	int graphNumber;
	Graph graph;
	int panelWidth, panelHeight;
	int vertexWidth = 50;
	int vertexHeight = 50;
	int labelX = 19;
	int labelY = 33;
	
	/**
	 * Initializes graph and object variables
	 * @param g Graph instance
	 * @param w Panel width
	 * @param h Panel height
	 * @param n Number of graph
	 */
	public GraphDisplay(Graph g, int w, int h, int n) {
		graph = g;
		panelWidth = w;
		panelHeight = h;
		graphNumber = n;
	}
	
    /**
     * Paints the graph example.
     * 
     * @param g graphics context
     */
    public void paint(Graphics g) {
    	if(graphNumber == 1)
    		graph1(g);
    	else
    		graph2(g);
    }
    
    /**
     * Paints graph example 1
     * @param g graphics context
     */
    private void graph1(Graphics g) {
    	int[] x = {600, 950, 1050, 1200, 750, 1150, 670};
    	int[] y = {150, 50, 310, 180, 350, 520, 600};
    	
    	for(int i = 0; i < graph.numberVertices; i++) {
    		for(int j = 0; j < graph.numberVertices; j++) {
    			if(graph.getEdge(i, j) > 0) {
    				g.setColor(Color.BLACK);
    		        g.drawLine(x[i], y[i], x[j], y[j]);
    			}
    		}
    	}
    	
    	int[] path = graph.shortestPath();
    	for(int i = 1; i < path.length; i++) {
    		g.setColor(Color.RED);
	        g.drawLine(x[path[i]], y[path[i]], x[path[i - 1]], y[path[i - 1]]);
    	}
    	
    	for(int i = 0; i < graph.numberVertices; i++)
    		drawVertex(g, i, x[i], y[i]);

        g.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 18));
        g.drawString(String.valueOf(graph.getEdge(0, 1)), x[0] + 40, y[0] - 20);
        g.drawString(String.valueOf(graph.getEdge(0, 2)), x[0] + 70, y[0] + 20);
        g.drawString(String.valueOf(graph.getEdge(0, 4)), x[0] + 70, y[0] + 80);
        g.drawString(String.valueOf(graph.getEdge(0, 6)), x[0] + 40, y[0] + 180);
        g.drawString(String.valueOf(graph.getEdge(1, 3)), x[1] + 100, y[1] + 40);
        g.drawString(String.valueOf(graph.getEdge(2, 3)), x[2] + 70, y[2] - 40);
        g.drawString(String.valueOf(graph.getEdge(2, 4)), x[2] - 180, y[2] + 15);
        g.drawString(String.valueOf(graph.getEdge(2, 5)), x[2] + 45, y[2] + 80);
        g.drawString(String.valueOf(graph.getEdge(2, 4)), x[2] - 250, y[2] + 175);
        g.drawString(String.valueOf(graph.getEdge(4, 5)), x[4] + 30, y[4] + 35);
        g.drawString(String.valueOf(graph.getEdge(5, 6)), x[5] - 250, y[5] + 35);
        
        String pathString = "";
        for(int i = 0; i < path.length - 1; i++) {
        	pathString += path[i] + ", ";
        }
        pathString += path[path.length - 1];
        g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 24));
        g.drawString("Shortest path from " + graph.start + " to " + graph.end + ": " + pathString, 10, 30);
        g.drawString("Cost of path: " + graph.costOfPath(path), 10, 60);
    }
    
    /**
     * Paints graph example 2
     * @param g graphics context
     */ 
    private void graph2(Graphics g) {
    	int[] x = {700, 900, 650, 950, 1250, 1350, 1250};
    	int[] y = {220, 200, 450, 600, 550, 350, 100};
    	
    	for(int i = 0; i < graph.numberVertices; i++) {
    		for(int j = 0; j < graph.numberVertices; j++) {
    			if(graph.getEdge(i, j) > 0) {
    				g.setColor(Color.BLACK);
    		        g.drawLine(x[i], y[i], x[j], y[j]);
    			}
    		}
    	}
    	
    	int[] path = graph.shortestPath();
    	for(int i = 1; i < path.length; i++) {
    		g.setColor(Color.RED);
	        g.drawLine(x[path[i]], y[path[i]], x[path[i - 1]], y[path[i - 1]]);
    	}
    	
    	for(int i = 0; i < graph.numberVertices; i++)
    		drawVertex(g, i, x[i], y[i]);
    	
    	g.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 18));
    	g.drawString(String.valueOf(graph.getEdge(0, 1)), x[0] + 90, y[0] - 15);
    	g.drawString(String.valueOf(graph.getEdge(0, 2)), x[0] - 50, y[0] + 130);
    	g.drawString(String.valueOf(graph.getEdge(1, 3)), x[1], y[1] + 150);
    	g.drawString(String.valueOf(graph.getEdge(1, 4)), x[1] + 160, y[1] + 150);
    	g.drawString(String.valueOf(graph.getEdge(1, 5)), x[1] + 160, y[1] + 45);
    	g.drawString(String.valueOf(graph.getEdge(1, 6)), x[1] + 160, y[1] - 60);
    	g.drawString(String.valueOf(graph.getEdge(2, 3)), x[2] + 140, y[2] + 60);
    	g.drawString(String.valueOf(graph.getEdge(3, 4)), x[3] + 150, y[3] - 5);
    	g.drawString(String.valueOf(graph.getEdge(4, 5)), x[4] + 60, y[4] - 80);
    	g.drawString(String.valueOf(graph.getEdge(5, 6)), x[5] - 30, y[5] - 120);
    	
    	String pathString = "";
        for(int i = 0; i < path.length - 1; i++) {
        	pathString += path[i] + ", ";
        }
        pathString += path[path.length - 1];
        g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 24));
        g.drawString("Shortest path from " + graph.start + " to " + graph.end + ": " + pathString, 10, 30);
        g.drawString("Cost of path: " + graph.costOfPath(path), 10, 60);
    }
    
    /**
     * Draws vertex
     * @param g graphics context
     * @param key vertex key
     * @param centerX x coordinate of vertex center
     * @param centerY y coordinate of vertex center
     */
    private void drawVertex(Graphics g, int key, int centerX, int centerY) {
    	int leftX = centerX - vertexWidth / 2;
    	int topY = centerY - vertexHeight / 2;
    	
    	g.setColor(Color.ORANGE);
        g.fillOval(leftX, topY, vertexWidth, vertexHeight);
        g.setColor(Color.BLACK);
        g.drawOval(leftX, topY, vertexWidth, vertexHeight);
        g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 24));
        g.drawString(String.valueOf(key), leftX + labelX, topY + labelY);
    }
}
