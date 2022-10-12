#include <iostream>
#include <vector>
using namespace std;

int A, B, N, M;
int board[100][100];
vector<pair<int, int>> robots;
char directions[100];
int dy, dx, state;

void turnL(int robot, char dir) {
	if (dir == 'N') {
		directions[robot - 1] = 'W';
	}
	else if (dir == 'W') {
		directions[robot - 1] = 'S';
	}
	else if (dir == 'S') {
		directions[robot - 1] = 'E';
	}
	else if (dir == 'E') {
		directions[robot - 1] = 'N';
	}
}

void turnR(int robot, char dir) {
	if (dir == 'N') {
		directions[robot - 1] = 'E';
	}
	else if (dir == 'E') {
		directions[robot - 1] = 'S';
	}
	else if (dir == 'S') {
		directions[robot - 1] = 'W';
	}
	else if (dir == 'W') {
		directions[robot - 1] = 'N';
	}
}

int goStraight(int ry, int rx, char dir) {
	if (dir == 'N') {
		ry = ry - 1;
	}
	else if (dir == 'W') {
		rx = rx - 1;
	}
	else if (dir == 'S') {
		ry = ry + 1;
	}
	else if (dir == 'E') {
		rx = rx + 1;
	}

	dy = ry;
	dx = rx;
	if (ry < 0 || rx < 0 || ry >= B || rx >= A) return -1;
	if (board[ry][rx]) return 0;
	return 1;
}

int main() {
	cin >> A >> B;
	cin >> N >> M;

	for (int i = 0; i < N; i++) {
		int x, y;
		char dir;
		cin >> x >> y >> dir;
		robots.push_back({ B-y,x-1 });
		directions[i] = dir;
		board[B - y][x - 1] = i + 1;
	}

	for (int i = 0; i < M; i++) {
		int robot, num;
		char order;
		cin >> robot >> order >> num;
		
		for (int j = 0; j < num; j++) {
			int ry = robots[robot - 1].first;
			int rx = robots[robot - 1].second;
			char dir = directions[robot - 1];
			if (order == 'L') {
				turnL(robot, dir);
			}
			else if (order == 'R') {
				turnR(robot, dir);
			}
			else if (order == 'F') {
				int result = goStraight(ry, rx, dir);
				if (result == 1) {
					board[ry][rx] = 0;
					board[dy][dx] = robot;
					robots[robot - 1].first = dy;
					robots[robot - 1].second = dx;
				}
				else if (!result) {
					state = 1;
					cout<<"Robot "<< robot << " crashes into robot " << board[dy][dx];
					break;
				}
				else if (result == -1) {
					state = 1;
					cout << "Robot " << robot << " crashes into the wall";
					break;
				}
			}
		}
		if (state) break;
	}

	if (!state) cout << "OK";

	return 0;
}