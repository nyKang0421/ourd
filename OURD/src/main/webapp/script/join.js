//console.log("join.js 확인");

const birthinit = document.getElementById("birthChoice");
let today = new Date();
//console.log(today);
let baseday = new Date(new Date().setDate(new Date().getDate()-3653));
birthinit.max = today.toISOString().substring(0,10);
birthinit.value = baseday.toISOString().substring(0,10);
//birthinit.value = baseday.toISOString().substring(0,10);

const id = document.getElementById("inputId");
const nickname = document.getElementById("inputNickname");
let isCheckId = false;
let isCheckNickname = false;
let idCheckDo = false;

let nameCheckDo = false;
let birthCheckDo = false;
let pwCheckDo = false;
let pwDoubleCheckDo = false;
let emailCheckDo = false;
let nicknameCheckDo = false;
let telmiddleCheckDo = false;
let tellastCheckDo = false;

id.addEventListener("keyup",()=>{
	let idValue = id.value;
	if(checkidlength(idValue) === true && checkidtext(idValue) === true){
		idCheckDo = true;
		id.style.border='3px solid green';
	}else{
		idCheckDo = false;
		id.style.border='3px solid crimson';
	}
})

function checkidlength(id){
	return id.length >=4 && id.length<=12;
}
function checkidtext(id){
	return /^[A-Za-z0-9][A-Za-z0-9]*$/.test(id);
}

const pw = document.getElementById('inputPw');
const pwRe = document.getElementById('inputPw-retype');

