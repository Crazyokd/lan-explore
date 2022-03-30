child : child.o
	cc -o child child.o
child.o : child.c
	cc -c child.c
.PHONY: clean
clean :
	-rm child.o child