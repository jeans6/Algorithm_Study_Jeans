var fs = require('fs');
var input = fs.readFileSync(`/dev/stdin`).toString().trim().split('\n');

const [AR, AC, BR, BC] = input[0].split(' ').map(e=>parseInt(e));
const arrB = [];

for(let i=1; i<=AR+BR; i++){
    let col = input[i].split(' ').map(e=>parseInt(e));
    arrB.push(col);
}

for(let i=BR; i<AR+BR; i++){
    for(let j=BC; j<AC+BC; j++){
        arrB[i][j] -= arrB[i-BR][j-BC];
    }
}


for(let i=0; i<AR; i++){
    let answer = arrB[i].slice(0, AC).join(' ');
    console.log(answer);
}
