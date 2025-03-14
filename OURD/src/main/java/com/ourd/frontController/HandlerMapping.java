package com.ourd.frontController;

import java.util.HashMap;

import com.ourd.controller.main.MainController;
import com.ourd.controller.user.JoinController;
import com.ourd.controller.user.LoginController;
import com.ourd.controller.user.ValidIdAjax;

public class HandlerMapping {
	private HashMap<String, Controller> mappings;
	
	public HandlerMapping() {
		mappings = new HashMap<String, Controller>();
		
		// 페이지 이동 mappings
		mappings.put("/main.do",new MainController());
		mappings.put("/gologin.do",new LoginController());
		mappings.put("/gojoin.do",new JoinController());
		
		//belong 처리 mappings
		
		//club 처리 mappings
		
		//comment 처리 mappings
		
		//diary 처리 mappings
		
		//message 처리 mappings
		
		//user 처리 mappings
		mappings.put("/valididajax.do", new ValidIdAjax());
	}
	
	
	
	public Controller getController(String key) {
		return mappings.get(key);
	}
}
