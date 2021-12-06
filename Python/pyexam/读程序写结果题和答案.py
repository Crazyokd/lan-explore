# 1.gif 
# 下列 Python语句的输出结果是
# counter = 1
# # num = 0
# #
# #
# # def Testvariable():
# #     global counter
# #     for i in (1, 2, 3):
# #         counter += 1
# #         num = 10
# #
# #
# # Testvariable()
# # print(counter, num)

#1.gif 输出结果是： 4 0





#2.gif:
#  2下列Python语句的程序运行结果为:

#
# class A:
#     def __init__(self, a, b, c):
#         self.x = a + b + c
#
#
# a = A(6, 2, 3)
# b = getattr(a, 'x')
# setattr(a, 'x', b + 1)
# print(a.x)

#2.gif: 12





#3.gif:
# 3  下列 Python语句的输出结果是

# d = lambda p: p * 2
# t = lambda p: p * 3
# x = 2
# x = d(x)
# x = t(x)
# x = d(x)
# print(x)

#3.gif: 24





#4.gif:
 #4 下列 Python语句的输出结果是
#
# def afunction():
#     "The quick brown fox"
#
#     return 1
#
#
# print(afunction.__doc__[4: 9])

#4.gif: quick






#5.gif:
# # 5下列 Python语句的输出结果是
#
# x = 30
#
# def func():
#     global x
#     x = 20
#
#
# func()
# print(x)

#5.gif: 20





#6.gif: 
# # 6 下列 Python语句的输出结果是
#
# fh = open('f.txt', 'w')
# fh.writelines(['python programming.'])
# fh.close()
# fh = open('f.txt', 'rb')
# fh.seek(10, 1)
# print(fh.tell())


#6.gif: 10





#7.gif: 
# # 7  下列 Python语句的输出结果是
#
# f1 = lambda x: x * 2
# f2 = lambda x: x ** 3
# print(f1(f2(2)))

#7.gif: 16




#8.gif: 
#  8 下列 Python语句的输出结果是
# #
# try:
#     x = 1/2
# except ZeroDivisionError:
#     print('aaa')

#8.gif: 没有输出






#9.gif：
# # 9 下列 Python语句的输出结果是
# try:
#     fh = open("testfile", "w")
#     try:
#         fh.write("这是一个测试文件，用于测试异常!!")
#     finally:
#         print("关闭文件")
#         fh.close()
# except IOError:
#     print("Error: 没有找到文件或读取文件失败")

#9.gif：关闭文件




#10.gif：参数没有包含数字
# #10 下列 Python语句的输出结果是
#
# # # 定义函数
# def temp_convert(var):
#     try:
#         return int(var)
#     except ValueError:
#         print("参数没有包含数字\n")
#
#
#  调用函数
# temp_convert("2.1")

#10.gif：参数没有包含数字




#11.gif：
# 11 下列 Python语句的输出结果是
#
# list1 = range(1, 10)
# list4 = [x for x in list1 if x % 2 == 1]
#
# print(list4)

#11.gif：[1, 3, 5, 7, 9]





#12.gif：
#  12下列 Python语句的输出结果是
#
# dic3 = {
#     'name': '小明',
#     'age': 17,
#     'sex': 'male',
#     'height': 1.76,
#     'fond': ['打游戏', '学习']
# }
#
# print(dic3.keys())

#12.gif：dict_keys(['name', 'age', 'sex', 'height', 'fond'])





#13.gif：
# 13 下列 Python语句的输出结果是
#
# list1 = ['01', '02', '03']
# unit_element = '1'
#
# for i, element in enumerate(list1):
#     list1[i] = unit_element + element
#
# print(list1)

#13.gif：['101', '102', '103']






#14.gif：
# # 14 下列 Python语句的输出结果是
# tup1 = ('physics', 'chemistry', 1997, 2000)
# tup2 = (1, 2, 3, 4, 5, 6, 7)
# print(dict(zip(tup1, tup2)))


#14.gif：{'physics': 1, 'chemistry': 2, 1997: 3, 2000: 4}




#15.gif：

