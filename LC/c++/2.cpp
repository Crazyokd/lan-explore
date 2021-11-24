#include<vector>
#include<algorithm>
using namespace std;

class Solution {
public:
    //从两端向中间扩散
    int maxArea(vector<int>& height) {
        int start=0,end=height.size()-1;
        int ans=0;
        while(end > start){
            ans=max(ans,(end-start)*min(height[start],height[end]));
            if(height[start] > height[end])end--;
            else start++;
        }
        return ans;
    }
};

int main(){
    Solution solution=Solution();

    return 0;
}