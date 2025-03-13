package com.ourd.frontController;

import java.util.HashMap;

import com.ourd.controller.user.MainController;

public class HandlerMapping {
	private HashMap<String, Controller> mappings;
	
	public HandlerMapping() {
		mappings = new HashMap<String, Controller>();
		
		// 페이지 이동 mappings
		mappings.put("/main.do",new MainController());
		
		//belong 처리 mappings
		
		//club 처리 mappings
		
		//comment 처리 mappings
		
		//diary 처리 mappings
		
		//message 처리 mappings
		
		//user 처리 mappings
	}
	
	
	
	public Controller getController(String key) {
		return mappings.get(key);
	}
}
