#include <stdio.h>
#include <string.h>
#include <stdlib.h>

#define SIZE 100000

char answer[SIZE * 2];

typedef struct {
	int stack[SIZE];
	int n;
}StackType;

void init_stack(StackType* s) {
	s->n = -1;
}

int is_empty(StackType* s) {
	return (s->n == -1);
}

int is_full(StackType* s) {
	return (s->n == SIZE - 1);
}

void push(StackType* s, int e) {
	if(is_full(s)) return;
	s->stack[++s->n] = e;
}

int pop(StackType* s) {
	if (is_empty(s)) return -1;
	int tmp = s->stack[s->n--];
	return tmp;
}

int top(StackType* s) {
	if (is_empty(s)) return -1;
	else return s->stack[s->n];
}

int main() {
	StackType s;
	init_stack(&s);

	int n, e, num = 1, chk = 1, idx = 0;

	scanf("%d", &n);

	for (int i = 0; i < n; i++) {
		scanf("%d", &e);

		if (top(&s) < e) {
			while (top(&s) < e) {
				push(&s, num++);
				answer[idx++] = '+';
			}

		}
		else if (top(&s) > e) {
			while (top(&s) > e) {
				pop(&s);
				answer[idx++] = '-';
			}
		}
		if (top(&s) != e) {
			chk = 0;
			break;
		}
		else {
			pop(&s);
			answer[idx++] = '-';
		}
	}

	if (!chk) printf("NO\n");
	else {
		for (int i = 0; i < idx; i++) {
			printf("%c\n", answer[i]);
		}
	}



	return 0;
}

