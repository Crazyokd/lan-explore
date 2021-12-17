# The viewport is what you traditionally call a window in other GUI libraries.

# In the case of DPG we call the operating system window the viewport and the DPG windows as windows.

# Before calling start_dearpygui, you must do the following:
# Create a viewport, using create_viewport.

# Assign the viewport, using setup_dearpygui.

# Show the viewport, using show_viewport.

# Once the viewport has been created, you can begin configuring the viewport using configure_viewport or the helper commands set_viewport_***.

import dearpygui.dearpygui as dpg

dpg.create_context()

with dpg.window(label="Example Window", width=500, height=150):
    dpg.add_text("Hello, world")

dpg.create_viewport(title='Custom Title', width=600, height=200)  # create viewport takes in config options too!

# must be called before showing viewport
dpg.set_viewport_small_icon("path/to/icon.ico")
dpg.set_viewport_large_icon("path/to/icon.ico")

dpg.setup_dearpygui()
dpg.show_viewport()
dpg.start_dearpygui()
dpg.destroy_context()