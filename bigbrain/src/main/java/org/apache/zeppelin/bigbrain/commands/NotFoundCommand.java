package org.apache.zeppelin.bigbrain.commands;

import org.apache.zeppelin.bigbrain.CommandsFactory;

/**
 * Created by shams on 2/5/16.
 */
public class NotFoundCommand extends AbstractCommand implements Command {
    @Override
    public String execute(String... arguments) {
        return "oops command not found, please try one of this -> <br /> "
                + CommandsFactory.commands.stream().reduce((a, b) -> getText(a, b)).get();
    }
}
