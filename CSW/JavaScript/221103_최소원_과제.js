const [N, ...arr] = require("fs").readFileSync("/dev/stdin").toString().trim().split("\n");
const scores = arr.map(el => el.split(" ").map(Number));


scores.sort((a, b) => {
    if (a[0] === b[0]) {
        return b[1] - a[1];
    }
    return b[0] - a[0];
});
let maxDay = scores[0][0];
let answer = 0;

while (maxDay) {
    let maxIdx = null;
    let maxScore = 0;
    for (let i = 0; i < scores.length; i++) {
        if (scores[i][0] < maxDay) break;
        if (scores[i][1] > maxScore) {
        maxIdx = i;
        maxScore = scores[i][1];
        }
    }

    if (maxIdx !== null) {
        answer += scores[maxIdx][1];
        scores.splice(maxIdx, 1);
    }

    maxDay--;
}

console.log(answer);
