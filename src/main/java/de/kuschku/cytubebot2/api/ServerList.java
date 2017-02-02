package de.kuschku.cytubebot2.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ServerList {
    @JsonProperty("servers")
    private List<Server> servers;

    public List<Server> getServers() {
        return servers;
    }

    @Override
    public String toString() {
        return "ServerList{" +
                "servers=" + servers +
                '}';
    }
}
