
var arr = [];

let data = [
{"num":"27","CHAP":"if","name":"q27","Q":"下列程序的运行结果是（      ）。<br>x=y=10 <br> x,y,z=6,x+1,x+2 <br> print(x,y,z)","A":"10 10 6 ","B":"6 10 10","C":"6 7 8","D":"6 11 12","ans":"D"},
{"num":"1","CHAP":"basic","name":"q1","Q":"Python语言属于（      ）。","A":"机器语言","B":"汇编语言","C":"高级语言","D":"科学计算语言","ans":"C"},
{"num":"2","CHAP":"basic","name":"q2","Q":"下列选项中，不属于Python特点的是（      ）。","A":"面向对象","B":"运行效率高","C":"可读性好","D":"开源","ans":"B"},
{"num":"3","CHAP":"basic","name":"q3","Q":"Python程序文件的扩展名是（      ）。","A":".python","B":".pyt","C":".pt","D":".py","ans":"D"},
{"num":"4","CHAP":"basic","name":"q4","Q":"以下叙述中正确的是（     ）。","A":"Python 3.x与Python 2.x兼容","B":"Python语句只能以程序方式执行","C":"Python是解释型语言","D":"Python语言出现得晚，具有其他高级语言的一切优点","ans":"C"},
{"num":"5","CHAP":"basic","name":"q5","Q":"下列选项中合法的标识符是（      ）。","A":"_7a_b","B":"break","C":"_a$b","D":"7ab","ans":"A"},
{"num":"6","CHAP":"basic","name":"q6","Q":"下列标识符中合法的是（      ）。","A":"i'm","B":"_","C":"3Q","D":"for","ans":"B"},
{"num":"7","CHAP":"basic","name":"q7","Q":"Python不支持的数据类型有（      ）。","A":"char","B":"int","C":"float","D":"list","ans":"A"},
{"num":"8","CHAP":"basic","name":"q8","Q":"函数type(1+0xf*3.14)的返回结果是（      ）。","A":"&lt;class 'int'&gt;","B":"&lt;class 'long'&gt;","C":"&lt;class 'str'&gt;","D":"&lt;class 'float'&gt;","ans":"D"},
{"num":"10","CHAP":"basic","name":"q10","Q":"下列属于math库中的数学函数的是（      ）。","A":"time()","B":"round()","C":"sqrt()","D":"random()","ans":"C"},
{"num":"11","CHAP":"basic","name":"q11","Q":"Python表达式中，可以使用（      ）控制运算的优先顺序。","A":"圆括号()","B":"方括号[]","C":"大括号{}","D":"尖括号<>","ans":"A"},
{"num":"12","CHAP":"basic","name":"q12","Q":"下列表达式中，值不是1的是（      ）。","A":"4//3","B":"15 % 2","C":"1^0","D":"~1","ans":"D"},
{"num":"14","CHAP":"basic","name":"q14","Q":"语句eval('2+4/5')执行后的输出结果是（      ）。","A":"2.8","B":"2","C":"2+4/5","D":"'2+4/5'","ans":"A"},
{"num":"15","CHAP":"basic","name":"q15","Q":"整型变量x中存放了一个两位数，要将这个两位数的个位数字和十位数字交换位置，例如，13变成31，正确的Python表达式是（      ）。","A":"（x%10）*10+x//10","B":"(x%10)//10+x//10","C":"(x/10)%10+x//10","D":"(x%10)*10+x%10","ans":"A"},
{"num":"16","CHAP":"structure","name":"q16","Q":"流程图中表示判断框的是（      ）。","A":"矩形框","B":"菱形框","C":"平行四边形框","D":"椭圆形框","ans":"B"},
{"num":"17","CHAP":"structure","name":"q17","Q":"下面不属于程序的基本控制结构的是（      ）。","A":"顺序结构","B":"选择结构","C":"循环结构","D":"输入输出结构","ans":"D"},
{"num":"18","CHAP":"structure","name":"q18","Q":"以下关于Python语句的叙述中，正确的是（     ）。","A":"同一层次的Python语句必须对齐","B":"Python语句可以从一行的任意一列开始","C":"在执行Python语句时，可发现注释中的拼写错误","D":"Python程序的每行只能写一条语句","ans":"A"},
{"num":"19","CHAP":"structure","name":"q19","Q":"下列语句中，在Python中非法的是（      ）。","A":"x=y=z=1","B":"x,y=y,x","C":"x=(y=z+1)","D":"x+=y","ans":"C"},
{"num":"20","CHAP":"structure","name":"q20","Q":"已知x=2，语句x*=x+1执行后，x的值是（      ）。","A":"2","B":"3","C":"5","D":"6","ans":"D"},
{"num":"21","CHAP":"structure","name":"q21","Q":"在Python中，正确的赋值语句为（      ）。","A":"x+y=10","B":"x=2y","C":"x=y=30","D":"3y=x+1","ans":"C"},
{"num":"22","CHAP":"structure","name":"q22","Q":"为了给整型变量x，y，z赋初值10，下面正确的Python赋值语句是（      ）。","A":"xyz=10","B":"x=10 y=10 z=10","C":"x=y=z=10","D":"x=10,y=10,z=10","ans":"C"},
{"num":"23","CHAP":"structure","name":"q23","Q":"语句x=input()执行时，如果从键盘输入12并按回车键，则x的值是（      ）。","A":"12","B":"12","C":"1.00E+02","D":"'12'","ans":"D"},
{"num":"24","CHAP":"structure","name":"q24","Q":"语句x,y=eval(input())执行时，输入数据格式错误的是（      ）。","A":"3 4","B":"(3,4)","C":"3,4","D":"[3,4]","ans":"A"},
{"num":"25","CHAP":"structure","name":"q25","Q":"语句print('x=${:7.2f}'.format(123.5678))执行后的输出结果是（      ）。选项中的□代表空格。","A":"x=□123.56","B":"$□123.57","C":"x=$□123.57","D":"x=$□123.56","ans":"C"},
{"num":"26","CHAP":"structure","name":"q26","Q":"print('{:7.2f}{:2d}'.format(101/7,101%8))的运行结果是（      ）。","A":"{:7.2f}{:2d}","B":"□□14.43□5（□代表空格）","C":"□14.43□□5（□代表空格）","D":"□□101/7□101%8（□代表空格）","ans":"B"},
{"num":"28","CHAP":"if","name":"q28","Q":"以下不合法的表达式是（      ）。","A":"x in [1,2,3,4,5]","B":"x-6>5","C":"e>5 and 4==f","D":"3=a","ans":"D"},
{"num":"29","CHAP":"if","name":"q29","Q":"将数学式2<x≤10表示成正确的Python表达式为（      ）。","A":"2<x<=10","B":"2<x and x<=10","C":"2<x && x<=10","D":"x>2 or x <=10","ans":"B"},
{"num":"30","CHAP":"if","name":"q30","Q":"与关系表达式x==0等价的表达式是（      ）。","A":"x=0","B":"not x","C":"x","D":"x!=1","ans":"B"},
{"num":"31","CHAP":"if","name":"q31","Q":"下列表达式的值为True的是（      ）。","A":"2!=5 or 0","B":"3>2>2","C":"5+4j>2-3j","D":"1 and 5==0","ans":"A"},
{"num":"33","CHAP":"if","name":"q33","Q":"以下if语句语法正确的是（      ）。","A":"<br>if a>0:x=20<br>else:x=200","B":"<br>if a>0:x=20<br>else:<br>&nbsp;&nbsp;&nbsp;&nbsp;x=200","C":"<br>if a>0:<br>&nbsp;&nbsp;&nbsp;&nbsp;x=20<br>else:x=200","D":"<br>if a>0<br>&nbsp;&nbsp;&nbsp;&nbsp;x=20<br>else<br>&nbsp;&nbsp;&nbsp;&nbsp;x=200","ans":"D"},
{"num":"34","CHAP":"if","name":"q34","Q":"在Python中，实现多分支选择结构的较好方法是（      ）。","A":"if","B":"if-else","C":"if-elif-else","D":"if嵌套","ans":"C"},
{"num":"35","CHAP":"if","name":"q35","Q":"下列语句执行后的输出是（      ）。<br>if 2:<br>&nbsp;&nbsp;&nbsp;&nbsp;print(5)<br>else:<br>&nbsp;&nbsp;&nbsp;&nbsp;print(6) ","A":"0","B":"2","C":"5","D":"6","ans":"C"},
{"num":"36","CHAP":"if","name":"q36","Q":"下面程序段求x和y中的较大数，不正确的是（      ）。","A":"maxNum=x if x>y else y","B":"<br>if x>y:maxNum=x<br>else:maxNum=y","C":"<br>maxNum=y<br>if x>y:maxNum=x","D":"<br>if y>=x:maxNum=y<br>maxNum=x","ans":"D"},
{"num":"37","CHAP":"loop","name":"q37","Q":"关于while循环和for循环的区别，下列叙述中正确的是（      ）。","A":"while语句的循环体至少无条件执行一次，for语句的循环体有可能一次都不执行","B":"while语句只能用于循环次数未知的循环，for语句只能用于循环次数已知的循环","C":"在很多情况下，while语句和for语句可以等价使用","D":"while语句只能用于可迭代变量，for语句可以用任意表达式表示条件","ans":"C"},
{"num":"38","CHAP":"loop","name":"q38","Q":"设有程序段：<br>k=10<br>while k:<br>&nbsp;&nbsp;&nbsp;&nbsp;k=k-1<br>&nbsp;&nbsp;&nbsp;&nbsp;print(k)则下面描述中正确的是（      ）。","A":"while循环执行10次","B":"循环是无限循环","C":"循环体语句一次也不执行","D":"循环体语句执行一次","ans":"A"},
{"num":"39","CHAP":"loop","name":"q39","Q":"以下while语句中的表达式“not E”等价于（      ）。<br>while not E:<br>&nbsp;&nbsp;&nbsp;&nbsp;pass","A":"E==0","B":"E!=1","C":"E!=0","D":"E==1","ans":"A"},
{"num":"40","CHAP":"loop","name":"q40","Q":"有以下程序段：<br>n=0<br>p=0<br>while p!=100 and n<3:<br>&nbsp;&nbsp;&nbsp;&nbsp;p=int(input())<br>&nbsp;&nbsp;&nbsp;&nbsp;n+=1<br>while循环结束的条件是（      ）。","A":"P的值不等于100并且n的值小于3","B":"P的值等于100并且n的值大于等于3","C":"P的值不等于100或者n的值小于3","D":"P的值等于100或者n的值大于等于3","ans":"D"},
{"num":"41","CHAP":"loop","name":"q41","Q":"以下for语句中，不能完成1～10的累加功能的是（      ）。","A":"for i in range(10,0):sum+=i","B":"for i in range(1,11):sum+=i","C":"for i in range(10,-1):sum+=i","D":"for i in (10,9,8,7,6,5,4,3,2,1):sum+=i","ans":"A"},
{"num":"42","CHAP":"loop","name":"q42","Q":"对下列语句不符合语法要求的表达式是（      ）。<br>for var in  _______:<br>&nbsp;&nbsp;&nbsp;&nbsp;print(var)","A":"range(0,10)","B":"&quot;Hello&quot;","C":"(1,2,3)","D":"{1,2,3,4,5}","ans":"D"},
{"num":"43","CHAP":"loop","name":"q43","Q":"下面Python循环体执行的次数与其他不同的是（      ）。","A":"<br>i=0<br>while i<=10:<br>&nbsp;&nbsp;&nbsp;&nbsp;print(i)<br>&nbsp;&nbsp;&nbsp;&nbsp;i+=1","B":"<br>i=10<br>while i>0:<br>&nbsp;&nbsp;&nbsp;&nbsp;print(i)<br>&nbsp;&nbsp;&nbsp;&nbsp;i-=1","C":"<br>for i in range(10):<br>&nbsp;&nbsp;&nbsp;&nbsp;print(i)","D":"<br>for i in range(10,0,-1):<br>&nbsp;&nbsp;&nbsp;&nbsp;print(i)","ans":"A"},
{"num":"44","CHAP":"loop","name":"q44","Q":"下列for循环执行后，输出结果的最后一行是（      ）。<br>for i in range(1,3):<br>&nbsp;&nbsp;&nbsp;&nbsp;for j in range(2,5):<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;print(i*j)","A":"2","B":"6","C":"8","D":"15","ans":"C"},
{"num":"45","CHAP":"loop","name":"q45","Q":"关于下列for循环，叙述正确的是（      ）。<br>for t in range(1,11):<br>&nbsp;&nbsp;&nbsp;&nbsp;x=int(input())<br>&nbsp;&nbsp;&nbsp;&nbsp;if x<0:continue<br>&nbsp;&nbsp;&nbsp;&nbsp;print(x)","A":"当x<0时整个循环结束","B":"x>=0时什么也不输出","C":"print()函数永远也不执行","D":"最多允许输出100个非负整数","ans":"D"},
{"num":"46","CHAP":"loop","name":"q46","Q":"下列说法中正确的是（      ）。","A":"break用在for语句中，而continue用在while语句中","B":"break用在while语句中，而continue用在for语句中","C":"continue能结束循环，而break只能结束本次循环","D":"break能结束循环，而continue只能结束本次循环","ans":"D"},
{"num":"47","CHAP":"string","name":"q47","Q":"访问字符串中的部分字符的操作称为（      ）。","A":"分片","B":"合并","C":"索引","D":"赋值","ans":"A"},
{"num":"48","CHAP":"string","name":"q48","Q":"下列关于字符串的描述错误的是（      ）。","A":"字符串s的首字符是s[0]","B":"在字符串中，同一个字母的大小是等价的。","D":"字符串也能进行关系比较操作","ans":"B"},
{"num":"49","CHAP":"string","name":"q49","Q":"执行下列语句后的显示结果是（      ）。<br>world=&quot;world&quot;<br>print(&quot;hello&quot;+world)","A":"helloworld","B":"&quot;hello&quot;world","C":"hello world","D":"&quot;hello&quot;+world","ans":"A"},
{"num":"50","CHAP":"string","name":"q50","Q":"下列表达式中，有3个表达式的值相同，另一个不相同，与其他3个表达式不同的是（      ）","A":"&quot;ABC&quot;+&quot;DEF&quot;","B":"'.join((&quot;ABC&quot;,&quot;DEF&quot;))","C":"&quot;ABC&quot;-&quot;DEF&quot;","D":"'ABCDEF'*1","ans":"C"},
{"num":"51","CHAP":"string","name":"q51","Q":"设s=&quot;Python Programming&quot;，那么print(s[-5:])的结果是（      ）。","A":"mming","B":"Python","C":"mmin","D":"Pytho","ans":"A"},
{"num":"52","CHAP":"string","name":"q52","Q":"设s=&quot;Happy New Year&quot;，则s[3:8]的值为（      ）。","A":"'ppy Ne'","B":"'py Ne'","C":"'ppy N'","D":"'py New'","ans":"B"},
{"num":"53","CHAP":"string","name":"q53","Q":"将字符串中全部字母转换为大写字母的字符串方法是（      ）。","A":"swapcase","B":"capitalize","C":"uppercase","D":"upper","ans":"D"},
{"num":"54","CHAP":"string","name":"q54","Q":"下列表达式中，能用于判断字符串s1是否属于字符串s（即s1是否s的子串）的是（      ）。<br>①s1 in s；②s.find(s1)>0；③s.index(s1)>0；④s.rfind(s1)；⑤s.rindex(s1)>0","A":"①","B":"①②","C":"①②③","D":"①②③④⑤","ans":"D"},
{"num":"55","CHAP":"string","name":"q55","Q":"re.findall('to','Tom likes to play football too.',re.I)的值是(      )。","A":"['To', 'to', 'to']","B":"['to', 'to', 'to']","C":"['To', 'to']","D":"['to', 'to']","ans":"A"},
{"num":"56","CHAP":"string","name":"q56","Q":"下列程序执行后，得到的输出结果是（      ）。<br>import re<br>p=re.compile(r'\\bb\\w*\\b')<br>str=&quot;Boys may be able to get a better idea.&quot;<br>print(p.sub('**',str,1))<br>","A":"** may be able to get a better idea.","B":"Boys may be able to get a ** idea.","C":"Boys may ** able to get a better idea.","D":"Boys may ** able to get a ** idea.","ans":"C"},
{"num":"57","CHAP":"list&tuple","name":"q57","Q":"下列Python数据中其元素可以改变的是（      ）。","A":"列表","B":"元组","C":"字符串","D":"数组","ans":"A"},
{"num":"58","CHAP":"list&tuple","name":"q58","Q":"表达式“[2] in [1,2,3,4]”的值是（      ）。（true false忽略大小写）","A":"Yes","B":"No","C":"TRUE","D":"FALSE","ans":"D"},
{"num":"59","CHAP":"list&tuple","name":"q59","Q":"max((1,2,3)*2)的值是（      ）。","A":"3","B":"4","C":"5","D":"6","ans":"A"},
{"num":"60","CHAP":"list&tuple","name":"q60","Q":"下列选项中与s[0:-1]表示的含义相同的是（      ）。","A":"s[-1]","B":"s[:]","C":"s[:len(s)-1]","D":"s[0:len(s)]","ans":"C"},
{"num":"61","CHAP":"list&tuple","name":"q61","Q":"对于列表L=[1,2,'Python',[1,2,3,4,5]]，L[-3]的是（      ）。","A":"1","B":"2","C":"'Python'","D":"[1,2,3,4,5]","ans":"B"},
{"num":"62","CHAP":"list&tuple","name":"q62","Q":"L.reverse()和L[-1:-1-len(L):-1]的主要区别是（      ）。","A":"L.reverse()和L[-1:-1-len(L):-1]都将列表的所有元素反转排列，没有区别","B":"L.reverse()和L[-1:-1-len(L):-1]都不会改变列表L原来内容","C":"L.reverse()不会改变列表L的内容，而L[-1:-1-len(L):-1]会改变列表L原来内容","D":"L.reverse()会改变列表L的内容，而L[-1:-1-len(L):-1]产生一个新列表，不会改变列表L原来内容","ans":"D"},
{"num":"63","CHAP":"list&tuple","name":"q63","Q":"tuple(range(2,10,2))的返回结果是(      )。","A":"[2, 4, 6, 8]","B":"[2, 4, 6, 8, 10]","C":"(2, 4, 6, 8)","D":"(2, 4, 6, 8, 10)","ans":"C"},
{"num":"64","CHAP":"list&tuple","name":"q64","Q":"下列程序执行后，p的值是（      ）。<br>a=[[1,2,3],[4,5,6],[7,8,9]]<br>p=1<br>for i in range(len(a)):<br>&nbsp;&nbsp;&nbsp;&nbsp;p*=a[i][i]","A":"45","B":"15","C":"6","D":"28","ans":"A"},
{"num":"65","CHAP":"list&tuple","name":"q65","Q":"下列Python程序的运行结果是（      ）。<br>s=[1,2,3,4]<br>s.append([5,6])<br>print(len(s))<br>","A":"2","B":"4","C":"5","D":"6","ans":"C"},
{"num":"66","CHAP":"list&tuple","name":"q66","Q":"下列Python程序的运行结果是（      ）。<br>s1=[4,5,6]<br>s1[1]=0<br>print(s2)<br>","A":"[4, 5, 6]","B":"[4, 0, 6]","C":"[0, 5, 6]","D":"[4, 5, 0]","ans":"B"},
{"num":"67","CHAP":"dict&set","name":"q67","Q":"Python语句print(type({1:1,2:2,3:3,4:4}))的输出结果是（      ）。","A":"&lt;class 'tuple'&gt;","B":"&lt;class 'dict'&gt;","C":"&lt;class 'set'&gt;","D":"&lt;class  'frozenset'&gt;","ans":"B"},
{"num":"68","CHAP":"dict&set","name":"q68","Q":"以下不能创建字典的语句是（      ）。","A":"dict1={}","B":"dict2={3:5}","C":"dict3=dict([2,5],[3,4])","D":"dict4=dict(([1,2],[3,4]))","ans":"C"},
{"num":"69","CHAP":"dict&set","name":"q69","Q":"对于字典D={'A':10,'B':20,'C':30,'D':40}，对第4个字典元素的访问形式是（      ）。","A":"D[3]","B":"D[4]","C":"D[D]","D":"D['D']","ans":"D"},
{"num":"70","CHAP":"dict&set","name":"q70","Q":"对于字典D={'A':10,'B':20,'C':30,'D':40}，len(D)的是（      ）。","A":"4","B":"8","C":"10","D":"12","ans":"A"},
{"num":"71","CHAP":"dict&set","name":"q71","Q":"对于字典D={'A':10,'B':20,'C':30,'D':40}，sum(list(D.values()))的值是（      ）。","A":"10","B":"100","C":"40","D":"200","ans":"B"},
{"num":"72","CHAP":"dict&set","name":"q72","Q":"以下不能创建集合的语句是（      ）。","A":"s1=set()","B":"s2=set(“abcd”)","C":"s3={}","D":"s4=frozenset((3,2,1))","ans":"C"},
{"num":"73","CHAP":"dict&set","name":"q73","Q":"设a=set([1,2,2,3,3,3,4,4,4,4])，则a.remove(4)的值是（      ）。","A":"{1, 2, 3}","B":"{1, 2, 2, 3, 3, 3, 4, 4, 4}","C":"{1, 2, 2, 3, 3, 3}","D":"[1, 2, 2, 3, 3, 3, 4, 4, 4]","ans":"A"},
{"num":"74","CHAP":"dict&set","name":"q74","Q":"下列语句执行后的结果是（       ）。<br>fruits={'apple':3,'banana':4,'pear':5}<br>fruits['banana']=7<br>print(sum(fruits.values()))<br>","A":"7","B":"19","C":"12","D":"15","ans":"D"},
{"num":"75","CHAP":"dict&set","name":"q75","Q":"下列语句执行后的结果是（       ）。<br>d1={1:'food'}<br>d2={1:'食品',2:'饮料'}<br>d1.update(d2)<br>print(d1[1])<br>","A":"1","B":"2","C":"食品","D":"饮料","ans":"C"},
{"num":"76","CHAP":"dict&set","name":"q76","Q":"下列Python程序的运行结果是（      ）。<br>s1=set([1,2,2,3,3,3,4])s2={1,2,5,6,4}print(s1&s2-s1.intersection(s2))","A":"{1, 2, 4}","B":"set()","C":"[1,2,2,3,3,3,4]","D":"{1,2,5,6,4}","ans":"B"},
{"num":"77","CHAP":"function&module","name":"q77","Q":"下列选项中不属于函数优点的是（      ）。","A":"减少代码重复","B":"使程序模块化","C":"使程序便于阅读","D":"便于发挥程序员的创造力","ans":"D"},
{"num":"78","CHAP":"function&module","name":"q78","Q":"关于函数的说法中正确的是（      ）。","A":"函数定义时必须有形参","B":"函数中定义的变量只在该函数体中起作用","C":"函数定义时必须带return语句","D":"实参与形参的个数可以不相同，类型可以任意","ans":"B"},
{"num":"79","CHAP":"function&module","name":"q79","Q":"以下关于函数说法正确的是（      ）。","A":"函数的实际参数和形式参数必须同名","B":"函数的形式参数既可以是变量也可以是常量","C":"函数的实际参数不可以是表达式","D":"函数的实际参数可以是其他函数的调用","ans":"D"},
{"num":"80","CHAP":"function&module","name":"q80","Q":"关于装饰器，下列说法中错误的是（      ）。","A":"装饰器是用来包装函数的函数","B":"装饰器有利于实现代码的复用","C":"装饰器中一定要返回一个函数对象","D":"一个函数只能用一个装饰器修饰","ans":"D"},
{"num":"81","CHAP":"function&module","name":"q81","Q":"调用装饰器的格式是（      ）。","A":"#装饰器名","B":"@装饰器名","C":"$装饰器名","D":"%装饰器名","ans":"B"},
{"num":"82","CHAP":"function&module","name":"q82","Q":"有以下两个程序。<br>程序一：<br>x=[1,2,3]<br>def f(x):<br>&nbsp;&nbsp;&nbsp;&nbsp;x=x+[4]<br>f(x)<br>print(x)<br>程序二：<br>x=[1,2,3]<br>def f(x):<br>&nbsp; &nbsp;&nbsp;&nbsp;x+=[4]<br>f(x)<br>print(x)<br>下列说法正确的是（      ）。<br>","A":"两个程序均能正确运行，但结果不同","B":"两个程序的运行结果相同","C":"程序一能正确运行，程序二不能","D":"程序一不能正确运行，程序二能","ans":"A"},
{"num":"83","CHAP":"function&module","name":"q83","Q":"已知f=lambda x,y:x+y，则f([4],[1,2,3])的值是（      ）。","A":"[1, 2, 3, 4]","B":"10","C":"[4, 1, 2, 3]","D":"{1, 2, 3, 4}","ans":"C"},
{"num":"84","CHAP":"function&module","name":"q84","Q":"下列程序的运行结果是（      ）。<br>f=[lambda x=1:x*2,lambda x:x**2]<br>print(f[1](f[0](3)))<br>","A":"1","B":"6","C":"9","D":"36","ans":"D"},
{"num":"85","CHAP":"function&module","name":"q85","Q":"下列程序的运行结果是（      ）。<br>def f(x=2,y=0):<br>&nbsp;&nbsp;&nbsp;&nbsp;return x-y<br>y=f(y=f(),x=5)<br>print(y)<br>","A":"-3","B":"3","C":"2","D":"5","ans":"B"},
{"num":"86","CHAP":"function&module","name":"q86","Q":"output.py文件和test.py文件内容如下，且output.py和test.py位于同一文件夹中，那么运行test.py的输出结果是（      ）。<br>#output.py<br>def show():<br>&nbsp; &nbsp;&nbsp;&nbsp;print(__name__)<br>#test.py<br>import output<br>if __name__=='__main__':<br>&nbsp; &nbsp;&nbsp;&nbsp;output.show()<br>","A":"output","B":"__name__","C":"test","D":"__main__","ans":"A"},
{"num":"87","CHAP":"oop","name":"q87","Q":"下列说法中不正确的是（      ）。","A":"类是对象的模板，而对象是类的实例","B":"实例属性名如果以__开头，就变成了一个私有变量","C":"只有在类的内部才可以访问类的私有变量，外部不能访问","D":"在Python中，一个子类只能有一个父类","ans":"D"},
{"num":"88","CHAP":"oop","name":"q88","Q":"下列选项中不是面向对象程序设计基本特征的是（      ）。","A":"继承","B":"多态","C":"可维护性","D":"封装","ans":"C"},
{"num":"89","CHAP":"oop","name":"q89","Q":"在方法定义中，访问实例属性x的格式是（      ）。","A":"x","B":"self.x","C":"self[x]","D":"self.getx()","ans":"B"},
{"num":"90","CHAP":"oop","name":"q90","Q":"下列程序的执行结果是（      ）。<br>class Point:<br>&nbsp;&nbsp;&nbsp;&nbsp;x=10<br>&nbsp; &nbsp;&nbsp;&nbsp;y=10<br>&nbsp; &nbsp;&nbsp;&nbsp;def __init__(self,x,y):<br>&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;self.x=x<br>&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;self.y=y<br>pt=Point(20,20)<br>print(pt.x,pt.y)<br>","A":"10 20","B":"20 10","C":"10 10","D":"20 20","ans":"D"},
{"num":"91","CHAP":"oop","name":"q91","Q":"下列程序的执行结果是（      ）。<br>class C():<br>&nbsp;&nbsp;&nbsp;&nbsp;f=10<br>class C1(C):<br>&nbsp;&nbsp;&nbsp;&nbsp;pass<br>print(C.f,C1.f)<br>","A":"10 10","B":"10 pass","C":"pass 10","D":"运行出错","ans":"A"},
{"num":"92","CHAP":"file","name":"q92","Q":"在读写文件之前，用于创建文件对象的函数是（      ）。","A":"open","B":"create","C":"file","D":"folder","ans":"A"},
{"num":"93","CHAP":"file","name":"q93","Q":"关于语句f=open('demo.txt','r')，下列说法不正确的是（）。","A":"demo.txt文件必须已经存在","B":"只能从demo.txt文件读数据，而不能向该文件写数据。","C":"只能向demo.txt文件写数据，而不能从该文件读数据。","D":"“r”方式是默认的文件打开方式","ans":"C"},
{"num":"94","CHAP":"file","name":"q94","Q":"下列程序的输出结果是（      ）。<br>f=open('c:\\out.txt','w+')<br>f.write('Python')<br>f.seek(0)<br>c=f.read(2)<br>print(c)<br>f.close()<br>","A":"Pyth","B":"Python","C":"Py","D":"th","ans":"C"},
{"num":"95","CHAP":"file","name":"q95","Q":"下列程序的输出结果是（      ）。<br>f=open('f.txt','w')<br>f.writelines(['Python programming.'])vf.close()<br>f=open('f.txt','rb')<br>f.seek(10,1)<br>print(f.tell())<br>","A":"1","B":"10","C":"gramming","D":"Python","ans":"B"},
{"num":"96","CHAP":"file","name":"q96","Q":"下列语句的作用是（      ）。<br>>>> import os<br>>>> os.mkdir(&quot;d:\\ppp&quot;)<br>","A":"在D盘当前文件夹下建立ppp文本文件","B":"在D盘根文件夹下建立ppp文本文件","C":"在D盘当前文件夹下建立ppp文件夹","D":"在D盘根文件夹下建立ppp文件夹","ans":"D"},
{"num":"97","CHAP":"try","name":"q97","Q":"下列关于Python异常处理的描述中，不正确的是（      ）。","A":"异常处理可以通过try-except语句实现。","B":"任何需要检测的语句必须在try语句块中执行，并由except语句处理异常。","C":"raise语句引发异常后，它后面的语句不再执行。","D":"except语句处理异常最多有两个分支。","ans":"D"},
{"num":"98","CHAP":"try","name":"q98","Q":"以下关于异常处理try语句块的说法，不正确的是（      ）。","A":"finally语句中的代码段始终要被执行","B":"一个try块后接一个或多个except块","C":"一个try块后接一个或多个finally块","D":"try必须与except或finally块一起使用","ans":"C"},
{"num":"99","CHAP":"try","name":"q99","Q":"Python异常处理机制中没有（      ）语句。","A":"try","B":"throw","C":"assert","D":"finally","ans":"B"},
{"num":"100","CHAP":"try","name":"q100","Q":"如果以负数作为平方根函数math.sqrt()的参数，将产生（      ）。","A":"死循环","B":"复数","C":"ValueError异常 ","D":"finally","ans":"C"},
{"num":"101","CHAP":"try","name":"q101","Q":"下列程序的输出结果是（      ）。<br>try:<br>&nbsp;&nbsp;&nbsp;&nbsp;x=1/2<br>except ZeroDivisionError:<br>&nbsp;&nbsp;&nbsp;&nbsp;print('AAA')<br>","A":"0","B":"0.5","C":"AAA","D":"无输出","ans":"D"},
{"num":"102","CHAP":"try","name":"q102","Q":"下列程序的输出结果是（      ）。<br>x=10<br>raise Exception(&quot;AAA&quot;)<br>x+=10<br>print(&quot;x=&quot;,x)<br>","A":"Exception: AAA","B":"10","C":"20","D":"x=20","ans":"A"},
{"num":"13","CHAP":"basic","name":"q13","Q":"Python语句print(r&quot;\nGood&quot;)的运行结果是（      ）。","A":"新行和字符串Good","B":"r&quot;\\nGood&quot;","C":"\\nGood","D":"字符r、新行和字符串Good","ans":"C"},
{"num":"9","CHAP":"basic","name":"q9","Q":"字符串s='a\\nb\\tc'，则len(s)的值是（      ）。","A":"7","B":"6","C":"5","D":"4","ans":"C"},

];

