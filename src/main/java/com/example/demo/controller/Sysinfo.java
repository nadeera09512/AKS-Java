package com.example.demo.controller;

public class Sysinfo {

	private String Hostname;
	private String IP_addr;
	
	public String getHostname() {
		return Hostname;
	}
	public void setHostname(String hostname) {
		Hostname = hostname;
	}
	public String getIP_addr() {
		return IP_addr;
	}
	public void setIP_addr(String iP_addr) {
		IP_addr = iP_addr;
	}

	@Override
    	public String toString() {
        return "Sysinfo {" +
                "Hostname='" + Hostname + '\'' +
                ", IP_addr='" + IP_addr + '\'' +
                '}';
    }
	
}
