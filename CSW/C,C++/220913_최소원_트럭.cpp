#include <iostream>
#include <queue>
using namespace std;

int N, W, L;
queue<int> bridge;
queue<int> truck;
int minTime;
int weight;

int main() {
	cin >> N >> W >> L;
	for (int i = 0; i < N; i++) {
		int num; cin >> num;
		truck.push(num);
	}

	for (int i = 0; i < W; i++) {
		bridge.push(0);
	}

	while (N) {
		minTime++;
		int outBridge = bridge.front();
		bridge.pop();
		if (outBridge) N--;
		if (!N) break;
		int onBridge = truck.front();
		weight = weight + onBridge - outBridge;
		if (weight > L) {
			weight -= onBridge;
			bridge.push(0);
		}
		else {
			bridge.push(onBridge);
			truck.pop();
			truck.push(0);
		}
	}

	cout << minTime;

	return 0;
}