package com.ourd.frontController;

import java.util.HashMap;

import com.ourd.controller.belong.InviteWeController;
import com.ourd.controller.belong.JoinWeController;
import com.ourd.controller.club.ClubInsertController;
import com.ourd.controller.club.MakeWeController;
import com.ourd.controller.club.SearchWeAjax;
import com.ourd.controller.club.ValidWeAjax;
import com.ourd.controller.club.WeController;
import com.ourd.controller.main.MainController;
import com.ourd.controller.message.AgreeMsg;
import com.ourd.controller.message.CheckInviteMsg;
import com.ourd.controller.message.CheckMsg;
import com.ourd.controller.message.DisagreeMsg;
import com.ourd.controller.message.MessageController;
import com.ourd.controller.message.MoveSendPage;
import com.ourd.controller.message.MoveTakePage;
import com.ourd.controller.message.RemoveMsg;
import com.ourd.controller.message.SendJoinMsg;
import com.ourd.controller.user.JoinController;
import com.ourd.controller.user.LoginController;
import com.ourd.controller.user.SearchUserAjax;
import com.ourd.controller.user.UserInfoController;
import com.ourd.controller.user.UserJoinController;
import com.ourd.controller.user.UserLoginController;
import com.ourd.controller.user.UserLogoutController;
import com.ourd.controller.user.UserUpdateController;
import com.ourd.controller.user.ValidIdAjax;
import com.ourd.controller.user.ValidNicknameAjax;
import com.ourd.controller.view.DiaryViewerController;
import com.ourd.controller.view.GetDiaryList;
import com.ourd.controller.view.MovepostDiaryList;
import com.ourd.controller.view.MovepreDiaryList;
import com.ourd.controller.view.RemoveDiary;
import com.ourd.controller.write.DiaryImgUploadAjax;
import com.ourd.controller.write.DiaryWriteController;
import com.ourd.controller.write.InsertDiary;

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
		mappings.put("/gomessage.do",new MessageController());
		mappings.put("/godiarywrite.do",new DiaryWriteController());
		mappings.put("/godiaryviewer.do",new DiaryViewerController());
		
		
		//belong 처리 mappings
		
		//club 처리 mappings
		mappings.put("/makewe.do",new ClubInsertController());
		mappings.put("/validweajax.do", new ValidWeAjax());
		mappings.put("/searchweajax.do", new SearchWeAjax());
		
		//comment 처리 mappings
		
		//diary 처리 mappings
		mappings.put("/uploadDiaryImg.do", new DiaryImgUploadAjax());
		mappings.put("/adddiary.do", new InsertDiary());
		mappings.put("/getdiarylistbywe.do", new GetDiaryList());
		mappings.put("/movediarypagepre.do", new MovepreDiaryList());
		mappings.put("/movediarypagepost.do", new MovepostDiaryList());
		mappings.put("/removediary.do", new RemoveDiary());
		
		
		//message 처리 mappings
		mappings.put("/sendjoinmsg.do", new SendJoinMsg());
		mappings.put("/checkmsg.do", new CheckMsg());
		mappings.put("/checkinvitemsg.do", new CheckInviteMsg());
		mappings.put("/movesendpage.do", new MoveSendPage());
		mappings.put("/movetakepage.do", new MoveTakePage());
		mappings.put("/agreemsg.do", new AgreeMsg());
		mappings.put("/disagreemsg.do", new DisagreeMsg());
		mappings.put("/removemsg.do", new RemoveMsg());
		
		//user 처리 mappings
		mappings.put("/valididajax.do", new ValidIdAjax());
		mappings.put("/validnicknameajax.do", new ValidNicknameAjax());
		mappings.put("/userjoin.do", new UserJoinController());
		mappings.put("/userlogin.do", new UserLoginController());
		mappings.put("/userlogout.do", new UserLogoutController());
		mappings.put("/myinfo.do", new UserInfoController());
		mappings.put("/userupdate.do", new UserUpdateController());
		mappings.put("/searchuserajax.do", new SearchUserAjax());
		
	}
	
	
	
	public Controller getController(String key) {
		return mappings.get(key);
	}
}
