@REM （1）goto 语句和标签要互相呼应，不能只有 goto 语句而没有相应的标签段；否则，程序将找不到相应的标签段而直接退出。
@echo off
echo hello bat
goto test
echo www.hxstrive.com
pause