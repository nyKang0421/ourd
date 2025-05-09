
weCheckDo = false;
isCheckWE = false;

const we = document.getElementById("inputWe");
we.addEventListener("keyup",()=>{
	let weValue = we.value;
	
	if(checkwelength(weValue) === true){
			weCheckDo = true;
			we.style.border='4px solid rgb(92,51,92)';
	}else{
			weCheckDo = false;
			we.style.border='4px solid crimson';
	}
	if(weValue.length == 0 ){
			weCheckDo = false;
			we.style.border='4px solid rgb(163,204,163)';
	}
})

function checkwelength(we){
	return we.length > 0 && we.length<=20;
}

async function checkWe(){
	let inputWe = we.value;
		
	if(inputWe==''){
		alert("입력된 이름이 없습니다")
		return;
	}
	
	if(!weCheckDo){
		alert("유효한 이름이 아닙니다")
		return;
	}
	
	//console.log(id.value);
	
	//console.log(inputId);
	try{
		const response = await fetch('validweajax.do',{
			method: "post",
			headers: {
				'Content-Type': 'application/x-www-form-urlencoded; charset=utf-8',
			},
			body: new URLSearchParams({inputWe}).toString(),
		});
		
		if(!response.ok){
			throw new Error(`HTTP error! status: ${response.status}`);
		}
		const result = await response.text();
		handleWeValidationResult(result);
		
	}catch(error){
		console.error("validweajax.do:", error);
		alert('이름 확인 중 오류가 발생했습니다');
	}
}

function handleWeValidationResult(data) {

    switch (data) {
        case 'valid':
            alert('사용 가능한 이름입니다');
            isCheckWe = true;
            break;

        case 'notValid':
            alert('이미 사용하고 있는 이름입니다');
            we.value = '';
            isCheckWe = false;
			we.style.border='4px solid crimson';
            break;

        default:
            alert('예상치 못한 응답입니다');
			we.style.border='4px solid crimson';
            isCheckWe = false;
    }
}

we.addEventListener("change", ()=>{
	isCheckWe = false;
})

function submitMakeWeForm(form){

	if(!weCheckDo){
		alert("유효하지 않은 이름입니다");
		return;
	}
	
	if(!isCheckWe){
		alert("이름 중복 체크를 해주세요");
		return;
	}
	
	//alert("테스트 제출 입니다")
	form.submit();
		
}