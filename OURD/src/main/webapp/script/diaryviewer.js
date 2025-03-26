console.log("diaryviewer script 확인");

const viewerwe = document.getElementById("choiceViewerClub");

viewerwe.addEventListener('change', async ()=>{
	let clubnum = viewerwe.value;
	console.log("weNo: ",clubnum);
	
	await fetch('getdiarylistbywe.do',{
		method: 'post',
		headers:{
			'Content-Type' : 'application/x-www-form-urlencoded; charset=utf-8',
		},
		body: new URLSearchParams({clubnum}).toString(),
	})
	//setTimeout(function(){},200);
	history.go(0);
	
})

async function dlmovepre(){
	let clubnum = viewerwe.value;
	
	await fetch('movediarypagepre.do',{
				method: 'post',
				headers:{
					'Content-Type' : 'application/x-www-form-urlencoded; charset=utf-8',
				},
				body: new URLSearchParams({clubnum}).toString(),
			})
		history.go(0);
}

async function dlmovepost(){
	let clubnum = viewerwe.value;
	
	await fetch('movediarypagepost.do',{
			method: 'post',
			headers:{
				'Content-Type' : 'application/x-www-form-urlencoded; charset=utf-8',
			},
			body: new URLSearchParams({clubnum}).toString(),
		})
		
	history.go(0);
}

async function deletediary(num){
	let diarynum = num;
	
	await fetch('removediary.do',{
				method: 'post',
				headers:{
					'Content-Type' : 'application/x-www-form-urlencoded; charset=utf-8',
				},
				body: new URLSearchParams({diarynum}).toString(),
			})
	history.go(0);
	
}

