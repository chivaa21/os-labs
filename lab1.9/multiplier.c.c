
#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <sys/types.h>
#include <string.h>
#include <pthread.h>

#define NUM_ROWS 2000
#define NUM_COLUMNS 2000
#define NUM_DATA NUM_COLUMNS*NUM_ROWS
#define MAX_LINE 80
#define A_PATH "matA.dat"
#define B_PATH "matB.dat"
#define nchar 255
#define NUM_THREADS 20
#define NUM_CYCLES NUM_ROWS/NUM_THREADS

typedef struct {
	int id;
	long * mat1;
	long * mat2;
}threads;


long * readMatrix(char *filename){
	int j;
	FILE *fp;
	char buff[nchar];
	fp=fopen(filename, "r");
	for(j=0;j<NUM_DATA;j++){
		fgets(buff,nchar,(FILE*)fp);
		matrix_4m[j]=(long)atoi(buff);     //saves .dat in the array of 4 000 000 values
	}
	fclose(fp);
	return matrix_4m;
}