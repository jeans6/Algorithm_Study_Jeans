var fs = require('fs');
var input = fs.readFileSync(`/dev/stdin`).toString().trim().split('\n');

let [N, M] = input[0].split(' ').map(e=>parseInt(e));
const map = [];

class Node{
    constructor(item){
      this.item = item;
      this.next = null;
    }
  }
  
class Queue{
    constructor(){
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    push(item){
        const node = new Node(item)
        if(this.head==null){
        this.head= node;
        this.head.next = null;
        }else{
        this.tail.next = node;
        }
        
        this.tail = node;
        this.length +=1;
    }

    shift(){
        const popItem = this.head;
        this.head = this.head.next;
        this.length -=1;
        return popItem.item;
    }

    size(){
        return this.length;
    }

    empty(){
        if(this.length==0){
        return 1;
        }else{
        return 0;
        }
    }

    front(){
        if(this.empty()==1) return -1;
        return this.head.item; 
    }

    back(){
        if(this.empty()==1) return -1;
        return this.tail.item; 
    }
}

for(let i=1; i<=N; i++){
    const temp = input[i].trim().split('').map(e=>parseInt(e));
    map.push(temp);
}

let queue = new Queue();
queue.push([0,0,1,0])
let answer = -1;
const dirY = [1,0,-1,0];
const dirX = [0,1,0,-1];
const visited = Array.from({length:N}, ()=>Array(M).fill(0));

visited[0][0] = 2;

while(queue.length){
    let [y, x, dist, flag] = queue.shift();
    if(y === N-1 && x === M-1){
        answer = dist;
        break;
    }

    for(let i=0; i<4; i++){
        let ny = y + dirY[i];
        let nx = x + dirX[i];

        if(ny<0 || nx <0 || ny>=N || nx>=M) continue;
     
        if(flag){
            if(map[ny][nx] || visited[ny][nx]) continue;
            visited[ny][nx] = 1;
            queue.push([ny, nx, dist+1, flag]);

        }else{
            if(map[ny][nx]){
                //뿌수기
                if(visited[ny][nx] ===2) continue;
                visited[ny][nx] = 1;
                queue.push([ny, nx, dist+1, !flag]);
            }else{
                //안부수기
                if(visited[ny][nx]===2) continue;
                visited[ny][nx] = 2;
                queue.push([ny, nx, dist+1, flag]);
            }
        }
    }

}

console.log(answer);
