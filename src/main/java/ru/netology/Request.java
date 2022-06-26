package ru.netology;

import org.apache.http.NameValuePair;

import java.util.List;
import java.util.stream.Collectors;

public class Request {

    private final String method;
    private final String path;
    private List<String> headers;
    private final String body;
    private List<NameValuePair> queryParams;


    public Request(String method, String path, List<String> headers, String body) {
        this.method = method;
        this.path = path;
        this.headers = headers;
        this.body = body;
    }


    public void setQueryParams(List<NameValuePair> params) {
        this.queryParams = params;
    }



    public String getPath() {
        return path;
    }

    public String getMethod() {
        return method;
    }

    public List<NameValuePair> getQueryParams() {
        return queryParams;
    }

    public String getQueryParam(String param) {
        return queryParams.stream()
                .filter(p -> p.getName().equals(param))
                .map(p -> p.getValue())
                .collect(Collectors.joining(", "));
    }


    @Override
    public String toString() {
        return "Request{" +
                "\n method='" + method + '\'' +
                "\n path='" + path + '\'' +
                "\n headers=" + headers +
                "\n body='" + body + '\'' +
                "\n queryParams=" + queryParams +
                '}';
    }
}
