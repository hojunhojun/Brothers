document.addEventListener('DOMContentLoaded', function() {
    function loadFile(input) {
        var file = input.files[0];
        if (file) {
            var newImage = document.createElement("img");
            newImage.src = URL.createObjectURL(file);
            newImage.style.width = "100px";
            newImage.style.height = "100px";
            newImage.style.objectFit = "contain";
            newImage.style.padding = "5px"; 
            var container = document.querySelector('.reviewCon');
            container.appendChild(newImage);
        }
    }

    document.getElementById('reviewImg').addEventListener('change', function() {
        loadFile(this);
    });
});