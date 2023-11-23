package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Task2 {
    private List<User> readUsersFromFile(File file) throws IOException {
        List<User> users = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            br.readLine(); // Skipping the header
            while ((line = br.readLine()) != null) {
                String[] columns = line.split("\\s+");
                String name = columns[0];
                int age = Integer.parseInt(columns[1]);
                User user = new User(name, age);
                users.add(user);
            }
        }
        return users;
    }

    private String objectToJsonString(List<User> users) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonUsers = gson.toJson(users);
        System.out.println(jsonUsers);
        return jsonUsers;
    }

    private void writeToJsonFile(String jsonUser) throws IOException {
        File file = new File(System.getProperty("user.dir"), "src/main/resources/user.json");
        if (file.exists()) {
            file.delete();
            file.createNewFile();
        } else {
            file.createNewFile();
        }
        try (FileWriter writer = new FileWriter(file, true)) {
            writer.write(jsonUser);
            writer.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void convertFileToJson(File file) throws IOException {
        this.writeToJsonFile(this.objectToJsonString(this.readUsersFromFile(file)));
    }
}
