function solution(w, h) {
    // 처음에 생각했던 반례들...(필요없음)
    // if(w===h) return w*h-w;
    // if(w===1 || h===1) return 0;
    // if(w%h ===0 || h%w === 0) return w*h/2;
    
    //최대공약수 구하는 함수
    const gcd = (a,b)=>{
        if(b === 0 )return a;
        return gcd(b, a%b);
    }
     
    return w*h-(w+h-gcd(w,h));
}