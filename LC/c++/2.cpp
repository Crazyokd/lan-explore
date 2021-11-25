#include<vector>
#include<algorithm>
#include<string>
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
    string intToRoman(int num) {
        int values[] = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        string symbols[] = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        string res="";
        int i=0;
        while(num != 0){
            while(values[i] > num){
                i++;
            }
            num -= values[i];
            res += symbols[i];
        } 
        return res;
    }
};

int main(){
    Solution solution=Solution();

    return 0;
}