#include<iostream>
#include<string>
#include<deque>
using namespace std;

int t;

int main() {
	cin >> t;

	while (t--) {
		string str;
		int n;
		string arr;
		deque<int> dq;
		cin >> str >> n >> arr;
		bool reverse = false, error = false;
		string s = "";

		for (int i = 0; i < arr.length(); i++) {

			if (isdigit(arr[i])) {
				s += arr[i];
			}
			else {
				if (!s.empty()) {
					dq.push_back(stoi(s));
					s = "";
				}
			}
		}

		int len = str.length();

		for (int i = 0; i < len; i++) {
			if (str[i] == 'R') {
				if (reverse) {
					reverse = false;
				}
				else reverse = true;
			}
			else {
				if (dq.empty()) {
					cout << "error\n";
					error = true;
					break;
				}
				if (reverse)
					dq.pop_back();
				else dq.pop_front();
			}
		}

		if (!error) {
			cout << '[';
		}
		len = dq.size();
		if (reverse && !dq.empty()) {
			for (int i = len-1; i >= 0; i--) {
				if (i == 0) cout << dq[i];
				else cout << dq[i] << ",";
			}
		}
		else if (!reverse && !dq.empty()) {
			for (int i = 0; i < len; i++) {
				if (i == len - 1) cout << dq[i];
				else cout << dq[i] << ",";
			}
		}
		if (!error) {
			cout << "]\n";
		}

	}


	return 0;
}

