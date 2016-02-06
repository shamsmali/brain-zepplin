package org.apache.zeppelin.bigbrain.commands;

/**
 * Created by shams on 2/5/16.
 */
public interface Command {
    String execute(String ... arguments);
}
