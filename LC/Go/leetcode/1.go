package leetcode

//make(type,len,capacity=len)
//访问数组时不得越界(len)
//切片不得越界(capacity)
//切片共用地址空间

//make(map[type1]type2)对应的map有默认值
//map[type1]type2
//m[type1]=type2
func twoSum(nums []int, target int) []int {
	m := make(map[int]int)
	for i := 0;i < len(nums);i++{
		another := target - nums[i]
		if _,ok := m[another];ok{
			return []int{m[another],i}
		}
		m[nums[i]]= i
	}
	return nil
}

func TwoSum(nums []int, target int) []int {
	return twoSum(nums,target)
}

type ListNode struct {
    Val int
	Next *ListNode
}
func AddTwoNumbers(l1 *ListNode, l2 *ListNode) *ListNode {
	head := &ListNode{Val: 0}
	n1,n2,carry,current := 0,0,0,head
	for l1 != nil || l2 != nil || carry != 0{
		if l1 != nil{
			 n1=l1.Val
			 l1=l1.Next
		 }else{
			 n1=0
		 }
		 if l2 != nil{
			 n2=l2.Val
			 l2=l2.Next
		 }else{
			 n2=0
		 }
		 current.Next = &ListNode{Val: (n1+n2+carry)%10}
		 current = current.Next
		 carry = (n1+n2+carry)/10
	}
	return head.Next
}