package com.workspace;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Server server = new Server(5000);
        Thread.sleep(10000);
        Client client = new Client("127.0.0.1", 5000);
    }
}
