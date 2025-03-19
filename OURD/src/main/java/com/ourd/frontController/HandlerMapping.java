package com.ourd.frontController;

import java.util.HashMap;

import com.ourd.controller.belong.InviteWeController;
import com.ourd.controller.belong.JoinWeController;
import com.ourd.controller.club.ClubInsertController;
import com.ourd.controller.club.MakeWeController;
import com.ourd.controller.club.ValidWeAjax;
import com.ourd.controller.club.WeController;
import com.ourd.controller.main.MainController;
import com.ourd.controller.user.JoinController;
import com.ourd.controller.user.LoginController;
import com.ourd.controller.user.UserInfoController;
import com.ourd.controller.user.UserJoinController;
import com.ourd.controller.user.UserLoginController;
import com.ourd.controller.user.UserLogoutController;
import com.ourd.controller.user.UserUpdateController;
import com.ourd.controller.user.ValidIdAjax;
import com.ourd.controller.user.ValidNicknameAjax;

public class HandlerMapping {
	private HashMap<String, Controller> mappings;
	
	public HandlerMapping() {
		mappings = new HashMap<String, Controller>();
		
		// 페이지 이동 mappings
		mappings.put("/main.do",new MainController());
		mappings.put("/gologin.do",new LoginController());
		mappings.put("/gojoin.do",new JoinController());
		mappings.put("/gowe.do",new WeController());
		mappings.put("/gomakewe.do",new MakeWeController());
		mappings.put("/gojoinwe.do",new JoinWeController());
		mappings.put("/goinvitewe.do",new InviteWeController());
		
		
		//belong 처리 mappings
		
		//club 처리 mappings
		mappings.put("/makewe.do",new ClubInsertController());
		mappings.put("/validweajax.do", new ValidWeAjax());
		
		//comment 처리 mappings
		
		//diary 처리 mappings
		
		//message 처리 mappings
		
		//user 처리 mappings
		mappings.put("/valididajax.do", new ValidIdAjax());
		mappings.put("/validnicknameajax.do", new ValidNicknameAjax());
		mappings.put("/userjoin.do", new UserJoinController());
		mappings.put("/userlogin.do", new UserLoginController());
		mappings.put("/userlogout.do", new UserLogoutController());
		mappings.put("/myinfo.do", new UserInfoController());
		mappings.put("/userupdate.do", new UserUpdateController());
		
	}
	
	
	
	public Controller getController(String key) {
		return mappings.get(key);
	}
}
