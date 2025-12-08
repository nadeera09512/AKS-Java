package com.example.demo.controller;

import java.net.InetAddress;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoAPIController {
	
	@GetMapping("/sysinfo")
	public String printHostNameAndIpAddress() {
		
		Sysinfo info=new Sysinfo();
		
        try {
            InetAddress localHost = InetAddress.getLocalHost();
            String hostName = localHost.getHostName();
            String ipAddress = localHost.getHostAddress();

            info.setHostname(hostName);
            info.setIP_addr(ipAddress);
            
        } catch (Exception e) {
            System.err.println("Unable to determine the hostname and IP address.");
            e.printStackTrace();
        }

	System.out.println(info.toString());
        return info.toString();
    	}
	
	@GetMapping("/")
	public String welcome() {

		System.out.println("Called the Welcome Endpoint ... !!!");
		return "Hi from Welcome Endpoint !!!";
	}

	@GetMapping("/error")
    	public String generateError() {
        	throw new RuntimeException("Deliberate exception triggered for /error endpoint.");
    	}
}
