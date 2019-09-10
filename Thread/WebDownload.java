package Thread;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * @author: CTH
 **/
public class WebDownload {

    public void downloadImage(String url, String path) {
        try {
            FileUtils.copyURLToFile(new URL(url), new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
