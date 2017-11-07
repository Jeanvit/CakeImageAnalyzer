package cake.classes;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

/**
 * * @author Jean Vitor de Paulo
 * Util class for helping the in the image processing
 */
public class ImageUtils {
    
    private ImageUtils(){};
//------------------------------------------------------------------------------------------     
   
    /* Process a image to obtain its alpha channel
    * @param BufferedImage originalImage - The image to be processed
    * @return BufferedImage originalImage - The alpha channel of the given image
    */
    public static BufferedImage getAlpha(BufferedImage originalImage) {     
        int RGBPixel;
        int alphaPixel;
                for (int i = 0 ; i <= originalImage.getWidth()-1 ; i++)
                    for (int j=0 ;j <= originalImage.getHeight()-1 ; j++){

                            RGBPixel = originalImage.getRGB(i,j);
                            alphaPixel = (RGBPixel>>24) & 0xff;

                            originalImage.setRGB(i, j, (alphaPixel << 24));
                    }
        return originalImage;
    }
//------------------------------------------------------------------------------------------    
   
    /*Process a image to obtain its blue channel
    * @param BufferedImage originalImage - The image to be processed
    * @return BufferedImage originalImage - The blue channel of the given image
    */
    public static BufferedImage getBlue(BufferedImage originalImage){
        int RGBPixel;
        int bluePixel;
                for (int i = 0 ; i <= originalImage.getWidth()-1 ; i++)
                    for (int j=0 ;j <= originalImage.getHeight()-1 ; j++){

                            RGBPixel = originalImage.getRGB(i,j);
                            bluePixel = RGBPixel & 0xff;

                            originalImage.setRGB(i, j, (bluePixel));
                    }
        return originalImage;
    }
    
//------------------------------------------------------------------------------------------   
   
    /* Process a image to obtain its red channel
    * @param BufferedImage originalImage - The image to be processed
    * @return BufferedImage originalImage - The red channel of the given image
    */
    public static BufferedImage getRed(BufferedImage originalImage){
        int RGBPixel;
        int redPixel;
                for (int i = 0 ; i <= originalImage.getWidth()-1 ; i++)
                    for (int j=0 ;j <= originalImage.getHeight()-1 ; j++){

                            RGBPixel = originalImage.getRGB(i,j);
                            redPixel = (RGBPixel>>16) & 0xff;

                            originalImage.setRGB(i, j, (redPixel << 16));
                    }
        return originalImage;
    }
    
 //------------------------------------------------------------------------------------------   
   
    /* Process a image to obtain its gren channel
    * @param BufferedImage originalImage - The image to be processed
    * @return BufferedImage originalImage - The green channel of the given image
    */
    public static BufferedImage getGreen(BufferedImage originalImage){
        int RGBPixel;
        int greenPixel;
                for (int i = 0 ; i <= originalImage.getWidth()-1 ; i++)
                    for (int j=0 ;j <= originalImage.getHeight()-1 ; j++){

                            RGBPixel = originalImage.getRGB(i,j);
                            greenPixel = (RGBPixel>>8) & 0xff;

                            originalImage.setRGB(i, j, (greenPixel << 8));
                    }
        return originalImage;
    }
    
//------------------------------------------------------------------------------------------   
  
    /* Process a image to obtain a 8 bit grayscale representation
    * @param BufferedImage originalImage - The image to be processed
    * @return BufferedImage img - The 8bit grayscale of the given image
    */    
    public static BufferedImage getGrayScale8bits(BufferedImage inputImage){
            BufferedImage img = new BufferedImage(inputImage.getWidth(), inputImage.getHeight(), BufferedImage.TYPE_BYTE_GRAY);
            Graphics g = img.getGraphics();
            g.drawImage(inputImage, 0, 0, null);
            g.dispose();
            return img;
    }
    
//------------------------------------------------------------------------------------------ 
   
    /* Rescale a image trying to maintain its proportion
    * @param BufferedImage originalImage - The image to be processed
    * @param int width - The new width
    * @param int height - The new height
    * @return BufferedImage resizedImage - The image with the new size
    */ 
    public static BufferedImage getScaledImage(BufferedImage image, int width, int height){   
            double factor = 1.0d;
            if(image.getWidth() > image.getHeight()){
                factor = ((double)image.getHeight()/(double)image.getWidth());
                height = (int)(width * factor);                
            }else{
                factor = ((double)image.getWidth()/(double)image.getHeight());
                width = (int)(height * factor);
            }   
            BufferedImage resizedImg = new BufferedImage(width, height, BufferedImage.TRANSLUCENT);
            Graphics2D g2 = resizedImg.createGraphics();
            g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
            g2.drawImage(image, 0, 0, width, height, null);
            g2.dispose();
            return resizedImg;
    }

//------------------------------------------------------------------------------------------ 
   
    /* Create a array of ints, representing the histogram of a given image
    * @param BufferedImage originalImage - The image to be processed
    * @param int numberOfBins - Number of histogram bins 
    * @return int bins[] - The array containing the occurrence of each intensity pixel (the histogram)
    */ 
    public static int[] buildHistogram(BufferedImage image, int numberOfBins){
        int bins[]=new int[numberOfBins];
        int intensity ;
        image=getGrayScale8bits(image);
                for (int i = 0 ; i <= image.getWidth()-1 ; i++){
                    for (int j=0 ;j <= image.getHeight()-1 ; j++){
                        intensity = image.getRGB(i,j) & 0xFF;
                        bins[intensity]++;
                    }            
                }
        return bins;
    }

//------------------------------------------------------------------------------------------
   
    /* Compute the entropy of an image based on the Shannon's Formula
    * @param BufferedImage originalImage - The image to be processed
    * @param int maxValue - The maximum value of intensity pixels, the same number as the histogram bins
    * @return int entropyValue - The entropy value
    */ 
    public static double getEntropy(BufferedImage image, int maxValue){
	int bins[] = buildHistogram(image,maxValue);
	  double entropyValue = 0,temp=0;
	  double totalSize = image.getHeight() * image.getWidth(); //total size of all symbols in an image

	  for(int i=0;i<maxValue;i++){ //the number of times a sybmol has occured
	    if(bins[i]>0){ //log of zero goes to infinity
	        temp=(bins[i]/totalSize)*(Math.log(totalSize/bins[i]));
	        entropyValue += temp;
	      }
	  }
	return entropyValue;
    }
} 