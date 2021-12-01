#include<vector>
#include<iostream>
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
    int romanToInt(string s) {
        int commonValues[] = {1000,500,100,50,10,5,1};
        int specialValues[] = {900,400,90,40,9,4};
        string commonSymbols[] = {"M","D","C","L","X","V","I"};
        string specialSymbols[] = {"CM","CD","XC","XL","IX","IV"};
        int ans=0;
        for(int i=0;i < s.size();i++){
            int j;
            for(j=0;j < 6;j++){
                if(s.substr(i,2) == specialSymbols[j]){
                    ans+=specialValues[j];
                    i+=1;
                    break;
                }    
            }
            if(j < 6)continue;
            for(j=0;j < 7;j++){
                if(i<s.size() && s.substr(i,1) == commonSymbols[j]){
                    ans+=commonValues[j];
                    break;
                }
            }
        }
        return ans;
    }
};

int main(){
    Solution solution=Solution();
    cout<<solution.romanToInt("MCMXCIV");
    return 0;
}