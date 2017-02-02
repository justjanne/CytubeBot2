package de.kuschku.cytubebot2.messages.in;

import com.fasterxml.jackson.annotation.JsonProperty;
import de.kuschku.cytubebot2.messages.CytubeEvent;
import org.springframework.core.style.ToStringCreator;

@CytubeEvent(name = "channelCSSJS", direction = CytubeEvent.Direction.IN)
public class ChannelCssJs {
    @JsonProperty("css")
    private String css;

    @JsonProperty("js")
    private String js;

    public String getCss() {
        return css;
    }

    public void setCss(String css) {
        this.css = css;
    }

    public String getJs() {
        return js;
    }

    public void setJs(String js) {
        this.js = js;
    }

    @Override
    public String toString() {
        return new ToStringCreator(this)
                .append("css", css)
                .append("js", js)
                .toString();
    }
}
