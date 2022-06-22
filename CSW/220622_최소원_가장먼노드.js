function solution(n, edge) {
    
    // 각 edge에 연결된 점 정보 정리
    const graph = Array.from(Array(n + 1), () => [])
    for (const [src, dest] of edge) {
        graph[src].push(dest)
        graph[dest].push(src)
    }
    
    const distance = Array(n + 1).fill(0)
    distance[1] = 1
    const toBeSearched = [1]
    while (toBeSearched.length > 0) {
        const src = toBeSearched.shift()
        for (const dest of graph[src]) {
            if (distance[dest] === 0) {
                distance[dest] = distance[src] + 1
                toBeSearched.push(dest)
            }
        }
    }
    
    return distance.filter(x => x === Math.max(...distance)).length
}