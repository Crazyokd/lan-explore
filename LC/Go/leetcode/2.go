package leetcode

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