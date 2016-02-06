package org.apache.zeppelin.bigbrain.commands;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by shams on 2/5/16.
 */
public class LSCommand extends AbstractCommand implements Command {
    @Override
    public String execute(String... arguments) {
        try {
            Process p = Runtime.getRuntime().exec("ls -l");
            p.waitFor();

            BufferedReader reader =
                    new BufferedReader(new InputStreamReader(p.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String line = "";
            while ((line = reader.readLine()) != null) {
                sb.append(getText(line, ""));
            }
            return sb.toString();
        } catch (Exception e) {
            throw new CommandException(e.getMessage());
        }
    }
}
