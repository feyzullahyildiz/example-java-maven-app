package com.mycompany.app;

import com.beust.jcommander.Parameter;

public class MyArgs {
    @Parameter(names = { "-d", "--debug", "-debug" }, description = "Debug mode")
    private boolean debug = false;

    public void run() {
        System.out.println(String.format("Debug Mode %s", debug));
    }

}