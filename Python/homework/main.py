# 1. 编写程序，生成一个包含50个随机整数的列表，然后删除其中所有奇数（提示：从后向前删除）。
import random

print("1. 编写程序，生成一个包含50个随机整数的列表，然后删除其中所有奇数（提示：从后向前删除）。")
lis=[]
for i in range(50):
    lis.append(int(random.random()*100))
print(lis)

odd_list=[]
for i in lis:
    if i%2==0:
        odd_list.append(i)
print(odd_list)
print()
#
# 2. 编写程序，生成一个包含20个随机整数的列表，然后对其中偶数下标的元素进行降序排列，奇数小标的元素不变（提示：使用切片）
print("2. 编写程序，生成一个包含20个随机整数的列表，然后对其中偶数下标的元素进行降序排列，奇数小标的元素不变（提示：使用切片）")
lis=[]
for i in range(20):
    lis.append(int(random.random()*100))
print("origin list",lis)
print("even list",sorted(lis[::2]))
print('odd list',lis[1::2])
print()
# #
# # 3. 编写程序，用户从键盘输入小于1000的整数，对其进行因数分解。例如：10=2×5,60=2×2×3×5。
print("3. 编写程序，用户从键盘输入小于1000的整数，对其进行因数分解。例如：10=2×5,60=2×2×3×5")
value=int(input("请输入一个小于1000的整数："))
print(value,"=",end=' ')
i=2
ans=[]
while value!=1:
    if value%i==0:
        value/=i
        ans.append(i)
    else:
        i+=1
for i in range(len(ans)-1):
    print(ans[i],end='*')
print(ans[len(ans)-1])
print()

# # 4. 编写程序，快速判断一个数是否为素数。
def isShuSu(sushu):
    i = 2
    while i <= sushu / i:
        if (sushu % i == 0):

            return False
        else:
            i += 1
    return True

print("4. 编写程序，快速判断一个数是否为素数")
if(isShuSu(int(input("请输入测试数：")))):
    print("是一个素数")
else:
    print("不是一个素数")
print()
#
# 5. 编写程序，输出所有由1/2/3/4这四个数字组成的素数，并且每个素数中，每个数字只使用一次。
print("5. 编写程序，输出所有由1/2/3/4这四个数字组成的素数，并且每个素数中，每个数字只使用一次。")

# 简单起见，这里只输出10000以内的满足条件的素数
for i in range(10001):
    if i>1 and isShuSu(i):
        if str(i).__contains__('1') or str(i).__contains__('1') or str(i).__contains__('1') or str(i).__contains__('1'):
            print(i)

print()
# 6. 编写程序，键盘输入若干个成绩，求所有成绩的平均分。
print("6. 编写程序，键盘输入若干个成绩，求所有成绩的平均分")
ans=0
cnt=0
while True:
    i=input("请输入成绩，按n/N退出：")
    if i.lower()=='n':
        break
    cnt+=1
    ans+=float(i)
print(ans/cnt)
print()
# #
# 7. 编写程序，输出由星号（*）组成的菱形图案，并且可以灵活控制图案的大小。
# 方法一
def print_diamond(diagonal:int):
    if(diagonal%2):
        for i in range(int((diagonal-1)/2+1)):
            print(" "*int((diagonal-1)/2-i),end='')
            print("*"*(i*2+1))
        for i in range(int((diagonal-1)/2)):
            print(" "*(i+1),end='')
            print("*"*(int(diagonal-(i+1)*2)))
    else:
        print("对角线不为奇数")

# 方法二
def print_diamond2(diagonal:int):
    for i in range(int(diagonal/2+1)):
        print(("*"*(i*2+1)).center(diagonal," "))
    for i in range(int(diagonal/2)):
        print(("*"*(diagonal-(i+1)*2)).center(diagonal," "))

print("7. 编写程序，输出由星号（*）组成的菱形图案，并且可以灵活控制图案的大小。")

print_diamond2(int(input("请输入菱形对角线长度（由于打印特点，只能为奇数）：")))

print()
#
# 8. 编写程序，模拟赛场最终成绩的计算过程。步骤如下：
print("8. 编写程序，模拟赛场最终成绩的计算过程。步骤如下：")
cnt=int(input("输入评委人数n（要求n>2）:"))
print("输入每个评委的打分数（要求为0-100的浮点数）")
ans=[]
for i in range(cnt):
    ans.append(float(input()))
ans.remove(max(ans))
ans.remove(min(ans))
print(sum(ans)/len(ans))

print()



# # Press the green button in the gutter to run the script.
# if __name__ == '__main__':
#     pass

