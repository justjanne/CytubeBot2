package de.kuschku.cytubebot2;

import com.github.nkzawa.socketio.client.IO;

public class SocketConfiguration {
    public final String url;
    public final IO.Options options;

    public SocketConfiguration(String url, IO.Options options) {
        this.url = url;
        this.options = options;
    }
}
