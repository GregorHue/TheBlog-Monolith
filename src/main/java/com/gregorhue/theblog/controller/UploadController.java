package com.gregorhue.theblog.controller;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.Serializable;
import javax.faces.view.ViewScoped;
import javax.imageio.ImageIO;
import javax.inject.Named;
import javax.servlet.http.Part;

import org.omnifaces.util.Utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by gregorhue on 31.12.2020.
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Named
@ViewScoped
public class UploadController implements Serializable {

	private static final long serialVersionUID = 6319888418463830183L;

	private static final int MAX_IMAGE_LENGTH = 100;
	
	private Part file;
	private byte[] image;
	private byte[] resizedImage;
	private boolean dirty;
	

	public void read() throws IOException {
		image = Utils.toByteArray(file.getInputStream());
		resizedImage = scale(image);
	}
	
	public byte[] fetchResizedImage() {
		if (resizedImage != null) {
			return resizedImage;
		} else {
			return new byte[] {};
		}
	}
	

	private byte[] scale(byte[] image) throws IOException {
		ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(image);
		BufferedImage originalBufferedImage = ImageIO.read(byteArrayInputStream);

		double originalWidth = (double) originalBufferedImage.getWidth();
		double originalHeight = (double) originalBufferedImage.getHeight();
		double relevantLength = originalWidth > originalHeight ? originalWidth : originalHeight;
		double transformationScale = MAX_IMAGE_LENGTH / relevantLength;

		int width = (int) Math.round(transformationScale * originalWidth);
		int height = (int) Math.round(transformationScale * originalHeight);

		BufferedImage resizedBufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics2D g2d = resizedBufferedImage.createGraphics();
		g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);

		AffineTransform affineTransform = AffineTransform.getScaleInstance(transformationScale, transformationScale);
		g2d.drawRenderedImage(originalBufferedImage, affineTransform);

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ImageIO.write(resizedBufferedImage, "PNG", baos);
		return baos.toByteArray();
	}

}
