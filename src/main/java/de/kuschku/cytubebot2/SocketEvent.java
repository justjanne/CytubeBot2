package de.kuschku.cytubebot2;

import org.springframework.core.style.ToStringCreator;

// TODO: Remove
class SocketEvent {
    public final String event;
    public final Object[] args;

    public SocketEvent(String event, Object[] args) {
        this.event = event;
        this.args = args;
    }

    @Override
    public String toString() {
        return new ToStringCreator(this)
                .append("event", event)
                .append("args", args)
                .toString();
    }
}
