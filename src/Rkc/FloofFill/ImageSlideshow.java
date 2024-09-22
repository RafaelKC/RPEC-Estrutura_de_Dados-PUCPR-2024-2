package Rkc.FloofFill;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Arrays;
import javax.imageio.ImageIO;

public class ImageSlideshow extends JFrame {
    private JLabel label;
    private File[] images;
    private int currentImage = 0;

    public ImageSlideshow(String folderPath, int width, int height) {
        label = new JLabel();
        label.setHorizontalAlignment(JLabel.CENTER);
        add(label);
        setSize(width, height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        images = new File(folderPath).listFiles((d, name) -> name.endsWith(".png") || name.endsWith(".jpg"));
        if (images != null && images.length > 0) {
            Arrays.sort(images);
            Timer timer = new Timer(100, e -> showNextImage());
            timer.start();
            showNextImage();
        }
    }

    private void showNextImage() {
        try {
            BufferedImage img = ImageIO.read(images[currentImage]);
            ImageIcon icon = new ImageIcon(img.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH));
            label.setIcon(icon);
            currentImage = (currentImage + 1) % images.length;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
