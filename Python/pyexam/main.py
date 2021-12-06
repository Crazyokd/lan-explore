students = [
{"class":"软件工程","num":"123456","name":"rekord"},
{"class":"软件工程","num":"123456","name":"admin"},
{"class":"软件工程","num":"123456","name":"test"},
]


import tkinter as tk

import random

from tkinter import messagebox

window = tk.Tk()
window.title('python_exam')
# 窗口尺寸：width×height
window.geometry('1200x600')

# ------------------------1 login begin---------------------------------
# 创建登录框架
frame_login = tk.Frame(window)
frame_exam = tk.Frame(window)

is_login = False
usr_name = ''
usr_pwd = ''



# welcome image
canvas = tk.Canvas(frame_login, width=500, height=400)  # 创建画布
image_file = tk.PhotoImage(file='welcome.gif')  # 加载图片文件
canvas.create_image(0, 0, anchor='nw', image=image_file)  # 将图片置于画布上
canvas.pack(side='top')  # 放置画布

# place two label
tk.Label(frame_login, text='学号: ', font=('Arial', 12)).place(x=100, y=150)
tk.Label(frame_login, text='姓名: ', font=('Arial', 12)).place(x=100, y=200)

# place two text_box.
var_usr_name = tk.StringVar()  # 定义变量
entry_usr_name = tk.Entry(frame_login, textvariable=var_usr_name)
entry_usr_name.place(x=150, y=150)

var_usr_pwd = tk.StringVar()
entry_usr_pwd = tk.Entry(frame_login, textvariable=var_usr_pwd)
entry_usr_pwd.place(x=150, y=200)

def usr_login():
    global is_login
    global usr_name
    global usr_pwd
    usr_name = (var_usr_name.get()).strip()
    usr_pwd = (var_usr_pwd.get()).strip()

    if usr_name == '' or usr_pwd == '':
        tk.messagebox.showerror(message='Error, 学号或姓名都不能为空, try again.')
        return
    # 201865110203 谭莹莹
    for item in students:
        if item['num'] == usr_name and item['name'] == usr_pwd:
            # print('登录成功')
            is_login = True

            ok = tk.messagebox.showinfo(title='Welcome', message='欢迎你:   ' + item['num'] + item['name'])
            if ok == 'ok':
                frame_login.pack_forget()  # frame_login销毁
                frame_exam.pack()

    if (not is_login):
        tk.messagebox.showinfo(title='sorry', message='学号或姓名错误? ')
        var_usr_name.set('')
        var_usr_pwd.set('')

# 登录按钮
btn_login = tk.Button(frame_login, text=' 登  录  ', font=('Arial', 12),
                      command=usr_login)  # 定义一个`button`按钮，名为`Login`,触发命令为`usr_login`
btn_login.place(x=185, y=240)

frame_login.pack()

#------------------- login end--------------------------------------

#  ---------------------------2 exam-start--------------------

#  ========抽题=========
num_timu = 15  # 抽题数
max_timu = 36  # 总题数

def chouti(num_timu,max_timu):
    # 随机抽题
    randxx = random.sample(range(1, max_timu), num_timu)
    timu = [('./lib/' + str(xx) + '.gif') for xx in randxx] #题号路径列表。        

    # d_ans为记录答案的字典，键名是x.gif
    myti = [(str(x) + '.gif') for x in randxx]
    ans = ['' for i in range(num_timu)]
    d_ans = dict(zip(myti, ans))  # 记录题目名称与学生作答。
    # print(d_ans)   # {'题':'答','题':'答'}
    return d_ans,timu,myti


choose_result = chouti(num_timu,max_timu)
d_ans = choose_result[0]
timu = choose_result[1]
myti = choose_result[2]

#  ========================定时器==============
#倒计时
fm2 = tk.Frame(frame_exam)
fm2.pack()

time = 30 * 60
canvas_timer = tk.Canvas(fm2, width=400, height=50, bg='#FFF0F5')
canvas_timer.pack()


def tick():
    global time
    canvas_timer.delete(tk.ALL)
    time -= 1
    canvas_timer.create_text(210, 25, width=400,text='剩余时间: ' + str(time), font=('Arial', 12))
    if time == 0:
        do_submit()
    else:
        canvas_timer.after(1000, tick)


canvas_timer.after(1, tick)


#  ========================显示题目==============
fm1 = tk.Frame(frame_exam,width=500,height=600,bd=2,bg='#F5DEB3')
fm1.pack(side='left',anchor=tk.W,fill='both',expand=1)

# 用0号题图片创建一个lable0,放在  上
photo = tk.PhotoImage(file=timu[0])
lable0 = tk.Label(fm1, image=photo)
lable0.pack()


#答题框
fm4 = tk.Frame(frame_exam)
fm4.pack()

w = 1   # 按钮上的文字

# ===答题框标签==
xuhao = tk.StringVar()
xuhao.set("第" + str(w) + "题请作答:  ")
L1 = tk.Label(fm4, textvariable=xuhao, font=('宋体', 20))
L1.pack()

# ===答题框==
ans_input = tk.Text(fm4, bg='#FFF0F5', width=50, height=10)
ans_input.pack()



# 按钮名字
btn_name = [('btn' + str(i)) for i in range(num_timu)]  # [btn0 , btn1...]
d_btns = {}

# 按钮响应
def do(event):
    global w
    global myti
    d_ans[myti[w - 1]] = (ans_input.get('1.0', 'end'))[:-1]
    # print(d_ans)

    w = event.widget['text']
    xuhao.set("第" + str(w) + "题请作答:  ")
    new_photo = tk.PhotoImage(file=timu[w - 1])
    lable0.configure(image=new_photo)
    lable0.image = new_photo
    lable0.pack()

    ans_input.delete('1.0', 'end')
    ans_input.insert('1.0', d_ans[myti[w - 1]])

#题号按钮
fm5 = tk.Frame(frame_exam)
fm5.pack()

# 创建一排题号按钮
for i, btn in enumerate(btn_name):
    d_btns[btn] = tk.Button(fm5, text=i + 1, width=3)
    d_btns[btn].pack(side=tk.LEFT)
    d_btns[btn].bind('<Button-1>', do)


#===交卷函数===
def do_submit():
    global w
    global myti
    d_ans[myti[w - 1]] = (ans_input.get('1.0', 'end'))[:-1]
    try:
        filename = usr_name + usr_pwd + '.txt'
        # print(filename)
        with open(filename, 'w', encoding='utf-8') as f:
            for key in d_ans:
                f.writelines(key + ":" + d_ans[key] + '\n')
            tk.messagebox.showinfo(message='交卷成功！')
    except:
        tk.messagebox.showerror(message='Error, 答案写入文件失败！')

#交卷按钮
fm3 = tk.Frame(frame_exam)
fm3.pack()

submit = tk.Button(fm3, text='交卷', font=('Arial', 20), command=do_submit)
# submit.bind('<Button-1>', do_submit)
submit.pack()

# #  ---------------------------exam--end-------------------


# 显示出来
window.mainloop()
