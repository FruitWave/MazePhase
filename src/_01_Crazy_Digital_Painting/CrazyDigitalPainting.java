package _01_Crazy_Digital_Painting;

import java.awt.Color;

public class CrazyDigitalPainting {
	// 1. Create two final static integers for the width and height of the display.
	final static int theFarthestWidthistanceInTheLand = 1000;
	// num of arrays
	final static int theFarthestHeighsistanceInTheLand = 1000;
	// vertical length of each array, in pixels

	// 2. Create a 2D array of Color objects. You will need to import
	// java.awt.Color. Initialize the size of the array using the
	// integers created in step 1.
	static Color[][] marshmallotomas = new Color[theFarthestWidthistanceInTheLand][theFarthestHeighsistanceInTheLand];

	public CrazyDigitalPainting() {
		// 3. Open the crazy_digital_painting.png file and look at the image.

		// 4. Iterate through the 2D array and initialize each Color object
		// to a new color. The sample image was created using the following
		// pattern:
		// colors[i][j] = new Color(i % 256, (i * j) % 256, j % 256);
		for (int i = 0; i < marshmallotomas.length; i++) {
			for (int j = 0; j < marshmallotomas[i].length; j++) {
				marshmallotomas[i][j] = new Color(Math.abs(((i - 100) % (j - 1000)) % 256),
						(((j ^ 2 * i) + 1) % 2) % 255, ((j + i ^ 2) % (200 + j)) % 255);
			}
		}

		// 5. Come up with your own pattern to make a cool crazy image.

		// 6. Use the ColorArrayDisplayer class to call the displayColorsAsImage method
		// to show off your picture.
	}

	public static void main(String[] args) {
		new CrazyDigitalPainting();
		new ColorArrayDisplayer().displayColorsAsImage(marshmallotomas);
	}
}
