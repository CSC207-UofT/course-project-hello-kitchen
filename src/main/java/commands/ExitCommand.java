package commands;

import module.InstanceRegistry;
import module.Shell;

public class ExitCommand extends Command {

    public Shell shell;

    public ExitCommand() {
    }

    @Override
    public void run(String commandLine) {
        this.execute();
    }

    @Override
    public void execute() {
        this.shell = InstanceRegistry.getShell();
        shell.stopRunning();
    }
}
