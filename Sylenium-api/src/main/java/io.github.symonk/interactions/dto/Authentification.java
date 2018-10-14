package io.github.symonk.interactions.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.slf4j.Logger;

public class Authentification {

    private static final Logger log = org.slf4j.LoggerFactory.getLogger(Authentification.class);
    @JsonProperty
    private final String username;
    @JsonProperty
    private final String password;

    @java.beans.ConstructorProperties({"username", "password"})
    Authentification(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public static AuthentificationBuilder builder() {
        return new AuthentificationBuilder();
    }

    public static class AuthentificationBuilder {
        private String username;
        private String password;

        AuthentificationBuilder() {
        }

        public Authentification.AuthentificationBuilder username(String username) {
            this.username = username;
            return this;
        }

        public Authentification.AuthentificationBuilder password(String password) {
            this.password = password;
            return this;
        }

        public Authentification build() {
            return new Authentification(username, password);
        }

        public String toString() {
            return "Authentification.AuthentificationBuilder(username=" + this.username + ", password=" + this.password + ")";
        }
    }
}