//某个范围内的随机数
var random = function(lower, upper) {
	return Math.floor(Math.random() * (upper - lower)) + lower;
}

//查重
var check = function(num){
	for (var i = arr.length - 1; i >= 0; i--) {
		if(arr[i] == num){
			return true;
		}
	}
	return false;
}
//
do{
	var randomx = random(0,data.length);
	if(!check(randomx)){
		arr.push(randomx);
		
	}
}while(arr.length < 40);   //40个题


var  flag = true;	

	function beginle(){
	var readinfo = sessionStorage.getItem("keyinfo");	
	var info = JSON.parse(readinfo);
	sessionStorage.setItem("keyinfo", readinfo); 

	(document.getElementById("info")).innerHTML = info.class +"  " +info.num+"  " + info.name+"  欢迎你！"

		for (var i = 0; i<=arr.length - 1; i++) {
			var num = data[arr[i]];
			var inner = "";	
			inner = "<p>"+(i+1)+".&nbsp; &nbsp;&nbsp;"+ num.Q + '<br><input type="radio" name="' +num.name+ '" value="A">'+num.A+'<br><input type="radio" name="' +num.name+ '" value="B">'+num.B+'<br><input type="radio" name="' +num.name+ '" value="C">'+num.C+'<br><input type="radio" name="' +num.name+ '" value="D">'+num.D +'<br></p>';
			
			document.getElementById("kaoshi").innerHTML += inner;
			
		}
		
	}





