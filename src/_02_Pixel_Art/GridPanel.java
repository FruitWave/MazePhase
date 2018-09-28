package _02_Pixel_Art;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class GridPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	int windowWidth;
	int windowHeight;
	int pixelWidth;
	int pixelHeight;
	int rows;
	int cols;

	// 1. Create a 2D array of pixels. Do not initialize it yet. done
	Pixel[][] pixarray;

	private Color color;

	public GridPanel(int w, int h, int r, int c) {
		this.windowWidth = w;
		this.windowHeight = h;
		this.rows = r;
		this.cols = c;

		this.pixelWidth = windowWidth / cols;
		this.pixelHeight = windowHeight / rows;

		color = Color.BLACK;

		setPreferredSize(new Dimension(windowWidth, windowHeight));

		// 2. Initialize the pixel array using the rows and cols variables.
		pixarray = new Pixel[rows][cols];
		// 3. Iterate through the array and initialize each element to a new pixel.

		for (int i = 0; i < pixarray.length; i++) {
			for (int j = 0; j < pixarray[i].length; j++) {
				Pixel pixa = new Pixel(i * (w / r), j * (h / c));
				pixarray[i][j] = pixa;
			}
		}

	}

	public void setColor(Color c) {
		color = c;
	}

	public void clickPixel(int mouseX, int mouseY) {
		// 5. Use the mouseX and mouseY variables to change the color
		// of the pixel that was clicked. *HINT* Use the pixel's dimensions.
		int i = (int) mouseX / pixelWidth;
		int j = (int) mouseY / pixelHeight;
		Pixel temporar = pixarray[i][j];
		setColor(color);
		temporar.color = color;

	}

	@Override
	public void paintComponent(Graphics g) {
		// 4. Iterate through the array.
		// For every pixel in the list, fill in a rectangle using the pixel's color.
		// Then, use drawRect to add a grid pattern to your display.
		for (int i = 0; i < pixarray.length; i++) {
			for (int j = 0; j < pixarray[i].length; j++) {
				Pixel temporar = pixarray[i][j];
				g.setColor(temporar.color);
				g.fillRect(temporar.x, temporar.y, temporar.x + (windowWidth / rows),
						temporar.y + (windowHeight / cols));
			}
		}
	}
}
