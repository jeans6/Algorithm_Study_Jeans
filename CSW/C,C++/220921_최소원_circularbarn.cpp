#include <iostream>
using namespace std;

int N, barn[1001], dist[1001];

void isCow(int blankP) {
    for (int j = blankP - 1; j >= 0; j--) {
        if (barn[j]) {
            barn[j] -= 1;
            barn[blankP] += 1;
            dist[blankP] = blankP - j + dist[j];
            return;
        }
    }
    for (int j = N - 1; j > blankP; j--) {
        if (barn[j]) {
            barn[j] -= 1;
            barn[blankP] += 1;
            dist[blankP] = N - j + blankP + dist[j];
            return;
        }
    }
}

int main() {

    cin >> N;
    for (int i = 0; i < N; i++) cin >> barn[i];

    while (1) {
        // 반시계방향으로 빈칸이 있는지 검사
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            if (!barn[i])cnt++;
        }
        if (!cnt) break;

        for (int i = N - 1; i >= 0; i--) {
            if (!barn[i]) {
                isCow(i);
            }
        }
    }

    int ans = 0;
    for (int i = 0; i < N; i++)
        ans += dist[i] * dist[i];
    cout << ans << '\n';

    return 0;
}


// 인터넷에서 찾은 정답코드 이게 훨 좋아보임 ㅎㅎ
// #include <iostream>
// using namespace std;

// int n, room[1001], d[1001];

// int main() {
//     cin >> n;
//     for (int i = 0; i < n; i++) cin >> room[i];

//     while (1) {
//         bool done = true;
//         int to = 0;
//         for (int i = 0; i < n; i++) {
//             if (room[i] == 0) {
//                 to = i;
//                 done = false;
//             }
//         }
//         if (done) break;

//         int from = to;
//         int dist = 0;
//         while (1) {
//             if (room[from] != 0) break;
//             if (from == 0)
//                 from = n;
//             from--;
//             dist++;
//         }
//         room[from]--;
//         room[to]++;
//         d[to] += dist + d[from];
//         d[from] = 0;
//     }

//     int ans = 0;
//     for (int i = 0; i < n; i++)
//         ans += d[i] * d[i];
//     cout << ans << '\n';
//     return 0;
// }