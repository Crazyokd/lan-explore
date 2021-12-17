# UI item handlers listen for events (changes in state) related to a UI item then submit a callback.

import dearpygui.dearpygui as dpg

def set_handler():
    def change_text(sender, app_data):
        dpg.set_value("text item", f"Mouse Button ID: {app_data}")

    with dpg.window(width=500, height=300):
        dpg.add_text("Click me with any mouse button", tag="text item")
        with dpg.item_handler_registry(tag="widget handler") as handler:
            dpg.add_item_clicked_handler(callback=change_text)
        dpg.bind_item_handler_registry("text item", "widget handler")

    dpg.create_viewport(title='Custom Title', width=800, height=600)
    dpg.setup_dearpygui()
    dpg.show_viewport()
    dpg.start_dearpygui()


# DPG contains several tools which can help debug applications.
def show_dpgmessage():
    dpg.show_documentation()
    dpg.show_style_editor()
    dpg.show_debug()
    dpg.show_about()
    dpg.show_metrics()
    dpg.show_font_manager()
    dpg.show_item_registry()

    dpg.create_viewport(title='Custom Title', width=800, height=600)
    dpg.setup_dearpygui()
    dpg.show_viewport()
    dpg.start_dearpygui()


if __name__ == '__main__':
    dpg.create_context()
    # set_handler()
    show_dpgmessage()
    dpg.destroy_context()