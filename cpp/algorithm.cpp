#include <algorithm>
#include <string>
#include <list>

using std::string;
using std::list;

void testFind()
{
    list<string> list;
    string val = "a value";
    auto result = std::find(list.cbegin(), list.cend(), val);

    std::unique(val.begin(), val.end());
}

int main()
{
    return 0;
}
