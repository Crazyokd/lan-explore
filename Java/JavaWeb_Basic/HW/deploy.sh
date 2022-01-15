find -name "*.java" > sources.txt
javac @sources.txt -d ./WEB-INF/classes/ -nowarn -g:none

rm ./sources.txt