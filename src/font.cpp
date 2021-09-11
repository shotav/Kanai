#include "font.h"

namespace font {

    FT_Library library;
    FT_Face face;

    void load() {
        FT_Init_FreeType(&library);
        FT_New_Face(library, "libs/fira/ttf/FiraMono-Regular.ttf", 0, &face);

        FT_Set_Char_Size(face, 0, 16*64, 300, 300);
        int glyph_index = FT_Get_Char_Index(face, 'a');
        FT_Load_Glyph(face, glyph_index, FT_LOAD_DEFAULT);
        FT_Render_Glyph(face->glyph, FT_RENDER_MODE_NORMAL);

        FT_Done_Face(face);
        FT_Done_FreeType(library);
    }
    
}