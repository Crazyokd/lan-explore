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
    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
        int len1=nums1.size(),len2=nums2.size();
        vector<int> ans;
        int cur1=0,cur2=0;
        while(cur1 < len1 || cur2 < len2){
            while(cur1< len1 && (cur2 ==len2 || nums1[cur1] <= nums2[cur2])){
                ans.push_back(nums1[cur1]);
                cur1++;
            }
            while(cur2 < len2 && (cur1 == len1 || nums1[cur1] > nums2[cur2])){
                ans.push_back(nums2[cur2]);
                cur2++;
            }
        }
        cout<<ans.size()<<endl;
        for(int i=0;i<ans.size();i++){
            cout<<ans[i]<<endl;
        }
        if((ans.size())%2==0)return (ans[ans.size()/2-1]+ans[ans.size()/2])/2.0;
        else return ans[ans.size()/2];
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
    // cout<<solution.lengthOfLongestSubstring(s);
    vector<int> a,b;
    a.push_back(1),a.push_back(3);
    b.push_back(2);
    solution.findMedianSortedArrays(a,b);
    return 0;
}