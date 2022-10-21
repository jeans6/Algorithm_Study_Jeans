#include <stdio.h>
#include <string.h>
#include <stdlib.h>

int root[101];
int N, connect, cnt=0;

int getParent(int a) {
	if (root[a] == a) return a;
	return root[a] = getParent(root[a]);
}

void unionParent(int a, int b) {
	int parentA = getParent(a);
	int parentB = getParent(b);
	if (parentA > parentB) root[parentA] = parentB;
	else root[parentB] = parentA;
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

	for (int i = 2; i <= N; i++) {
		if (getParent(i) == getParent(1)) {
			cnt++;
		}
	}

	printf("%d\n", cnt);

	return 0;
}

