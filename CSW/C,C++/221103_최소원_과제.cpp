#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

int N;
vector<pair<int, int>> score;


bool compare(const pair<int, int>& a, const pair<int, int>& b) {
	if (a.first == b.first) {
		return a.second < b.second;
	}
	return a.first < b.first;
}

int main() {

	cin >> N;

	int maxDay = 0;
	for (int i = 0; i < N; i++) {
		int a, b;
		cin >> a >> b;
		maxDay = max(maxDay, a);
		score.push_back({ a,b });
	}
	sort(score.begin(), score.end(), compare);


	int answer = 0;
	
	for (int i = maxDay; i > 0; i--) {
		int sizeV = score.size();
		if (!sizeV) break;
		int maxScore = 0;
		int maxIdx = -1;
		for (int j = 0; j <sizeV; j++) {
			if (score[j].first >= i) {
				if (score[j].second > maxScore) {
					maxScore = score[j].second;
					maxIdx = j;
				}
			}
		}

		if (maxIdx != -1) {
			answer += maxScore;
			score.erase(score.begin() + maxIdx);
		}
	}

	cout << answer << endl;


	return 0;
}

