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