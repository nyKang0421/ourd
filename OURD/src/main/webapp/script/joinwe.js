weNameCheckDo= false;

const weFind = document.getElementById("findClub");
weFind.addEventListener("keyup", ()=>{
	let findValue = weFind.value;
	if(checkfindlength(findValue) === true){
		weNameCheckDo = true;
		weFind.style.border='4px solid rgb(92,51,92)';
	}else{
		weNameCheckDo = false;
		weFind.style.border='4px solid crimson';
	}
	if(findValue.length == 0){
		weFind.style.border='4px solid rgb(163,204,163)';
	}
})

function checkfindlength(findValue){
	return findValue.length!=0 &&findValue.length<=20;
}

async function serchClub(){
	if(!weNameCheckDo){
		alert("검색할 우리 이름이 유효하지 않습니다.")
		return;
	}
	
	let findValue = weFind.value;
	
	try{
			const response = await fetch('searchweajax.do',{
				method: "post",
				headers: {
					'Content-Type': 'application/x-www-form-urlencoded; charset=utf-8',
				},
				body: new URLSearchParams({findValue}).toString(),
			});
			
			if(!response.ok){
				throw new Error(`HTTP error! status: ${response.status}`);
			}
			const result = await response.text();
			handleSearchWeResult(result);
			
		}catch(error){
			console.error("searchweajax.do:", error);
			alert('우리 확인 중 오류가 발생했습니다');
		}
	
}

function handleSearchWeResult(result){
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


function activeWeModal(){
	// 모달 활성화 하기
}

function NonActiveWeModal(){
	// 모달 비활성화 하기
}

let ischecksubmit = false;

function sendJoinMsg(form){
	document.querySelector(".joinweform").addEventListener("submit",function(event){
		event.preventDefault();
		console.log('preventSubmit');
	})
	if(document.getElementById('joinTaker').value === document.getElementById('joinSender').value){
		alert("본인이 모임장인 우리에는 신청할 수 없습니다.")
		return;
	}
	
	let msginfo ={
		num: null,
		club: document.getElementById('joinClubNum').value,
		send: document.getElementById('joinSender').value,
		take: document.getElementById('joinTaker').value,
		state: '0'
	}
	
	fetch("checkmsg.do", {
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
			ischecksubmit = true;
			subform(form);
	      }else{
			//메세지 있을 때
			//let ctx = window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));
			alert("이미 요청한 메세지가 있어요");
			return;
			//location.href=ctx+"/gojoinwe.do";
		  }
	    })
	    .catch(error => console.error('Error:', error));
	
}

function subform(form){
	console.log(ischecksubmit);
	if(!ischecksubmit){
		return;
	}
	form.submit();
}


