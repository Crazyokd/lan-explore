import dearpygui.dearpygui as dpg

def context_manager():
    with dpg.window(label="Main"):

        with dpg.menu_bar():
            with dpg.menu(label="Themes"):
                dpg.add_menu_item(label="Dark")
                dpg.add_menu_item(label="Light")
                dpg.add_menu_item(label="Classic")

                with dpg.menu(label="Other Themes"):
                    dpg.add_menu_item(label="Purple")
                    dpg.add_menu_item(label="Gold")
                    dpg.add_menu_item(label="Red")

            with dpg.menu(label="Tools"):
                dpg.add_menu_item(label="Show Logger")
                dpg.add_menu_item(label="Show About")

            with dpg.menu(label="Oddities"):
                dpg.add_button(label="A Button")
                dpg.add_simple_plot(label="Menu plot", default_value=(0.3, 0.9, 2.5, 8.9), height=80)

    dpg.create_viewport(title='Custom Title', width=800, height=600)
    dpg.setup_dearpygui()
    dpg.show_viewport()
    dpg.start_dearpygui()


# using UUID
def assign_parent():
    w = dpg.add_window(label="Main")

    mb = dpg.add_menu_bar(parent=w)

    themes = dpg.add_menu(label="Themes", parent=mb)
    dpg.add_menu_item(label="Dark", parent=themes)
    dpg.add_menu_item(label="Light", parent=themes)

    other_themes = dpg.add_menu(label="Other Themes", parent=themes)
    dpg.add_menu_item(label="Purple", parent=other_themes)
    dpg.add_menu_item(label="Gold", parent=other_themes)
    dpg.add_menu_item(label="Red", parent=other_themes)

    tools = dpg.add_menu(label="Tools", parent=mb)
    dpg.add_menu_item(label="Show Logger", parent=tools)
    dpg.add_menu_item(label="Show About", parent=tools)

    oddities = dpg.add_menu(label="Oddities", parent=mb)
    dpg.add_button(label="A Button", parent=oddities)
    dpg.add_simple_plot(label="A menu plot", default_value=(0.3, 0.9, 2.5, 8.9), height=80, parent=oddities)

    dpg.create_viewport(title='Custom Title', width=800, height=600)
    dpg.setup_dearpygui()
    dpg.show_viewport()
    dpg.start_dearpygui()


# using aliases
def assign_parent2():
    dpg.add_window(label="Main", tag="w")

    dpg.add_menu_bar(parent="w", tag="mb")

    dpg.add_menu(label="Themes", parent="mb", tag="themes")
    dpg.add_menu_item(label="Dark", parent="themes")
    dpg.add_menu_item(label="Light", parent="themes")

    dpg.add_menu(label="Other Themes", parent="themes", tag="other_themes")
    dpg.add_menu_item(label="Purple", parent="other_themes")
    dpg.add_menu_item(label="Gold", parent="other_themes")
    dpg.add_menu_item(label="Red", parent="other_themes")

    dpg.add_menu(label="Tools", parent="mb", tag="tools")
    dpg.add_menu_item(label="Show Logger", parent="tools")
    dpg.add_menu_item(label="Show About", parent="tools")

    dpg.add_menu(label="Oddities", parent="mb", tag="Oddities")
    dpg.add_button(label="A Button", parent="Oddities")
    dpg.add_simple_plot(label="A menu plot", default_value=(0.3, 0.9, 2.5, 8.9), height=80, parent="Oddities")

    dpg.create_viewport(title='Custom Title', width=800, height=600)
    dpg.setup_dearpygui()
    dpg.show_viewport()
    dpg.start_dearpygui()


def stack_operation():
    dpg.push_container_stack(dpg.add_window(label="Main"))

    dpg.push_container_stack(dpg.add_menu_bar())

    dpg.push_container_stack(dpg.add_menu(label="Themes"))
    dpg.add_menu_item(label="Dark")
    dpg.add_menu_item(label="Light")
    dpg.pop_container_stack()

    dpg.push_container_stack(dpg.add_menu(label="Tools"))
    dpg.add_menu_item(label="Show Logger")
    dpg.add_menu_item(label="Show About")
    dpg.pop_container_stack()

    # remove menu_bar from container stack
    dpg.pop_container_stack()

    # remove window from container stack
    dpg.pop_container_stack()

    dpg.create_viewport(title='Custom Title', width=800, height=600)
    dpg.setup_dearpygui()
    dpg.show_viewport()
    dpg.start_dearpygui()


if __name__ == '__main__':
    dpg.create_context()
    # context_manager()
    # assign_parent()
    # assign_parent2()
    stack_operation()
    dpg.destroy_context()