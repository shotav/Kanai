open System
open System.Drawing
open PhotinoNET

module Program =

  [<EntryPoint>]
  [<STAThread>]
  let main argv =
    let window = new PhotinoWindow()
    window.SetTitle("Kanai")
    window.SetUseOsDefaultSize(false)
    window.SetSize(new Size(600, 400))
    window.Center()
    window.Load("build/index.html")
    window.WaitForClose()
    0