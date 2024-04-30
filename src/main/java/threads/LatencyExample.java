package threads;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import java.util.*;

public class LatencyExample {
	
	public static final String sf="src/main/resources/many-flowers.jpg";
	public static final String of="src/main/resources/many-flowers-out.jpg";
	
	public static void main(String[] args) throws IOException    {
	BufferedImage origImag=	ImageIO.read(new File(sf));
	BufferedImage resImag=new BufferedImage(origImag.getWidth(), origImag.getHeight(), BufferedImage.TYPE_INT_RGB);

	Long stTime=System.currentTimeMillis();
//	recolorSingleThread(origImag,resImag);
	int numthreads=8;
	recolorMultipleThread(origImag, resImag, numthreads);
	System.out.println("Total time take is"+ (System.currentTimeMillis()-stTime)+" ms ");
	File outputfile=new File(of);
	ImageIO.write(resImag, "jpg", outputfile);
	}
	
	public static void recolorSingleThread(BufferedImage orig, BufferedImage res) {
		recolorImage(orig, res, 0, 0, orig.getWidth(), orig.getHeight());
	}
	
	
	public static void recolorMultipleThread(BufferedImage orig, BufferedImage res, int nothreads) {
		int height=orig.getHeight()/nothreads;
		int width=orig.getWidth();
		ArrayList<Thread> threads=new ArrayList<Thread>();
		for(int i=0;i<nothreads;i++) {
			int multiplier=i;
			Thread temp1=new Thread(()->{
					int leftcorner=0;
					int topCorner=height*multiplier;
				
					recolorImage(orig, res, leftcorner, topCorner, width, height);
				
			});
			threads.add(temp1);
			
		}
		for(Thread th:threads) {
			th.start();
		}
		
		for(Thread th:threads) {
			try {
				th.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public static void recolorPixel(BufferedImage origImg,BufferedImage resImg,int x, int y) {
		int rgb=origImg.getRGB(x, y);
		int r=getRed(rgb);
		int g=getGreen(rgb);
		int b=getBlue(rgb);
		
		int newg,newr,newb;
		if(isGreyShade(r, g, b)) {
			newr=Math.min(255, r+10);
			newg=Math.max(0, g-80);
			newb=Math.max(0, b-20);
		} else {
			newg=g;
			newr=r;
			newb=b;
		}
		
		
		int newrgb=createRGBFromColors(newr, newg, newb);
		setRGB(resImg,x,y,newrgb);
	}
	public static void recolorImage(BufferedImage origImg, BufferedImage resImg, int leftCorner,int topCorner,int width, int height) {
		for(int x=leftCorner;x<leftCorner+width&&x<origImg.getWidth();x++) {
			for(int y=topCorner;y<topCorner+height&&y<origImg.getHeight();y++) {
				recolorPixel(origImg, resImg, x, y);
			}
		}
	}
	
	public static void setRGB(BufferedImage tgtimg, int x, int y, int rgb) {
		tgtimg.getRaster().setDataElements(x, y, tgtimg.getColorModel().getDataElements(rgb, null ));
	}
	
	public static int getBlue(int rgb) {
		return rgb & 0x000000FF;
	}
	public static int getGreen(int rgb) {
		return (rgb & 0x0000FF00)>>8;
	}
	public static int getRed(int rgb) {
		return (rgb & 0x00FF0000)>>16;
	}
	
	public static int createRGBFromColors(int r, int g, int b) {
		int rgb=0;
		rgb|=b;
		rgb|=g<<8;
		rgb|=r<<16;
		rgb|=0xFF000000;
		return rgb;
		
	}
	public static boolean isGreyShade(int r, int g, int b) {
		return Math.abs(r-g)<30 && Math.abs(r-b)<30 && Math.abs(g-b)<30;
	}
}
