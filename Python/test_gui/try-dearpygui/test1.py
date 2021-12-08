import dearpygui.dearpygui as dpg
import dearpygui.demo as demo




def init_window():
    dpg.create_context()    # 创建上下文
    dpg.create_viewport(title='Custom Title', width=600, height=600)    # 创建视区————window
    
    add_window()
    # demo.show_demo()        # 一个demo

    dpg.setup_dearpygui()   # 设置dearpygui
    dpg.show_viewport()     # 展示视区

    # The manual render loop must be created after setup_dearpygui
    # while dpg.is_dearpygui_running():
    #     # insert here any code you would like to run in the render loop
    #     # you can manually stop by using stop_dearpygui()
    #     print("this will run every frame")
    #     dpg.render_dearpygui_frame()

    
    dpg.start_dearpygui()   # 启动dearpygui

    dpg.destroy_context()   # 清理上下文


def add_window():
    with dpg.window(label="Example Window",tag="Primary Window"):
        dpg.add_text("Hello, world")
        dpg.add_button(label="Save")
        dpg.add_input_text(label="string", default_value="Quick brown fox")
        dpg.add_slider_float(label="float", default_value=0.273, max_value=1)
    dpg.set_primary_window("Primary Window", True)

init_window()
