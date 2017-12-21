package com.juliette.api.transactional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
public class Property {

    @Value("${microserver.backup.user}")
    public String usuario;

    @Value("${microserver.backup.host}")
    public String host;

    @Value("${microserver.backup.port}")
    public Integer port;

    @Value("${microserver.backup.path}")
    public String path;
}
