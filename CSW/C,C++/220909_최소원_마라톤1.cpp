#include <iostream>
using namespace std;

int N;
int point[100000][2];
int visited[100000];
int maxG,total;

int main() {

	cin >> N;
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < 2; j++) {
			cin >> point[i][j];
		}
	}

	// 총 거리계산
	for (int i = 1; i < N; i++) {
		int dist = abs(point[i][0] - point[i - 1][0]) + abs(point[i][1] - point[i - 1][1]);
		total += dist;
	}

	// 사이 gap이 최대인 것
	for (int i = 1; i < N - 1; i++) {
        // 포인트 찍고 이동
		int gap = abs(point[i][0] - point[i - 1][0]) + abs(point[i][1] - point[i - 1][1]) + abs(point[i][0] - point[i + 1][0]) + abs(point[i][1] - point[i + 1][1]);
        // 포인트 생략하고 직선이동
		int straight = abs(point[i - 1][0] - point[i + 1][0]) + abs(point[i - 1][1] - point[i + 1][1]);
        int pass = abs(gap- straight)
		if (maxG < pass) maxG = pass;
	}

	cout << total-maxG;

	return 0;
}