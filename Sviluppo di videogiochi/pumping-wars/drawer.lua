function drawer()
    if bg.bombed then
        love.graphics.setColor(255,0,0)
    else
        love.graphics.setColor(255,255,255)
    end

    drawBackground(bg.img, bg.x, bg.y)

    if keyboard_hints.alpha < 0 then
        draw_dangertape()
        draw_score()
    end

    if status.muted then
        love.graphics.setColor(255,255,255)
        love.graphics.draw(mute_object.img, mute_object.x, mute_object.y)
    end

    -- draw initial keyboard hints

    if keyboard_hints.display and keyboard_hints.alpha >= 0 and not status.paused then
        love.graphics.setColor(255,255,255, keyboard_hints.alpha)
        love.graphics.draw(keyboard_hints.img, keyboard_hints.x, keyboard_hints.y)
    end

    -- if a bomb exploded then make red also the rest of the game
    if bg.bombed then
        love.graphics.setColor(255,0,0)
    else
        love.graphics.setColor(255,255,255)
    end

    if keyboard_hints.alpha < 0 then
        draw_players()

        -- if chomsky npc is spawned then remove objects from screen
        if not chomsky.spawned then
            draw_objects()
        end

        draw_npc()

        -- if background is red then make both bullets black because
        -- they might have problem with the contrast
        if bg.bombed then
            love.graphics.setColor(0,0,0)
        else
            love.graphics.setColor(255,255,255)
        end
        draw_bullets()
    end

    -- draw nuke explosion when bg is bombed
    -- display is checked in order to properly show image while
    -- alpha is checked to see whether the image has completely disappeared

    if nuke.display and nuke.alpha >= 0 then
        love.graphics.setColor(255,255,255,nuke.alpha)
        love.graphics.draw(nuke.img, nuke.x, nuke.y)
    end

    -- draw final banner

    if final_banner.display and final_banner.alpha >= 0 and not status.paused then
        love.graphics.setColor(255,255,255, final_banner.alpha)
        love.graphics.draw(final_banner.img, final_banner.x, final_banner.y)
    end

    -- draw various status object when special keys are pressed

    if status.paused then
        love.graphics.setColor(255,255,255)
        love.graphics.draw(paused_object.img, paused_object.x, paused_object.y)
    end

    -- debugging stuff

    if status.debugging then
        if chomsky.spawned then
            love.graphics.setColor(255,0,0,150)  -- collisions with bullets
            love.graphics.rectangle("fill", chomsky.x,
                                            chomsky.y,
                                            chomsky.img:getWidth(),
                                            chomsky.img:getHeight())
        end

        for i, player in ipairs(players) do
            love.graphics.setColor(0,255,0,150) -- collisions for power ups
            love.graphics.rectangle("fill", player.x + player.shapes.arm_x,
                                            player.y + player.shapes.arm_y,
                                            player.img:getWidth() + player.shapes.arm_img_width,
                                            player.img:getHeight() + player.shapes.arm_img_height, 10, 10 )
            love.graphics.setColor(255,0,0,150)  -- collisions with bullets
            love.graphics.rectangle("fill", player.x + player.shapes.body_x,
                                            player.y + player.shapes.body_y,
                                            player.img:getWidth() + player.shapes.body_img_width,
                                            player.img:getHeight() + player.shapes.body_img_height, 10, 10 )
        end

        fps = tostring(love.timer.getFPS())
        love.graphics.setColor(255,0,0)
        love.graphics.print("Current FPS:" .. fps, love.graphics:getWidth() - 300, love.graphics:getHeight() - 40)
        love.graphics.setColor(0,128,0)
        love.graphics.print("Version " .. game_version, 20, love.graphics:getHeight() - 40)
    end
end

function draw_npc()
    if chomsky.spawned then
        love.graphics.draw(chomsky.img, chomsky.x, chomsky.y)

        -- if a npc as been hit draw blood
        if chomsky.hit then
            love.graphics.draw(player_hit_img, chomsky.x, chomsky.y)
        end
    end
end

function draw_players()
    for i, player in ipairs(players) do
        -- before drawing players check if one of the two players won
        -- if true then chage avatar
        if player.won then
            player.img = player_won_img
            love.graphics.draw(player.img, player.x, player.y)
        else
            -- draw the two players animation
            player.anim:draw(player.x, player.y)
        end

        -- draw power up animation for player

        if player.powered and (not player.won) then
            love.graphics.draw(player.bodyStateImg, player.x, player.y)
        end

        -- if a player as been hit draw blood
        if player.hit then
            love.graphics.draw(player_hit_img, player.x, player.y)
        end
    end
end

function draw_objects()
    -- draw power ups
    for i, power in ipairs(powerups) do
        if power.spawned and power.spawn_timer > 0 then
            love.graphics.draw(power.img, power.x, power.y)
        end
    end

    -- draw bombs
    for i, bomb in ipairs(bombs) do
        love.graphics.draw(bomb.img, bomb.x, bomb.y)
    end

    -- draw kleene star
    love.graphics.draw(kleene.img, kleene.x, kleene.y)

    -- draw the savescore object
    love.graphics.draw(savescore.img, savescore.x, savescore.y)
end

