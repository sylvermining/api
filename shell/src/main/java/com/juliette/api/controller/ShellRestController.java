package com.juliette.api.controller;

import com.juliette.api.service.BackupService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class ShellRestController {

    private static final Logger LOG = Logger.getLogger(ShellRestController.class);

    private BackupService backupService;

    @Autowired
    public ShellRestController(BackupService backupService) {
        this.backupService = backupService;
    }

    @RequestMapping(value = "/backup/{name}", method = GET)
    public String helloWorld(@PathVariable("name") String name) throws Exception {
        LOG.info(String.format(">>> init backup <<<"));

        backupService.backupExample(name);

        LOG.info(String.format(">>> end backup <<<"));
        return "go";
    }

}
