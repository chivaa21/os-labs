#include <sys/types.h>
#include <stdio.h> 
#include <unistd.h>
#include <errno.h>
#include <sys/wait.h>
#include <stdlib.h>
#include <string.h>




int main(int argc, char const *argv[])
{
	pid_t pid;
	char* str;
	char path[] = "/bin/bash";
	/* fork a child process */
	pid = fork();
	str = argv[1];

	if (pid < 0) {
		fprintf(stderr, "Fork failed"); 
		exit(-1);
	}
	
	else if (pid == 0) {
		if(argc == 2){
			/* Concatenate command passed in terminal to '/bin/' */
			strcat(path, "-c", str);
			execlp(path, str, NULL);
		}
		
		else if(argc == 4){
			char* str2;		
			strcat(path,"-c", str);
			str2 = argv[2];	
			printf("%s\n", str2);
			execlp(path, str, str2, NULL);
		}
		else{
			printf("Check the number of arguments.\n");
		}
	}
	
	else{ 	
		wait(NULL);
		printf("\n");	
	
		if(argc > 1){	
			printf("Command executed.\n");
		}
		else{	
			printf("Command not executed.\n");
		}
		exit(0);
	
	}
	return 0;

}
