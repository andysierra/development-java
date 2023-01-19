window.onload = function() {
	outImg = document.getElementById('output-img');
	binImg = document.getElementById('bin-img');
}

function onSubmitImg(e) {
	e.preventDefault();
	binImg.innerHTML = 'cargando...';
	var files = document.getElementById('input-img').files;
	
	if(FileReader && files && files.length) {
		var fr = new FileReader();
        fr.onload = function () {
			console.log('loaded!');
            outImg.src = fr.result;
            outImg.style.display = 'block';
            
            sendImage(fr.result);
        }
        fr.readAsDataURL(files[0]);
	}
}

function sendImage(formImage) {
	let b64Img = formImage.split(',')[1];
	let byteChars = atob(b64Img);
	let uint = undefined;
	
	const byteNumbers = new Array(byteChars.length);
	for (let i = 0; i < byteChars.length; i++) {
    	byteNumbers[i] = byteChars.charCodeAt(i);
	}
	
	uint = new Uint8Array(byteNumbers);
	
	let str = '';
	
	uint.forEach(bin => str += (Number(bin).toString(2)+'<br>'));
	
	binImg.innerHTML = str;
}