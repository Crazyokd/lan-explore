all : exp1 exp2 exp3 exp4

.PHONY: all exp1 exp2 exp3 exp4 clean

exp1 : 
	@echo make exp1
	cd exp1 && $(MAKE)
exp2 :
	cd exp2 && $(MAKE)
exp3 :
	cd exp3 && $(MAKE)
exp4 :
	# ignore error
	-cd exp4 && $(MAKE)
	@echo "run success"

clean : 
	@echo "清理目录"
	@cd exp1 && $(MAKE) clean
	@cd exp2 && $(MAKE) clean
	@cd exp3 && $(MAKE) clean
	@cd exp4 && $(MAKE) clean