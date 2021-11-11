open System.Drawing
open PhotinoNET

module Program =

  [<EntryPoint>]
  let main _ =
    PhotinoWindow()
      .SetTitle("Kanai Editor")
      .SetUseOsDefaultSize(false)
      .SetSize(Size(600, 400))
      .Center()
      .Load("build/index.html")
      .WaitForClose()
    0