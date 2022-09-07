var fs = require('fs');
var input = fs.readFileSync(`/dev/stdin`).toString().trim().split('\n');

const n = parseInt(input[0]);

class Node{
    constructor(value){
        this.value = value;
        this.next = null;
        this.prev = null;
    }
} 

class LinkedList{
    constructor(){
        this.head = null;
        this.tail = null;
        this._size = 0;
    }

    add(value){
        const newNode = new Node(value);
        if(!this.head){
            this.head = newNode;
        }else{
            this.tail.next = newNode;
            newNode.prev = this.tail;
        }
        this.tail = newNode;
        this._size +=1;

        return newNode;
    }

    getHead(){
        return this.head.value;
    }

    removeHead(){
        this.head = this.head.next;
        this.head.prev = null;
        this._size -=1;
    }

    getSize(){
        return this._size;
    }

}

const queue = new LinkedList();

for(let i=1; i<=n; i++){
    queue.add(i);
}

while(queue._size>1){
    queue.removeHead();
    queue.add(queue.getHead());
    queue.removeHead();
}


console.log(queue.getHead());
