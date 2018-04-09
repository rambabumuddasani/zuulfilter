package com.example.resources.resource_app;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class ResourceController {

	@RequestMapping(value = "/foo", method=GET)
	public String foo() {
		return "foo from " + getClass().getSimpleName();
	}

	@RequestMapping(value = "/foo", method=POST)
	public String foo(@RequestBody String body) {
		return "foo recieved: " + body;
	}

	@RequestMapping(value = "/hello", method=GET)
	public String hello() {
		return "hello from " + getClass().getSimpleName();
	}
}
