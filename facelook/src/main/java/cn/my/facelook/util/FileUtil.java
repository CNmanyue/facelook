package cn.my.facelook.util;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

/**
 * 图像管理工具类
 * @author 满月
 *
 */
public class FileUtil {
	private static Log log = LogFactory.getLog(FileUtil.class);

	/**
	 * 将文件保存成为byte[]
	 * @param photo
	 * @return
	 * @throws IOException
	 */
	public static byte[] toByteArray(File photo) throws IOException {
		FileInputStream fis = new FileInputStream(photo);
		BufferedInputStream bis = new BufferedInputStream(fis);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		int c = bis.read();
		while (c != -1) {
			baos.write(c);
			c = bis.read();
		}
		bis.close();
		byte[] rtn = baos.toByteArray();
		baos.close();
		return rtn;
	}

	/**
	 * 生成缩略图
	 * @param srcFile
	 * @return
	 */
	public static byte[] buildThumbnail(File srcFile) {
		byte[] rtn = null;
		try {
			Image src = ImageIO.read(srcFile); // 构造Image对象
			int oldWidth = src.getWidth(null); // 得到源图宽
			int oldHeight = src.getHeight(null);// 得到源图高

			log.debug("old width is " + oldWidth);
			log.debug("old height is " + oldHeight);

			float divWidth = 200f; // 限制宽度为200
			int newWidth = 200; // 缩略图宽,
			int newHeight = 0; // 缩略图高
			float tmp;
			if (oldWidth > newWidth) {
				tmp = oldWidth / divWidth;
				newWidth = Math.round(oldWidth / tmp);// 计算缩略图高
				newHeight = Math.round(oldHeight / tmp);// 计算缩略图高
				log.debug("tmp scale is  " + tmp);
			} else {
				newWidth = oldWidth;
				newHeight = oldHeight;
			}
			/*
			 * My Option Begin
			//int imageHeight = 100;
			//int imageWidth = 200;
			 * 注释掉这两个变量，将下面引用这两个变量的地方改为引用：
			 * newWidth\newHeight
			 * My Option End
			*/
			log.debug("new width is " + newWidth);
			log.debug("new height is " + newHeight);

			BufferedImage bufferedImage = new BufferedImage(newWidth,
					newHeight, BufferedImage.TYPE_INT_RGB);

			Graphics2D graphics2D = (Graphics2D) bufferedImage.createGraphics();
			graphics2D.setBackground(Color.WHITE);
			graphics2D.clearRect(0, 0, newWidth, newHeight);
			bufferedImage.getGraphics().drawImage(src,
					//(imageWidth - oldWidth) / 2, (imageHeight - newHeight) / 2,
					0,0,
					newWidth, newHeight, null); // 绘制缩小后的图

			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			BufferedOutputStream bos = new BufferedOutputStream(baos);
			JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(bos);
			encoder.encode(bufferedImage); // 近JPEG编码
			rtn = baos.toByteArray();
			bos.close();
			baos.close();
		} catch (Exception e) {
			log.debug(e);
		} finally {

		}
		return rtn;
	}
}
