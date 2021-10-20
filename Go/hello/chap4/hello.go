package main

import "fmt"
// import "container/list"
import "errors"


type e interface{}

func mult2(f e)e{
	switch f.(type){
	case int:
		return f.(int)*2
	case string:
		return f.(string)+f.(string)+f.(string)+f.(string)
	}
	return f
}


type Value int

func Map(n []e,f func(e)e)[]e{
	m:=make([]e,len(n))
	for k,v:=range n{
		m[k]=f(v)
	}
	return m
}

type Node struct {
	Value
	prev,next *Node
}

type List struct {
	head, tail *Node
}

func (l *List) Front() *Node {
	return l.head
}
func (n *Node) Next() *Node {
	return n.next
}
func (l *List) Push(v Value) *List {
	n := &Node{Value: v}
	if l.head == nil {
		l.head = n
	} else {
		l.tail.next = n 
		n.prev = l.tail
	}
	l.tail = n
	return l
}
var errEmpty = errors.New("List is empty")
func (l *List) Pop() (v Value, err error) {
	if l.tail == nil {
		err = errEmpty
	} else {
		v = l.tail.Value
		l.tail = l.tail.prev
		if l.tail == nil {
			l.head = nil
		}
	}
	return v,err
}

func main(){
	m:=[]e{1,2,3,4}
	s:=[]e{"a","b","c","d"}
	mf:=Map(m,mult2)
	ms:=Map(s,mult2)
	fmt.Printf("%v\n",mf)
	fmt.Printf("%v\n",ms)
	// l:=list.New()
	// l.PushBack(1)
	// l.PushBack(2)
	// l.PushBack(4)

	// for e:=l.Front();e!=nil;e=e.Next(){
	// 	fmt.Printf("%v",e.Value)
	// }
	l:=new(List)
	l.Push(1)
	l.Push(2)
	l.Push(4)

	for e:=l.Front();e!=nil;e=e.Next(){
		fmt.Printf("%v",e.Value)
	}
}