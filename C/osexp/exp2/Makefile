all : pipe pipe_1 rcvfile rcvshm sndfile sndshm
.PHONY : all

pipe : pipe.o
	cc -o pipe pipe.o
pipe.o : pipe.c
	cc -c pipe.c

pipe_1 : pipe_1.o
	cc -o pipe_1 pipe_1.o
pipe_1.o : pipe_1.c
	cc -c pipe_1.c

rcvfile : rcvfile.o
	cc -o rcvfile rcvfile.o
rcvfile.o : rcvfile.c
	cc -c rcvfile.c

rcvshm : rcvshm.o
	cc -o rcvshm rcvshm.o
rcvshm.o : rcvshm.c	
	cc -c rcvshm.c

sndfile : sndfile.o
	cc -o sndfile sndfile.o
sndfile.o : sndfile.c
	cc -c sndfile.c

sndshm : sndshm.o
	cc -o sndshm sndshm.o
sndshm.o : sndshm.c
	cc -c sndshm.c

.PHONY : clean
clean :
	-rm -f pipe pipe_1 rcvfile rcvshm sndfile sndshm \
		pipe.o pipe_1.o rcvfile.o rcvshm.o sndfile.o sndshm.o