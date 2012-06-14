var pictureSource; 
var destinationType; 


function onBodyLoad() {
    document.addEventListener("deviceready",onDeviceReady,false);
}

function onDeviceReady() {
    pictureSource=navigator.camera.PictureSourceType;
    destinationType=navigator.camera.DestinationType;
}

function back() {
		window.location="revised.html"
}

function onPhotoDataSuccess(imageData) {
    var myImage = document.getElementById('myImage');
    myImage.style.display = 'block';
    myImage.src = "data:image/jpeg;base64," + imageData;
}

function onPhotoURISuccess(imageURI) {
    var myImage = document.getElementById('myImage');
    myImage.style.display = 'block';
    myImage.src = imageURI;
}

function capturePhoto() {
    navigator.camera.getPicture(onPhotoURISuccess, onFail, { quality: 90, allowEdit: true, saveToPhotoAlbum: true });
}

function capturePhotoEdit() {
    navigator.camera.getPicture(onPhotoDataSuccess, onFail, { quality: 90, allowEdit: true, saveToPhotoAlbum: true });
}

function getPhoto(source) {
        navigator.camera.getPicture(onPhotoURISuccess, onFail, { quality: 50, destinationType: destinationType.FILE_URI, sourceType: source, saveToPhotoAlbum: true });
}


function onFail(message) {
    alert('Failed: ' + message);
}    