package de.kuschku.cytubebot2.messages.in;

import com.fasterxml.jackson.annotation.JsonProperty;
import de.kuschku.cytubebot2.messages.CytubeEvent;
import org.springframework.core.style.ToStringCreator;

@CytubeEvent(name = "channelOpts", direction = CytubeEvent.Direction.IN)
public class ChannelOpts {
    @JsonProperty("maxlength")
    private int maxlength;

    @JsonProperty("chat_antiflood")
    private boolean chat_antiflood;

    @JsonProperty("torbanned")
    private boolean torbanned;

    @JsonProperty("playlist_max_per_user")
    private int playlist_max_per_user;

    @JsonProperty("new_user_chat_delay")
    private int new_user_chat_delay;

    @JsonProperty("allow_dupes")
    private boolean allow_dupes;

    @JsonProperty("chat_antiflood_params")
    private AntiFloodParams chat_antiflood_params;

    @JsonProperty("afk_timeout")
    private int afk_timeout;

    @JsonProperty("enable_link_regex")
    private boolean enable_link_regex;

    @JsonProperty("password")
    private boolean password;

    @JsonProperty("allow_ascii_control")
    private boolean allow_ascii_control;

    @JsonProperty("allow_voteskip")
    private boolean allow_voteskip;

    @JsonProperty("voteskip_ratio")
    private int voteskip_ratio;

    @JsonProperty("pagetitle")
    private String pagetitle;

    @JsonProperty("externaljs")
    private String externaljs;

    @JsonProperty("show_public")
    private boolean show_public;

    @JsonProperty("new_user_chat_link_delay")
    private int new_user_chat_link_delay;

    @JsonProperty("externalcss")
    private String externalcss;

    public int getMaxlength() {
        return maxlength;
    }

    public void setMaxlength(int maxlength) {
        this.maxlength = maxlength;
    }

    public boolean isChat_antiflood() {
        return chat_antiflood;
    }

    public void setChat_antiflood(boolean chat_antiflood) {
        this.chat_antiflood = chat_antiflood;
    }

    public boolean isTorbanned() {
        return torbanned;
    }

    public void setTorbanned(boolean torbanned) {
        this.torbanned = torbanned;
    }

    public int getPlaylist_max_per_user() {
        return playlist_max_per_user;
    }

    public void setPlaylist_max_per_user(int playlist_max_per_user) {
        this.playlist_max_per_user = playlist_max_per_user;
    }

    public int getNew_user_chat_delay() {
        return new_user_chat_delay;
    }

    public void setNew_user_chat_delay(int new_user_chat_delay) {
        this.new_user_chat_delay = new_user_chat_delay;
    }

    public boolean isAllow_dupes() {
        return allow_dupes;
    }

    public void setAllow_dupes(boolean allow_dupes) {
        this.allow_dupes = allow_dupes;
    }

    public AntiFloodParams getChat_antiflood_params() {
        return chat_antiflood_params;
    }

    public void setChat_antiflood_params(AntiFloodParams chat_antiflood_params) {
        this.chat_antiflood_params = chat_antiflood_params;
    }

    public int getAfk_timeout() {
        return afk_timeout;
    }

    public void setAfk_timeout(int afk_timeout) {
        this.afk_timeout = afk_timeout;
    }

    public boolean isEnable_link_regex() {
        return enable_link_regex;
    }

    public void setEnable_link_regex(boolean enable_link_regex) {
        this.enable_link_regex = enable_link_regex;
    }

    public boolean isPassword() {
        return password;
    }

    public void setPassword(boolean password) {
        this.password = password;
    }

    public boolean isAllow_ascii_control() {
        return allow_ascii_control;
    }

    public void setAllow_ascii_control(boolean allow_ascii_control) {
        this.allow_ascii_control = allow_ascii_control;
    }

    public boolean isAllow_voteskip() {
        return allow_voteskip;
    }

    public void setAllow_voteskip(boolean allow_voteskip) {
        this.allow_voteskip = allow_voteskip;
    }

    public int getVoteskip_ratio() {
        return voteskip_ratio;
    }

    public void setVoteskip_ratio(int voteskip_ratio) {
        this.voteskip_ratio = voteskip_ratio;
    }

    public String getPagetitle() {
        return pagetitle;
    }

    public void setPagetitle(String pagetitle) {
        this.pagetitle = pagetitle;
    }

    public String getExternaljs() {
        return externaljs;
    }

    public void setExternaljs(String externaljs) {
        this.externaljs = externaljs;
    }

    public boolean isShow_public() {
        return show_public;
    }

    public void setShow_public(boolean show_public) {
        this.show_public = show_public;
    }

    public int getNew_user_chat_link_delay() {
        return new_user_chat_link_delay;
    }

    public void setNew_user_chat_link_delay(int new_user_chat_link_delay) {
        this.new_user_chat_link_delay = new_user_chat_link_delay;
    }

    public String getExternalcss() {
        return externalcss;
    }

    public void setExternalcss(String externalcss) {
        this.externalcss = externalcss;
    }

    @Override
    public String toString() {
        return new ToStringCreator(this)
                .append("maxlength", maxlength)
                .append("chat_antiflood", chat_antiflood)
                .append("torbanned", torbanned)
                .append("playlist_max_per_user", playlist_max_per_user)
                .append("new_user_chat_delay", new_user_chat_delay)
                .append("allow_dupes", allow_dupes)
                .append("chat_antiflood_params", chat_antiflood_params)
                .append("afk_timeout", afk_timeout)
                .append("enable_link_regex", enable_link_regex)
                .append("password", password)
                .append("allow_ascii_control", allow_ascii_control)
                .append("allow_voteskip", allow_voteskip)
                .append("voteskip_ratio", voteskip_ratio)
                .append("pagetitle", pagetitle)
                .append("externaljs", externaljs)
                .append("show_public", show_public)
                .append("new_user_chat_link_delay", new_user_chat_link_delay)
                .append("externalcss", externalcss)
                .toString();
    }

    public class AntiFloodParams {
        @JsonProperty("cooldown")
        private int cooldown;

        @JsonProperty("burst")
        private int burst;

        @JsonProperty("sustained")
        private int sustained;

        public int getCooldown() {
            return cooldown;
        }

        public void setCooldown(int cooldown) {
            this.cooldown = cooldown;
        }

        public int getBurst() {
            return burst;
        }

        public void setBurst(int burst) {
            this.burst = burst;
        }

        public int getSustained() {
            return sustained;
        }

        public void setSustained(int sustained) {
            this.sustained = sustained;
        }

        @Override
        public String toString() {
            return new ToStringCreator(this)
                    .append("cooldown", cooldown)
                    .append("burst", burst)
                    .append("sustained", sustained)
                    .toString();
        }
    }
}
