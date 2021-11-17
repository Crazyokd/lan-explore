package main

import "fmt"
import "rekord/leetcode"

func main() {
    fmt.Println("Hello, World!")
    array := []int{2,7,11,15}
    fmt.Println(leetcode.TwoSum(array,9))
    //初始化为false
    var bitSet [256]bool
    fmt.Println(bitSet[1],bitSet[2])
}