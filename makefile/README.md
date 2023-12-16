# 笔记
```shell
targets: prerequisites
	command
	command
	command
```

Make decides if it should run the target. It will only run if target doesn't exist, or prerequisites is newer than target.
the first target is the default target

# Outputs the target name
echo $@

# Outputs all prerequisites newer than the target
echo $?

# [Output the first prerequisite](https://www.gnu.org/software/make/manual/html_node/Automatic-Variables.html)
echo $<

# Outputs all prerequisites
echo $^

The important variables used by implicit rules are:

CC: Program for compiling C programs; default cc
CXX: Program for compiling C++ programs; default g++
CFLAGS: Extra flags to give to the C compiler
CXXFLAGS: Extra flags to give to the C++ compiler
CPPFLAGS: Extra flags to give to the C preprocessor
LDFLAGS: Extra flags to give to compilers when they are supposed to invoke the linker

* searches your filesystem for matching filenames. I suggest that you always wrap it in the wildcard function
* The default shell is /bin/sh, You can change this by changing the variable SHELL
* Each command is run in a new shell
* If you want a string to have a dollar sign, you can use $$. This is how to use a shell variable in bash or sh
5.5 Errors in Recipes
每一条recipe调用返回后，make都会查看它的exit status。
如果shell执行成功（exit status为0），那么下一条recipe就会在新的shell中继续被执行；
如果存在一个错误（exit status不为0），make就会放弃当前的rule
To ignore errors in a recipe line, write a ‘-’ at the beginning of the line’s text
see also `make -i` or `make --ignore-errors`
`make -k`: 使用了这个选项，如果recipe出现任何错误，make仅仅会停止构建当前rule，但它会继续执行直接依赖该rule的target的其他的prerequisite。
使用-k选项可以为你下一次make发现尽可能多的错误。但也有一个可以用``.DELETE_ON_ERROR`target解决的潜在问题。
5.6 Interrupting or Killing
如果在make执行过程中发送一个fatal signal给make，那么make会删除当前正在构建的target以防止奇怪的错误。

* When Make starts, it automatically creates Make variables out of all the environment variables that are set when it's executed.
* The `export` directive takes a make variable and sets it the environment for all shell commands in all the recipes. And this way will make it accessible to sub-make commands. `.EXPORT_ALL_VARIABLES` exports all variables for you.
* you can specify multi target to make, it will make one by one.
* 行首的空格会被自动删除，但行尾不会。To make a variable with a single space, use $(nullstring)

1. make会默认每一个prerequisite是一个依赖
2. 将prerequisites中的每一个依赖视为一个target，并对每一个target递归执行步骤1、2；如果prerequisites为空，则进入步骤3
3. 如果target对应的文件不存在，则执行该target下的command，如果存在，那么不执行该target下的command，然后回溯到上一个节点作为一个依赖。
4. 如果对应的target文件不存在，执行该target下的command，如果文件存在，则与上一步回溯过来的依赖对比文件修改时间。
5. 只要依赖项中的任何一个对应的文件修改时间晚于target文件，那么make都会执行target下的command


试想一下如果target对应的文件不存在会怎样呢？
那么每次都会执行target下对应的command，因为想要的target不存在make就认为需要make一个target
试想一下如果target对应的文件存在但不存在prerequisites会怎样呢？
那么make每次都不会执行target下对应的command，因为target对应的文件已经存在了而又不存在prerequisites作为参考物

所以到头来prerequisites都是target，而target也都会尝试映射为文件，然后比较文件的修改时间。

所以你现在知道为什么会有.PHONY了吧

* 对于通配的rule一定要注意，相当于通配的每一个target都会执行一遍recipes，所以其中的recipe一般使用`$<`而不是`$?`

func handle_target(target)
	if exist_file(target)
		return
	else
		execute command_of_target(target)
endfunc

func handle(target)
for (prerequisite : prerequisites_of_target(target))
	if exist_prerequisite(prerequisite)
		handle(prerequisite)
		if (!exist_file(prerequisite))
			continue
		else
			if (modtime(prerequisite) > modtime(target))
				execute command_of_target(target)
			else
				continue
	else
		handle_target()

if !exist_file(target)
	execute command
else
	if null(prerequisites)
		do not execute command forever
	if modtime(anyof(prerequisites)) > modtime(target)
		execute command

# 学习资源
- https://makefiletutorial.com/
- https://www.gnu.org/software/make/