#include<iostream>
using namespace std;

int N;
int arr[200];
int answer = 1;
int dp[100];

int main() {
	
	cin >> N;
	for (int i = 0; i < N; i++) {
		cin >> arr[i];
	}

	for (int i = 0; i < N; i++) {
		dp[i] = 1;
		for (int j = 0; j < i; j++) {
			if (arr[j] <= arr[i]) {
				dp[i] = max(dp[i], dp[j]+1);
				answer = max(answer, dp[i]);
			}
		}
	}

	cout << N - answer << endl;


	return 0;
}

