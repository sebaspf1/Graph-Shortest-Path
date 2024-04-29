import javax.swing.*;

public class Project2 {
	/**
	 * Main method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		new Project2();
	}
	
	/**
	 * Prints solutions to two examples graphs
	 */
	public Project2() {
		Graph graph1 = new Graph("C:\\Users\\Sebastian\\Documents\\COP4534\\Project 2\\src\\graph1.txt");
		FrameDisplay frame1 = new FrameDisplay(graph1, 1);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setVisible(true);
		
		Graph graph2 = new Graph("C:\\Users\\Sebastian\\Documents\\COP4534\\Project 2\\src\\graph2.txt");
		FrameDisplay frame2 = new FrameDisplay(graph2, 2);
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setVisible(true);
	}
}
