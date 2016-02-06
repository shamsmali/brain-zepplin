package org.apache.zeppelin.bigbrain.commands;

/**
 * Created by shams on 2/5/16.
 */
public abstract class AbstractCommand implements Command {

    protected String getText(String a, String b) {
        String right = (b == null || b.isEmpty()) ? "" : "<font color=\"blue\">" + b + "</font>";
        return "<font color=\"gray\">" + a + "</font><br/>" + right;
    }
}
