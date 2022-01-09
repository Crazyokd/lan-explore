@echo off
set /p score=输入成绩：
if %score% lss 60 (
    echo 未及格，需要多努力啊!
) else if %score% lss 70 (
    echo 及格，多做题
) else if %score% lss 80 (
    echo 良，加把劲考
) else if %score% lss 90 (
    echo 优，你很优秀，继续保持
) else (
    echo 不是凡人
)
pause


@REM 将 else if 换行，需要在 “)” 后面添加 “^” 符号。
set /p score=输入成绩：
if %score% lss 60 (
    echo 未及格，需要多努力啊!
) ^
else if %score% lss 70 (
    echo 及格，多做题
) ^
else if %score% lss 80 (
    echo 良，加把劲考
) ^
else if %score% lss 90 (
    echo 优，你很优秀，继续保持
) ^
else (
    echo 不是凡人
)
pause