
package imagetrim;

/**
 * The purpose of this is to trim image file documents
 * @author xthomas
 */
public class ImageTrim {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        OpenFile temp = new OpenFile();
        temp.accessFiles();
//        temp.listF1();
        temp.listF2();
//        temp.TrimF1();
        temp.TrimF22();
    }
    
}
