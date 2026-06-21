package com.tarush.model;

public class HTTPRequest {
    private String method;
    private String path;
    private String version;
    private String host;

    public HTTPRequest(String method, String path, String version, String host){
        this.method = method;
        this.path = path;
        this.version = version;
        this.host = host;
    }

    public String getMethod() {
        return method;
    }
    public String getPath() {
        return path;
    }
    public String getVersion() {
        return version;
    }
    public String getHost() {
        return host;
    }

    @Override
    public String toString() {
        return "HTTPRequest{" +
                "method='" + method + '\'' +
                ", path='" + path + '\'' +
                ", version='" + version + '\'' +
                ", host='" + host + '\'' +
                '}';
    }
}
