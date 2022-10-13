#include <iostream>
#include <string>
using namespace std;

int map[5][5];
int visited[5][5];
int R, C, K, cnt;
string s;

int dirY[4] = { 1, 0, -1, 0 };
int dirX[4] = { 0,1,0,-1 };


void dfs(int y,int x, int dis) {
	if (y == 0 && x == C - 1 && dis == K) {
		cnt++;
		return;
	}

	for (int i = 0; i < 4; i++) {
		int dy = y + dirY[i];
		int dx = x + dirX[i];
		if (dy < 0 || dx < 0 || dy >= R || dx >= C) continue;
		if (visited[dy][dx] || map[dy][dx]) continue;
		visited[dy][dx] = 1;
		dfs(dy, dx, dis + 1);
		visited[dy][dx] = 0;
	}
}

int main() {
	
	cin >> R >> C >> K;

	for (int i = 0; i < R; i++) {
		cin >> s;
		for (int j = 0; j < C; j++) {
			if (s[j] == 'T') map[i][j] = 1;
		}
	}


	visited[R - 1][0] = 1;
	dfs(R - 1, 0, 1);

	cout << cnt;

	return 0;
}