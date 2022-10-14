#include <stdio.h>
#include <string.h>
#include <stdlib.h>

typedef struct discussion {
	int start, end;
}Discussion;

int compare(const void*, const void*);

int main() {
	int n, cnt = 0, t1, t2, last = 0;
	scanf("%d", &n);
	Discussion* dis;
	dis = (Discussion*)calloc(n, sizeof(Discussion));
	for (int i = 0; i < n; i++) {
		scanf("%d %d", &t1, &t2);
		dis[i].start = t1;
		dis[i].end = t2;
	}
	qsort(dis, n, sizeof(Discussion), compare);
	for (int i = 0; i < n; i++) {
		if (dis[i].start >= last) {
			cnt++;
			last = dis[i].end;
		}
	}

	printf("%d", cnt);
	free(dis);

	return 0;
}

int compare(const void* a, const void* b) {
	const Discussion* n1, * n2;
	n1 = (const Discussion*)a;
	n2 = (const Discussion*)b;

	if (n1->end != n2->end) {
		if (n1->end < n2->end) {
			return -1;
		}
		else if (n1->end == n2->end) {
			return 0;
		}
		else return 1;
	}
	else {
		if (n1->start < n2->start) {
			return -1;
		}
		else if (n1->start == n2->start) {
			return 0;
		}
		else return 1;
	}
}