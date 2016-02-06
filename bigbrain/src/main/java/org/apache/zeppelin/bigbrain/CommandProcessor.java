package org.apache.zeppelin.bigbrain;

import org.apache.zeppelin.bigbrain.commands.CommandException;
import org.apache.zeppelin.bigbrain.commands.NotFoundCommand;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by shams on 2/5/16.
 */
public class CommandProcessor {

    public String processCommand(final String text) {
        sanitize(text, new String[]{});

        String[] stringArray = text.split("\\s+");
        String[] arguments = Arrays.copyOfRange(stringArray, 1, stringArray.length);
        List<String> command = CommandsFactory.commands.stream().filter(i -> i.equalsIgnoreCase(stringArray[0].trim())).collect(Collectors.toList());

        if (null == command || command.isEmpty())
            return new NotFoundCommand().execute(arguments);

        return CommandsFactory.getCommandByName(command.get(0)).execute(arguments);
    }

    private void sanitize(String text, String arguments[]) {
        if (null == text || text.isEmpty()) {
            throw new CommandException(new NotFoundCommand().execute(arguments));
        }
    }
}
