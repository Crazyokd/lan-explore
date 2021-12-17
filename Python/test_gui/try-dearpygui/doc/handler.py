# Handlers are items that submit a callback when the specified state of an item changes.

# Handlers can be activated or deactivated by showing or hiding them.

# Handlers are required to be added to a handler registry.

import dearpygui.dearpygui as dpg

def set_registry():
    def change_text(sender, app_data):
        dpg.set_value("text item", f"Mouse Button ID: {app_data}")

    def visible_call(sender, app_data):
        print("I'm visible")

    with dpg.item_handler_registry(tag="widget handler") as handler:
        dpg.add_item_clicked_handler(callback=change_text)
        dpg.add_item_visible_handler(callback=visible_call)

    with dpg.window(width=500, height=300):
        dpg.add_text("Click me with any mouse button", tag="text item")
        dpg.add_text("Close window with arrow to change visible state printing to console", tag="text item 2")

    # bind item handler registry to item
    dpg.bind_item_handler_registry("text item", "widget handler")
    dpg.bind_item_handler_registry("text item 2", "widget handler")

    dpg.create_viewport(title='Custom Title', width=800, height=600)
    dpg.setup_dearpygui()
    dpg.show_viewport()
    dpg.start_dearpygui()


def poll_item_state():
    def change_text(sender, app_data):
        if dpg.is_item_hovered("text item"):
            dpg.set_value("text item", f"Stop Hovering Me, Go away!!")
        else:
            dpg.set_value("text item", f"Hover Me!")

    with dpg.handler_registry():
        dpg.add_mouse_move_handler(callback=change_text)

    with dpg.window(width=500, height=300):
        dpg.add_text("Hover Me!", tag="text item")


    dpg.create_viewport(title='Custom Title', width=800, height=600)
    dpg.setup_dearpygui()
    dpg.show_viewport()
    dpg.start_dearpygui()


if __name__ == '__main__':
    dpg.create_context()
    poll_item_state()
    dpg.destroy_context()