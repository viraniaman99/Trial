package org.techfest.trial;

/**
 * Created by DELL on 25-Oct-15.
 */
public class ViewPagerItem {

    String className;
    String fragName;
    int image;

    public ViewPagerItem(int image, String className, String fragName) {
        this.image = image;
        this.className = className;
        this.fragName = fragName;
    }

    public String getClassName()
    {
        return className;
    }

    public int getImage()
    {
        return image;
    }

    public String getFragName()
    {
        return fragName;
    }

    public void setClassName(String text) {
        this.className = text;
    }

    public void setImage(int image1) {
        this.image = image1;
    }

}
