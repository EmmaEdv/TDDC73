package com.example.emmaedv.tddc73_lab3;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by emmaedv on 09/12/14.
 */
public class ourHttpURLConnection extends HttpURLConnection {
    protected ourHttpURLConnection(URL url) {
        super(url);
    }

    @Override
    public void disconnect() {

    }

    @Override
    public boolean usingProxy() {
        return false;
    }

    @Override
    public void connect() throws IOException {

    }
}
