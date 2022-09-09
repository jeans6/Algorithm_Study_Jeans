#include <iostream>
using namespace std;

int AR, AC;
int BR, BC;
int arrB[600][600];

int main() {
	
	cin >> AR >> AC >> BR >> BC;

	for (int i = 0; i < AR + BR; i++) {
		for (int j = 0; j < AC + BC; j++) {
			cin >> arrB[i][j];
		}
	}

	for (int i = BR; i < AR + BR; i++) {
		for (int j = BC; j < AC + BC; j++) {
			arrB[i][j] -= arrB[i - BR][j - BC];
		}
	}

	for (int i = 0; i < AR; i++) {
		for (int j = 0; j < AC; j++) {
			cout << arrB[i][j] <<" ";
		}
		cout << "\n";
	}


	return 0;
}