package de.kuschku.cytubebot2.messages.in;

import com.fasterxml.jackson.annotation.JsonProperty;
import de.kuschku.cytubebot2.messages.CytubeEvent;
import org.springframework.core.style.ToStringCreator;

@CytubeEvent(name = "chatMsg", direction = CytubeEvent.Direction.IN)
public class ChatMsg {
    @JsonProperty("msg")
    private String msg;

    @JsonProperty("username")
    private String username;

    @JsonProperty("time")
    private long time;

    @JsonProperty("meta")
    private Meta meta;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    @Override
    public String toString() {
        return new ToStringCreator(this)
                .append("msg", msg)
                .append("username", username)
                .append("time", time)
                .append("meta", meta)
                .toString();
    }

    public static class Meta {
        @JsonProperty("action")
        private boolean action;

        @JsonProperty("modflair")
        private int modflair;

        @JsonProperty("forceShowName")
        private boolean forceShowName;

        @JsonProperty("addClass")
        private String addClass;

        @JsonProperty("addClassToNameAndTimestamp")
        private String addClassToNameAndTimestamp;

        public boolean isAction() {
            return action;
        }

        public void setAction(boolean action) {
            this.action = action;
        }

        public int getModflair() {
            return modflair;
        }

        public void setModflair(int modflair) {
            this.modflair = modflair;
        }

        public boolean isForceShowName() {
            return forceShowName;
        }

        public void setForceShowName(boolean forceShowName) {
            this.forceShowName = forceShowName;
        }

        public String getAddClass() {
            return addClass;
        }

        public void setAddClass(String addClass) {
            this.addClass = addClass;
        }

        public String getAddClassToNameAndTimestamp() {
            return addClassToNameAndTimestamp;
        }

        public void setAddClassToNameAndTimestamp(String addClassToNameAndTimestamp) {
            this.addClassToNameAndTimestamp = addClassToNameAndTimestamp;
        }

        @Override
        public String toString() {
            return new ToStringCreator(this)
                    .append("action", action)
                    .append("forceShowName", forceShowName)
                    .append("modflair", modflair)
                    .append("addClass", addClass)
                    .append("addClassToNameAndTimestamp", addClassToNameAndTimestamp)
                    .toString();
        }
    }
}
