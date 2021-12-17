import dearpygui.dearpygui as dpg

def create_item():
    with dpg.window(label="Tutorial") as window:
        # When creating items within the scope of the context
        # manager, they are automatically "parented" by the
        # container created in the initial call. So, "window"
        # will be the parent for all of these items.

        button1 = dpg.add_button(label="Press Me!")

        slider_int = dpg.add_slider_int(label="Slide to the left!", width=100)
        slider_float = dpg.add_slider_float(label="Slide to the right!", width=100)

        # An item's unique identifier (tag) is returned when
        # creating items.
        print(f"Printing item tag's: {window}, {button1}, {slider_int}, {slider_float}")

    # If you want to add an item to an existing container, you
    # can specify it by passing the container's tag as the
    # "parent" parameter.
    button2 = dpg.add_button(label="Don't forget me!", parent=window)

    dpg.create_viewport(title='Custom Title', width=600, height=200)
    dpg.setup_dearpygui()
    dpg.show_viewport()
    dpg.start_dearpygui()



def runtime_add_and_del():
    def add_buttons():
        global new_button1, new_button2
        new_button1 = dpg.add_button(label="New Button", before="delete_button", tag="new_button1")
        new_button2 = dpg.add_button(label="New Button 2", parent="secondary_window", tag="new_button2")


    def delete_buttons():
        dpg.delete_item("new_button1")
        dpg.delete_item("new_button2")


    with dpg.window(label="Tutorial", pos=(200, 200)):
        dpg.add_button(label="Add Buttons", callback=add_buttons)
        dpg.add_button(label="Delete Buttons", callback=delete_buttons, tag="delete_button")

    with dpg.window(label="Secondary Window", tag="secondary_window", pos=(100, 100)):
        pass

    dpg.create_viewport(title='Custom Title', width=600, height=400)
    dpg.setup_dearpygui()
    dpg.show_viewport()
    dpg.start_dearpygui()


if __name__ == '__main__':
    dpg.create_context()
    runtime_add_and_del()
    dpg.destroy_context()