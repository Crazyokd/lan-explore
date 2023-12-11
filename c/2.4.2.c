#include <stdio.h>

/* The lookahead symbol */
int token;

int gettoken(void) {
  return token = getchar();
}

void s(void) {
  if (token == '(') {
    gettoken();
    if (token == '(') {
      s();
      gettoken();
      if (token != ')') {
        fprintf(stderr, "Syntax error.\n");
      }
    } else if (token != ')') {
      fprintf(stderr, "Syntax error.\n");
    }
  } else {
    fprintf(stderr, "Syntax error.\n");
  }
}

int main(void) {
  printf("Please enter expressions according to the following grammar:\n");
  printf("S -> S '(' S ')' S | e \n");
  while (1) {
    printf("> ");
    fflush(stdout);
    gettoken();
    if (token == '\n') {
      break;
    }
    s();
  }
  return 0;
}