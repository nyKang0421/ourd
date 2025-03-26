const choiceClub = document.getElementById("choiceClub");
const choicediarydate = document.getElementById("diarydate");
const choiceweather = document.getElementById("choiceweather");
const feel = document.getElementById("inputfeel");
const title = document.getElementById("inputtitle");
const content = document.getElementById("inputcontent");

let ischoiceClub = false;
let ischoicediarydate = true;
let ischoiceweather = false;
let isfeel = false;
let istitle = false;
let iscontent = false;

let today = new Date().toISOString().substring(0,10);
choicediarydate.max = today;
choicediarydate.value = today;

choiceClub.addEventListener("change", ()=>{
	ischoiceClub = false;
	console.log('clubNum:',choiceClub.value);
	if(choiceClub.value != -1){
		ischoiceClub = true;
	}
})

let weather;
choiceweather.addEventListener("change", ()=>{
	ischoiceweather = false;
		let la = 0; // 위도
		let lo = 0; // 경도
	if(choiceweather.value != -1){
		
		let code = choiceweather.value;
		if(code = 2){
			la = 37.540423;
			lo = 127.007850;
		}else if(code = 33){
			la = 37.837665;
			lo = 128.164104;
		}else if(code = 43){
			la = 37.020649;
			lo = 127.690497;
		}else if(code = 41){
			la = 36.714920;
			lo = 126.854336;
		}else if(code = 63){
			la = 35.741484;
			lo = 127.172223;
		}else if(code = 61){
			la = 34.898465;
			lo = 126.962473;
		}else if(code = 54){
			la = 36.319462;
			lo = 128.896831;
		}else if(code = 55){
			la = 35.485706;
			lo = 128.345267;
		}else if(code = 64){
			la = 33.455693;
			lo = 126.752723;
		}else{
			alert("날씨 선택에 예상치 못한 오류가 발생했습니다");
			return;
		}
		
	}
	
	lat = la;  
	lon = lo;
	
	let appkey="55b86296ddb34b733932180287868904";
	
	fetch(`https://api.openweathermap.org/data/2.5/weather?lat=${lat}&lon=${lon}&appid=${appkey}&lang=kr`)
	        .then(response => response.json())
	        .then(data => {
	            console.log(data);

	            weather = data.weather[0].description;
				console.log(weather);
				ischoiceweather = true;
				document.querySelector('#weatherresult').setAttribute("value", weather);
	})
	.catch(error => console.error('Error:', error));
	
})



feel.addEventListener("keyup",()=>{
	if(feel.value != ''){
		isfeel = true;
	}
})

title.addEventListener("keyup",()=>{
	if(title.value != ''){
		istitle = true;
	}
})

content.addEventListener("keyup",()=>{
	if(content.value != ''){
		iscontent = true;
	}
})

isupload = false;

function uploadImg(){
	if(isupload){
		alert("이미지 업로드 중입니다");
		return;
	}
	
	let file = document.querySelector('#formfile').files[0];
	if(!file){
		alert("먼저 파일을 업로드 해주세요");
		return;
	}
	console.log(file.name);
	console.log(file.type);
	console.log(file.size);
	
	let check = checkImg(file.name, file.size);
	
	if(!check) return;
	else{
		isupload = true;
		uploadFile();
	}
	
}

function uploadFile(){
	let imgform = document.getElementById('imguploadform');
	let formData = new FormData(imgform);
	
	fetch('uploadDiaryImg.do',{
		method: 'POST',
		body: formData,
		contentType: false,
		processData: false
		
	})
	.then(response => response.text())
	.then(data => {
		if(data === 'fail'){
			alert('파일업로드 실패');
			
		} else{
			alert(data + "파일 업로드 성공");
			let src = "/Uploads/"+data;
			console.log("src : " + src);
			document.querySelector('#inputImg').setAttribute("src", src);
			document.querySelector('#imgVal').setAttribute("value", data);
			
		}
	});
	
}

function checkImg(fname, fsize){
	let fileForm = /(.*?)\.(jpg|jpeg|JPG|JPEG|PNG|png)$/;
	let maxSize = 10 * 1024 * 1024;
	if(fname != "" && fname !== null){
		if(!fname.match(fileForm)){
			alert("이미지 파일판 업로드 가능합니다");
			return false;
		}else if(fsize >= maxSize){
			alert("10MB 미만의 파일만 올려주세요");
			return false;
		}
	}
	
	return true;
	
}

function submitdiary(){
	const form = document.getElementById('diarywriteForm');
	form.addEventListener('submit', function(event){
		event.preventDefault();
	})
	if(!(iscontent&&istitle&&isfeel&&ischoiceweather&&ischoiceClub&&ischoicediarydate)){
		alert("빠진 내용이 있습니다");
		return
	}
	form.submit();
}


