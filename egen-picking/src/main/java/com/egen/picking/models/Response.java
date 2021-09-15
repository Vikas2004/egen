package com.egen.picking.models;

public class Response {

    private org.apache.coyote.Response response;
    private Object output;

    public org.apache.coyote.Response getResponse() {
        return response;
    }

    public void setResponse(org.apache.coyote.Response response) {
        this.response = response;
    }

    public Object getOutput() {
        return output;
    }

    public void setOutput(Object output) {
        this.output = output;
    }
}
