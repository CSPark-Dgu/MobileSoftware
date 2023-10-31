#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int prisoner[51];
int box[101] = {0};
int box_check[101] = {0};

void initialize_array(int*);
void sort_box(int*);
void print_box(int*);
int escape(int*, int*);

int main(void) {
    srand((unsigned)time(NULL));
    int result = 0;
    int numSimulations = 10000; // 시뮬레이션 횟수
    for (int sim = 0; sim < numSimulations; sim++) {
        sort_box(box);
        if (escape(prisoner, box)) {
            result++;
        }
    }

    printf("Total success : %d\nProbability of success : %.2f%%\n", result, (float)result / numSimulations * 100);

    return 0;
}

void initialize_array(int* arr){
    for (int i = 0; i < 101; i++) {
        arr[i] = 0;
    }
}

void sort_box(int* arr) {
    for (int i = 1; i < 101; i++) {
        int tmp = rand() % 100 + 1;
        if (box_check[tmp] != 0) {
            i--;
            continue;
        } 
        else {
            arr[i] = tmp;
            box_check[tmp] = 1;
        }
    }
}

void print_box(int* arr) {
    for (int i = 1; i < 101; i++) {
        printf("%d ", arr[i]);
    }
}

int escape(int* prisoner, int* box) {
    int successCount = 0;
    for (int i = 1; i < 51; i++) {
        int target = i;
        int cnt = 0;
        while (cnt < 50) {
            if (box[target] == i) {
                successCount++;
                break;
            } 
            else {
                cnt++;
                target = box[target];
            }
        }
    }
    initialize_array(box);
    initialize_array(box_check);
    return (successCount == 50) ? 1 : 0;
}
