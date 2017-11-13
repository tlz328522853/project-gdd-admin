package cn.hacz.edu.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.springframework.util.ResourceUtils;

/**
 * project - 自定义规范
 *
 * @author guo
 * @date 日期:2017年8月14日 时间:下午7:03:00
 * @JDK:version used:jdk1.7
 * @version 3.0
 * @Description 功能模块：各种文件的读取操作
 */
public class GetFileUtil {

	/**
	 * @Title getJSON
	 * @date 日期:2017年8月14日 时间:下午7:28:39
	 * @return String
	 * @Description 功能：获取json文件中的数据
	 */
	public String getJSON(String name) throws IOException {
		File file = ResourceUtils.getFile("classpath:resource/" + name + ".json");
		String lines = FileUtils.readFileToString(file, Charset.forName("UTF-8"));
		System.out.println(lines);
		return lines;
	}

	/**
	 * @Title getWebapp
	 * @ClassName APPserver
	 * @date 日期:2017年8月14日 时间:下午7:29:22
	 * @return String
	 * @Description 功能：获取json文件中的数据
	 */

	public String getWebapp(String name) throws IOException {
		String filePath = System.getProperty("webapp.root") + "WEB-INF/classes/init/db/" + name + ".json";
		String lines = FileUtils.readFileToString(new File(filePath), Charset.forName("UTF-8"));
		return lines;
	}

	/**
	 * @Title getXML
	 * @ClassName APPserver
	 * @date 日期:2017年8月14日 时间:下午7:28:53
	 * @return String
	 * @Description 功能：读取xml文件中的数据
	 */
	public String getXML(String name) throws IOException {
		File file = ResourceUtils.getFile("classpath:resource/" + name + ".xml");
		String lines = FileUtils.readFileToString(file, Charset.forName("UTF-8"));
		System.out.println(lines);
		return lines;
	}
	/**
	 * @Title getReqUrl
	 * @param name
	 * @param keyWord
	 * @throws IOException
	 * @date 日期:2017年11月10日 时间:上午11:08:44
	 * @return String
	 * @Description 功能：
	 */
	private String getReqUrl(String name, String keyWord) throws IOException {
		URL m = this.getClass().getResource("/");
		Properties pro = new Properties();
		FileInputStream in = new FileInputStream(m.getPath() + "/" + name + ".properties");
		pro.load(in);
		String result = pro.getProperty(keyWord);
		in.close();
		return result;
	}

}
