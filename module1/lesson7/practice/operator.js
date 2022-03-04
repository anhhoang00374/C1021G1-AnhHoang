let inputWidth;
let inputHeight;

function area() {
    inputWidth = prompt("please enter the width");
    inputHeight = prompt("please enter the height");
    let width = parseInt(inputWidth);
    let height = parseInt(inputHeight);
    let area = width * height;
    document.write("Enter width: </br>");
    document.write(width + "</br>");
    document.write("Enter height: </br>");
    document.write(height + "</br>");
    document.write("The area is: " + area);
}