
package watermark;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Rect;
import org.opencv.highgui.Highgui;
import org.opencv.imgproc.Imgproc;
public class Watermark 
{
public static void main( String[] args )
{
try
{
System.loadLibrary( Core.NATIVE_LIBRARY_NAME );
Mat source = Highgui.imread("digital_image_processing.jpg",Highgui.CV_LOAD_IMAGE_COLOR);
Mat waterMark=Highgui.imread("watermark.png",Highgui.CV_LOAD_IMAGE_COLOR);
Rect ROI = new Rect(waterMark.rows()*4,waterMark.cols(),
waterMark.cols(),waterMark.rows());
Core.addWeighted(source.submat(ROI), 0.8, waterMark,
0.2, 1, source.submat(ROI));
Highgui.imwrite("watermarkedImage.jpg", source);
} 
catch (Exception e) 
{
System.out.println("Error: "+e.getMessage());
}
}
}
