// #include<iostream>
// #include<vector>

// using namespace std;

// typedef long long ll;

// int main() {
//     ll a, b, n;
//     scanf("%lld%lld%lld", &a, &b, &n);
//     // ll sum = 0;
//     ll day = 1;
//     while (n > 0) {
//         if (day % 6 == 0 || day % 7 == 0) {
//             n -= b; 
//         } else {
//             n -= a;
//         }
//         day++;
//     }
//     printf("%lld\n", day-1);
//     return 0;
// }

// #include<iostream>
// #include<vector>

// using namespace std;

// int maxHeight(int left, int right) {
//     if (left > right) {
//         return 2*left;
//     } else {
//         return 2*right;
//     }
// }
// int main() {
//     int n;
//     scanf("%d", &n);
//     for (int i = 1; i <= n; i++) {
//         printf("%d\n", maxHeight(i-1, n-i));
//     }
//     return 0;
// }

// #include<iostream>
// #include<vector>

// using namespace std;

// typedef long long ll;

// ll solve(int n) {
//     if (n == 2) return 2;
//     if (n <= 1) return 1;
//     long long cnt1 = 0, cnt2 = 0, cnt3 = 0;

//     cnt1 = solve(n-1);
//     cnt2 = solve(n-2);
//     cnt3 = 2*solve(n-3);
//     return cnt1+cnt2+cnt3;
// }

// int main() {
//     int n;
//     scanf("%d", &n);
//     printf("%lld\n", solve(n));
//     return 0;
// }


// #include<iostream>
// #include<vector>

// using namespace std;

// typedef long long ll;

// int solve(int n, int m, int sum) {
//     if (sum == 0) {
//         if (m == 0 && n == 0)return 1;
//         else return 0;
//     }
//     int cnt1 = 0, cnt2 = 0;
//     if (n > 0) {
//         cnt1 = solve(n-1, m, sum*2);
//     }
//     if (m > 0) {
//         cnt2 = solve(n, m-1, sum-1);
//     }
//     return (cnt1+cnt2)%1000000007;
// }

// int main() {
//     int n, m;
//     scanf("%d%d", &n, &m);
//     printf("%d\n", solve(n, m, 2));
//     return 0;
// }

// 1000000007
// 5 10
// 14
// 遇店N次，遇花M次