import javax.swing.*;

/**
 * Defines a frame a panel with the drawings will be added to.
 * 
 * @author Prof. Antonio Hernandez
 */
public class FrameDisplay extends JFrame
{
    int WIDTH = 1500;
    int HEIGHT = 900;

    public FrameDisplay(Graph g, int n)
    {
        setTitle("Graph Display");
        setSize(WIDTH, HEIGHT);

        GraphDisplay panel = new GraphDisplay(g, WIDTH, HEIGHT, n);
        add(panel);
    }
}
