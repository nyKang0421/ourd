let ctx = window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));
document.querySelector('#toplogo').addEventListener('click', ()=>{
	location.href=ctx+'/main.do'
})

const bannerRight = document.getElementById("banner-right");
const bannerLeft = document.getElementById("banner-left");

bannerLeft.addEventListener('click', ()=>{
	window.open("http://www.coupang.com");
})

bannerRight.addEventListener('click', ()=>{
	window.open("http://www.everland.com");
})

