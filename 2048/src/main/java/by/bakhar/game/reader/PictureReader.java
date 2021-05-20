package by.bakhar.game.reader;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PictureReader {
    private static final String FILEPATH = "src\\main\\resources\\number";

    public static List<BufferedImage> readImages() throws IOException {
        List<BufferedImage> images = new ArrayList<>();
        File dir = new File(FILEPATH);
        File[] arrFiles = dir.listFiles();
        for (File file : arrFiles) {
            images.add(ImageIO.read(file));
        }
        return images;
    }
}
