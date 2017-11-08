package cn.hacz.edu.images;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.coobird.thumbnailator.Thumbnails;

/**
 * 
 * @author guod
 *
 */
public class ThumbnailsUtil {

	protected final Logger loggerL = LoggerFactory.getLogger(this.getClass());
	private static final Logger logger = LoggerFactory.getLogger(ThumbnailsUtil.class);

	/**
	 * 功能：图片缩放
	 * 
	 * @param inputFile
	 * @param outputFile
	 * @param size
	 * @param quality
	 * @return
	 */
	public static boolean thumbnailsCompressPic(String inputFile, String outputFile, int size, float quality) {
		File input = new File(inputFile);
		try {
			Thumbnails.Builder<File> fileBuilder = Thumbnails.of(input).scale(1.0).outputQuality(1.0);
			BufferedImage src = fileBuilder.asBufferedImage();
			if (src.getHeight(null) > size || src.getWidth(null) > size) {
				Thumbnails.Builder<File> builder = Thumbnails.of(input);
				// 取最大的尺寸变成size，然后等比缩放
				builder.size(size, size).outputQuality(quality).toFile(outputFile);
			} else {
				Thumbnails.of(input).scale(1.0).outputQuality(quality).toFile(outputFile);
			}
			return true;
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
		}
		return false;
	}

	public static boolean thumbnailsSize(String inputFile, String outputFile, int sizeWidth, int sizeHeight) {
		File input = new File(inputFile);
		try {
			Thumbnails.Builder<File> fileBuilder = Thumbnails.of(input).scale(1.0).outputQuality(1.0);
			BufferedImage src = fileBuilder.asBufferedImage();
			if (sizeWidth >= 0 && sizeHeight >= 0) {
				Thumbnails.Builder<File> builder = Thumbnails.of(input);
				// 取最大的尺寸变成size，然后等比缩放
				builder.size(sizeWidth, sizeHeight).toFile(outputFile);
			} else {
				Thumbnails.of(input).size(src.getWidth(), src.getHeight()).toFile(outputFile);
			}
			return true;
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
		}
		return false;
	}

}
