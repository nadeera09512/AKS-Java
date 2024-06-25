package com.example.demo.controller;

import java.net.InetAddress;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoAPIController {
	
	@GetMapping("/sysinfo")
	public Sysinfo printHostNameAndIpAddress() {
		
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
        
        return info;
    }
	
	@GetMapping("/")
	public String welcome() {
		return "Welcome!!!";
	}
}
