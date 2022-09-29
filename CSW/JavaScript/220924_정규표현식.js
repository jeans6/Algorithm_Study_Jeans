let k = 2;
const regex = /\.{1,k}/g;
let str = "..shi";
str = str.replace(regex, '##');

console.log(str);
