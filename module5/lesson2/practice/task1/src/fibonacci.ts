let sum:number=0;
let fNum:number = 0;
let sNum:number = 1;
let temp: number = 0;
// @ts-ignore
function fibonacci(n: number){
        if(n>0){
              console.log(fNum);
              sum+=fNum
              temp = sNum;
              sNum = sNum + fNum;
              fNum = temp;
            return fibonacci(n-1);
        }else {
            console.log("sum id: "+sum);
            return false;
        }

}
fibonacci(10);

