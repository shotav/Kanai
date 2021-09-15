#include "font.h"

namespace font {

    FT_Library library;
    FT_Face face;
    FT_GlyphSlot slot;

    void load() {
        FT_Init_FreeType(&library);
        FT_New_Face(library, "libs/fira/ttf/FiraMono-Regular.ttf", 0, &face);
        FT_Set_Pixel_Sizes(face, 0, 48);
        FT_Load_Char(face, 'X', FT_LOAD_RENDER);
        slot = face->glyph;

        auto vertex = resource::load("res/shaders/font.vert");
        auto fragment = resource::load("res/shaders/font.frag");

        FT_Done_Face(face);
        FT_Done_FreeType(library);
    }

    void test() {}

}