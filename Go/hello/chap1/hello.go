package main

import "fmt"
import "unicode/utf8"
import "rsc.io/quote"

func main(){
	//A1
	for i:=0;i<10;i++{
		fmt.Printf("%d",i)
	}
	fmt.Printf("\n")
	i:=1
loop:
	fmt.Printf("%d",i)
	if i<10{
		i++
		goto loop
	}
	fmt.Printf("\n")
	var arr [10]int
	for i:=0;i<10;i++{
		arr[i]=i
	}
	fmt.Printf("%v",arr)
	fmt.Printf("\n")
	a:=[...]int{1,2,3,4,5,6,7,8,9}
	fmt.Printf("%v",a)
	fmt.Printf("\n")

	//A2
	const (
		FIZZ=3
		BUZZ=5
	)
	var p bool 
	for i:=1;i<100;i++{
		p=false;
		if i%FIZZ==0{
			fmt.Printf("FIZZ")
			p=true
		}
		if i%BUZZ==0{
			fmt.Printf("BUZZ")
			p=true
		}
		if !p{
			fmt.Printf("%v",i)
		}
	}
	fmt.Printf("\n")
	//A3
	str:="A"
	for i:=0;i<10;i++{
		fmt.Printf("%s\n",str)
		str+="A"
	}
	fmt.Printf("\n")
	str="hello,world"
	// b:=[]byte(str)
	fmt.Printf("String:%s\nLength:%d,Runes:%d\n",str,
			len([]byte(str)),utf8.RuneCount([]byte(str)))
	
	r:=[]rune(str)
	copy(r[4:4+3],[]rune("abc"))//将第二个参数复制到第一个参数
	fmt.Printf("%s\n",string(r))

	abc:="foobar"
	efg:=[]rune(abc)
	for i,j:=0,len(efg)-1;i<j;i,j=i+1,j-1{//len函数的参数必须为rune数组
		efg[i],efg[j]=efg[j],efg[i]
	}
	fmt.Printf("%s\n",string(efg))
	//A4
	// sum:=0.0
	fmt.Println(quote.Go())
}