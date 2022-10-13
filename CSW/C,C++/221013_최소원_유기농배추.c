#include <stdio.h>
#include <string.h>
#include <stdlib.h>

int T, N, K, M;
int farm[51][51];
int visited[51][51];
int dirY[4] = { 1,0,-1,0 };
int dirX[4] = { 0,1,0,-1 };

void DFS(int dy, int dx) {
	for (int i = 0; i < 4; i++) {
		int ny = dy + dirY[i];
		int nx = dx + dirX[i];
		if (ny < 0 || nx < 0 || ny >= N || nx >= M)continue;
		if (visited[ny][nx] || !farm[ny][nx]) continue;
		visited[ny][nx] = 1;
		DFS(ny, nx);
	}

}


int main() {

	scanf("%d", &T);

	for (int i = 0; i < T; i++) {
		scanf("%d %d %d", &M, &N, &K);
		int cnt = 0;

		memset(farm, 0, sizeof(farm));
		memset(visited, 0, sizeof(visited));

		for (int j = 0; j < K; j++) {
			int x, y;
			scanf("%d %d", &x, &y);
			farm[y][x] = 1;
		}

		for (int j = 0; j < N; j++) {
			for (int z = 0; z < M; z++) {
				if (visited[j][z] || !farm[j][z]) continue;
				visited[j][z] = 1;
				DFS(j, z);
				cnt++;
			}
		}
		printf("%d\n", cnt);

	}


	return 0;
}

