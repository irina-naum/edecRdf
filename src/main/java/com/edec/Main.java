package com.edec;

import org.apache.jena.fuseki.FusekiCmd;

/**
 * This class launches the web application in an embedded Jetty container.
 * This is the entry point to your application. The Java command that is used for
 * launching should fire this main method.
 */
public class Main {

    public static void main(String[] args) {
        FusekiCmd.main("--mem", "--port=" + System.getenv("PORT"), "--pages=pages", "/edec");
    }

}
