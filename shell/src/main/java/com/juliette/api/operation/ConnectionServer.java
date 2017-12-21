package com.juliette.api.operation;

import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import com.juliette.api.transactional.Constant;
import com.juliette.api.transactional.Property;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import javax.security.auth.login.Configuration;
import java.io.BufferedReader;
import java.io.InputStreamReader;

@Repository
public class ConnectionServer {

    private static final Logger LOG = Logger.getLogger(ConnectionServer.class);

    private Property property;

    @Autowired
    public ConnectionServer(Property property) {
        this.property = property;
    }

    public void executeBackup(String name) throws Exception {

        StringBuffer output =  new StringBuffer();

        JSch jsch = new JSch();

        jsch.addIdentity(property.path);
        jsch.setConfig("StrictHostKeyChecking", "no");

        Session session = jsch.getSession(property.usuario,
                property.host,
                property.port);

        session.connect();

        ChannelExec exec = (ChannelExec)session.openChannel("exec");

        exec.setCommand("sh bdzum_newdev.sh");
        
        exec.connect();

        BufferedReader readerRemote = new BufferedReader(new InputStreamReader(exec.getInputStream()));

        String lineRemote;

        while((lineRemote = readerRemote.readLine()) != null) {
            output.append(lineRemote + "\n");
        }

        exec.disconnect();

        session.disconnect();

        LOG.info(String.format("output = %s", output.toString()));
    }

    public void executeSync() {

    }
}
