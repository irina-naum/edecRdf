package com.edec;

import org.apache.commons.io.IOUtils;
import org.apache.jena.fuseki.FusekiCmd;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * This class launches the web application in an embedded Jetty container.
 * This is the entry point to your application. The Java command that is used for
 * launching should fire this main method.
 */
public class Main {

    public static void concatenateData() throws IOException {
        StringBuffer outBuffer = new StringBuffer();

        for (final File fileEntry : new File("/app/include/data/").listFiles()) {
            if (fileEntry.isFile()) {
                FileInputStream inputStream = new FileInputStream(fileEntry);

                outBuffer.append(IOUtils.toString(inputStream));
                inputStream.close();
            }
        }

        FileOutputStream out = new FileOutputStream("include/data.ttl");
        IOUtils.write(outBuffer, out);
        out.close();

    }

    public static void main(String[] args) throws IOException {
        concatenateData();
        FusekiCmd.main("--file=include/data.ttl", "--port=" + System.getenv("PORT"), "--pages=include/pages", "--update", "/edec");
    }

}
