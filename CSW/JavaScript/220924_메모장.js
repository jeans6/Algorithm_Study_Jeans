let k = 2;
const regex = /\.{1,k}/g;
let str = "..shi";
str = str.replace(regex, '##');

console.log(str);


//Queue 구현 연습
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
        this.length = null;
    }

    push(item){
        const node = new Node(item);
        if(this.head){
            this.tail.next = node;
        }else{
            this.head = node;
            this.head.next = null;
        }
        this.tail = node;
        this.length +=1;
    }

    pop(){
        if(!this.head) return false;
        const popItem = this.head;
        this.head = this.head.next;
        this.length -= 1;
        return popItem.item;
    }

    size(){
        return this.length;
    }

    isEmpty(){
        if(!this.head) return 1;
        else 0;
    }

    front(){
        if(this.isEmpty()) return -1;
        return this.head.item;
    }

    back(){
        if(this.isEmpty()) return -1;
        return this.tail.item;
    }
    
}