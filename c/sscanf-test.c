#include <stdio.h>

int main()
{
    char caller[32];
    char tag[40];
    char *str = "From: <sip:13801234504@[fd01:3200:3200::210]>;tag=413a6486-99d8-4375-a029-0a21dddce3dd";
    sscanf(str, "%*[^<]<%*[^0-9]%31[0-9]", caller);
    sscanf(str, "%*[^<]<%*[^0-9]%31[0-9]%*[^tag=]tag=%36[a-fA-F0-9-]", caller, tag);

    printf("caller=%s; tag=%s\n", caller, tag);
	return 0;
}
