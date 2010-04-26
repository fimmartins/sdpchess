package com.structures;
import javax.swing.ImageIcon;

public class LoadImagine {
	private ImageIcon createImageIcon(String path,String description) {
		java.net.URL imgURL = getClass().getResource(path);
		if (imgURL != null) {
			return new ImageIcon(imgURL, description);
		} else {
			System.err.println("Couldn't find file: " + path);
			return null;
		}
	}
	public ImageIcon getIcon(String path)
	{
		ImageIcon picture = createImageIcon(path,"");
		return picture;
	}

}
