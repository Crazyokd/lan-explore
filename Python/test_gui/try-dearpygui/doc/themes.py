# Themes are containers which are composed of:
# Theme Components:
# are containers within a theme that can specify an item type the theme colors/styles target

# Theme Colors:
# items that are added to a theme component and set colors

# Theme Styles:
# items that are added to a theme component and set styles

# The theme can be:

# bound as the default theme. This will have a global effect across all windows and propagate.

# bound to a container. This will propagate to its children if applicable theme components are in the theme.

# bound to an item type if applicable theme components are in the theme. a item container, or a specific item.

# Theme components must have a specified item type. This can either be mvAll for all items or a specific item type.

# Style and color items have a named constant and will apply that constant to their components named item type. 
# Style and color items must have a named category. Constants contain their category in the name.

import dearpygui.dearpygui as dpg

def theme():
    with dpg.window(label="Tutorial", pos=(20, 50), width=275, height=225) as win1:
        t1 = dpg.add_input_text(default_value="some text")
        t2 = dpg.add_input_text(default_value="some text")
        with dpg.child_window(height=100):
            t3 = dpg.add_input_text(default_value="some text")
            dpg.add_input_int()
        dpg.add_input_text(default_value="some text")

    with dpg.window(label="Tutorial", pos=(320, 50), width=275, height=225) as win2:
        dpg.add_input_text(default_value="some text")
        dpg.add_input_int()

    with dpg.theme() as global_theme:

        with dpg.theme_component(dpg.mvAll):
            dpg.add_theme_color(dpg.mvThemeCol_FrameBg, (255, 140, 23), category=dpg.mvThemeCat_Core)
            dpg.add_theme_style(dpg.mvStyleVar_FrameRounding, 5, category=dpg.mvThemeCat_Core)

        with dpg.theme_component(dpg.mvInputInt):
            dpg.add_theme_color(dpg.mvThemeCol_FrameBg, (140, 255, 23), category=dpg.mvThemeCat_Core)
            dpg.add_theme_style(dpg.mvStyleVar_FrameRounding, 5, category=dpg.mvThemeCat_Core)

    dpg.bind_theme(global_theme)

    # control style
    dpg.show_style_editor()

    dpg.create_viewport(title='Custom Title', width=800, height=600)
    dpg.setup_dearpygui()
    dpg.show_viewport()
    dpg.start_dearpygui()


if __name__ == '__main__':
    dpg.create_context()
    theme()
    dpg.destroy_context()