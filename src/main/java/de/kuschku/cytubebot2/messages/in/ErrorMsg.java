package de.kuschku.cytubebot2.messages.in;

import com.fasterxml.jackson.annotation.JsonProperty;
import de.kuschku.cytubebot2.messages.CytubeEvent;
import org.springframework.core.style.ToStringCreator;

@CytubeEvent(name = "errorMsg", direction = CytubeEvent.Direction.IN)
public class ErrorMsg {
    @JsonProperty("alert")
    private boolean alert;

    @JsonProperty("message")
    private String message;

    public boolean isAlert() {
        return alert;
    }

    public void setAlert(boolean alert) {
        this.alert = alert;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return new ToStringCreator(this)
                .append("alert", alert)
                .append("message", message)
                .toString();
    }
}
