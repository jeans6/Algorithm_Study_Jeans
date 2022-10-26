var fs = require('fs');
var input = fs.readFileSync(`C://Users/SONG/Desktop/pjt/Algorithm_Study_Jeans/CSW/JavaScript/example.txt`).toString().trim().split('\n');

let [n, ...list] = input;
list = list.map(e=>parseInt(e));

class Heap{
    constructor(){
        this.items = [];
    }

    swap(index1, index2){
        let temp = this.items[index1];
        this.items[index1] = this.items[index2];
        this.items[index2] = temp;
    }

    findParentIndex(index){
        return Math.floor((index-1)/2);
    }

    findeLeftChildIndex(index){
        return index*2+1;
    }

    findRightChildIndex(index){
        return index*2+2;
    }

    findParent(index){
        return this.items[this.findParentIndex(index)];
    }

    findLeftChild(index){
        return this.items[this.findeLeftChildIndex(index)];
    }

    findRightChild(index){
        return this.items[this.findRightChildIndex(index)];
    }

    peek(){
        return this.items[0];
    }

    size(){
        return this.items.length;
    }

}

class MinHeap extends Heap{
    bubbleUp(){
        let index = this.items.length-1;
        while(this.findParent(index) !== undefined && this.findParent(index)>this.items[index]){
            this.swap(index, this.findParentIndex(index));
            index = this.findParentIndex(index);
        }
    }

    bubbleDown(){
        let index = 0;
        while(this.findLeftChild(index)!==undefined && (this.findLeftChild(index) < this.items[index] || this.findRightChild(index) < this.items[index])){
            let smallerIndex = this.findeLeftChildIndex(index);
            if(this.findRightChild(index)!==undefined && this.findRightChild(index)<this.items[smallerIndex]){
                smallerIndex = this.findRightChildIndex(index);
            }
            this.swap(index, smallerIndex);
            index = smallerIndex;
        }
    }

    add(item){
        this.items[this.items.length] = item;
        this.bubbleUp();
    }

    poll(){
        let item = this.items[0];
        this.items[0] = this.items[this.items.length-1];
        this.items.pop();
        this.bubbleDown();
        return item;
    }

}

let minHeap = new MinHeap();
let compareCnt = 0;
let beforeCnt = 0;

for(let i=0; i<n; i++){
    minHeap.add(list[i]);
}

for(let i=0; i<n-1; i++){
    let first = minHeap.poll();
    let second = minHeap.poll();

    beforeCnt = first + second;
    minHeap.add(beforeCnt);
    compareCnt+= beforeCnt;
}

console.log(compareCnt);