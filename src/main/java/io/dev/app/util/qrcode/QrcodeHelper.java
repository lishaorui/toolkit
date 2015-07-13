package io.dev.app.util.qrcode;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

/**
 * desc: 二维码帮助类
 * 
 * @author lsr
 * @version 2014年6月3日
 */
@Component
public class QrcodeHelper {
	private static final Logger logger = LoggerFactory.getLogger(QrcodeHelper.class);
	/**
	 * 设置二维码的格式参数
	 */
	public Map<EncodeHintType, Object> getDecodeHintType(){
		// 用于设置QR二维码参数
		Map<EncodeHintType, Object> hints = new HashMap<EncodeHintType, Object>();
		// 设置QR二维码的纠错级别（H为最高级别）具体级别信息
		hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
		// 设置编码方式
		hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
		hints.put(EncodeHintType.MAX_SIZE, 350);
		hints.put(EncodeHintType.MIN_SIZE, 100);
		return hints;
	}
	
	/**
	 * 生成二维码
	 * @param content 文本内容
	 * @param targetFile 目标文件
	 */
	public void generate(String content, String targetFile) {
		MultiFormatWriter multiFormatWriter = new MultiFormatWriter();

		try {
			BitMatrix bitMatrix = multiFormatWriter.encode(content, BarcodeFormat.QR_CODE, 400, 400, getDecodeHintType());
			File file = new File(targetFile);
			MatrixToImageWriter.writeToFile(bitMatrix, "jpg", file);
		} catch (IOException | WriterException e) {
			logger.warn("generate qrcode error.content:[{}]", new Object[]{content}, e);
		}
	}
	
/*	public void generateLogoCode(File qrPic, File logoPic) throws IOException{
        *//**
         * 读取二维码图片，并构建绘图对象
         *//*
        BufferedImage image = ImageIO.read(qrPic);
        Graphics2D g = image.createGraphics();

        *//**
         * 读取Logo图片
         *//*
        BufferedImage logo = ImageIO.read(logoPic);
         
        int widthLogo = logo.getWidth(), heightLogo = logo.getHeight();
         
        // 计算图片放置位置
        int x = (image.getWidth() - widthLogo) / 2;
        int y = (image.getHeight() - logo.getHeight()) / 2;

        //开始绘制图片
        g.drawImage(logo, x, y, widthLogo, heightLogo, null);
        g.drawRoundRect(x, y, widthLogo, heightLogo, 15, 15);
        g.setStroke(new BasicStroke(2));//logoConfig.getBorder()
        g.setColor(Color.WHITE);//logoConfig.getBorderColor()
        g.drawRect(x, y, widthLogo, heightLogo);
         
        g.dispose();
         
        ImageIO.write(image, "jpeg", new File("E:/Ent/newPic.jpg"));

	}*/

/*	public void read() {
		MultiFormatReader formatReader = new MultiFormatReader();
		String filePath = "C:/Users/Administrator/Desktop/testImage/test.jpg";
		File file = new File(filePath);
		Result result;
		try {
			BufferedImage image = ImageIO.read(file);
			;
			LuminanceSource source = new BufferedImageLuminanceSource(image);
			Binarizer binarizer = new HybridBinarizer(source);
			BinaryBitmap binaryBitmap = new BinaryBitmap(binarizer);
			result = formatReader.decode(binaryBitmap, getDecodeHintType());
			System.out.println("result = " + result.toString());
			System.out.println("resultFormat = " + result.getBarcodeFormat());
			System.out.println("resultText = " + result.getText());
		} catch (NotFoundException | IOException e) {
			e.printStackTrace();
		}

	}*/
	
}
