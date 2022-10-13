#include <iostream>
#include <string>
#include <algorithm>
using namespace std;

int N,cnt;
string initStr;
string resultStr;
char first[1000000];
char second[1000000];
int minV = 100000000;

void flip(char str[], int idx) {
	if (idx > 0 && idx < N - 1) {
		for (int i = idx - 1; i <= idx + 1; i++) {
			str[i] = str[i] == '0' ? '1' : '0';
		}
	}
	else if (!idx) {
		str[idx] = str[idx] == '0' ? '1' : '0';
		str[idx + 1] = str[idx + 1] == '0' ? '1' : '0';
	}
	else {
		str[idx] = str[idx] == '0' ? '1' : '0';
		str[idx - 1] = str[idx - 1] == '0' ? '1' : '0';
	}
}

int main() {
	cin >> N >> initStr >> resultStr;

	for (int i = 0; i < N; i++) {
		first[i] = initStr[i];
		second[i] = initStr[i];
	}

	for (int i = 1; i < N; i++) {
		if (first[i - 1] == resultStr[i - 1])continue;
		flip(first, i);
		cnt++;
	}

	if (first == resultStr) minV = min(minV, cnt);

	flip(second, 0);
	cnt = 1;
	for (int i = 1; i < N; i++) {
		if (second[i - 1] == resultStr[i - 1])continue;
		flip(second, i);
		cnt++;
	}

	if (second == resultStr) minV = min(minV, cnt);

	if (minV == 100000000) {
		cout << -1;
	}
	else cout << minV;


	return 0;
}