package org.apache.zeppelin.bigbrain;

import org.apache.zeppelin.bigbrain.commands.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shams on 2/5/16.
 */
public class CommandsFactory {

    public static final List<String> commands = new ArrayList<String>();

    static {
        commands.add("ls");
        commands.add("file");
        commands.add("listFiles");

    }

    public static Command getCommandByName(String name) {
        switch (name) {
            case "ls": {
                return new LSCommand();
            }
            case "file": {
                return new FileCommand();
            }
            case "listFiles": {
                return new ListFilesCommand();
            }
            default: {
                return new NotFoundCommand();
            }
        }
    }
}
