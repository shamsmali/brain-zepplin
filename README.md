##Brain Zepplin Interpreter

Added custom interpreter for Brain. This is just a simple p.o.c. By default, bb interpreter is enabled.

Sample commands,

ls -> executes local ls -l command
file <name> -> reads the content of a file
fileList -> Lists all the files under current directory


... many more can added and customized


### Build.
```
clone the repo and cd into it
mvn clean package -Pscalding -DskipTests
import to intellij
find bigbrain and start coding
```
