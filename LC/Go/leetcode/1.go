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