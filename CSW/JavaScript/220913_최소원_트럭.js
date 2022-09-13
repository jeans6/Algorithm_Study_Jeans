var fs = require('fs');
var input = fs.readFileSync(`C://Users/SONG/Desktop/pjt/Algorithm_Study_Jeans/CSW/JavaScript/example.txt`).toString().trim().split('\n');

let [N, W, L] = input[0].split(' ').map(e=>parseInt(e));
const truck = input[1].split(' ').map(e=>parseInt(e));
const bridge = Array.from({length:W}, ()=>0);

let weight = 0;
let minTime = 0;

while(N){
    minTime++;
    let outBridge = bridge.shift();
    if(outBridge) N--;
    if(!N)break;
    let onBridge = truck[0];
    weight =  weight + onBridge - outBridge;
    if(weight > L){
        weight -= onBridge;
        bridge.push(0);
    }else{
        let temp = truck.shift();
        truck.push(0);
        bridge.push(temp);
    }
}


console.log(minTime);