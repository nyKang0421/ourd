weUserCheckDo=false;

const userFind = document.getElementById("findUser");
userFind.addEventListener("keyup", ()=>{
	let findValue = userFind.value;
	if(checkfindlength(findValue) === true){
		weUserCheckDo = true;
		userFind.style.border='4px solid rgb(92,51,92)';
	}else{
		weUserCheckDo = false;
		userFind.style.border='4px solid crimson';
	}
	if(findValue.length == 0){
		userFind.style.border='4px solid rgb(163,204,163)';
	}
})

function checkfindlength(findValue){
	return findValue.length!=0 &&findValue.length<=25;
}

let clubNum = document.getElementById("slectClub");

clubNum.addEventListener("change",()=>{
	clubNum.style.border='4px solid rgb(92,51,92)';
	if(clubNum.value == -1){
		clubNum.style.border='4px solid rgb(163,204,163)';
	}
})


async function searchUser(){
	console.log(clubNum.value)
	if(clubNum.value == -1){
		alert("초대할 우리를 선택해 주세요")
		return;
	}
	if(!weUserCheckDo){
		alert("검색할 이름이 유효하지 않습니다.")
		return;
	}
	
	let findValue = userFind.value;
	let infodata = findValue+"/"+clubNum.value;
	
	if(findValue == document.getElementById("logUser").value){
		alert("본인을 초대 할 수 없습니다.")
		return;
	}
	
	try{
			const response = await fetch('searchuserajax.do',{
				method: "post",
				headers: {
					'Content-Type': 'application/x-www-form-urlencoded; charset=utf-8',
				},
				body: new URLSearchParams({infodata}).toString(),
			});
			
			if(!response.ok){
				throw new Error(`HTTP error! status: ${response.status}`);
			}
			const result = await response.text();
			handleSearchUserResult(result);
			
		}catch(error){
			console.error("searchuserajax.do:", error);
			alert('초대자 확인 중 오류가 발생했습니다');
		}
	
}

function handleSearchUserResult(result){
	switch(result){
		case 'exist':
			break;
		case 'notexist':
			break;
		default:
			alert('예상치 못한 응답입니다')
	}
	// 모달 활성화 하기
	
	activeWeModal();
}

function checkModalView(){
	let modalstate = sessionStorage.getItem('modalon');
	console.log(modalstate);
	if(modalstate == 'on'){
		document.querySelector('.modal').classList.add('active');
		document.querySelector('.overlay').classList.add('active');
	}
}
checkModalView()

function activeWeModal(){
	// 모달 활성화 하기
	sessionStorage.setItem('modalon','on');
	location.reload(true);
}

function NonActiveWeModal(){
	document.querySelector(".joinweform").addEventListener("submit",function(event){
			event.preventDefault();
	})
	// 모달 비활성화 하기
	sessionStorage.removeItem('modalon');
	history.go(0);
}

function sendinviteMsg(form){
	document.querySelector(".joinweform").addEventListener("submit",function(event){
		event.preventDefault();
	})
	// 이미 가입된 멤버인 경우 처리
	
	let msginfo ={
		num: null,
		club: document.getElementById('joinClubNum').value,
		send: document.getElementById('joinSender').value,
		take: document.getElementById('joinTaker').value,
		state: '1'
	}
	
	fetch("checkinvitemsg.do", {
	      method: "POST",
	      headers: {
	        "Content-Type": "application/json"
	      },
	      body: JSON.stringify(msginfo)
	    })
	    .then(response => response.json())
	    .then(data => {
			console.log("data:",data);
	      if (data == 0) {
	        //메시지 없을 때
			alert("우리하기 요청 성공");
			form.submit();
	      }else if(data == -1){
			// 이미 가입된 멤버인 경우 처리
			alert("이미 함께하고 있는 멤버에요");
			return;
		  }	else{
			//메세지 있을 때
			//let ctx = window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));
			alert("이미 요청한 메세지가 있어요");
			return;
			//location.href=ctx+"/gojoinwe.do";
			}
			sessionStorage.removeItem('modalon');
	    })
	    .catch(error => console.error('Error:', error));
	
}

