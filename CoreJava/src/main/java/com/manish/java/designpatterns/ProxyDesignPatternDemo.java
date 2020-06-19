package com.manish.java.designpatterns;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/**
 * @author Manish
 *
 */

interface Internet {
	
	public void connectToServer(String serverHost);
}

class RealInternet implements Internet {
	
	
	

	@Override
	public void connectToServer(String serverHost) {
		System.out.println("Connecting to...... "+serverHost);
		
	}
}

class ProxyInternet implements Internet {

	List<String> proxySites = new ArrayList<>();
	
	public void addProxy(String proxySite) {
		proxySites.add(proxySite);
	}
	
	
	@Override
	public void connectToServer(String serverHost) {
		if(proxySites.contains(serverHost)) {
			System.out.println("Access Denied");
		} else {
			System.out.println("Connecting to....."+serverHost);
		}
		
	}
	
}
public class ProxyDesignPatternDemo {
	public static void main(String[] args) {
		TreeSet<String> treeeSet = new TreeSet<>();
		treeeSet.add(null);
		
		RealInternet realInternet = new RealInternet();
		realInternet.connectToServer("localhost");
		ProxyInternet proxyInternet = new ProxyInternet();
		proxyInternet.addProxy("iConsole");
		proxyInternet.connectToServer("iConsole");
	}

}
