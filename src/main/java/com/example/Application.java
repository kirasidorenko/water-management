package com.example;

import com.example.command.CommandFactory;
import com.example.command.CommandExecutor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Application {

    public static void main(String[] args) throws IOException {
        String absoluteFilePath = args[0];
        Application application = new Application();
        application.execute(absoluteFilePath);
    }

    protected void execute(String absoluteFilePath) throws IOException {
        CommandExecutor commandExecutor = new CommandExecutor();
        CommandFactory commandFactory = new CommandFactory();
        List<String> lines = Files.readAllLines(Paths.get(absoluteFilePath));
        lines.forEach(line -> commandExecutor.addCommand(commandFactory.getCommand(line)));
        commandExecutor.execute();
    }
}
