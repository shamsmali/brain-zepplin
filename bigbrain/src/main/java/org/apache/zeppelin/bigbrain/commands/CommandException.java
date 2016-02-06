package org.apache.zeppelin.bigbrain.commands;

/**
 * Created by shams on 2/5/16.
 */
public class CommandException extends RuntimeException {
    public CommandException(String message) {
        super(message);
    }
}
