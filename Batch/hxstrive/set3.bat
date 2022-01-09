@REM /P 命令行开关允许将变量数值设成用户输入的一行输入。
@REM 读取输入行之前，显示指定的 promptString。promptString 可以是空的。

@echo off
set /p username=请输入姓名：
echo 你的姓名：%username%
pause

rem replace the variable
@REM %PATH:str1=str2%

set val=hello bat
echo %val%
rem replace
echo %val:bat=CMD%
pause

@echo off
set val=hello bat
echo %val%
echo %val:a=%
pause

@REM "str1" 可以以星号打头；在这种情况下，"str1" 会从扩展结果的开始到 str1 剩余部分第一次出现的地方，都一直保持相配
set val=hello bat hello bat
echo %val%
echo %val:*bat=CMD%
pause