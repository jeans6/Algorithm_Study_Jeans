#include<iostream>
#include<vector>
#include<string>
#include<stack>
using namespace std;

#define Row 12
#define Col 6

int visited[12][6];
int map[12][6];
int answer;
int dirY[4] = { 1,0,-1,0 };
int dirX[4] = { 0,1,0,-1 };

int pop_puyo() {
    int is_pop = 0;
    int visited[Row][Col] = { 0 };
    vector<pair<int, int>> pop_puyo_vec;
    for (int row = 0; row < Row; row++) {
        for (int col = 0; col < Col; col++) {
            if (visited[row][col]) continue;
            else visited[row][col] = 1;

            if (map[row][col] == '.') continue;

            vector<pair<int, int>> dfs_vec;
            stack<pair<int, int>> dfs_stack;
            dfs_stack.push({ row , col });
            dfs_vec.push_back({ row , col });
            while (!dfs_stack.empty()) {
                pair<int, int> now = dfs_stack.top(); 
                dfs_stack.pop();

                for (int i = 0; i < 4; i++) {
                    int ny = now.first + dirY[i];
                    int nx = now.second + dirX[i];

                    if (ny < 0 || ny >= Row|| nx<0 || nx>=Col) continue; 
                    if (visited[ny][nx]) continue;

                    if (map[ny][nx] == map[row][col]) {
                        dfs_vec.push_back({ ny , nx });
                        dfs_stack.push({ ny , nx });
                        visited[ny][nx] = 1;
                    }
                }
            }

            if (dfs_vec.size() >= 4) {
                for (auto dfs_each : dfs_vec)
                    pop_puyo_vec.push_back(dfs_each);
                is_pop = 1;
            }
        }
    }

    for (auto puyo : pop_puyo_vec)
        map[puyo.first][puyo.second] = '.';

    return is_pop;
}

void drop() {
	for (int col = 0; col < Col; col++) {
		int row_top = Row - 1;
		for (int row = Row - 1; row >= 0; row--) {
			if (map[row][col] == '.') continue;
			if (row_top != row) {
				map[row_top][col] = map[row][col];
				map[row][col] = '.';
			}
			row_top--;
		}
	}
}


int main() {

	for (int i = 0; i < Row; i++) {
		string s;
		cin >> s;

		for (int j = 0; j < Col; j++) {
			map[i][j] = s[j];
		}
	}

	while (pop_puyo()) {
		drop();
        	answer++;	
	}
	
    cout << answer;


	return 0;
}

