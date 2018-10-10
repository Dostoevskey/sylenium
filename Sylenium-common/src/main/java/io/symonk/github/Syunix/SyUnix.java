package io.symonk.github.Syunix;

import com.google.inject.Inject;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import io.github.symonk.configurations.properties.SyleniumProperties;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SyUnix {

    private static final JSch jsch = new JSch();
    private SyleniumProperties properties;
    private Session session;

    @Inject
    public SyUnix(final SyleniumProperties properties) {
        this.properties = properties;
    }

    private void configureSession() {
        try {
            session = jsch.getSession(properties.unixUsername(), properties.unixHost(), properties.unixPort());
            session.setPassword(properties.unixPassword());
            session.connect();
        }catch(final JSchException exception) {
            log.error("Unable to establish a session because: {}", exception);
        }
    }

    private void establishConnection() {
        if(session.isConnected()) return;
        configureSession();
    }






}
