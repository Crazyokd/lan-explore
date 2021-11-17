#include<iostream>
#include<vector>
#include<map>

using namespace std;
int main(){
    vector<int> ans(2);//创建一个size=2的vector
    return 0;
}
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

};