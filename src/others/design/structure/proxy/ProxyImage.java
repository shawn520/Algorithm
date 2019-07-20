package others.design.structure.proxy;

/**
 * @author Shawn
 * @date 2019/7/5
 */
public class ProxyImage implements Image {

    public RealImage realImage;
    public String fileName;

    public ProxyImage(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void display() {
        if(null == realImage) {
            realImage = new RealImage(fileName);

        }
        realImage.display();

    }
}
