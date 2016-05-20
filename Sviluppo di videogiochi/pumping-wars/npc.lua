function npc_controller(dt)
    update_npc_timers(dt)
    npc_collisions(dt)
    npc_shooting(dt)
    move_npc(dt)

    if chomsky.life <= 0 then
        chomsky.spawned = false
        chomsky.defeated = true
    end
end

-- this function is used to adjust the bullet y axis in order to
-- follow the head of the player. This way is harder to destroy bullets
-- which follow the player vertical movement
function check_bullet_y(bullet, player, npc, dt)
    if bullet.y > player.y + (player.img:getHeight() / 2) then
        bullet.y = bullet.y - (npc.bullets_speed * dt)

        if bullet.y <= player.y + (player.img:getHeight() / 2) then
            bullet.y = player.y + (player.img:getHeight() / 2)
        end
    else
        bullet.y = bullet.y + (npc.bullets_speed * dt)

        if bullet.y >= player.y + (player.img:getHeight() / 2) then
            bullet.y = player.y + (player.img:getHeight() / 2)
        end
    end
end

function npc_collisions(dt)
    -- check npc bullets

    for i, bullet in ipairs(chomsky.bullets) do
        -- direction will indicate which version to shoot which can be
        -- right or left
        if bullet.right_direction then
            bullet.x = bullet.x + (chomsky.bullets_speed * dt)
            check_bullet_y(bullet, players[2], chomsky, dt)
        else
            bullet.x = bullet.x - (chomsky.bullets_speed * dt)
            check_bullet_y(bullet, players[1], chomsky, dt)
        end

        -- check collision for player 2 with npc bullets

        if check_collision(players[2].x + players[2].shapes.body_x,
                           players[2].y + players[2].shapes.body_y,
                           players[2].img:getWidth() + players[2].shapes.body_img_width,
                           players[2].img:getHeight() + players[2].shapes.body_img_height,
                           bullet.x, bullet.y, bullet.img:getWidth(), bullet.img:getHeight()) and not bullet.destroyed then

            bullet.destroyed = true

            players[2].hit = true
            players[2].hitTimer = players[2].hitTimerMax

            change_score(players[2], -2)
        end

        if bullet.x > love.graphics:getWidth() then
            bullet.destroyed = true
        end

        -- check collision for player 1 with npc bullets

        if check_collision(players[1].x + players[1].shapes.body_x,
                           players[1].y + players[1].shapes.body_y,
                           players[1].img:getWidth() + players[1].shapes.body_img_width,
                           players[1].img:getHeight() + players[1].shapes.body_img_height,
                           bullet.x, bullet.y, bullet.img:getWidth(), bullet.img:getHeight()) and not bullet.destroyed then

            bullet.destroyed = true

            players[1].hit = true
            players[1].hitTimer = players[1].hitTimerMax

            change_score(players[1], -2)
        end

        if bullet.x + bullet.img:getWidth() < 0 then
            bullet.destroyed = true
        end
    end

    -- check bullet collision among npc bullets and players

    for i, chomsky_bullet in ipairs(chomsky.bullets) do
        for j, player in ipairs(players) do
            for k, player_bullet in ipairs(player.bullets) do
                if check_collision(player_bullet.x,player_bullet.y,player_bullet.img:getWidth(),player_bullet.img:getHeight(),
                                   chomsky_bullet.x,chomsky_bullet.y,chomsky_bullet.img:getWidth(),chomsky_bullet.img:getHeight()) and
                   not (player_bullet.destroyed and chomsky_bullet.destroyed) then

                    bullet_collision.collided = true
                    bullet_collision.hitTimer = bullet_collision.hitTimerMax

                    bullet_collision.x = chomsky_bullet.x
                    bullet_collision.y = chomsky_bullet.y

                    if not player_bullet.is_kleene then
                        player_bullet.destroyed = true
                    end

                    chomsky_bullet.destroyed = true
                end
            end
        end
    end

    -- check if bullets from player one hits npc

    for i, bullet in ipairs(players[1].bullets) do
        if check_collision(chomsky.x, chomsky.y, chomsky.img:getWidth(), chomsky.img:getHeight(),
                           bullet.x, bullet.y, bullet.img:getWidth(), bullet.img:getHeight()) and not bullet.destroyed then

            bullet.destroyed = true

            chomsky.hit = true
            chomsky.hitTimer = chomsky.hitTimerMax

            score_value = 1
            if players[1].has_kleene then
                score_value = 2
            end

            chomsky.life = chomsky.life - score_value
            change_score(players[1], score_value)
        end

        if bullet.x > love.graphics:getWidth() then
            bullet.destroyed = true
        end
    end

    -- check if bullets from player two hits npc

    for i, bullet in ipairs(players[2].bullets) do
        if check_collision(chomsky.x, chomsky.y, chomsky.img:getWidth(), chomsky.img:getHeight(),
                           bullet.x, bullet.y, bullet.img:getWidth(), bullet.img:getHeight()) and not bullet.destroyed then

            bullet.destroyed = true

            chomsky.hit = true
            chomsky.hitTimer = chomsky.hitTimerMax

            score_value = 1
            if players[2].has_kleene then
                score_value = 2
            end

            chomsky.life = chomsky.life - score_value
            change_score(players[2], score_value)
        end

        if bullet.x + bullet.img:getWidth() < 0 then
            bullet.destroyed = true
        end
    end

    local j=1
    while j <= #chomsky.bullets do
        if chomsky.bullets[j].destroyed then
            table.remove(chomsky.bullets, j)
        else
            j = j + 1
        end
    end
end

function npc_shooting(dt)
    if chomsky.canShoot then
        table.insert(chomsky.bullets, {
            x = chomsky.x + (chomsky.img:getWidth() / 2),
            y = chomsky.y + (chomsky.img:getHeight() / 2),
            destroyed = false, right_direction = chomsky.bullet_direction,
            img = chomsky.bulletImg
        })

        chomsky.bullet_direction = not chomsky.bullet_direction
        chomsky.canShoot = false
        chomsky.canShootTimer = chomsky.canShootTimerMax
    end
end

function move_npc(dt)
    local target_reached = false

    if chomsky.y > chomsky.target then -- going up
        chomsky.y = chomsky.y - (chomsky.speed * dt)

        -- when changing position on y axis if target was overcome then
        -- target is reached

        if chomsky.y <= chomsky.target then
            target_reached = true
        end
    elseif chomsky.y < chomsky.target then -- going down
        chomsky.y = chomsky.y + (chomsky.speed * dt)

        if chomsky.y >= chomsky.target then
            target_reached = true
        end
    else
        target_reached = true
    end

    if target_reached then
        chomsky.target = love.math.random(0, love.graphics:getHeight() - chomsky.img:getHeight())
    end
end

function update_npc_timers(dt)
    -- updating shoot timer
    chomsky.canShootTimer = chomsky.canShootTimer - (1 * dt)
    if chomsky.canShootTimer < 0 then
        chomsky.canShoot = true
    end

    -- updating hit timer
    if chomsky.hit then
        chomsky.hitTimer = chomsky.hitTimer - (1 * dt)

        if chomsky.hitTimer <= 0 then
            chomsky.hit = false
        end
    end
end
