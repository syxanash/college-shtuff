require "object_checker"
require "npc"

function updater(dt)
    update_timers(dt)

    check_bullet_collisions(dt)

    if not chomsky.spawned and keyboard_hints.alpha <= 0 then
        -- objects are power ups, savescore or bombs
        object_checker(dt)
    end

    -- npc controller
    if chomsky.spawned then
        npc_controller(dt)
    end

    if keyboard_hints.alpha <= 0 then
        control_players(dt)
    end

    -- check if one of the two players won scoring 100 points
    for i, player in ipairs(players) do
        -- check if one of the two players reaches the score to spawn boss
        -- also check if the boss already spawned and it wasn't defeated
        if player.score >= score_to_boss and not chomsky.defeated and not chomsky.spawned then
            chomsky.spawned = true
        end

        if player.score >= max_score and not player.won then
            player.won = true
            player.min_score = max_score

            -- show final banner if someone wins
            final_banner.display = true
            final_banner.displayTimer = final_banner.displayTimerMax
            final_banner.fadeOutTimer = final_banner.fadeOutTimerMax

            if soundtrack:isPlaying() then
                soundtrack:pause()
                status.muted = true
            end

            final_soundtrack:play()
        end
    end
end

function control_players(dt)
    -- shooting keys
    -- if player is hit by a normal bullet then it stops shooting
    -- otherwise if he has a kleene star he can shoot even if he has been hit

    if love.keyboard.isDown("space") and players[1].canShoot and not (players[1].hit and not players[1].has_kleene) then
        if players[1].reloadTimer <= 0 then
            if players[1].has_kleene then
                table.insert(players[1].bullets, {x = players[1].x + (players[1].img:getWidth() / 2), y = players[1].y + (players[1].img:getHeight() / 2), destroyed = false, is_kleene = true, img = kleene.bulletImg})
            else
                table.insert(players[1].bullets, {x = players[1].x + (players[1].img:getWidth() / 2), y = players[1].y + (players[1].img:getHeight() / 2), destroyed = false, is_kleene = false, img = players[1].bulletImg})
            end

            players[1].canShoot = false
            players[1].canShootTimer = players[1].canShootTimerMax

            -- count bullets fired if counter reches max then set
            -- reload timer to max
            players[1].bulletCounter = players[1].bulletCounter + 1
            if players[1].bulletCounter >= players[1].maxBullets then
                players[1].reloadTimer = players[1].reloadTimerMax
                players[1].bulletCounter = 0
            end
        end
    end

    if love.keyboard.isDown("rshift") and players[2].canShoot and not (players[2].hit and not players[2].has_kleene) then
        if players[2].reloadTimer <= 0 then
            if players[2].has_kleene then
                table.insert(players[2].bullets, {x = players[2].x + (players[2].img:getWidth() / 2), y = players[2].y + (players[2].img:getHeight() / 2), destroyed = false, is_kleene = true, img = kleene.bulletImg})
            else
                table.insert(players[2].bullets, {x = players[2].x + (players[2].img:getWidth() / 2), y = players[2].y + (players[2].img:getHeight() / 2), destroyed = false, is_kleene = false, img = players[2].bulletImg})
            end

            players[2].canShoot = false
            players[2].canShootTimer = players[2].canShootTimerMax

            players[2].bulletCounter = players[2].bulletCounter + 1
            if players[2].bulletCounter >= players[2].maxBullets then
                players[2].reloadTimer = players[2].reloadTimerMax
                players[2].bulletCounter = 0
            end
        end
    end

    -- controlling player one

    local moving = false

    if love.keyboard.isDown("a") then
        if players[1].x > 0 then
            players[1].x = players[1].x - (players[1].speed * dt)
        else
            players[1].x = 0
        end

        moving = true
    elseif love.keyboard.isDown("d") then
        if players[1].x < (love.graphics:getWidth() / 2) - players[1].img:getWidth() then
            players[1].x = players[1].x + (players[1].speed * dt)
        else
            players[1].x = (love.graphics:getWidth() / 2) - players[1].img:getWidth()
        end

        moving = true
    end

    if love.keyboard.isDown("w") then
        if players[1].y > 0 then
            players[1].y = players[1].y - (players[1].speed * dt)
        else
            players[1].y = 0
        end

        moving = true
    elseif love.keyboard.isDown("s") then
        if players[1].y < love.graphics:getHeight() - players[1].img:getHeight() then
            players[1].y = players[1].y + (players[1].speed * dt)
        else
            players[1].y = love.graphics:getHeight() - players[1].img:getHeight()
        end

        moving = true
    end

    if moving then
        players[1].anim:update(dt)
    end

    moving = false

    -- controlling player two

    if love.keyboard.isDown("left") then
        if players[2].x > love.graphics:getWidth() / 2 then
            players[2].x = players[2].x - (players[2].speed * dt)
        else
            players[2].x = love.graphics:getWidth() / 2
        end

        moving = true
    elseif love.keyboard.isDown("right") then
        if players[2].x < love.graphics:getWidth() - players[2].img:getWidth() then
            players[2].x = players[2].x + (players[2].speed * dt)
        else
            players[2].x = love.graphics:getWidth() - players[2].img:getWidth()
        end

        moving = true
    end

    if love.keyboard.isDown("up") then
        if players[2].y > 0 then
            players[2].y = players[2].y - (players[2].speed * dt)
        else
            players[2].y = 0
        end

        moving = true
    elseif love.keyboard.isDown("down") then
        if players[2].y < love.graphics:getHeight() - players[2].img:getHeight() then
            players[2].y = players[2].y + (players[2].speed * dt)
        else
            players[2].y = love.graphics:getHeight() - players[2].img:getHeight()
        end

        moving = true
    end

    if moving then
        players[2].anim:update(dt)
    end
