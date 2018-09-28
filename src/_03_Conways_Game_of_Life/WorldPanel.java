package _03_Conways_Game_of_Life;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.Timer;

public class WorldPanel extends JPanel implements MouseListener, ActionListener {
	private static final long serialVersionUID = 1L;
	private int cellsPerRow;
	private int cellSize;

	private Timer timer;

	// 1. Create a 2D array of Cells. Do not initialize it.
	Cell[][] cellArr;

	public WorldPanel(int w, int h, int cpr) {
		setPreferredSize(new Dimension(w, h));
		addMouseListener(this);
		timer = new Timer(500, this);
		this.cellsPerRow = cpr;

		// 2. Calculate the cell size.
		cellSize = w / cellsPerRow;
		// 3. Initialize the cell array to the appropriate size.
		cellArr = new Cell[cellsPerRow][cellsPerRow];
		// 3. Iterate through the array and initialize each cell.
		// Don't forget to consider the cell's dimensions when
		// passing in the location.
		for (int i = 0; i < cellArr.length; i++) {
			for (int j = 0; j < cellArr.length; j++) {

				cellArr[i][j] = new Cell(i, j, cellSize);

			}

		}

	}

	public void randomizeCells() {
		// 4. Iterate through each cell and randomly set each
		// cell's isAlive memeber to true or false
		for (int i = 0; i < cellArr.length; i++) {
			for (int j = 0; j < cellArr.length; j++) {
				boolean bool = new Random().nextBoolean();

				cellArr[i][j].isAlive = bool;
				System.out.println(bool);
			}
		}
		repaint();
	}

	public void clearCells() {
		// 5. Iterated through the cells and set them all to dead.
		for (int i = 0; i < cellArr.length; i++) {
			for (int j = 0; j < cellArr.length; j++) {
				cellArr[i][j].isAlive = false;
			}
		}
		repaint();
	}

	public void startAnimation() {
		timer.start();
	}

	public void stopAnimation() {
		timer.stop();
	}

	public void setAnimationDelay(int sp) {
		timer.setDelay(sp);
	}

	@Override
	public void paintComponent(Graphics g) {
		// 6. Iterate through the cells and draw them all
		for (int i = 0; i < cellArr.length; i++) {
			for (int j = 0; j < cellArr.length; j++) {
				cellArr[i][j].draw(g);
			}
		}
		// draws grid
		g.setColor(Color.BLACK);
		g.drawRect(0, 0, getWidth() - 1, getHeight() - 1);
	}

	// advances world one step
	public void step() {
		// 7. iterate through cells and get their neighbors
		// int livingNeighbors = getLivingNeighbors(x, y);
		for (int i = 0; i < cellArr.length; i++) {
			for (int j = 0; j < cellArr.length; j++) {
				int livingNeighbors = getLivingNeighbors(cellArr[i][j].getX(), cellArr[i][j].getY());
				cellArr[i][j].liveOrDie(livingNeighbors);
			}
		}
		// 8. check if each cell should live or die

		repaint();
	}

	// 9. Complete the method.
	// It returns an array list of the 8 or less neighbors of the
	// cell identified by x and y
	public int getLivingNeighbors(int x, int y) {
		int returnable = 0;
		int xScan = x - 1;
		int yScan = y - 1;

		Cell[][] temp_ra = new Cell[cellArr.length][cellArr.length];
		for (int i = 0; i <= 2; i++) {

			for (int j = 0; j <= 2; j++) {

				if (!((xScan == x) && (yScan == y)) && !(yScan + j <= 0) && !(xScan + i <= 0)
						&& !(yScan + j >= ConwaysGameOfLife.HEIGHT) && !(xScan + i >= ConwaysGameOfLife.WIDTH)) {
					// temp_ra[xScan + i][yScan + j] = new Cell(xScan + i, yScan + j, cellSize);
					if (!(xScan + i == 50) && !(yScan + j == 50)) {
						returnable += cellArr[xScan + i][yScan + j].isAlive ? 1 : 0;
						System.out.println("return temp = " + returnable);
					}

				}
			}

		}
		System.out.println("return final = " + returnable);
		return returnable;
		// do this next
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// 10. Use e.getX() and e.getY() to determine
		// which cell is clicked. Then toggle
		// the isAlive variable for that cell.
		cellArr[e.getX() / cellSize][e.getY()
				/ cellSize].isAlive = !cellArr[e.getX() / cellSize][e.getY() / cellSize].isAlive;
		repaint();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		step();
	}
}
