#!/bin/bash

path='/usr/src'
salida='/home/oscreader/Desktop/salida.txt'

for dir in $path; do
	if [ -d "$dir" ]; then
		echo 'path: ' >> $salida
		echo 'Files .c '>> $salida
		find $dir -name '*.c' >> $salida
		echo 'Files .h ' >> $salida
		find $dir -name '*.h' >> $salida
	fi
done

