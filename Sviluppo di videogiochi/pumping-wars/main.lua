require "lib/AnAL/AnAL"

require "loader"
require "updater"
require "drawer"

game_version = "1.4.3"

status = {
    debugging = false,
    paused = false,
    muted = false,
    intro_skipped = false
}

function love.keypressed(key, unicode)
    if key == "escape" then
        love.event.push("quit")
    elseif key == "return" then
        status.intro_skipped = true
    elseif key == "m" then
        if soundtrack:isPlaying() then
            soundtrack:pause()
            status.muted = true
        else
            soundtrack:play()
            status.muted = false
        end
    elseif key == "h" then
        status.debugging = not status.debugging
    elseif key == "p" then
        status.paused = not status.paused
    end
end

function love.load()
    loader()
end

function love.update(dt)
    if not status.paused then
        updater(dt)
    end
end

function love.draw()
    drawer()
end
