# DPG embeds a copy of ‘ProggyClean.ttf’ (by Tristan Grimmer), a 13 pixels high, pixel-perfect font used by default. 
# ProggyClean does not scale smoothly, 
# therefore it is recommended that you load your own file when using DPG in an application aiming to look nice and wanting to support multiple resolutions.

# You do this by loading external .TTF/.OTF files. In the Resources folder you can find an example of a otf font.

import dearpygui.dearpygui as dpg

def use_fonts():
    # add a font registry
    with dpg.font_registry():
        # first argument ids the path to the .ttf or .otf file
        default_font = dpg.add_font("DEJAVUSANSMONO_0.ttf", 18)
        second_font = dpg.add_font("DEJAVUSANSMONO_0.ttf", 15)

    with dpg.window(label="Font Example", height=200, width=200):
        dpg.add_button(label="Default font")
        b2 = dpg.add_button(label="Secondary font")
        dpg.add_button(label="default")

        # set font of specific widget
        dpg.bind_font(default_font)
        dpg.bind_item_font(b2, second_font)

    dpg.show_font_manager()

    dpg.create_viewport(title='Custom Title', width=800, height=600)
    dpg.setup_dearpygui()
    dpg.show_viewport()
    dpg.start_dearpygui()


def load_specify_character():
    with dpg.font_registry():
        with dpg.font("DEJAVUSANSMONO_0.ttf", 20) as font1:

            # add the default font range
            dpg.add_font_range_hint(dpg.mvFontRangeHint_Default)

            # helper to add range of characters
            #    Options:
            #        mvFontRangeHint_Japanese
            #        mvFontRangeHint_Korean
            #        mvFontRangeHint_Chinese_Full
            #        mvFontRangeHint_Chinese_Simplified_Common
            #        mvFontRangeHint_Cyrillic
            #        mvFontRangeHint_Thai
            #        mvFontRangeHint_Vietnamese
            dpg.add_font_range_hint(dpg.mvFontRangeHint_Japanese)

            # add specific range of glyphs
            dpg.add_font_range(0x3100, 0x3ff0)

            # add specific glyphs
            dpg.add_font_chars([0x3105, 0x3107, 0x3108])

            # remap や to %
            dpg.add_char_remap(0x3084, 0x0025)

    dpg.show_font_manager()

    dpg.create_viewport(title='Custom Title', width=800, height=600)
    dpg.setup_dearpygui()
    dpg.show_viewport()
    dpg.start_dearpygui()


if __name__ == '__main__':
    dpg.create_context()
    # use_fonts()
    load_specify_character()
    dpg.destroy_context()
