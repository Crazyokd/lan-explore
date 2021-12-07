package leetcode
import (
	"sort"
)

func maxArea(height []int) int{
	max,start,end := 0,0,len(height)-1
	for start < end{
		width := end - start
		high := 0
		if height[start] < height[end]{
			high = height[start]
			start++
		}else{
			high = height[end]
			end--
		}

		t := width*high
		if t > max{
			max = t
		}
	}
	return max
}

func intToRoman(num int) string {
    values := []int{1000,900,500,400,100,90,50,40,10,9,5,4,1}
	symbols := []string{"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"}
	res,i := "",0
	for num != 0{
		for values[i] > num{
			i++
		}
		num -= values[i]
		res += symbols[i]
	} 
	return res
}

func romanToInt(s string) int {
	if s==""{
		return 0;
	}
	var roman = map[string]int{
		"I":1,
		"V":5,
		"X":10,
		"L":50,
		"C":100,
		"D":500,
		"M":1000,
	}
	num,lastint,total := 0,0,0
	for i:=0;i<len(s);i++{
		char := s[len(s)-(i+1):len(s)-i]
		num = roman[char]
		if num < lastint{
			total = total - num
		}else{
			total = total + num
		}
		lastint = num
	}
	return total
}

//最优解，双指针 + 排序
func threeSum(nums []int) [][]int {
    sort.Ints(nums)
	result,start,end,index,addNum,length := make([][]int,0),0,0,0,0,len(nums)
	for index = 1;index < length - 1;index++{
		start,end = 0,length-1
		if index > 1 && nums[index] == nums[index-1]{
			start = index -1
		}
		for start < index && end > index{
			if start > 0 && nums[start] == nums[start-1]{
				start++
				continue
			} 
			if end < length-1 && nums[end] == nums[end+1]{
				end--
				continue
			}
			addNum = nums[start] + nums[end] + nums[index]
			if addNum == 0{
				result = append(result,[]int{nums[start],nums[index],nums[end]})
				start++
				end--
			}else if addNum > 0{
				end--
			}else{
				start++
			}
		}
	}
	return result
}

//解法二
func threeSum1(nums []int) [][]int{
	res := [][]int{}
	counter := map[int]int{}
	for _,value := range nums{
		counter[value]++
	}

	uniqNums := []int{}
	for key := range counter{
		uniqNums = append(uniqNums,key)
	}
	sort.Ints(uniqNums)

	for i := 0;i < len(uniqNums);i++{
		if (uniqNums[i]*3 == 0) && counter[uniqNums[i]] >= 3{
			res = append(res,[]int{uniqNums[i],uniqNums[i],uniqNums[i]})
		}
		for j := i+1;j < len(uniqNums);j++{
			if (uniqNums[i]*2+uniqNums[j] == 0) && counter[uniqNums[i]] > 1{
				res = append(res,[]int{uniqNums[i],uniqNums[i],uniqNums[j]})
			}
			if (uniqNums[j]*2+uniqNums[i] == 0) && counter[uniqNums[j]] > 1{
				res = append(res,[]int{uniqNums[i],uniqNums[j],uniqNums[j]})
			}
			c := 0-uniqNums[i] - uniqNums[j]
			if c > uniqNums[j] && counter[c] > 0{
				res =  append(res,[]int{uniqNums[i],uniqNums[j],c})
			}
		}
	}
	return res
}