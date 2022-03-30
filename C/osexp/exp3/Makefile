process : process.o
	@cc -o process process.o
process.o : process.c
	@echo "正在编译process.c"
	cc -c process.c

.PHONY : clean
clean : 
	@echo "清理目录"
	-rm -f process process.o