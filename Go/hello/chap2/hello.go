package main

import (
	"fmt"
	"rsc.io/quote"
	"strconv"
)

//编写一个函数用于计算一个float64类型的slice的平均值
func average(xs []float64)(avg float64){
	sum:=0.0
	switch len(xs){
	case 0:
		avg=0
	default:
		for _,v:=range xs{
			sum+=v;
		}
		avg=sum/float64(len(xs))
	}
	return 
}
func order(a,b int)(int,int){
	if a>b{
		return b,a
	}
	return a,b
}

type stack struct{//Go的type关键字类似于c++中的typedef关键字
	i int
	data [10]int
}

func (s *stack)push(k int){//将函数定义为stack类型的成员函数
	if s.i+1>9{
		return
	}
	s.data[s.i]=k
	s.i++
}

func (s *stack)pop() int{//似乎不是指针都不行
	if s.i==0{
		return -1
	}
	s.i--
	return s.data[s.i]
}

//每次%v打印相当于打印对象的String方法
func (s stack)String() string{//相当于重写String方法
	var str string
	for i:=0;i<s.i;i++{
		str=str+"["+strconv.Itoa(i)+":"+strconv.Itoa(s.data[i])+"]"
	}
	return str
}

//和Java的形式相似
func printthem(numbers... int){
	for _,d:=range numbers{
		fmt.Printf("%d",d)
	}
}

func fibonacci(n int)[]int{
	x:=make([]int,n)//n作为容量变量
	x[0],x[1]=1,1//这边初始化是真香
	for i:=2;i<n;i++{
		x[i]=x[i-1]+x[i-2]
	}
	return x
}

//将l数组中的每个元素使用f函数处理一次
func Map(f func(int) int,l []int)[]int{
	j:=make([]int,len(l))
	for k,v:=range l{
		j[k]=f(v)
	}
	return j
}
func max(l []int)(max int){
	max=l[0]
	for _,v:=range l{
		if v>max{
			max=v
		}
	}
	return  //若不指定，默认返回返回值参数
}
//slice(数组)是一个引用类型

func bubblesort(n []int) {
	for i := 0 ; i < len(n) - 1 ; i++ {
		for j := i + 1 ; j < len(n) ; j++ {
			if n[j] < n[i] {
				n[i], n[j] = n[j], n[i]
			}
		}
	}
}
func main(){
	fmt.Println(quote.Go())
	a,b:=order(2,7)
	fmt.Printf("%d,%d\n",a,b)
	a,b=order(8,3)
	fmt.Printf("%d,%d\n",a,b)
	//测试push和pop函数
	var s stack
	s.push(25)
	s.push(14)
	fmt.Printf("%v\n",s)
	fmt.Printf("%d\n",s.pop())
	fmt.Printf("%v\n",s)
	printthem(1,2,3,4,5,6)
	printthem(23,326,7,5,34,2)	
	fmt.Printf("%v\n",fibonacci(10))
	m:=[]int{1,3,4,3}
	f:=func(i int)int{
		return i*i
	}
	fmt.Printf("%v",Map(f,m))
	fmt.Printf("%v\n",max(m))
	bubblesort(m)
	fmt.Printf("%v\n",m)//验证m（slice）是一种引用类型，
	
}
