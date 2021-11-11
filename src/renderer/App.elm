module App exposing (..)
import Html exposing (..)
import Files

main : Html msg
main =
  div []
    [ p [] [ text "App" ]
    , Files.view
    ]