package driver;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * This class holds all the states of the Shell Program
 */
public class Shell{

    private boolean running;


    /**
     * Constructs an object that holds JShell's important states including
     * the root directory, current directory, directory stack and a boolean that
     * indicates JShell is running
     */
    public Shell() {
        this.running = true;

    }

    public boolean isRunning() {
        return running;
    }

    public void stopRunning() {
        running = false;
    }
}