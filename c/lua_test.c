#include <stdio.h>
#include <lua5.3/lua.h>
#include <lua5.3/lauxlib.h>
#include <lua5.3/lualib.h>

void stackDump(lua_State *L)
{
	int i;
	int top = lua_gettop(L);
	for(i=1; i<=top; i++)
	{
		int t = lua_type(L, i);
		switch(t)
		{
		  case LUA_TSTRING: {
			printf("'%s'", lua_tostring(L, i));
			break;
		  }
		  case LUA_TBOOLEAN: {
			printf(lua_toboolean(L, i)?"true":"false");
			break;
		  }
		  case LUA_TNUMBER: { /* 数值 */
			if (lua_isinteger(L, i))
				printf("%lld", lua_tointeger(L, i));
			else /* 浮点型 */
				printf("%g", lua_tonumber(L, i));
			break;
		  }
		  default: {
			printf("%s", lua_typename(L, t));
			break;
		  }
		}
		printf("  ");
	}
	printf("\n");
}

/* gcc lua_test.c -o lua_test -llua5.3 */
int main()
{
    lua_remove(L, 0);
    return 0;
}