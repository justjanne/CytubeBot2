package de.kuschku.cytubebot2.messages.in;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import de.kuschku.cytubebot2.messages.CytubeEvent;
import de.kuschku.cytubebot2.messages.elements.PlaylistElement;
import org.springframework.core.style.ToStringCreator;

import java.util.List;

@CytubeEvent(name = "playlist", direction = CytubeEvent.Direction.IN)
public class Playlist {
    private List<PlaylistElement> elements;

    @JsonCreator
    public Playlist(List<PlaylistElement> elements) {
        this.elements = elements;
    }

    @JsonValue
    public List<PlaylistElement> getElements() {
        return elements;
    }

    public void setElements(List<PlaylistElement> elements) {
        this.elements = elements;
    }

    @Override
    public String toString() {
        return new ToStringCreator(this)
                .append("elements", elements)
                .toString();
    }
}
