#include <stdio.h>
#include <string.h>
#include <stdlib.h>

int root[101];
int N, connect, cnt;

void unionParent(int a, int b) {
	int parentA = getParent(a);
	int parentB = getParent(b);
	if (parentA > parentB) root[a] = parentB;
	else root[b] = parentA;
}

int getParent(int a) {
	if (root[a] == a) return a;
	return root[a] = getParent(root[a]);
}


int main() {
	scanf("%d", &N);
	scanf("%d", &connect);

	for (int i = 1; i <= N; i++) {
		root[i] = i;
	}

	for (int i = 0; i < connect; i++) {
		int a, b;
		scanf("%d %d", &a, &b);
		unionParent(a, b);
	}

	for (int i = 1; i <= N; i++) {
		if (getParent(i) == 1) {
			cnt++;
		}
	}

	printf("%d", cnt);

	return 0;
}

