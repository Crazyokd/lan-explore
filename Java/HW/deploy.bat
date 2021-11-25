dir /s /B *.java > .\sources.txt

javac @sources.txt -d .\WEB-INF\classes\ -nowarn -g:none

del sources.txt
