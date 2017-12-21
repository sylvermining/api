package com.juliette.api.service;

import com.juliette.api.operation.ConnectionServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BackupService {

    private ConnectionServer connectionServer;

    @Autowired
    public BackupService(ConnectionServer connectionServer) {
        this.connectionServer = connectionServer;
    }

    public void backupExample(String name) throws Exception{
        connectionServer.executeBackup(name);
    }
}
