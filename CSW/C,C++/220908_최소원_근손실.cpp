#include <iostream>
#include <vector>
using namespace std;

int N, K;
vector<int> v;
int visited[8];
int cnt;

void dfs(int lev, int weight) {
	if (lev == N-1) {
		if (weight >= 500) {
			cnt++;
		}
		return;
	}
	for (int i = 0; i < N; i++) {
		if (visited[i]) continue;
		visited[i] = 1;
		if(weight+v[i]-K>=500) dfs(lev + 1, weight + v[i] - K);
		visited[i] = 0;
	}
}

int main() {
	
	cin >> N >> K;
	for (int i = 0; i < N; i++) {
		int kit;
		cin >> kit;
		v.push_back(kit);
	}
	dfs(0, 500);

	cout << cnt;

	return 0;
}