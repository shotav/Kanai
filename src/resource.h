#pragma once

#include <string>
#include <cmrc/cmrc.hpp>

CMRC_DECLARE(res);

namespace resource {

    std::string load(std::string path);

}