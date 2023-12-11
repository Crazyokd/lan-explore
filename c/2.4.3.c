#include <stdio.h>

/* The lookahead symbol */
int token;

int gettoken(void) {
  return token = getchar();
}

void s(void) {
  if (token == '0') {
    gettoken();
    if (token == '0') {
      s();
      gettoken();
      if (token != '1') {
        fprintf(stderr, "Syntax error.\n");
      }
    } else if (token != '1') {
      fprintf(stderr, "Syntax error.\n");
    }
  } else {
    fprintf(stderr, "Syntax error.\n");
  }
}

int main(void) {
  printf("Please enter expressions according to the following grammar:\n");
  printf("S -> 0 S 1 | 0 1 \n");
  printf("> ");
  fflush(stdout);
  gettoken();
  s();
  return 0;
}