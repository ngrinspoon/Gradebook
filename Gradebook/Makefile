all: gradebookadd gradebookdisplay setup

JFLAGS=-g
JC = javac

gradebookadd:
	$(JC) $(JFLAGS) gradebookadd.java Gradebook.java
	echo "java gradebookadd" > gradebookadd

gradebookdisplay:
	$(JC) $(JFLAGS) gradebookdisplay.java Gradebook.java
	echo "java gradebookdisplay" > gradebookdisplay

setup:
	$(JC) $(JFLAGS) setup.java Gradebook.java
	echo "java setup" > setup


clean:
	rm -f *.class
	rm -f gradebookadd gradebookdisplay setup
