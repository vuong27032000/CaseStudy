package IO;

import models.Account;

import java.io.*;
import java.util.ArrayList;

public class ReadandWrite<E> {
    public void write(ArrayList<E> list, String path){
        File file = new File(path);

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(list);
            objectOutputStream.close();
            fileOutputStream.close();
        }catch (IOException ioE){
            ioE.printStackTrace();
        }
    }
    public ArrayList<E> read(String path){
        File file = new File(path);

        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            return (ArrayList<E>) objectInputStream.readObject();
        }catch (IOException | ClassNotFoundException e){
            System.err.println("Lỗi");
        }
        return new ArrayList<>();
    }
}