function pwTextCheck(){
	//console.log(pw.value)
	return /^(?=.*[A-Za-z])(?=.*\d)(?=.*[@$!%*#?&])[A-Za-z\d@$!%*#?&]{8,}$/.test(pw.value);
}

function pwDoubleCheck(){
	return pw.value === pwRe.value
}

pw.addEventListener("keyup", ()=>{
	if(pwTextCheck()){
		pw.style.border="3px solid green";
		pwCheckDo = true;
	}else{
		pw.style.border="3px solid crimson";
		pwCheckDo = false;
	}
})
pwRe.addEventListener("keyup", ()=>{
	if(pwDoubleCheck()){
		pwRe.style.border="3px solid green";
		pwDoubleCheckDo = true;
	}else{
		pwRe.style.border="3px solid crimson";
		pwDoubleCheckDo = false;
	}
})

const email = document.getElementById('inputEmail');

email.addEventListener("keyup", ()=>{
	if(emailCheck()){
		email.style.border="3px solid green";
		emailCheckDo = true;
	}else{
		email.style.border="3px solid crimson";
		emailCheckDo = false;
	}
})

function emailCheck(){
	return /^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/.test(email.value)
}


document.getElementById("inputName").addEventListener("input", ()=>{
	nameCheckDo = true;
	document.getElementById("inputName").style.border = "3px solid green";
})

document.getElementById("birthChoice").addEventListener("click", ()=>{
	birthCheckDo = true;
	document.getElementById("birthChoice").style.border = "3px solid green";
})


async function checkId(){
	if(!idCheckDo){
		alert("유효한 아이디가 아닙니다")
		return;
	}
	
	//console.log(id.value);
	let inputId = id.value;
	
	if(inputId==''){
		alert("입력된 아이디가 없습니다")
		return;
	}
	//console.log(inputId);
	try{
		const response = await fetch('valididajax.do',{
			method: "post",
			headers: {
				'Content-Type': 'application/x-www-form-urlencoded; charset=utf-8',
			},
			body: new URLSearchParams({inputId}).toString(),
		});
		
		if(!response.ok){
			throw new Error(`HTTP error! status: ${response.status}`);
		}
		const result = await response.text();
		handleIdValidationResult(result);
		
	}catch(error){
		console.error("valididajax.do:", error);
		alert('아이디 확인 중 오류가 발생했습니다');
	}
}

id.addEventListener("change", ()=>{
	isCheckId = false;
})
nickname.addEventListener("change", ()=>{
	isCheckNickname = false;
})



function handleIdValidationResult(data) {

    switch (data) {
        case 'valid':
            alert('이 아이디는 사용 가능합니다');
            isCheckId = true;
            break;

        case 'notValid':
            alert('이 아이디는 사용 불가능합니다');
            id.value = '';
            isCheckId = false;
            break;

        default:
            alert('예상치 못한 응답입니다');
            isCheckId = false;
    }
}


const telinit = document.getElementById('telinit');
const telmiddle = document.getElementById('telmiddle');
const tellast = document.getElementById('tellast');
function checkNumLength(){
	if(telinit.value == '010'){
		if(telmiddle.value.length>=4){
			telmiddle.value = telmiddle.value.slice(0,4);
			telmiddle.style.border="3px solid green";
			telmiddleCheckDo = true;
		}else{
			telmiddle.style.border="3px solid crimson";
			telmiddleCheckDo = false;
		}
	}else{
		if(telmiddle.value.length>=3){
				telmiddle.value = telmiddle.value.slice(0,3);
				telmiddle.style.border="3px solid green";
				telmiddleCheckDo = true;
					
				}else{
				telmiddle.style.border="3px solid crimson";
				telmiddleCheckDo = false;
				}
	}
	if(tellast.value.length>=4){
		tellast.value = tellast.value.slice(0,4);
		tellast.style.border="3px solid green";
		tellastCheckDo = true;
	}else{
		tellast.style.border="3px solid crimson";
		tellastCheckDo = false;
	}
	//console.log(telmiddle.value)
}
telmiddle.addEventListener('keyup',checkNumLength);
tellast.addEventListener('input',checkNumLength);

telinit.addEventListener('change', ()=>{
	telmiddle.value = '';
	telmiddle.style.border="3px solid crimson";
	tellast.value = '';
	tellast.style.border="3px solid crimson";
})


async function checkNickname(){
	console.log(nickname.value);
		let inputNickname = nickname.value;
		if(inputNickname==''){
			alert("입력된 별명이 없습니다")
			return;
		}
		
		try{
			const response = await fetch('validnicknameajax.do',{
				method: "post",
				headers: {
					'Content-Type': 'application/x-www-form-urlencoded; charset=utf-8',
				},
				body: new URLSearchParams({inputNickname}).toString(),
			});
			
			if(!response.ok){
				throw new Error(`HTTP error! status: ${response.status}`);
			}
			const result = await response.text();
			handleNicknameValidationResult(result);
			
		}catch(error){
			console.error("validnicknameajax.do:", error);
			alert('별명 확인 중 오류가 발생했습니다');
		}
}

function handleNicknameValidationResult(data) {

    switch (data) {
        case 'valid':
            alert('사용가능한 별명입니다.');
			
            isCheckNickname = true;
            break;

        case 'notValid':
            alert('다른 사람이 사용하고 있는 별명입니다.');
            nickname.value = '';
            isCheckNickname = false;
            break;

        default:
            alert('예상치 못한 응답입니다');
            isCheckId = false;
    }
}

nickname.addEventListener("input",()=>{
	if(nickname.value == ''){
		nickname.style.border = "3px solid crimson";
		nicknameCheckDo = false;
	}else{
		nickname.style.border = "3px solid green";
		nicknameCheckDo = true;
	}
})


function submitJoinForm(form){
	console.log("test")
	console.log(idCheckDo)
	console.log(nameCheckDo)
	console.log(birthCheckDo)
	console.log(pwCheckDo)
	console.log(pwDoubleCheckDo)
	console.log(emailCheckDo)
	console.log(nicknameCheckDo)
	console.log(telmiddleCheckDo)
	console.log(tellastCheckDo)
	if(!(idCheckDo&&nameCheckDo&&birthCheckDo && pwCheckDo && pwDoubleCheckDo && emailCheckDo &&nicknameCheckDo &&telmiddleCheckDo && tellastCheckDo)){
		alert("유효하지 않은 항목이 있습니다");
		return;
	}
	
	if(!isCheckId){
		alert("아이디 중복 체크를 해주세요");
		return;
	}
	if(!isCheckNickname){
			alert("별명 중복 체크를 해주세요");
			return;
		}
	//alert("테스트 제출 입니다")
	form.submit();
		
}

