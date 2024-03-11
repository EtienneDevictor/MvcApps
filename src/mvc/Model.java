package mvc;
import java.io.*;
import java.beans.*;


public abstract class Model extends Publisher implements Serializable {

    Boolean unsavedChanges = false;
    String fileName = null;

    public void serializeModel(String filename) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
            out.writeObject(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Model deserializeModel(String filename) {
        Model model = null;
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
            model = (Model) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return model;
    }
    Model test;
    public void changed() {

        unsavedChanges = true;
        System.out.println("model");
        notifySubscribers();

    }




}
