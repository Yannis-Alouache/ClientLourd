package org.tp;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;

import java.io.IOException;

/**
 * A service class used to get image data from url
 */
public class ImageHandler {

    /**
     * Get the image from a url, is used to get image from ImageLink of the boat
     * Can throw a BadElementException and a IOException
     *
     * @param url the url to extract image from
     * @param document the document you are trying to print the image on (used for sizing)
     *
     * @return the Image relative to the url
     *
     */
    public static Image getImageFromUrl(String url, Document document) {
        Image image = null;
        try {
            image = Image.getInstance(url);
            image.scaleToFit(PageSize.A4.getWidth() - 70, PageSize.A4.getHeight());
        } catch (BadElementException | IOException e) {
            e.printStackTrace();
        }
        return image;
    }
}
