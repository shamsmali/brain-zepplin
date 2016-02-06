package org.apache.zeppelin.bigbrain.commands;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by shams on 2/5/16.
 */
public class ListFilesCommand extends AbstractCommand implements Command {

    @Override
    public String execute(String... arguments) {
        try (Stream<Path> stream = Files.list(Paths.get(""))) {
            return stream
                    .map(f -> f.toFile().getAbsolutePath())
                    .filter(path -> !path.startsWith("."))
                    .sorted()
                    .reduce((a, b) -> getText(a, b)).get();
        } catch (Exception e) {
            throw new CommandException(e.getMessage());
        }
    }
}