end

function check_bullet_collisions(dt)
    -- check if bullets collide
    -- if bullet is a kleene star then it won't collide with anything
    -- hitting the target directly

    for i, bullet_one in ipairs (players[1].bullets) do
        for j, bullet_two in ipairs(players[2].bullets) do
            if check_collision(bullet_one.x,bullet_one.y,bullet_one.img:getWidth(),bullet_one.img:getHeight(),
                               bullet_two.x,bullet_two.y,bullet_two.img:getWidth(),bullet_two.img:getHeight()) and
               not (bullet_one.destroyed and bullet_two.destroyed) then

                bullet_collision.collided = true
                bullet_collision.hitTimer = bullet_collision.hitTimerMax

                bullet_collision.x = bullet_one.x
                bullet_collision.y = bullet_one.y

                if not bullet_one.is_kleene then
                    bullet_one.destroyed = true
                end

                if not bullet_two.is_kleene then
                    bullet_two.destroyed = true
                end
            end
        end
    end

    -- check if bullets from player one hits player two

    for i, bullet in ipairs(players[1].bullets) do
        bullet.x = bullet.x + (players[1].bullets_speed * dt)

        if check_collision(players[2].x + players[2].shapes.body_x,
                           players[2].y + players[2].shapes.body_y,
                           players[2].img:getWidth() + players[2].shapes.body_img_width,
                           players[2].img:getHeight() + players[2].shapes.body_img_height,
                           bullet.x, bullet.y, bullet.img:getWidth(), bullet.img:getHeight()) and not bullet.destroyed then

            bullet.destroyed = true

            players[2].hit = true
            players[2].hitTimer = players[2].hitTimerMax

            score_value = 1
            if players[1].has_kleene then
                score_value = 2
            end

            change_score(players[2], -score_value)
            change_score(players[1], score_value)
        end

        if bullet.x > love.graphics:getWidth() then
            bullet.destroyed = true
        end
    end

    -- check if bullets from player two hits player one

    for i, bullet in ipairs(players[2].bullets) do
        bullet.x = bullet.x - (players[2].bullets_speed * dt)

        if check_collision(players[1].x + players[1].shapes.body_x,
                           players[1].y + players[1].shapes.body_y,
                           players[1].img:getWidth() + players[1].shapes.body_img_width,
                           players[1].img:getHeight() + players[1].shapes.body_img_height,
                           bullet.x, bullet.y, bullet.img:getWidth(), bullet.img:getHeight()) and not bullet.destroyed then

            bullet.destroyed = true

            players[1].hit = true
            players[1].hitTimer = players[1].hitTimerMax

            score_value = 1
            if players[2].has_kleene then
                score_value = 2
            end

            change_score(players[1], -score_value)
            change_score(players[2], score_value)
        end

        if bullet.x + bullet.img:getWidth() < 0 then
            bullet.destroyed = true
        end
    end

    -- remove all player's bullets marked as destroyed otherwise if
    -- put table.remove directly into the loops for collisions
    -- the animation would look glitchy

    for i, player in ipairs(players) do
        local j=1
        while j <= #player.bullets do
            if player.bullets[j].destroyed then
                table.remove(player.bullets, j)
            else
                j = j + 1
            end
        end
    end