function draw_dangertape()
    -- drawing danger tape

    -- adjust alpha channel of danger tape
    love.graphics.setColor(255,255,255, 100)

    for j = 1, math.ceil(love.graphics.getHeight()/danger_tape_img:getHeight()) do
        love.graphics.draw(danger_tape_img,
                           (love.graphics:getWidth() / 2) - (danger_tape_img:getWidth() / 2),
                           (j-1) * danger_tape_img:getHeight() + 0)
    end
end

function draw_score()
    -- before writing the score change color of the label
    -- according to the action performed

    love.graphics.setColor(0, 0, 0)
    love.graphics.print(players[1].name, 40, 20)

    love.graphics.setColor(0, 0, 0)
    if players[2].hit and players[2].hitTimer > 0 then
        love.graphics.setColor(0, 128, 0)
    elseif players[1].powered and players[1].poweredTimer > 0 then
        love.graphics.setColor(255, 255, 0)
    elseif players[1].hit and players[1].hitTimer > 0 then
        love.graphics.setColor(255, 0, 0)
    end
    love.graphics.print("PUNTI: " .. players[1].score, 40, 50)

    -- print out ammo
    if players[1].reloadTimer > 0 then
        love.graphics.setColor(142, 68, 173)
        love.graphics.print("RICARICO...", 40, 80)
    else
        ammo_string = ""

        for i = 1, (players[1].maxBullets - players[1].bulletCounter) do
            ammo_string = ammo_string .. "|"
        end

        love.graphics.setColor(0, 0, 0)
        love.graphics.print("AMMO ", 40, 80)
        love.graphics.setFont(font.ammo)

        if players[1].has_kleene then
            love.graphics.setColor(255, 150, 0)
        else
            love.graphics.setColor(0, 79, 162)
        end

        love.graphics.print(ammo_string, 130, 80)
        love.graphics.setFont(font.game)
    end

    -- print second player stats

    love.graphics.setColor(0, 0, 0)
    love.graphics.print(players[2].name, love.graphics:getWidth() - 150, 20)

    love.graphics.setColor(0, 0, 0)
    if players[1].hit and players[1].hitTimer > 0 then
        love.graphics.setColor(0, 128, 0)
    elseif players[2].powered and players[2].poweredTimer > 0 then
        love.graphics.setColor(255, 255, 0)
    elseif players[2].hit and players[2].hitTimer > 0 then
        love.graphics.setColor(255, 0, 0)
    end

    -- calculate dynamic spacing form left side everytime a new number
    -- character is added to the score string
    -- these values are strictly related to the font size

    label_spacing = 185
    score_length = (players[2].score) .. ""
    label_spacing = label_spacing + ((#score_length - 1) * 17)

    love.graphics.print("PUNTI: " .. players[2].score, love.graphics:getWidth() - label_spacing, 50)

    -- print out ammo
    if players[2].reloadTimer > 0 then
        love.graphics.setColor(142, 68, 173)
        love.graphics.print("RICARICO...", love.graphics:getWidth() - 230, 80)
    else
        ammo_string = ""

        for i = 1, (players[2].maxBullets - players[2].bulletCounter) do
            ammo_string = ammo_string .. "|"
        end

        love.graphics.setColor(0, 0, 0)
        love.graphics.printf(" AMMO", love.graphics:getWidth() - 300, 80, 250, "right")
        love.graphics.setFont(font.ammo)

        if players[2].has_kleene then
            love.graphics.setColor(255, 150, 0)
        else
            love.graphics.setColor(255, 0, 0)
        end

        love.graphics.printf(ammo_string, love.graphics:getWidth() - 380, 80, 245, "right")
        love.graphics.setFont(font.game)
    end

    -- print score for chomsky npc

    if chomsky.spawned then
        ammo_string = "|"

        for i = 1, chomsky.life / 2.9 do
            ammo_string = ammo_string .. "|"
        end

        love.graphics.setColor(0, 0, 0)

        if chomsky.hit then
            love.graphics.setColor(255, 0, 0)
        end

        love.graphics.print("chomsky  vita", (love.graphics:getWidth() / 2) - 140, 20)
        love.graphics.setColor(39, 174, 96)
        love.graphics.setFont(font.ammo)
        love.graphics.printf(ammo_string, (love.graphics:getWidth() / 2) - 140, 50, 260, "left")
        love.graphics.setFont(font.game)
    end
end

function draw_bullets()
    --draw bullets

    for i, player in ipairs(players) do
        for j, bullet in ipairs(player.bullets) do
            love.graphics.draw(bullet.img, bullet.x, bullet.y)
        end
    end

    -- draw npc bullets

    if chomsky.spawned then
        for i, bullet in ipairs(chomsky.bullets) do
            love.graphics.draw(bullet.img, bullet.x, bullet.y)
        end
    end

    -- draw explosion if two bullets collided

    if bullet_collision.collided then
        love.graphics.draw(bullet_collision.img, bullet_collision.x, bullet_collision.y)
    end
end

function drawBackground(bgImg, xPos, yPos)
    for i = 1, math.ceil(love.graphics.getWidth()/bgImg:getWidth()) do
        for j = 1, math.ceil(love.graphics.getHeight()/bgImg:getHeight()) do
            love.graphics.draw(bgImg, (i-1)*bgImg:getWidth() + xPos, (j-1)*bgImg:getHeight() + yPos)
        end
    end
end
