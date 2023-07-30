package com.aws.demo.controller;

import com.aws.demo.service.AWSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AWSController {

@Autowired
AWSService service;
//create function respectievi to the aws service class
}
