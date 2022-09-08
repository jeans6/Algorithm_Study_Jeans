function solution(rows, columns, queries) {

    // 행렬
    const box = [];
    for(let i=1; i<=rows; i++){
        const row=[];
        for(let j=1; j<=columns; j++){
            row.push((i-1)*columns+j);
        }
        box.push(row);
    }
    
    const rotation = (box, [x1,y1,x2,y2]) =>{
        // 인덱스에 맞게 1씩 --
        x1--, x2--, y1--, y2--;
        let temp = box[x1][y1];
        let minNum = temp;
        
        // 좌 상단이동
        for(let i=x1; i<x2; i++){
            box[i][y1] = box[i+1][y1];
            minNum = Math.min(minNum, box[i+1][y1]);
        }
        // 하 좌측이동
        for(let i=y1; i<y2; i++){
            box[x2][i] = box[x2][i+1];
            minNum = Math.min(minNum, box[x2][i+1]);
        }
        // 우 하단이동
        for(let i=x2; i>x1; i--){
            box[i][y2] = box[i-1][y2];
            minNum = Math.min(minNum, box[i-1][y2]);
        }
        // 상 우측이동
        for(let i=y2; i>y1; i--){
            box[x1][i] = box[x1][i-1];
            minNum = Math.min(minNum, box[x1][i-1]);
        }
        box[x1][y1+1] = temp;
        
        return minNum;
    }
    
    return queries.map(query=>rotation(box, query));;
}