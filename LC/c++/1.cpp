#include<iostream>
#include<vector>
#include<map>
#include<algorithm>

using namespace std;

struct ListNode {
    int val;
    ListNode *next;
    ListNode() : val(0), next(nullptr) {}
    ListNode(int x) : val(x), next(nullptr) {}
    ListNode(int x, ListNode *next) : val(x), next(next) {}
};
class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        vector<int> ans;
        map<int,int> m;
        for(int i=0;i<nums.size();i++){
            int another=target-nums[i];
            if(m[another]){
                ans.push_back(m[another]-1);
                ans.push_back(i);
                break;
            }
            m[nums[i]]=i+1;
        }
        return ans;
    }

    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        ListNode *head = new ListNode();
        int n1=0,n2=0,carry=0;
        ListNode *current=head;
        while(l1!=nullptr || l2 != nullptr || carry != 0){
            if(l1==nullptr)n1=0;
            else{
                n1=l1->val;
                l1=l1->next;
            }
            if(l2==nullptr)n2=0;
            else{
                n2=l2->val;
                l2=l2->next;
            }
            current->next=new ListNode((n1+n2+carry)%10);
            current=current->next;
            carry=(n1+n2+carry)/10;
        }
        return head->next;
    }
    int lengthOfLongestSubstring(string s) {
        //使用map
        map<int,int> m;
        //cur_sta表示当前子串起点
        int ans=0,cur_sta=0,len=s.size();
        for(int i=0;i<len;i++){
            if(m[(int)s[i]]){
                //如果当前字符已经出现过
                ans=max(i-cur_sta,ans);
                //擦除
                for(int j=cur_sta;j<m[(int)s[i]]-1;j++){
                    m[(int)s[j]]=0;
                }
                cur_sta=m[(int)s[i]];
            }
            m[(int)s[i]]=i+1;
        }
        return max(ans,len-cur_sta);
    }
};

int main(){
    vector<int> ans(2);//创建一个size=2的vector
    string s="abba";
    map<int,int> m;
    m[1]=2;
    // cout<<m[1];
    m.erase(1);
    // cout<<m[1];
    // cout<<(int)s[1];
    Solution solution=Solution();
    cout<<solution.lengthOfLongestSubstring(s);
    return 0;
}