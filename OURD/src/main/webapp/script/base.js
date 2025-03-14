let ctx = window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));
document.querySelector('#toplogo').addEventListener('click', ()=>{
	location.href=ctx+'/main.do'
})