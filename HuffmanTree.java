package huffman;

import graphs.Tree;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import static java.lang.Character.isLetter;
import java.util.ArrayList;

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
    private boolean isCharacter;

    public HuffmanTree() {
        this('?');
        isRoot = false;
        isCharacter = false;
        weight = 0;
    }

    public HuffmanTree(char newChar) {
        super(0);
        MAX_NODES = 0; // No limit to the number of branches.
        character = newChar;
        remainingText = "";
        weight = 1;
        isRoot = false;
        isCharacter = true;
    }

    /**
     * Create a new tree that regroups two smaller trees.
     * Compute the weight of the new tree as the sum of the two children.
     *
     * @param leftChild
     * @param rightChild
     */
    public HuffmanTree(HuffmanTree leftChild, HuffmanTree rightChild) {
        this();
        isCharacter = false;
        branches.add(leftChild);
        branches.add(rightChild);
    }

    public void addChild(HuffmanTree child) {
        branches.add(child);
        weight += child.weight;
    }

    public void setText(String newText) {
        remainingText = newText;
        while (remainingText.length() > 0) {
            char firstChar = remainingText.charAt(0);
            remainingText = remainingText.substring(1);
            HuffmanTree existingNode = findCharacterNode(firstChar);
            if (existingNode == null) {
                HuffmanTree newNode = new HuffmanTree(firstChar);
                branches.add(newNode); // replaced with addChild(newNode);
            } else {
                existingNode.weight++;
            }
            weight++;
        }
        sort();
    }

    @Override
    public void paint(Graphics g, int x0, int y0, double zoom) {

        fontSize = (int) (20 * zoom);
        int boxVerticalOffset = 3; // Each box is shifted down from the text baseline.

        // Text
        g.setColor(Color.black);
        g.setFont(new Font(fontName, fontStyle, fontSize));
        int textHeight = g.getFontMetrics().getAscent();
        int textWidth = getNodeWidth(g);
        if (isRoot) {
            // Root of the tree
            g.drawString("Root", (int) (x0 + x * zoom), (int) (y0 + y * zoom + textHeight));
        } else if (isCharacter) {
            // This node represents a character of the original message.
            g.drawString("" + character, (int) (x0 + x * zoom), (int) (y0 + y * zoom + textHeight));
        } else {
            // Non-character node
            g.drawString(" ", (int) (x0 + x * zoom), (int) (y0 + y * zoom + textHeight));
        }
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

    /**
     * Find the node that represents a given character.
     *
     * @param targetChar the character we are looking for
     * @return the node that represents @targetChar if it exists, null
     * otherwise.
     */
    private HuffmanTree findCharacterNode(char targetChar) {
        if (!this.isRoot && this.character == targetChar) {
            return this;
        }
        if (branches == null || branches.isEmpty()) {
            return null;
        }
        for (Tree branch : branches) {
            HuffmanTree candidate = ((HuffmanTree) branch).findCharacterNode(targetChar);
            if (candidate != null) {
                return candidate;
            }
        }
        return null;
    }

    @Override
    public int getNodeWidth(Graphics g) {
        return Math.max(g.getFontMetrics().stringWidth(character + ""),
                g.getFontMetrics().stringWidth(weight + ""));
    }

    /**
     * Sort the nodes, with the smallest weight in first position.
     *
     */
    private void sort() {
        ArrayList<Tree> sortedNodes = new ArrayList<>();
        for (Tree branch : branches) {
            sortedNodes.add((HuffmanTree) branch);
        }
        sortedNodes.sort((o1, o2) -> {
            return ((HuffmanTree) o1).weight - ((HuffmanTree) o2).weight;
        });
        branches = sortedNodes;
    }

    /**
     * Group the smallest two trees as one.
     * Only if there are at least two trees to group.
     */
    protected void groupSmallestTrees() {

        if (branches.size() > 2) {
            // Step 1: extract the smallest two trees.
            HuffmanTree smallestOne = (HuffmanTree) branches.remove(0);
            HuffmanTree smallestTwo = (HuffmanTree) branches.remove(0);
            // Step 2: group them in a weighted companion tree.
            HuffmanTree merged = new HuffmanTree(smallestOne, smallestTwo);
            merged.weight = smallestOne.weight + smallestTwo.weight;

            // Step 3: add the result back to the list and sort the list.
            branches.add(merged);
            sort();
        } else {
            System.out.println("Nodes already grouped.");
        }
    }

    /**
     * Tell a node that it is the root of a tree (or not).
     */
    public void setRoot(boolean b) {
        isRoot = b;
    }
}
