package mvc;
import java.io.Serializable;

public class Model extends Publisher implements Serializable {

    Boolean unsavedChanges = false;
    String fileName = null;

    public void changed() {
        unsavedChanges = true;
        notifySubscribers();
    }


}
