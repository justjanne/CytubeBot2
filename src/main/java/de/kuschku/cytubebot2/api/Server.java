package de.kuschku.cytubebot2.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Server {
    @JsonProperty("url")
    private String url;

    @JsonProperty("secure")
    private boolean secure;

    public String getUrl() {
        return url;
    }

    public boolean isSecure() {
        return secure;
    }

    @Override
    public String toString() {
        return "Server{" +
                "url='" + url + '\'' +
                ", secure=" + secure +
                '}';
    }
}
