-- Configuration
function love.conf(t)
  t.title = "Pumping Wars"              -- The title of the window the game is in (string)
  t.version = "0.10.1"                  -- The LÖVE version this game was made for (string)
  t.author = "th3_sh4llow_5tato_p0zzo"  -- sorry who?

  t.window.width = 1024
  t.window.height = 600

  t.window.fullscreen = true

  -- For Windows debugging
  t.console = true
end
