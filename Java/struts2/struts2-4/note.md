# 1. 关于值栈:

1). helloWorld 时, ${productName} 读取 productName 值, 实际上该属性并不在 request 等域对象中, 而是从值栈中获取的. 

2). ValueStack: 

I.  可以从 ActionContext 中获取值栈对象

II. 值栈分为两个逻辑部分

	> Map 栈: 实际上是 OgnlContext 类型, 是个 Map, 也是对 ActionContext 的一个引用. 里边保存着各种 Map:
	         requestMap, sessionMap, applicationMap, parametersMap, attr
	         
	> Object 栈: 实际上是 CompoundRoot 类型, 是一个使用 ArrayList 定义的栈. 里边保存各种和当前 Action 实例相关的对象.
	                   是一个数据结构意义的栈.
	                   
 ## 2. Struts2 利用 s:property 标签和 OGNL 表达式来读取值栈中的属性值
 
 1). 值栈中的属性值:
 
 	> 对于对象栈: 对象栈中某一个对象的属性值
 	
 	> Map 栈: request, session, application 的一个属性值 或 一个请求参数的值. 
 	
 2). 读取对象栈中对象的属性:
 
 	> 若想访问 Object Stack 里的某个对象的属性. 可以使用以下几种形式之一: 
		
	  object.propertyName ; 
	  object['propertyName'] ; 
	  object["propertyName"]	
		
	> ObjectStack 里的对象可以通过一个从零开始的下标来引用. ObjectStack 里的栈顶对象可以用 [0] 来引用, 
	     它下面的那个对象可以用 [1] 引用. 
	   
	  [0].message   
	     
	> [n] 的含义是从第 n 个开始搜索, 而不是只搜索第 n 个对象
	
	> 若从栈顶对象开始搜索, 则可以省略下标部分: message 
	
	> 结合 s:property 标签: <s:property value="[0].message" />  <s:property value="message" />
 
 3). 默认情况下, Action 对象会被 Struts2 自动的放到值栈的栈顶. 

## 主题
主题: 为了让所有的 UI 标签能够产生同样的视觉效果而归集到一起的一组模板. 即风格相近的模板被打包为一个主题
### 常用主题
- simple: 把 UI 标签翻译成最简单的 HTML 对应元素, 而且会忽视行标属性
- xhtml: xhtml 是默认的主题. 这个主题的模板通过使用一个布局表格提供了一种自动化的排版机制. 
- css_xhtml: 这个主题里的模板与 xhtml 主题里的模板很相似, 但它们将使用 css 来进行布局和排版
- ajax: 这个主题里的模板以 xhtml 主题里德模板为基础, 但增加了一些 Ajax 功能. 

### 修改主题:
- 通过 UI 标签的 theme 属性
- 在一个表单里, 若没有给出某个 UI 标签的 theme 属性, 它将使用这个表单的主题
- 在 page, request, session 或 application 中添加一个 theme 属性
- 修改 struts.properties 文件中的 struts.ui.theme 属性. 