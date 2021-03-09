package huffman;

import graphs.GraphPanel;
import graphs.PanelKeyListener;
import java.awt.Dimension;
import javax.swing.JFrame;

/**
 *
 * @author arthu
 */
public class Huffman {

    public static void main(String[] args) {

        JFrame window = new JFrame();

        HuffmanTree root = new HuffmanTree('?');

        GraphPanel panel = new GraphPanel(root);
        window.addKeyListener(new PanelKeyListener(root, panel));
        window.setContentPane(panel);
        window.setVisible(true);

        int windowWidth = 800;
        int windowHeight = 600;
        window.setPreferredSize(new Dimension(windowWidth, windowHeight));
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.pack();

        panel.repaint();
    }
}
