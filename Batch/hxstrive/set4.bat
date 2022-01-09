@REM substr
@REM %PATH:~10,5%

@echo off
set val=administrator
echo %val%
echo %val:~5,2%
pause

rem 如果没有指定长度，则采用默认值，即变量数值的余数。
set val=administrator
echo %val%
echo %val:~5%
pause

set val=administrator
echo %val%
rem 提取 val 变量的最后6个字符
echo %val:~-6%
rem 从倒数第6个字符开始，提取两个字符
echo %val:~-6,2%
rem 提取 val 变量的所有字符，除了最后两个
echo %val:~0,-2%
rem 提取倒数第6个字符开始到结尾的字符，除了最后两个字符
echo %val:~-6,-2%
pause