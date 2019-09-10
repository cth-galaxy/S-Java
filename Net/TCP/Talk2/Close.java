package Net.TCP.Talk2;

import java.io.Closeable;
import java.io.IOException;

/**
 * @author: CTH
 **/
public class Close {
    public void release(Closeable ... targets) {
        for (Closeable target: targets) {
            if (target != null) {
                try {
                    target.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
