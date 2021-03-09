package huffman;

import graphs.GraphPanel;
import graphs.PanelKeyListener;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author arthu
 */
public class Huffman {

    public static void main(String[] args) {

        JFrame window = new JFrame();

        HuffmanTree root = new HuffmanTree();
        root.setRoot(true);

        GraphPanel panel = new GraphPanel(root);
        window.addKeyListener(new PanelKeyListener(root, panel));
        window.setContentPane(panel);
        window.setVisible(true);

        int windowWidth = 800;
        int windowHeight = 600;
        window.setPreferredSize(new Dimension(windowWidth, windowHeight));
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLayout(new BorderLayout());

        JButton processButton = new JButton("Process");
        processButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                root.groupSmallestTrees();
                panel.repaint();
            }
        });

        window.add(processButton, BorderLayout.SOUTH);
        window.pack();

//        root.setText("couco?uaa");
        root.setText("Coucou les gens, comment ça va, vous allez vraiment bien ?"
                + " Je suis vraiment content de voir que ça commence à marcher.");
//        root.setText("Mais si, c’est possible avec la carte Kiwi : enfant de moins de seize ans et ceux qui l’accompagnent jusqu’à quatre personnes paient tous moitié prix Moitié prix Mais c’est pas possible Mais si  c'est possible avec la carte Kiwi enfant de moins de seize ans et ceux qui l'accompagnent jusqu'à quatre personnes paient tous moitié prix Moitié prix Mais c’est pas possible Mais si c'est possible avec la carte Kiwi enfant de moins de seize ans et ceux qui l'accompagnent jusqu'à quatre personnes paient tous moitié prix Moitié prix Mais c’est pas possible Mais si c'est possible avec la carte Kiwi enfant de moins de seize ans et ceux qui l'accompagnent jusqu'à quatre personnes paient tous moitié prix Moitié prix Mais c’est pas possible Mais si c'est possible avec la carte Kiwi  enfant de moins de seize ans et ceux qui l'accompagnent jusqu'à quatre personnes paient tous moitié prix Moitié prix Mais c’est pas possible Mais si c'est possible avec la carte Kiwi enfant de moins de seize ans et ceux qui l'accompagnent jusqu'à quatre personnes paient tous moitié prix Moitié prix Mais c’est pas possible Mais si c'est possible avec la carte Kiwi enfant de moins de seize ans et ceux qui l'accompagnent jusqu'à quatre personnes paient tous moitié prix Moitié prix Mais c’est pas possible Mais si c'est possible avec la carte Kiwi enfant de moins de seize ans et ceux qui l'accompagnent jusqu'à quatre personnes paient tous moitié prix Moitié prix Mais c’est pas possible Mais si c'est possible avec la carte Kiwi enfant de moins de seize ans et ceux qui l'accompagnent jusqu'à quatre personnes paient tous moitié prix Moitié prix Mais c’est pas possible Mais si c'est possible avec la carte Kiwi enfant de moins de seize ans et ceux qui l'accompagnent jusqu'à quatre personnes paient tous moitié prix Moitié prix Mais c’est pas possible Mais si c'est possible avec la carte Kiwi enfant de moins de seize ans et ceux qui l'accompagnent jusqu'à quatre personnes paient tous moitié prix Moitié prix Mais c’est pas possible Mais si c'est possible avec la carte Kiwi enfant de moins de seize ans et ceux qui l'accompagnent jusqu'à quatre personnes paient tous moitié prix Moitié prix Mais c’est pas possible Vous savez moi je crois pas qu'il y ait de bonne ou de mauvaise situation… De toute façon c'est la seizième ligne ça devient illisible Mais non c'est pas illisible avec la carte Kiwi enfant de moins de seize ans et ceux qui l'accompagnent jusqu'à quatre personnes paient tous moitié prix Moitié prix Mais c’est pas possible Mais si c'est possible avec la carte Kiwi enfant de moins de seize ans et ceux qui l'accompagnent jusqu'à quatre personnes paient tous moitié prix Moitié prix Mais c’est pas possible Mais si c'est possible avec la carte Kiwi enfant de moins de seize ans et ceux qui l'accompagnent jusqu'à quatre personnes paient tous moitié prix Moitié prix Mais c’est pas possible Mais si c'est possible avec la carte Kiwi enfant de moins de seize ans et ceux qui l'accompagnent jusqu'à quatre personnes paient tous moitié prix Moitié prix Mais c’est pas possible Mais si c'est possible avec la carte Kiwi enfant de moins de seize ans et ceux qui l'accompagnent jusqu'à quatre personnes paient tous moitié prix Moitié prix Mais c’est pas possible Mais si c'est possible avec la carte Kiwi enfant de moins de seize ans et ceux qui l'accompagnent jusqu'à quatre personnes paient tous moitié prix Moitié prix Mais c’est pas possible Mais si c'est possible avec la carte Kiwi enfant de moins de seize ans et ceux qui l'accompagnent jusqu'à quatre personnes paient tous moitié prix Moitié prix Mais c’est pas possible Mais si c'est possible avec la carte Kiwi enfant de moins de seize ans et ceux qui l'accompagnent jusqu'à quatre personnes paient tous moitié prix Moitié prix Mais c’est pas possible Mais si c'est possible avec la carte Kiwi enfant de moins de seize ans et ceux qui l'accompagnent jusqu'à quatre personnes paient tous moitié prix Moitié prix Mais c’est pas possib le Mais si c'est possible avec la carte Kiwi enfant de moins de seize ans et ceux qui l'accompagnent jusqu'à quatre personnes paient tous moitié prix Moitié prix Mais c’est pas possible Mais si c'est possib le avec la carte Kiwi enfant de moins de seize ans et ceux qui l'accompagnent jusqu'à quatre personnes paient tous moitié prix Moitié prix Mais c’est pas possible Mais si c'est possible avec la carte Kiwi enfant de moins de seize ans et ceux qui l'accompagnent jusqu'à quatre personnes paient tous moitié prix Moitié prix Mais c’est pas possible Mais si c'est possible avec la carte Kiwi enfant de moins de seize ans et ceux qui l'accompagnent jusqu'à quatre personnes paient tous moitié prix Moitié prix Mais c’est pas possible Mais si c'est possible avec la carte Kiwi enfant de moins de seize ans et ceux qui l'accompagnent jusqu'à quatre personnes paient tous moitié prix Moitié prix Mais c’est pas possible Mais si c'est possible avec la carte Kiwi enfant de moins de seize ans et ceux qui l'accompagnent jusqu'à quatre personnes paient tous moitié prix Moitié prix Mais c’est pas possible Mais si c'est possible avec la carte Kiwi enfant de moins de seize ans et ceux qui l'accompagnent jusqu'à quatre personnes paient tous moitié prix Moitié prix Mais c’est pas possible Mais si c'est possible avec la carte Kiwi enfant de moins de seize ans et ceux qui l'accompagnent jusqu'à quatre personnes paient tous moitié prix Moitié prix Mais c’est pas possible Mais si c'est possible avec la carte Kiwi et cette fois c'est fini");

        panel.repaint();

    }
}
