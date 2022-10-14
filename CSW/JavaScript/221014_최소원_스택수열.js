var fs = require('fs');
var [n, ...nums] = fs.readFileSync(`/dev/stdin`).toString().trim().split('\n');

const numbers = nums.map(e=>parseInt(e));

function Solution(n, numbers){
    let cnt = 1;
    let answer = '';
    const stack = [];

    for(let i=0; i<n; i++){

        let target = parseInt(numbers[i]);

        while(cnt<=target){
            stack.push(cnt++);
            answer += '+ ';
        }
        
        let top = stack.pop();
        if(top !== target){
            return 'NO';
        }
        
        answer += '- ';
    }
    return answer.split(' ').join('\n');
}

const answer = Solution(n, numbers);
console.log(answer);