function solution(bridge_length, weight, truck_weights) {
    let sec = 1;
    let onBridge = [];
    let totalWeight = truck_weights[0];
    onBridge.push(truck_weights.shift());
    
    while(truck_weights.length>0){
        sec++;
        
        // onBridge 길이가 다리길이랑 같아지면 onBridge랑 총 무게에서 빼줌
        if(onBridge.length === bridge_length){
            totalWeight -= onBridge.shift();
        }
        // totalWeight에 다음 트럭 무게 더한게 더 크면 0만 푸시
        if(totalWeight + truck_weights[0] > weight ){
            onBridge.push(0);
        }
        // 작으면 총 무게에 더해주고 onBridge에 추가
        else{
            let temp = truck_weights.shift();
            totalWeight += temp;
            onBridge.push(temp);
        }
        
    }

    return sec+bridge_length;
}