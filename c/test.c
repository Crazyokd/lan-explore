#include "json/cJSON.h"
#include <stdio.h>
#include <stdlib.h>

int main()
{
    cJSON *root = NULL;
    cJSON *fmt = NULL;

    /* Our "Video" datatype: */
    root = cJSON_CreateObject();
    cJSON_AddItemToObject(root, "name", cJSON_CreateString("Jack (\"Bee\") Nimble"));
    cJSON_AddItemToObject(root, "format", fmt = cJSON_CreateObject());
    cJSON_AddStringToObject(fmt, "type", "rect");
    cJSON_AddNumberToObject(fmt, "width", 1920);
    cJSON_AddNumberToObject(fmt, "height", 1080);
    cJSON_AddFalseToObject (fmt, "interlace");
    cJSON_AddNumberToObject(fmt, "frame rate", 24);

    /* Print to text */
    // if (print_preallocated(root) != 0) {
    //     cJSON_Delete(root);
    //     exit(EXIT_FAILURE);
    // }
    
    char *rules_c = cJSON_Print(root);



    cJSON_Delete(root);
    printf("rules: %s", rules_c);
    free(rules_c);
}
