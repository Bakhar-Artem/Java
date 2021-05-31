package by.bakhar.game.reader;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PictureReader {
    private static final String FILEPATH_0 = "src\\main\\resources\\number\\0.png";
    private static final String FILEPATH_2 = "src\\main\\resources\\number\\2.png";
    private static final String FILEPATH_4 = "src\\main\\resources\\number\\4.png";
    private static final String FILEPATH_8 = "src\\main\\resources\\number\\8.png";
    private static final String FILEPATH_16 = "src\\main\\resources\\number\\16.png";
    private static final String FILEPATH_32 = "src\\main\\resources\\number\\32.png";
    private static final String FILEPATH_64 = "src\\main\\resources\\number\\64.png";
    private static final String FILEPATH_128 = "src\\main\\resources\\number\\128.png";
    private static final String FILEPATH_256 = "src\\main\\resources\\number\\256.png";
    private static final String FILEPATH_512 = "src\\main\\resources\\number\\512.png";
    private static final String FILEPATH_1024 = "src\\main\\resources\\number\\1024.png";
    private static final String FILEPATH_2048 = "src\\main\\resources\\number\\2048.png";


    public static List<BufferedImage> readImages() throws IOException {
        List<BufferedImage> images = new ArrayList<>();
        images.add(ImageIO.read(new File(FILEPATH_0)));
        images.add(ImageIO.read(new File(FILEPATH_2)));
        images.add(ImageIO.read(new File(FILEPATH_4)));
        images.add(ImageIO.read(new File(FILEPATH_8)));
        images.add(ImageIO.read(new File(FILEPATH_16)));
        images.add(ImageIO.read(new File(FILEPATH_32)));
        images.add(ImageIO.read(new File(FILEPATH_64)));
        images.add(ImageIO.read(new File(FILEPATH_128)));
        images.add(ImageIO.read(new File(FILEPATH_256)));
        images.add(ImageIO.read(new File(FILEPATH_512)));
        images.add(ImageIO.read(new File(FILEPATH_1024)));
        images.add(ImageIO.read(new File(FILEPATH_2048)));
        return images;
    }
}
