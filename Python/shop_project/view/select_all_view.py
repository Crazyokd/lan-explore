import dearpygui.dearpygui as dpg
from view.bg_main_view import show_bgmain_view


def show_select_all_goods_view():
    def submit():
        print("save and submit")

    def return_pre_view():
        print("返回上一层")
        dpg.delete_item("sa")
        from view.items_view import items_main_view
        items_main_view()

    with dpg.window(label="sa_view",tag="sa"):
        with dpg.group(label="ct",tag="ct"):
            dpg.add_text("商品查询")
            with dpg.table(tag="table"):
                # use add_table_column to add columns to the table,
                # table columns use child slot 0
                dpg.add_table_column(label="header1")
                dpg.add_table_column(label="header2")
                dpg.add_table_column(label="header3")
                dpg.add_table_column(label="header4")

                # add_table_next_column will jump to the next row
                # once it reaches the end of the columns
                # table next column use slot 1
                for i in range(0, 4):
                    with dpg.table_row():
                        for j in range(0, 4):
                            dpg.add_text(f"Row{i} Column{j}")
            dpg.add_button(label="返回上一层",callback=return_pre_view)
            
            
        # width = dpg.get_viewport_width()
        # height =  dpg.get_viewport_height()
        # dpg.set_item_pos("ct",[(width-75)/2,(height-200)/2])
    dpg.set_primary_window("sa",True)