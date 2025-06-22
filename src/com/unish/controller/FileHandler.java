package com.unish.controller;

import com.unish.model.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {
    private static final String FILE_NAME = "students.dat";

    public void saveToFile(List<Student> students) {
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))){
            oos.writeObject(students);
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<Student> loadFromFile() {
        File file = new File(FILE_NAME);

        if (!file.exists()){
            return new ArrayList<>();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))){

            return (ArrayList<Student>) ois.readObject();

        }catch (IOException | ClassNotFoundException e){
            System.out.println(e.getMessage());
            return new ArrayList<>();
        }


    }

}
