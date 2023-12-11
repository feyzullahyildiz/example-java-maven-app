package com.mycompany.app;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.beust.jcommander.JCommander;
import com.google.gson.Gson;

public class App {
    public void logJsonFile() throws IOException {
        String cwd = System.getProperty("user.dir");
        Path jsonFilePath = Paths.get(cwd, "assets", "example.json");
        System.out.println(String.format("jsonFilePath : %s", jsonFilePath));
        String jsonContent = Files.readString(jsonFilePath);
        System.out.println(String.format("jsonContent: %s", jsonContent));
        Gson gson = new Gson();
        User user = gson.fromJson(jsonContent, User.class);
        System.out.println(String.format("USER ID: %d", user.id));
        System.out.println(String.format("USER NAME: %s", user.name));
        System.out.println(String.format("USER SURNAME: %s", user.surname));
    }

    public void logEnv() {
        String user = System.getenv("USER");
        String javaHome = System.getenv("JAVA_HOME");
        System.out.println(String.format("SYSTEM USER: %s", user));
        System.out.println(String.format("JAVA HOME: %s", javaHome));
    }

    public void logArgs(String[] args) {
        System.out.println("ARGS");
        String argsInString = String.join(", ", args);
        System.out.println(String.format("Args %s", argsInString));

        MyArgs main = new MyArgs();
        JCommander.newBuilder()
                .addObject(main)
                .build()
                .parse(args);
        main.run();
    }

    public void compareString() {
        if (new String("FOO") == "FOO") {
            System.out.println("FOO equals to FOO");
        } else {
            System.out.println("FOO IS NOT equals to FOO");
        }
    }

    public static void main(String[] args) {
        App app = new App();
        app.logArgs(args);
        app.logEnv();
        app.compareString();
        try {
            app.logJsonFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
