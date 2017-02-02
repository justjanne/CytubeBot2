package de.kuschku.cytubebot2.messages.in;

import com.fasterxml.jackson.annotation.JsonProperty;
import de.kuschku.cytubebot2.messages.CytubeEvent;
import org.springframework.core.style.ToStringCreator;

@CytubeEvent(name = "login", direction = CytubeEvent.Direction.IN)
public class Login {
    @JsonProperty("success")
    private boolean success;

    @JsonProperty("name")
    private String name;

    @JsonProperty("guest")
    private boolean guest;

    @JsonProperty("error")
    private String error;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isGuest() {
        return guest;
    }

    public void setGuest(boolean guest) {
        this.guest = guest;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    @Override
    public String toString() {
        return new ToStringCreator(this)
                .append("success", success)
                .append("name", name)
                .append("guest", guest)
                .append("error", error)
                .toString();
    }
}