# # 15 下列 Python语句的输出结果是
#
# def printinfo(arg1, *vartuple):
#     print("输出: ")
#     print(arg1)
#     for var in vartuple:
#         print(var,end='-')
#
#     return
#
# # 调用printinfo 函数
# printinfo(10)
# printinfo(70, 60, 50)

#15.gif：
#输出: 
#10
#输出: 
#70
#60-50-




#16.gif：

# # 16 下列 Python语句的输出结果是
# class Vector:
#     def __init__(self, a, b):
#         self.a = a
#         self.b = b
#
#     def __str__(self):
#         return 'Vector (%d, %d)' % (self.a, self.b)
#
#     def __add__(self, other):
#         return Vector(self.a + other.a, self.b + other.b)
#
#
# v1 = Vector(2, 10)
# v2 = Vector(5, -2)
# print(v1 + v2)


#16.gif：Vector (7, 8)





#17.gif：

#  # 17下列 Python语句的输出结果是
# class JustCounter:
#     __sCount = 0
#     pCount = 0
#
#     def count(self):
#         self.__sCount += 1
#         self.pCount += 1
#         print(self.__sCount)
#
#
# counter = JustCounter()
# counter.count()
# counter.count()
# print(counter.pCount)
# print(counter.__sCount)

#17.gif：AttributeError: 'JustCounter' object has no attribute '__sCount'






#18.gif：
# #18 Python程序，请写出下列代码运行的结果
# def f(x, y=[]):
#     for i in range(x):
#         y.append(i * i)
#     print(y)
#
#
# f(3)

#18.gif：[0, 1, 4]





#19.gif：
# 19 Python程序，请写出下列代码运行的结果
# def func(s, i, j):
#     if i < j:
#         func(s, i + 1, j - 1)
#         s[i], s[j] = s[j], s[i]
#
#
# def main():
#     a = [10, 13, 24, 15, -9, 0, 3]
#     func(a, 0, len(a) - 1)
#     for i in range(6):
#         print(a[i], end='\t')
#
#
# main()

#19.gif：3	0	-9	15	24	13






#20.gif：
# 20 Python程序，请写出下列代码运行的结果

# i = 1
# while i + 1:
#     if i > 4:
#         print("%d\n" % i)
#         i += 1
#         break
#     print("%d\n" % i)
#     i += 1
#     i += 1

#20.gif：
#1

#3

#5






#21.gif：
# 21 Python程序，请写出下列代码运行的结果
#
# def foo(s):
#     if s == "":
#         return s
#     else:
#         return foo(s[1:]) + s[0]
#
#
# print(foo("hello"))

#21.gif：olleh





#22.gif：
# # 22 Python程序，请写出下列代码运行的结果
# def func(a, b):
#     if (a < b):
#         a, b = b, a
#     r = a % b
#     if r == 0:
#         return b
#     else:
#         return func(b, r)
#
#
# ans = func(342, 84)
# print(ans)

#22.gif：6






#23.gif：
# 23下列程序运行后，在键盘输入"orange and apple",则程序运行结果是

# str = input("请输入一串字符：")
# flag = 0
# count = 0
# for c in str:
#     if c == "":
#         flag = 0
#     else:
#         if flag == 0:
#             flag = 1
#             count = count + 1
#
# print(count)

#23.gif：1





#24.gif：
# # 24 程序的结果是
# import math
#
# n = 0
# lis = []
# for m in range(101, 201, 2):
#     k = int(math.sqrt(m))
#     for i in range(2, k + 2):
#         if m % i == 0:
#             break
#         if i == k + 1:
#             if n % 10 == 0:
#                 print()
#             lis.append(m)
#             n += 1
#
# print(lis)

#24.gif：
#[101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193, 197, 199]






#25.gif：
# # 25 程序的结果是
# from math import *
#
# for i in range(100, 1000):
#     a1 = i // 100
#     a2 = (i % 100) // 10
#     a3 = i % 10
#
#     if (pow(a1, 3) + pow(a2, 3) + pow(a3, 3) == i):
#         print(i, end=' ')

#25.gif：153 370 371 407 






