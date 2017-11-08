package cn.hacz.edu.id;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * project - spring boot整合
 *
 * @author dong
 * @date 日期:2017年10月11日 时间:下午8:47:33
 * @JDK:version used:jdk1.8
 * @version 3.0
 * @Description 功能模块：各种id生成策略
 */

public class IDUtils {

	/**
	 * @Title excelFileName
	 * @return
	 * @date 日期:2017年10月11日 时间:下午8:48:01
	 * @return String
	 * @Description 功能：生成文件的名称，将时间格式转换成标准格式
	 */
	public static String excelFileName() {
		long millis = System.currentTimeMillis();
		Date date = new Date(millis);
		SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
		String retStrFormatNowDate = formatDate.format(date);
		Random random = new Random();
		int end3 = random.nextInt(999);
		String str = retStrFormatNowDate + String.format("%03d", end3);
		return str;

	}

	/**
	 * @Title genImageName
	 * @return
	 * @date 日期:2017年10月11日 时间:下午8:48:16
	 * @return String
	 * @Description 功能：图片名生成
	 */
	public static String genImageName() {
		// 取当前时间的长整形值包含毫秒
		long millis = System.currentTimeMillis();
		// long millis = System.nanoTime();
		// 加上三位随机数
		Random random = new Random();
		int end3 = random.nextInt(999);
		// 如果不足三位前面补0
		String str = millis + String.format("%03d", end3);

		return str;
	}

	/**
	 * @Title genItemId
	 * @return
	 * @date 日期:2017年10月11日 时间:下午8:48:27
	 * @return long
	 * @Description 功能：商品id生成
	 */
	public static long genItemId() {
		// 取当前时间的长整形值包含毫秒
		long millis = System.currentTimeMillis();
		// long millis = System.nanoTime();
		// 加上两位随机数
		Random random = new Random();
		int end2 = random.nextInt(99);
		// 如果不足两位前面补0
		String str = millis + String.format("%02d", end2);
		long id = new Long(str);
		return id;
	}

	/**
	 * @Title getSnNumber
	 * @return
	 * @date 日期:2017年10月11日 时间:下午8:48:41
	 * @return long
	 * @Description 功能：获取随机数
	 */
	public static long getSnNumber() {
		// 取当前时间的长整形值包含毫秒
		long millis = System.currentTimeMillis();
		// long millis = System.nanoTime();
		// 加上两位随机数
		Random random = new Random();
		int end2 = random.nextInt(99);
		// 如果不足两位前面补0
		String str = millis + String.format("%02d", end2);
		long id = new Long(str);
		return id;
	}
}
