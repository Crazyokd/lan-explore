#include "tt.hpp"

template <typename T>
T min(T const a, T const b)
{
    return a < b ? a : b;
}

template <>
int min(int const a, int const b)
{
    return a > b ? b : a;
}

double c = min(1111.11, 222.11);
