package cn.hacz.edu.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

/**
 * project -
 *
 * @author guo
 * @date 日期:2017年8月23日 时间:下午4:33:04
 * @JDK:version used:jdk1.7
 * @version 3.0
 * @Description 功能模块：文件压缩工具类
 */
public class ZipsUtil {

	public static void main(String args[]) {
		/**
		 * 功能：压缩
		 */
		zipFiles("d:\\hello.txt", "d:\\test.zip");
		
		/**
		 * 功能：解压
		 */
		unZipFiles("d:\\test.zip", "F:\\1");
	}

	/**
	 * @Title zipFiles
	 * @date 日期:2017年8月23日 时间:下午4:25:44
	 * @param filePath：需要压缩的文件地址d:\\test
	 * @param descDir：压缩后的文件目录d:\\test.zip
	 * @return void
	 * @Description 功能：生成Zip压缩文件
	 */
	public static void zipFiles(String filePath, String descDir) {
		ZipOutputStream zos = null;

		try {
			// 创建一个Zip输出流
			zos = new ZipOutputStream(new FileOutputStream(descDir));
			// 启动压缩
			startZip(zos, "", filePath);

			// System.out.println("******************压缩完毕********************");
		} catch (IOException e) {
			// 压缩失败，则删除创建的文件
			File zipFile = new File(descDir);

			if (zipFile.exists()) {
				zipFile.delete();
			}
			// System.out.println("******************压缩失败********************");

			e.printStackTrace();
		} finally {
			try {
				if (zos != null) {
					zos.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * @Title startZip
	 * @date 日期:2017年8月23日 时间:下午4:32:26
	 * @param zosZIP压缩输出流
	 * @param oppositePath在zip文件中的相对路径
	 * @param directory要压缩的文件的路径
	 * @throws IOException
	 * @return void
	 * @Description 功能：对目录中所有文件递归遍历进行压缩
	 */
	private static void startZip(ZipOutputStream zos, String oppositePath, String directory) throws IOException {
		File file = new File(directory);

		if (file.isDirectory()) {
			// 如果是压缩目录
			File[] files = file.listFiles();

			for (int i = 0; i < files.length; i++) {
				File aFile = files[i];

				if (aFile.isDirectory()) {
					// 如果是目录，修改相对地址
					String newOppositePath = oppositePath + aFile.getName() + "/";
					// 压缩目录，这是关键，创建一个目录的条目时，需要在目录名后面加多一个"/"
					ZipEntry entry = new ZipEntry(oppositePath + aFile.getName() + "/");

					zos.putNextEntry(entry);

					zos.closeEntry();
					// 进行递归调用
					startZip(zos, newOppositePath, aFile.getPath());
				} else {
					// 如果不是目录，则进行压缩
					zipFile(zos, oppositePath, aFile);
				}
			}
		} else {
			// 如果是压缩文件，直接调用压缩方法进行压缩
			zipFile(zos, oppositePath, file);
		}
	}

	/**
	 * @Title zipFile
	 * @date 日期:2017年8月23日 时间:下午4:31:56
	 * @param zoszip输出流
	 * @param oppositePath在zip文件中的相对路径
	 * @param file要压缩的的文件
	 * @return void
	 * @Description 功能：压缩单个文件到目录中
	 */
	private static void zipFile(ZipOutputStream zos, String oppositePath, File file) {
		// 创建一个Zip条目，每个Zip条目都是必须相对于根路径
		InputStream is = null;

		try {
			ZipEntry entry = new ZipEntry(oppositePath + file.getName());
			// 将条目保存到Zip压缩文件当中
			zos.putNextEntry(entry);
			// 从文件输入流当中读取数据，并将数据写到输出流当中.
			is = new FileInputStream(file);

			int length = 0;

			int bufferSize = 1024;

			byte[] buffer = new byte[bufferSize];

			while ((length = is.read(buffer, 0, bufferSize)) >= 0) {
				zos.write(buffer, 0, length);
			}
			zos.closeEntry();
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (is != null) {
					is.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}

	/*********************************** 华丽的分割线 ***********************************/

	/**
	 * @Title unZipFiles
	 * @date 日期:2017年8月23日 时间:下午4:30:44
	 * @param zipFilePathzip文件路径
	 * @param descDir解压出来的文件保存的目录
	 * @return void
	 * @Description 功能：解压文件操作
	 */
	public static void unZipFiles(String zipFilePath, String descDir) {
		File zipFile = new File(zipFilePath);

		File pathFile = new File(descDir);

		if (!pathFile.exists()) {
			pathFile.mkdirs();
		}
		ZipFile zip = null;

		InputStream in = null;

		OutputStream out = null;

		try {
			zip = new ZipFile(zipFile);

			for (Enumeration<? extends ZipEntry> entries = zip.entries(); entries.hasMoreElements();) {
				ZipEntry entry = entries.nextElement();

				String zipEntryName = entry.getName();

				in = zip.getInputStream(entry);

				String outPath = (descDir + "/" + zipEntryName).replaceAll("\\*", "/");
				;
				// 判断路径是否存在,不存在则创建文件路径
				File file = new File(outPath.substring(0, outPath.lastIndexOf('/')));

				if (!file.exists()) {
					file.mkdirs();
				}
				// 判断文件全路径是否为文件夹,如果是上面已经创建,不需要解压
				if (new File(outPath).isDirectory()) {
					continue;
				}
				out = new FileOutputStream(outPath);

				byte[] buf1 = new byte[4 * 1024];

				int len;

				while ((len = in.read(buf1)) > 0) {
					out.write(buf1, 0, len);
				}
				in.close();

				out.close();
			}
			// System.out.println("******************解压完毕********************");
		} catch (IOException e) {
			pathFile.delete();
			// System.out.println("******************解压失败********************");
			e.printStackTrace();
		} finally {
			try {
				if (zip != null) {
					zip.close();
				}
				if (in != null) {
					in.close();
				}
				if (out != null) {
					out.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
