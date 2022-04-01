var sum = 0;
var count = 0;
var fNum = 0;
var sNum = 1;
var temp = 0;
// @ts-ignore
function fibonacci(n) {
    if (n > 0) {
        console.log(fNum);
        sum += fNum;
        temp = sNum;
        sNum = sNum + fNum;
        fNum = temp;
        return fibonacci(n - 1);
    }
    else {
        console.log("sum id: " + sum);
        return false;
    }
}
fibonacci(10);