end

function update_timers(dt)
    -- timer for background if a bomb exploded
    if bg.bombed then
        bg.bombedTimer = bg.bombedTimer - (1 * dt)

        if bg.bombedTimer <= 0 then
            bg.bombed = false
        end
    end

    -- timer for nuke when background is bombed

    if nuke.display then
        nuke.displayTimer = nuke.displayTimer - (1 * dt)

        if nuke.displayTimer <= 0 and nuke.alpha >= 0 then
            nuke.fadeOutTimer = nuke.fadeOutTimer - (1 * dt)
            nuke.alpha = nuke.alpha - (255/nuke.fadeOutTimerMax * dt)
        end

        -- if alpha channel of image is less than 0 than set image display to false
        if nuke.alpha < 0 then
            nuke.display = false
        end
    end

    -- update final banner timers

    if final_banner.display then
        final_banner.displayTimer = final_banner.displayTimer - (1 * dt)

        if final_banner.displayTimer <= 0 and final_banner.alpha >= 0 then
            final_banner.fadeOutTimer = final_banner.fadeOutTimer - (1 * dt)
            final_banner.alpha = final_banner.alpha - (255/final_banner.fadeOutTimerMax * dt)
        end

        if final_banner.alpha < 0 then
            final_banner.display = false
        end
    end

    -- timer for keyboard hints
    if keyboard_hints.display then
        if status.intro_skipped then
            keyboard_hints.alpha = -1
        end

        keyboard_hints.displayTimer = keyboard_hints.displayTimer - (1 * dt)

        if keyboard_hints.displayTimer <= 0 and keyboard_hints.alpha >= 0 then
            keyboard_hints.fadeOutTimer = keyboard_hints.fadeOutTimer - (1 * dt)
            keyboard_hints.alpha = keyboard_hints.alpha - (255/keyboard_hints.fadeOutTimerMax * dt)
        end

        if keyboard_hints.alpha < 0 then
            keyboard_hints.display = false
        end
    end

    -- timers for players
    for i, player in ipairs(players) do
        if player.reloadTimer > 0 then
            player.reloadTimer = player.reloadTimer - (1 * dt)
        end

        -- updating shoot timer
        player.canShootTimer = player.canShootTimer - (1 * dt)
        if player.canShootTimer < 0 then
            player.canShoot = true
        end

        -- updating hit timer
        if player.hit then
            player.hitTimer = player.hitTimer - (1 * dt)

            if player.hitTimer <= 0 then
                player.hit = false
            end
        end

        -- powered timer
        if player.powered then
            player.poweredTimer = player.poweredTimer - (1 * dt)

            if player.poweredTimer <= 0 then
                player.powered = false
            end
        end

        -- kleene power
        if player.has_kleene then
            player.kleeneTimer = player.kleeneTimer - (1 * dt)

            if player.kleeneTimer <= 0 then
                player.has_kleene = false
            end
        end
    end

    -- bullet collision timers
    if bullet_collision.collided then
        bullet_collision.hitTimer = bullet_collision.hitTimer - (1 * dt)

        if bullet_collision.hitTimer <= 0 then
            bullet_collision.collided = false
        end
    end
end

function change_score(p, value)
    -- if value is negative it has to be subtracted to the score
    -- otherwise we sum the value to the current score
    if value < 0 then
        value = value * -1
        if (p.score - value) >= p.min_score + 1 then
            p.score = p.score - value
        else
            p.score = p.min_score
        end
    else
        p.score = p.score + value
    end
end

function check_collision(x1,y1,w1,h1, x2,y2,w2,h2)
  return x1 < x2 + w2 and
         x2 < x1 + w1 and
         y1 < y2 + h2 and
         y2 < y1 + h1
end
