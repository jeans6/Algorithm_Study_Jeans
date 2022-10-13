#include <iostream>
#include <vector>
using namespace std;

int N, possible;
vector<pair<int, int>> teacher;
vector<pair<int, int>> emp;
char map[6][6];
int dirY[4] = { -1,0,1,0 };
int dirX[4] = { 0,1,0,-1 };

bool find() {

	for (int i = 0; i < teacher.size(); i++) {
		int ty = teacher[i].first;
		int tx = teacher[i].second;
		for (int j = 0; j < 4; j++) {
			int dy = ty;
			int dx = tx;
			while(1) {
				dy += dirY[j];
				dx += dirX[j];
				if (dy < 0 || dx < 0 || dy >= N || dx >= N || map[dy][dx] == 'O') break;
				if (map[dy][dx] == 'S') return false;
			}
		}
	}
	return true;
	
}

void dfs(int level) {
	if (level == 3) {
		if (find()) possible = 1;
		return;
	}

	for (int i = 0; i < emp.size(); i++) {
		int ey = emp[i].first;
		int ex = emp[i].second;
		if (map[ey][ex] == 'X') {
			map[ey][ex] = 'O';
			dfs(level + 1);
			map[ey][ex] = 'X';
		}
	}
}

int main() {
	cin >> N;

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			cin >> map[i][j];
			if (map[i][j] == 'X') emp.push_back({ i,j });
			else if (map[i][j] == 'T') teacher.push_back({ i,j });
		}
	}


	dfs(0);

	if (possible) cout << "YES";
	else cout << "NO";

	return 0;
}