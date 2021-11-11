open System.Drawing
open PhotinoNET

module Program =

  [<EntryPoint>]
  let main _ =
    let window = PhotinoWindow()
    window.SetTitle("Kanai Editor")       |> ignore
    window.SetUseOsDefaultSize(false)     |> ignore
    window.SetSize(Size(1280, 720))        |> ignore
    window.Center()                       |> ignore

    #if DEBUG
    window.Load("http://localhost:8080")  |> ignore
    #else
    window.Load("build/index.html")       |> ignore
    #endif

    window.WaitForClose()
    0