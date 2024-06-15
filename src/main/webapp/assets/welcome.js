function showPopup(studentName) {
    const popup = document.getElementById('popup');
    const close = document.getElementsByClassName('close')[0];
    const name = document.getElementById('studentName');

    name.innerText = studentName;
    popup.style.display = 'block';

    close.onclick = function() {
        popup.style.display = 'none';
    }

    window.onclick = function(event) {
        if (event.target === popup) {
            popup.style.display = 'none';
        }
    }
}