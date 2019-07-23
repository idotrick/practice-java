echo Setup Environment...
set JAVA_HOME=%JDK12_HOME%
set proj_home=.
set src=%proj_home%\src\main\java
set target=%proj_home%\target\classes
set classpath=%target%;%classpath%

echo cleaning...
del /Q %target%\*

echo compiling...
dir %src% /B

%JAVA_HOME%\bin\javac %src%\* -d %target%

echo compiled classes..
dir %target% /B
