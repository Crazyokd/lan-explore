#demo 完整代码
import dearpygui.dearpygui as dpg

dpg.create_context()
with dpg.font_registry(): #注册字体，自选字体
    with dpg.font("STKAITI.ttf", 20) as font1:	#增加中文编码范围，防止问好
          dpg.add_font_range_hint(dpg.mvFontRangeHint_Default)
          dpg.add_font_range_hint(dpg.mvFontRangeHint_Chinese_Simplified_Common)
          dpg.add_font_range_hint(dpg.mvFontRangeHint_Chinese_Full)
 #       mvFontRangeHint_Japanese
 #       mvFontRangeHint_Korean
 #       mvFontRangeHint_Cyrillic
 #       mvFontRangeHint_Thai
#        mvFontRangeHint_Vietnamese

with dpg.window(label="demo", width=500, height=150):
    dpg.add_text("Hello, world")
    dpg.add_text("你好，世界")
    dpg.bind_font(font1)
    
dpg.create_viewport(title="dear_pygui", width=800, height=600)
dpg.setup_dearpygui()
dpg.show_viewport()
dpg.start_dearpygui()
dpg.destroy_context()