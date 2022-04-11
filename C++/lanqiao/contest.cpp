#include<iostream>
#include<vector>

using namespace std;

typedef long long ll;

ll solve(int n) {
    if (n == 2) return 2;
    if (n <= 1) return 1;
    long long cnt1 = 0, cnt2 = 0, cnt3 = 0;

    cnt1 = solve(n-1);
    cnt2 = solve(n-2);
    cnt3 = 2*solve(n-3);
    return cnt1+cnt2+cnt3;
}

int main() {
    int n;
    scanf("%d", &n);
    printf("%lld\n", solve(n));
    return 0;
}