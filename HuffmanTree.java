package huffman;

import graphs.Tree;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import static java.lang.Character.isLetter;

/**
 *
 * @author arthu
 */
public class HuffmanTree extends Tree {

    private char character;
    private int weight;
    private String remainingText;

    private String fontName = "Monospaced";
    private int fontStyle = Font.PLAIN;
    private int fontSize;

    private boolean isRoot; // No character is associated with the root.

    public HuffmanTree() {
        this('?');
        isRoot = true;
    }

    public HuffmanTree(char newChar) {
        super(0);
        MAX_NODES = 0; // No limit to the number of branches.
        character = newChar;
        remainingText = "";
        weight = 1;
        if (isLetter(newChar)) {
            isRoot = false;
        } else {
            isRoot = true;
        }
    }

    public void addChild(HuffmanTree child) {
        branches.add(child);
    }

    public void setText(String newText) {
        remainingText = newText;
        while (remainingText.length() > 0) {
            char firstChar = remainingText.charAt(0);
            remainingText = remainingText.substring(1);
            HuffmanTree newNode = new HuffmanTree(firstChar);
            branches.add(newNode);
        }
    }

    @Override
    public void paint(Graphics g, int x0, int y0, double zoom) {

        fontSize = (int) (20 * zoom);
        int boxVerticalOffset = 3; // Each box is shifted down from the text baseline.

        // Text
        g.setColor(Color.black);
        g.setFont(new Font(fontName, fontStyle, fontSize));
        int textHeight = g.getFontMetrics().getAscent();
        int textWidth = g.getFontMetrics().stringWidth(character + "");
        g.drawString(character + "", (int) (x0 + x * zoom), (int) (y0 + y * zoom + textHeight));
        g.drawRect((int) (x0 + x * zoom), (int) (y0 + y * zoom + boxVerticalOffset), textWidth, textHeight);

        g.drawString(weight + "", (int) (x0 + x * zoom), (int) (y0 + y * zoom + textHeight + textHeight));
        g.drawRect((int) (x0 + x * zoom), (int) (y0 + y * zoom + textHeight + boxVerticalOffset), textWidth, textHeight);

        for (Tree child : branches) {
            // Paint the branch
            HuffmanTree hufChild = (HuffmanTree) child;
            hufChild.paint(g, x0, y0, zoom);
            // Link the branch to the current node
            g.setColor(Color.black);
            g.drawLine(// Bottom of parent
                    (int) (x0 + x * zoom + textWidth / 2),
                    (int) (y0 + y * zoom + 2 * textHeight + boxVerticalOffset),
                    // Top of child
                    (int) (x0 + hufChild.x * zoom + textWidth / 2),
                    (int) (y0 + hufChild.y * zoom + boxVerticalOffset));
        }

        paintOrigin(g, x0, y0);
    }

    private void paintOrigin(Graphics g, int x0, int y0) {
        g.setColor(Color.blue);
        g.drawLine(x0, y0, x0 + 20, y0);
        g.drawLine(x0, y0, x0, y0 + 20);
    }

    /**
     * Get the apparent height of the node.
     * This takes into account the two lines of text (character and weight).
     *
     * @param g
     * @return
     */
    @Override
    protected int getNodeHeight(Graphics g) {
        return 2 * g.getFontMetrics().getHeight();
    }

    @Override
    public void moveUpOrDown(double dy) {
        super.moveUpOrDown(dy);
    }
}
