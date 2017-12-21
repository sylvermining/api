package com.juliette.api.controller;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ManagerRestController {

    private static final Logger LOG = Logger.getLogger(ManagerRestController.class);

    @ExceptionHandler({Exception.class})
    public void handleException() {
        LOG.info(String.format(">>> init handle exception <<<"));
    }
}
