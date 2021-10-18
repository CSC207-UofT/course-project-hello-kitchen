package driver;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Shell{

    private boolean running;
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