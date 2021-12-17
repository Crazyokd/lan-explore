# In DPG, all items must have an associated unique ID (UUID) which can either be an integer or a string.

# When a item is created, a tag is generated for you automatically. 
# It is your responsibility to store this tag if you intend on interacting with the widget at a later time.

# Tags allow for modification of the associated item at runtime.

import dearpygui.dearpygui as dpg

# def tag():

#     unique_id = 0 # to be filled out later

#     def callback():
#         print(dpg.get_value(unique_tag))

#     with dpg.window(label="Example"):
#         dpg.add_button(label="Press me (print to output)", callback=callback)
#         unique_id = dpg.add_input_int(label="Input")

#     dpg.create_viewport(title='Custom Title', width=600, height=200)
#     dpg.setup_dearpygui()
#     dpg.show_viewport()
#     dpg.start_dearpygui()


def generate_tag():
    
    unique_tag = dpg.generate_uuid()

    def callback():
        print(dpg.get_value(unique_tag))

    with dpg.window(label="Example"):
        dpg.add_button(label="Press me (print to output)", callback=callback)
        dpg.add_input_int(label="Input", tag=unique_tag)

    dpg.create_viewport(title='Custom Title', width=600, height=200)
    dpg.setup_dearpygui()
    dpg.show_viewport()
    dpg.start_dearpygui()


def aliases():
    def callback():
        print(dpg.get_value("unique_tag"))

    with dpg.window(label="Example"):
        dpg.add_button(label="Press me (print to output)", callback=callback)
        dpg.add_input_int(default_value=5, label="Input", tag="unique_tag")

    dpg.create_viewport(title='Custom Title', width=600, height=200)
    dpg.setup_dearpygui()
    dpg.show_viewport()
    dpg.start_dearpygui()


def recent_tag():
    with dpg.window(label="Example"):
        with dpg.group():
            dpg.add_button(label="View the Terminal for item tags")
            print(dpg.last_item())
            print(dpg.last_container())
            print(dpg.last_root())

    dpg.create_viewport(title='Custom Title', width=600, height=200)
    dpg.setup_dearpygui()
    dpg.show_viewport()
    dpg.start_dearpygui()


if __name__ == '__main__':
    dpg.create_context()
    # generate_tag()
    recent_tag()
    dpg.destroy_context()