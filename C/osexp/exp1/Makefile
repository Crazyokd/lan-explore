# ignore file error
# -include child.make

# include child.make

all : child_parent fork forkshare_1 forkshare_2 wait
.PHONY : all

child_parent : child_parent.o
	cc -o child_parent child_parent.o
child_parent.o : child_parent.c
	cc -c child_parent.c

fork : fork.o
	cc -o fork fork.o
fork.o : fork.c
	cc -c fork.c

forkshare_1 : forkshare_1.o
	cc -o forkshare_1 forkshare_1.o
forkshare_1.o : forkshare_1.c
	cc -c forkshare_1.c

forkshare_2 : forkshare_2.o
	cc -o forkshare_2 forkshare_2.o
forkshare_2.o : forkshare_2.c
	cc -c forkshare_2.c

wait : wait.o
	cc -o wait wait.o
wait.o : wait.c
	cc -c wait.c

.PHONY : clean cleanall
clean :
	-rm -f child_parent fork forkshare_1 forkshare_2 wait \
		child_parent.o fork.o forkshare_1.o forkshare_2.o wait.o

cleanall : clean
	-rm -f child child.o