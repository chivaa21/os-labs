#include <linux/init.h>
#include <linux/module.h>
#include <linux/kernel.h>
#include <linux/jiffies.h>
#include <linux/utsname.h>


void get_time(void);
void getSystemInfo(void);


typedef struct{
	int ID;
	char *NAME;
	int AGE;
}Student;

int i;
int countS=-1;

Student arrStudent[10];

Student createStudent(int id, char *nombre, int edad){
	Student newStudent;
	newStudent.ID=id;
	newStudent.NAME=nombre;
	newStudent.AGE=edad;
	countS=countS+1;
return newStudent;
}

void addStudent(Student x){
	arrStudent[countS]=x;
}

void listStudents(void){
	int i;
	for(i=0;i<=countS;i++){
		printk("Student: %s\n Name: %s\n\tID: %d\n\tAge: %d\n"," ",arrStudent[i].NAME, arrStudent[i].ID, arrStudent[i].AGE);
	}
}

//////////////////////////////////////////////////////////////

/* This function is called when the module is loaded. */
int simple_init(void)
{
       printk(KERN_INFO "Loading Module\n");
	//simple_uptime();
	//simple_systeminfo();
	addStudent(createStudent(122,"Arturo",23));
	listStudents();

       return 0;
}

void simple_uptime(void){
	printk("Uptime: %d sec \n", (jiffies_to_msecs(get_jiffies_64())/1000));
}

void simple_systeminfo(void){
	struct new_utsname *a= utsname();
	printk("Sysname: %s\n", a->sysname);
	printk("Nodename: %s\n", a->nodename);
	printk("Realease: %s\n", a->release);
	printk("Version: %s\n", a->version);
	printk("Machine: %s\n", a->machine);

}


/* This function is called when the module is removed. */
void simple_exit(void) {
	printk(KERN_INFO "Removing Module\n");
}

/* Macros for registering module entry and exit points. */
module_init( simple_init );
module_exit( simple_exit );

MODULE_LICENSE("GPL");
MODULE_DESCRIPTION("Simple Module");
MODULE_AUTHOR("SGG");




