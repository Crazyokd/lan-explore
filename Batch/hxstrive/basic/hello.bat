@echo off
echo hello world
pause & exit

@REM （1）@ 表示将不在 DOS 中显示 echo off 命令；

@REM （2）echo off 表示后续命令在 DOS 中不显示；

@REM （3）echo hello bat 表示将在 DOS 中显示 “hello world” 字符串；

@REM （4）pause 表示脚本执行完成后，不立即关闭 DOS 窗口，而是提示 “请按任意键继续...” 信息。当用户按了任意键，DOS 窗口将关闭；