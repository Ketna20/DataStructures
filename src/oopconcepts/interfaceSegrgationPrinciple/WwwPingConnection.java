package oopconcepts.interfaceSegrgationPrinciple;
/*
 * ketnakhalasi created on 7/13/21
 * */

public class WwwPingConnection implements HttpConnection {

    private final String www;

    public WwwPingConnection(String www) {
        this.www = www;
    }

    @Override
    public void http() {
        System.out.println("Set up a HTTP Connection to " + www);
    }

    @Override
    public void connect() {
        System.out.println("Connect to " + www);
    }
}
