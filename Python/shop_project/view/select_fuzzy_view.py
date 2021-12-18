import dearpygui.dearpygui as dpg
from view.bg_main_view import show_bgmain_view


def show_select_fuzzy_goods_view():
    def submit():
        print("save and submit")

    def return_pre_view():
        print("返回上一层")
        dpg.delete_item("sf")
        from view.items_view import items_main_view
        items_main_view()

    with dpg.window(label="sf_view",tag="sf"):
        with dpg.group(label="ct",tag="ct"):
            dpg.add_text("模糊查询")
            with dpg.group(label="key_word",tag="key_word"):
                dpg.add_text("关键字：")
                dpg.add_input_text()
            
            dpg.add_button(label="查询",callback=submit)
            dpg.add_button(label="返回上一层",callback=return_pre_view)
        # width = dpg.get_viewport_width()
        # height =  dpg.get_viewport_height()
        # dpg.set_item_pos("ct",[(width-75)/2,(height-200)/2])
    dpg.set_primary_window("sf",True)