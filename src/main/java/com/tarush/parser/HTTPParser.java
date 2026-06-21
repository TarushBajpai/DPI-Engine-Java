package com.tarush.parser;

import com.tarush.model.HTTPRequest;

public class HTTPParser {
    public static HTTPRequest extract(String payload){

        String[] lines = payload.split("\r\n");
        String[] firstLine = lines[0].split(" ");

        String method = firstLine[0];
        String path = firstLine[1];
        String version = firstLine[2];

        String host = "";

        for (String line : lines) {
            if (line.startsWith("Host:")) {
                host = line.substring(5).trim();
            }
        }

        return new HTTPRequest(method, path, version, host);
    }
}
