{-# LANGUAGE
  OverloadedStrings
#-}

module Main where

import qualified Graphics.UI.Webviewhs as WHS
import System.Environment

main :: IO ()
main = do
  WHS.createWindowAndBlock
    WHS.WindowParams
      { WHS.windowParamsTitle      = "Kanai Editor"
      , WHS.windowParamsUri        = "https://example.com"
      , WHS.windowParamsWidth      = 1280
      , WHS.windowParamsHeight     = 720
      , WHS.windowParamsResizable  = True
      , WHS.windowParamsDebuggable = True
      }