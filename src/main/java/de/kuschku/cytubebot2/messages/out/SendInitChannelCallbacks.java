package de.kuschku.cytubebot2.messages.out;

import de.kuschku.cytubebot2.messages.CytubeEvent;
import org.springframework.core.style.ToStringCreator;

@CytubeEvent(name = "initChannelCallbacks", direction = CytubeEvent.Direction.OUT)
public class SendInitChannelCallbacks {
    @Override
    public String toString() {
        return new ToStringCreator(this)
                .toString();
    }
}
