function solution(files) {
    const reg = /[0-9]+/;
    
    return files.sort((a,b)=>{
        const [numA, numB] = [a.match(reg), b.match(reg)];
        const [headA, headB] = [a.slice(0, numA.index).toLowerCase(), b.slice(0,numB.index).toLowerCase()];
        const [numberA, numberB] = [ parseInt(numA[0]), parseInt(numB[0]) ];
        
        return headA<headB ? -1 : headA>headB ? 1: numberA<numberB?-1: numberA>numberB? 1: 0;
    })  
}