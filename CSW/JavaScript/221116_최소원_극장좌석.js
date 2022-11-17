var fs = require('fs');
var input = fs.readFileSync(`/dev/stdin`).toString().trim().split('\n');

let N = parseInt(input[0]);
let vip = parseInt(input[1]);
const vips = [];
const dp = Array.from({length:N}, ()=>0);

dp[0] = 1;
dp[1] = 1;
dp[2] = 2;

for(let i=0; i<vip; i++){
    vips.push(parseInt(input[2+i]));
}

for(let i=2; i<=N; i++){
    dp[i] = dp[i-1] + dp[i-2];
}

if(!vip) console.log(dp[N]);
else if(vip === N) console.log(1);
else{
    const interval = [];
    let temp = 0;
    for(let i=0; i<vip; i++){
        interval.push(vips[i]-temp-1);
        temp = vips[i];
    }
    interval.push(N-temp);
    temp = 1;

    for(let i=0; i<interval.length; i++){
        temp *= dp[interval[i]];
    }
    console.log(temp);
}
