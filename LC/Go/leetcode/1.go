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
func lengthOfLongestSubstring(s string)int{
	if len(s) == 0{
		return 0
	}
	var bitSet [256]bool
	result,left,right := 0,0,0
	for right < len (s){
		if bitSet[s[right]] {
			bitSet[s[left]]=false
			left++
		}else{
			bitSet[s[right]]=true
			right++
		}
		if result < right-left{
			result=right-left
		}
		if left + result >= len(s){
			break
		}
	}
	return result
}
func FindMedianSortedArrays(nums1 []int,nums2 []int)float64{
	//保证len(nums1)<=len(nums2)
	if len(nums1) > len(nums2){
		return FindMedianSortedArrays(nums2,nums1);
	}
	low,high,k,nums1Mid,nums2Mid := 0,len(nums1),(len(nums1)+len(nums2)+1)>>1,0,0
	for low <= high{
		nums1Mid = low + (high-low)>>1
		nums2Mid = k - nums1Mid
		if nums1Mid > 0 && nums1[nums1Mid-1] > nums2[nums2Mid]{
			high = nums1Mid - 1;
		}else if nums1Mid != len(nums1) && nums1[nums1Mid] < nums2[nums2Mid - 1]{
			low = nums1Mid + 1;
		}else{
			break
		}
	}
	midLeft,midRight := 0,0
	if nums1Mid == 0{
		midLeft = nums2[nums2Mid - 1]
	}else if nums2Mid == 0{
		midLeft = nums1[nums1Mid - 1]
	}else{
		midLeft = max(nums1[nums1Mid - 1],nums2[nums2Mid - 1])
	}
	if (len(nums1)+len(nums2))&1 == 1{
		return float64(midLeft)
	}
	if nums1Mid == len(nums1){
		midRight = nums2[nums2Mid]
	}else if nums2Mid == len(nums2){
		midRight = nums1[nums1Mid]
	}else{
		midRight = nums1[nums1Mid] ^ nums2[nums2Mid] ^ max(nums1[nums1Mid],nums2[nums2Mid])
	}
	return float64(midLeft+midRight)/2
}

func max(a,b int)int{
    if a > b{
        return a
    }
    return b
}

