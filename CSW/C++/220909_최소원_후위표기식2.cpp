#include <iostream>
#include <string>
#include <stack>
using namespace std;

string str;
int N;
int num[26];
stack<double> s;

int main() {

	cin >> N >> str;

	for (int i = 0; i < N; i++) {
		cin >> num[i];
	}

	for (int i = 0; i < str.length(); i++) {
		if (str[i] >= 'A' && str[i] <= 'Z') {
			s.push(num[str[i]-'A']);
		}
		else {
			double second = s.top();
			s.pop();
			double first = s.top();
			s.pop();
			double val = 0;
			switch (str[i]) {
				case '+':
					val = first + second;
					s.push(val);
					break;
				case '-':
					val = first - second;
					s.push(val);
					break;
				case '*':
					val = first * second;
					s.push(val);
					break;
				case '/':
					val = first / second;
					s.push(val);
					break;

			}

		}
	}

	cout << fixed;
	cout.precision(2);
	cout << s.top();

	return 0;
}