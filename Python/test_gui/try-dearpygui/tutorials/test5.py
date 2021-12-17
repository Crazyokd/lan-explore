# DPG items consist of configuration, state and info. (AND value but we will cover that separately)

# Each of these can be accessed by their corresponding function

# get_item_configuration
# keywords that control its appearance and behavior (label, callback, width, height)

# get_item_state
# keywords that reflect its interaction (visible, hovered, clicked, ect)

# get_item_info
# keywords that reflect its information (item type, children, theme, ect)

import dearpygui.dearpygui as dpg

def set_configuration():
    with dpg.window(label="Tutorial"):

        # configuration set when button is created
        dpg.add_button(label="Apply", width=300)

        # user data and callback set any time after button has been created
        btn = dpg.add_button(label="Apply 2")
        dpg.set_item_label(btn, "Button 57")
        dpg.set_item_width(btn, 200)

    dpg.show_item_registry()

    dpg.create_viewport(title='Custom Title', width=800, height=600)
    dpg.setup_dearpygui()
    dpg.show_viewport()
    dpg.start_dearpygui()



# Callbacks give items functionality by assigning a function to run when they are activated and almost all UI Items in DPG can run callbacks.

# Functions or methods are assigned as UI item callbacks when an item is created or at a later runtime using set_item_callback

# Callbacks may have up to 3 arguments in the following order.

# sender:
# the id of the UI item that submitted the callback

# app_data:
# occasionally UI items will send their own data (ex. file dialog)

# user_data:
# any python object you want to send to the function

def set_callback():
    def button_callback(sender, app_data, user_data):
        print(f"sender is: {sender}")
        print(f"app_data is: {app_data}")
        print(f"user_data is: {user_data}")

    with dpg.window(label="Tutorial"):
        # user data and callback set when button is created
        dpg.add_button(label="Apply", callback=button_callback, user_data="Some Data")

        # user data and callback set any time after button has been created
        btn = dpg.add_button(label="Apply 2", )
        dpg.set_item_callback(btn, button_callback)
        dpg.set_item_user_data(btn, "Some Extra User Data")

    dpg.create_viewport(title='Custom Title', width=800, height=600)
    dpg.setup_dearpygui()
    dpg.show_viewport()
    dpg.start_dearpygui()


# Almost all UI items have a value which can be accessed or set.

# All UI items that have a value also have the default_value parameter which will set the items’ initial starting value.

# Values can be accessed using get_value.
def get_value():
    def print_value(sender):
        print(dpg.get_value(sender))

    with dpg.window(width=300):
        input_txt1 = dpg.add_input_text()
        # The value for input_text2 will have a starting value
        # of "This is a default value!"
        input_txt2 = dpg.add_input_text(
            label="InputTxt2",
            default_value="This is a default value!",
            callback=print_value
        )

        slider_float1 = dpg.add_slider_float()
        # The slider for slider_float2 will have a starting value
        # of 50.0.
        slider_float2 = dpg.add_slider_float(
            label="SliderFloat2",
            default_value=50.0,
            callback=print_value
        )

        dpg.set_item_callback(input_txt1, print_value)
        dpg.set_item_callback(slider_float1, print_value)

        print(dpg.get_value(input_txt1))
        print(dpg.get_value(input_txt2))
        print(dpg.get_value(slider_float1))
        print(dpg.get_value(slider_float2))

    dpg.create_viewport(title='Custom Title', width=800, height=600)
    dpg.setup_dearpygui()
    dpg.show_viewport()
    dpg.start_dearpygui()

def set_value():
    with dpg.window(width=300):
        # Creating a slider_int widget and setting the
        # default value to 15.
        dpg.add_slider_int(default_value=15, tag="slider_int")

    # On second thought, we're gonna set the value to 40
    # instead - for no reason in particular...
    dpg.set_value("slider_int", 40)

    dpg.create_viewport(title='Custom Title', width=800, height=600)
    dpg.setup_dearpygui()
    dpg.show_viewport()
    dpg.start_dearpygui()


if __name__ == '__main__':
    dpg.create_context()
    # set_configuration()
    # set_callback()
    get_value()
    dpg.destroy_context()