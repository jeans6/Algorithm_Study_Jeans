#include <stdio.h>
#include <string.h>
#include <stdlib.h>

int main(void) {
	char str[51];
	int arr[25] = { 0 };
	scanf("%s", str);
	int len = strlen(str);
	int temp = 0, sum = 0, result = 0;
	int j = 0;

	for (int i = 0; i <= len; i++) {
		if (str[i] == '-' || i == len) {
			sum += temp;
			arr[j] = sum;
			j++;
			temp = 0;
			sum = 0;
		}
		else if (str[i] == '+') {
			sum += temp;
			temp = 0;
		}
		else {
			temp = temp * 10;
			temp += str[i] - '0';
		}
	}

	result = arr[0];
	for (int i = 1; i < j; i++) {
		result -= arr[i];
	}

	printf("%d", result);
}