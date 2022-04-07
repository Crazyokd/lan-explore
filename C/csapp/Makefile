all : test-show-bytes

.PHONY: all clean

test-show-bytes : test-show-bytes.o show-bytes.o
	gcc -o test-show-bytes test-show-bytes.o show-bytes.o


test-show-bytes.o : test-show-bytes.c show-bytes.h
	gcc -c test-show-bytes.c
show-bytes.o : show-bytes.c show-bytes.h
	gcc -c show-bytes.c

run-show-bytes : test-show-bytes
	./test-show-bytes 12345 flag
run-simple-show : test-show-bytes
	./test-show-bytes 1
run-show-str : test-show-bytes
	./test-show-bytes 2
run-show-twocomp : test-show-bytes
	./test-show-bytes 3
run-show-extend : test-show-bytes
	./test-show-bytes 4
run-show-extend-2 : test-show-bytes
	./test-show-bytes 5
run-test-fun : test-show-bytes
	./test-show-bytes 6
run-test : test-show-bytes
	./test-show-bytes
run-float-eg : test-show-bytes
	./test-show-bytes 7	

clean : 
	-rm -f show-bytes.o  test-show-bytes.o \
	test-show-bytes