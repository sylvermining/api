package com.juliette.api.operation;


import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Shell {

    public static void main(String args[]) {

        StringBuffer output =  new StringBuffer();

        try {

            JSch jsch = new JSch();

            jsch.addIdentity("");
            jsch.setConfig("StrictHostKeyChecking", "no");
            String user = "";
            String host = "";

            Session session=jsch.getSession(user, host, 22);
            session.connect();

            String command = "ls -ltr";

            ChannelExec exec = (ChannelExec)session.openChannel("exec");
            exec.setCommand(command);
            exec.connect();

            BufferedReader readerRemote = new BufferedReader(new InputStreamReader(exec.getInputStream()));

            String lineRemote;

            while((lineRemote = readerRemote.readLine()) != null) {
                output.append(lineRemote + "\n");
            }

            exec.disconnect();
            session.disconnect();


            Process process =  Runtime.getRuntime().exec("ls -ltr");
            process.waitFor();

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            String line;

            while((line = reader.readLine()) != null) {
                output.append(line + "\n");
            }
        } catch(IOException | InterruptedException uu) {
           uu.printStackTrace();
        } catch(JSchException uu) {
            uu.printStackTrace();
        }
        System.out.printf("output>>" + output.toString());

    }
}
