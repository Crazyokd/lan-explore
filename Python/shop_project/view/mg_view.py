import dearpygui.dearpygui as dpg


def show_modify_goods_view():
    def submit():
        print("save and submit")

    def return_pre_view():
        print("返回上一层")
        dpg.delete_item("mg")
        from view.items_view import items_main_view
        items_main_view()

    with dpg.window(label="mg_view",tag="mg"):
        with dpg.group(label="ct",tag="ct"):
            dpg.add_text("商品修改")
            with dpg.group(label="goods_id",tag="goods_id"):
                dpg.add_text("待修改的商品ID：")
                dpg.add_input_int()
            with dpg.group(label="goods_name",tag="goods_name"):
                dpg.add_text("商品名称：")
                dpg.add_input_text()
            with dpg.group(label="goods_price",tag="goods_price"):
                dpg.add_text("商品价格：")
                dpg.add_input_text()
            with dpg.group(label="goods_num",tag="goods_num"):
                dpg.add_text("商品数量：")
                dpg.add_input_text()
            dpg.add_button(label="保存并提交",callback=submit)
            dpg.add_button(label="返回上一层",callback=return_pre_view)
        # width = dpg.get_viewport_width()
        # height =  dpg.get_viewport_height()
        # dpg.set_item_pos("ct",[(width-75)/2,(height-200)/2])
    dpg.set_primary_window("mg",True)