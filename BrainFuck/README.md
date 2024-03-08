# How Compile BrainFuck code
This guide provides instructions on how to compile and run Brainfuck code using a custom C interpreter. Follow these step-by-step instructions to set up your environment and execute Brainfuck scripts.

## Prerequisites
Ensure you have GCC (GNU Compiler Collection) installed on your system to compile the Brainfuck interpreter written in C.

- **Windows Users**: Install MinGW or Cygwin.
- **Linux Users**: GCC is usually pre-installed. If not, Terminal `sudo apt-get install gcc` on Debian/Ubuntu.
- **macOS Users**: Terminal `brew install gcc`

## Step 1: Download the Brainfuck Interpreter Source Code

Download the `bf_interpreter.c` source code from the provided location or copy it from the given instructions. Or just download full BrainFuck dir with some examples of .bf code

## Step 2: Compiling the Interpreter

Open a terminal or command prompt and navigate to the directory where `bf_interpreter.c` is located. Compile the interpreter using the following command:

Open or navigate terminal line to your directory with .bf files and bf_interpreter.c
(For example /(pathToThisDir)/BrainFuck)
```Terminal
cd /BrainFuck
```
Run bf_interpreter.c
```Terminal
gcc -o bf_interpreter/bf_interpreter bf_interpreter/bf_interpreter.c
```
Compile your.bf code
```Terminal
gcc -o ./bf_interpreter/bf_interpreter nameOfYourFile.bf
```
Compile your.bf code
(For example HelloWorld.bf)
```Terminal
gcc -o ./bf_interpreter/bf_interpreter HelloWorld.bf
```
