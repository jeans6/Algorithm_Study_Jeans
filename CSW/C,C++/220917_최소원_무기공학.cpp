#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int N, M, answer;
int visited[6][6];
int material[6][6];
vector<pair<int, int>> blocks[4] = { {{-1, 0 }, {0, 1}}, {{-1,0}, {0, -1}}, {{0, -1}, {1, 0}}, {{0, 1}, {1,0}} };

bool check(int y, int x) {
	if (y < 0 || x < 0 || y >= N || x >= M) {
		return false;
	}
	return true;
}

void dfs(int y, int x, int sum) {
	answer = max(answer, sum);

	if (x == M) {
		x = 0;
		y++;
	}
	if (y == N) return;

	if (!visited[y][x]) {
		for (int i = 0; i < 4; i++) {
			int dy1 = y + blocks[i][0].first;
			int dx1 = x + blocks[i][0].second;
			int dy2 = y + blocks[i][1].first;
			int dx2 = x + blocks[i][1].second;
			if (!check(dy1, dx1) || !check(dy2, dx2)) continue;
			if (visited[dy1][dx1] || visited[dy2][dx2])continue;
			visited[dy1][dx1] = 1;
			visited[dy2][dx2] = 1;
			visited[y][x] = 1;
			dfs(y, x + 1, sum + 2 * material[y][x] + material[dy1][dx1] + material[dy2][dx2]);
			visited[dy1][dx1] = 0;
			visited[dy2][dx2] = 0;
			visited[y][x] = 0;
		}

	}
	dfs(y, x + 1, sum);
}


int main() {
	cin >> N >> M;
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			cin >> material[i][j];
		}
	}

	if (N < 2 || M < 2) cout << 0;
	else {
		dfs(0, 0, 0);
		cout << answer;
	}

	return 0;
}