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
async function checkId(){
	//console.log(id.value);
	let inputId = id.value;
	if(inputId==''){
		alert("입력된 아이디가 없습니다")
		return;
	}
	
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

id.addEventListener("input", ()=>{
	isCheckId = false;
})
nickname.addEventListener("input", ()=>{
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
		if(telmiddle.value.length>4){
			telmiddle.value = telmiddle.value.slice(0,4);
		};
	}else{
		if(telmiddle.value.length>3){
					telmiddle.value = telmiddle.value.slice(0,3);
				};
	}
	if(tellast.value.length>4){
		tellast.value = tellast.value.slice(0,4);
	};
	//console.log(telmiddle.value)
}
telmiddle.addEventListener('input',checkNumLength);
tellast.addEventListener('input',checkNumLength);


function checkNickname(){
	
}


