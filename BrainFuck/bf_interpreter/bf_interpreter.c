#include <stdio.h>
#include <stdlib.h>

#define TAPE_SIZE 30000

int main(int argc, char *argv[]) {
    if (argc != 2) {
        printf("Usage: %s <filename>\n", argv[0]);
        return 1;
    }

    FILE *file = fopen(argv[1], "r");
    if (!file) {
        perror("Error opening file");
        return 1;
    }

    unsigned char tape[TAPE_SIZE] = {0};
    unsigned char* ptr = tape;
    char c, code[30000], *codeptr = code;
    int brackets = 0, i;

    while ((c = fgetc(file)) != EOF) {
        *codeptr++ = c;
    }
    *codeptr = 0;
    fclose(file);

    for (codeptr = code; *codeptr; ++codeptr) {
        switch (*codeptr) {
            case '>': ++ptr; break;
            case '<': --ptr; break;
            case '+': ++*ptr; break;
            case '-': --*ptr; break;
            case '.': putchar(*ptr); break;
            case ',': *ptr = getchar(); break;
            case '[':
                if (!*ptr) {
                    brackets = 1;
                    while (brackets) {
                        ++codeptr;
                        if (*codeptr == '[') ++brackets;
                        if (*codeptr == ']') --brackets;
                    }
                }
                break;
            case ']':
                if (*ptr) {
                    brackets = 1;
                    while (brackets) {
                        --codeptr;
                        if (*codeptr == '[') --brackets;
                        if (*codeptr == ']') ++brackets;
                    }
                }
                break;
        }
    }
    
    return 0;
}