#26.gif：
# #26  程序的结果是
# class Person:
#     # Define the class parameter "name"
#     name = "Person"
#
#     def __init__(self, name=None):
#         # self.name is the instance parameter
#         self.name = name
#
#
# jeffrey = Person("Jeffrey")
# print("%s name is %s" % (Person.name, jeffrey.name))
#
# nico = Person()
# nico.name = "Nico"
# print("%s name is %s" % (Person.name, nico.name))

#26.gif：
#Person name is Jeffrey
#Person name is Nico







#27.gif：
# frequency of words in text
# 按key值对字典排序

# 27 若输入值为"Python2 and Python3. Python2 or Python3."
# freq = {}
#
# print("请输入：")
# line = input()
# for word in line.split():
#     freq[word] = freq.get(word, 0) + 1
#
# words = sorted(freq.keys())
#
# for w in words:
#     print("%s:%d" % (w, freq[w]))

#27.gif：
#Python2:2
#Python3.:2
#and:1
#or:1





#28.gif：
# #28  程序的结果是：
# def putNumbers(n):
#     i = 0
#     while i < n:
#         j = i
#         i = i + 1
#         if j % 7 == 0:
#             yield j
#
# for i in putNumbers(50):
#     print(i)
#28.gif：
#0
#7
#14
#21
#28
#35
#42
#49






#29.gif：

# def f(n):
#     if n == 1:
#         return [1]
#     if n == 2:
#         return [1, 1]
#     f = [1, 1]
#     for i in range(2, n):
#         f.append(f[-1] + f[-2])
#     return f
#
#
# print(f(10))
#29.gif：斐波拉契数列 [1, 1, 2, 3, 5, 8, 13, 21, 34, 55]







#30.gif：
# # 30输出结果为：
# values = []
# for i in range(1000, 3001):
#     s = str(i)
#     if (int(s[0]) % 2 == 0) and (int(s[1]) % 2 == 0) \
#     and (int(s[2]) % 2 == 0) and (int(s[3]) % 2 == 0):
#         values.append(s)
# print(",".join(values))

#30.gif：2000-3000之间的偶数







#31.gif：
# # 31 若输入为"hello world" 输出结果为：
# class InputOutString(object):
#     def __init__(self):
#         self.s = ""
#
#     def getString(self):
#         print('请输入字符串：')
#         self.s = input()
#
#     def printString(self):
#         print(self.s.upper())
#
#
# strObj = InputOutString()
# strObj.getString()
# strObj.printString()

#31.gif：HELLO WORLD






#32.gif：
# #32 输入：34岁,67年,55岁,33岁,12日,98年，输出结果是：
# import re  # re为正则表达式模块
#
# print('请输入一组数字：')
# values = input()
# l = values.split(",")
# k = re.findall(r'[0-9]+', values)
# t = tuple(k)
# print(k)
# print(t)
#32.gif：
#['34', '67', '55', '33', '12', '98']
#('34', '67', '55', '33', '12', '98')







#33.gif：
# # 33 输入:5,则输出为：
# print('请输入一个数字：')
# n = int(input())
# d = dict()
# for i in range(1, n + 1):
#     d[i] = i * i
#
# print(d)

#33.gif：{1: 1, 2: 4, 3: 9, 4: 16, 5: 25}





#34.gif：
# # 34 若输入5,输出结果是：
# def fact(x):
#     if x == 0:
#         return 1
#     return x * fact(x - 1)
#
#
# print('请输入一个数字：')
# x = int(input())
# print(fact(x))

#34.gif：120






# 35.gif
# i = int(input('净利润:'))
# arr = [1000000, 600000, 400000, 200000, 100000, 0]
# rat = [0.01, 0.015, 0.03, 0.05, 0.075, 0.1]
# r = 0
# for idx in range(0, 6):
#     if i > arr[idx]:
#         r += (i - arr[idx]) * rat[idx]
#         print((i - arr[idx]) * rat[idx])
#         i = arr[idx]
# print(r)
#
# 净利润: 120000
#35.gif：
#1500.0
#10000.0
#11500.0






# 36.gif
# lis = []
# for i in range(3):
#     x = int(input('integer:\n'))
#     lis.append(x)
# lis.sort()
# print(lis)
#
# # 若输入整数3,7,1
# # 输出是什么？

#36.gif：[1, 3, 7]







