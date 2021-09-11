#include "resource.h"

namespace resource {

    std::string load(std::string path) {
        auto fs = cmrc::res::get_filesystem();
        auto file = fs.open(path);
        return std::string(file.begin(), file.end());
    }

}