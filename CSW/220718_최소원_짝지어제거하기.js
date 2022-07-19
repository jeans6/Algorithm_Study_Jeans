function solution(s)
{
    const stack =[];
    stack.push(s[0]);
    let len = s.length;
    for(let i=1; i<len; i++){
        if(stack[stack.length-1] === s[i]){
            stack.pop();
        }else stack.push(s[i]);
    }
    let answer = stack.length === 0 ? 1 :0;

    return answer;
}