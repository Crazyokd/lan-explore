import dearpygui.dearpygui as dpg
import dearpygui.demo as demo

dpg.create_context()    # This should be the first DPG command


dpg.create_viewport(title='Custom Title', width=1200, height=600)   # The viewport is the window created by the operating system.

# with dpg.window(label="Example Window"):
#     dpg.add_text("Hello, world")
#     dpg.add_button(label="Save")
#     dpg.add_input_text(label="string", default_value="Quick brown fox")
#     dpg.add_slider_float(label="float", default_value=0.273, max_value=1)
demo.show_demo()

dpg.setup_dearpygui()
dpg.show_viewport()
dpg.start_dearpygui()   # the render loop

# below can replace dpg.start_dearpygui()
# while dpg.is_dearpygui_running():
#     # insert here any code you would like to run in the render loop
#     # you can manually stop by using stop_dearpygui()
#     print("this will run every frame")
#     dpg.render_dearpygui_frame()


dpg.destroy_context()   # Proper clean up of DPG can be done