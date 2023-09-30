package model.saveAndRead;

import java.io.*;

public class SaveAndRead implements Writable {
    private File file;

    public SaveAndRead(File file) {
        this.file = file;
    }
    public SaveAndRead(){
    }

    @Override
    public boolean save(Serializable serializable, String filePath) {
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                    new FileOutputStream(filePath));
            objectOutputStream.writeObject(serializable);
            objectOutputStream.writeObject("\n");
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Object read(String filePath) {
        try {
            ObjectInputStream objectOutputStream = new ObjectInputStream(
                    new FileInputStream(filePath));
            return objectOutputStream.readObject();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
