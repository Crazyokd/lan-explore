# 201903130218 易操
import random
import time
import string

MAX_CAR=10
PRICE=2.4 #每秒钟收费
occupied_number=[] #已经被占用的停车号
parking_list=[] #已停车辆列表

# 第一次暂且用字典表示对象吧（类似于结构体），待更新......
car={"license_plate":"","parking_space":"","start_time":"","end_time":"","charging":""}
# 拼串得到五位车牌号，前两位为大写字母，后三位为数字

def get_license_plate():
    lp=""
    for i in range(5):
        if(i<2):
            lp+=random.choice(string.ascii_uppercase)
        else:
            lp+=random.choice(string.digits)
    return lp

# 停车
def parking():
    new_car=car.copy()
    new_car["license_plate"]=get_license_plate()
    while True:
        number=random.choice(range(MAX_CAR))+1
        # print(number)
        if number not in occupied_number:
            occupied_number.append(number)
            new_car["parking_space"]=number
            new_car["start_time"]=time.time()
            parking_list.append(new_car)
            break
    print("=====>%s入库成功"%new_car["license_plate"])
    # print(new_car)
    
def enter_parking_lot():
    if len(occupied_number)==MAX_CAR:
        print("车库已满")
    else:
        parking()

def leave():
    leave_car=random.choice(parking_list)
    # 出库要及时对列表中的元素进行移除
    parking_list.remove(leave_car)
    occupied_number.remove(leave_car["parking_space"])

    # print(len(parking_list),len(occupied_number))
    leave_car["end_time"]=time.time()
    leave_car["charging"]=leave_car["end_time"]-leave_car["start_time"]*PRICE
    # 格式转换
    leave_car["start_time"]=time.ctime(leave_car["start_time"])
    leave_car["end_time"]=time.ctime(leave_car["end_time"])
    print(leave_car,"=====>出库")

def exit_parking_lot():
    if len(occupied_number)==0:
        print("车库为空")
    else:
        leave()

def query_car():
    # 这里设置为仅查询一次，且不为用户的失误买单
    try:
        query_number=int(input("请输入要查询的车位号（不大于%d)"%MAX_CAR))
    except ValueError as e:
        print("输入格式有误!")
    if query_number>MAX_CAR:
        print("不是说了输入数字不超过%d吗？调皮！"%MAX_CAR)
    elif query_number<1:
        print("最小车位为1哦，亲~~")
    elif query_number not in occupied_number:
        print("该车位暂时空闲，赶快来停车吧！")
    else:
        for car in parking_list:
            if car["parking_space"]==query_number:
                print(car)
                break


def main():
    print("*"*50)
    print('----欢迎来到停车场----')
    print("*"*50)
    while True:
        choice=input("[1.入停车场。2.出停车场。3.查询车辆。4.退出系统]请选择功能：")
        if choice =="1":
            print("***入停车常***")
            enter_parking_lot()
        elif choice =='2':
            print("***出停车场***")
            exit_parking_lot()
        elif choice =='3':
            print("查询车辆")
            query_car()
        elif choice =='4':
            print("退出系统")
            break
        else:
            print("输入有误，请重新输入！")


if __name__=="__main__":
    main()

