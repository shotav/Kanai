open System.Drawing
open PhotinoNET

module Program =

  [<EntryPoint>]
  let main _ =
    let window = new PhotinoWindow()
    window.SetTitle("Kanai")            |> ignore
    window.SetUseOsDefaultSize(false)   |> ignore
    window.SetSize(new Size(600, 400))  |> ignore
    window.Center()                     |> ignore
    window.Load("build/index.html")     |> ignore
    window.WaitForClose()
    0