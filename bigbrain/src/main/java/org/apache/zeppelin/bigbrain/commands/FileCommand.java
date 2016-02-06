package org.apache.zeppelin.bigbrain.commands;

import org.apache.zeppelin.bigbrain.CommandProcessor;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by shams on 2/5/16.
 */
public class FileCommand extends AbstractCommand implements Command {

    @Override
    public String execute(String... arguments) {
        if (null == arguments || arguments.length <= 0) {
            throw new IllegalArgumentException("Command file requires file name. Try file " + "xyz.txt");
        }
        try {
            List<String> lines = Files.readAllLines(Paths.get(arguments[0]));
            return lines.stream().reduce((a, b) -> getText(a, b)).get();
        } catch (Exception e) {
            throw new CommandException(e.getMessage());
        }
    }

}
