function object_checker(dt)
    check_powerups(dt)
    check_bombs(dt)
    check_savescore(dt)
    check_kleenepower(dt)
end

function check_kleenepower(dt)
    if kleene.spawn_timer <= 0 then
        -- move object on the screen with cosin function
        kleene.counter = kleene.counter + (1 * dt)
        kleene.x = kleene.x + (math.cos(kleene.counter * kleene.sin_freq) * kleene.sin_ampl) * kleene.sin_sign
        kleene.y = kleene.y + (kleene.speed * dt)

        local touched_player = 0

        for j, player in ipairs(players) do
            if check_collision(kleene.x,kleene.y,kleene.img:getWidth(),kleene.img:getHeight(),
                               players[j].x + players[j].shapes.arm_x,
                               players[j].y + players[j].shapes.arm_y,
                               players[j].img:getWidth() + players[j].shapes.arm_img_width,
                               players[j].img:getHeight() + players[j].shapes.arm_img_height) then

                touched_player = j
            end
        end

        if touched_player > 0 or kleene.y > love.graphics:getHeight() then
            if touched_player > 0 then
                players[touched_player].has_kleene = true
                players[touched_player].kleeneTimer = players[touched_player].kleeneTimerMax

                players[touched_player].powered = true
                players[touched_player].bodyStateImg = players[touched_player].powerImg
                players[touched_player].poweredTimer = players[touched_player].poweredTimerMax
            end

            -- reset values for saving object
            kleene.spawn_timer = love.math.random(kleene.freq_min, kleene.freq_max)
            kleene.x = (love.graphics:getWidth() / 2) - (kleene.img:getWidth() / 2)
            kleene.y = -kleene.img:getHeight()
            kleene.sin_sign = love.math.random(0, 1) == 0 and 1 or -1
            kleene.counter = 0
        end
    else
        kleene.spawn_timer = kleene.spawn_timer - (1 * dt)
    end
end

function check_savescore(dt)
    if savescore.spawn_timer <= 0 then
        -- move object on the screen with cosin function
        savescore.counter = savescore.counter + (1 * dt)
        savescore.x = savescore.x + (math.cos(savescore.counter * savescore.sin_freq) * savescore.sin_ampl) * savescore.sin_sign
        savescore.y = savescore.y + (savescore.speed * dt)

        local touched_player = 0

        for j, player in ipairs(players) do
            if check_collision(savescore.x,savescore.y,savescore.img:getWidth(),savescore.img:getHeight(),
                               players[j].x + players[j].shapes.arm_x,
                               players[j].y + players[j].shapes.arm_y,
                               players[j].img:getWidth() + players[j].shapes.arm_img_width,
                               players[j].img:getHeight() + players[j].shapes.arm_img_height) then

                touched_player = j
            end
        end

        if touched_player > 0 or savescore.y > love.graphics:getHeight() then
            if touched_player > 0 then
                players[touched_player].powered = true
                players[touched_player].bodyStateImg = players[touched_player].powerImg
                players[touched_player].poweredTimer = players[touched_player].poweredTimerMax

                -- subtract the 20% of the current score of the player
                percentage = math.floor((savescore.perc_to_sub * players[touched_player].score) / 100)
                change_score(players[touched_player], -percentage)

                -- if a saving object has been touched by the player then
                -- store the current score as a minimum score
                -- this way if player is hit in the future the score won't go below that value
                players[touched_player].min_score = players[touched_player].score
            end

            -- reset values for saving object
            savescore.spawn_timer = love.math.random(savescore.freq_min, savescore.freq_max)
            savescore.x = (love.graphics:getWidth() / 2) - (savescore.img:getWidth() / 2)
            savescore.y = -savescore.img:getHeight()
            savescore.sin_sign = love.math.random(0, 1) == 0 and 1 or -1
            savescore.counter = 0
        end
    else
        savescore.spawn_timer = savescore.spawn_timer - (1 * dt)
    end
end

function check_bombs(dt)
    for i, bomb in ipairs(bombs) do
        if bomb.spawn_timer <= 0 then
            local touched_player = 0

            bomb.y = bomb.y + (bomb.speed * dt)

            for j, player in ipairs(players) do
                if check_collision(bomb.x,bomb.y,bomb.img:getWidth(),bomb.img:getHeight(),
                                   players[j].x + players[j].shapes.arm_x,
                                   players[j].y + players[j].shapes.arm_y,
                                   players[j].img:getWidth() + players[j].shapes.arm_img_width,
                                   players[j].img:getHeight() + players[j].shapes.arm_img_height) then

                    touched_player = j
                end
            end

            if touched_player > 0 or bomb.y > love.graphics:getHeight() then
                -- if someone touched a nuke then make background
                -- bombed and change the score to both players
                if touched_player > 0 and bomb.is_nuke then
                    bg.bombed = true
                    bg.bombedTimer = bg.bombedTimerMax

                    -- also display nuke explosion when bg is bombed
                    nuke.display = true
                    nuke.fadeOutTimer = nuke.fadeOutTimerMax
                    nuke.displayTimer = nuke.displayTimerMax
                    nuke.alpha = 255

                    for k, player in ipairs(players) do
                        change_score(players[k], bomb.value)
                        players[k].powered = true
                        players[k].bodyStateImg = players[k].downImg
                        players[k].poweredTimer = players[k].poweredTimerMax
                    end
                elseif touched_player > 0 then
                    change_score(players[touched_player], bomb.value)
                    players[touched_player].powered = true
                    players[touched_player].bodyStateImg = players[touched_player].downImg
                    players[touched_player].poweredTimer = players[touched_player].poweredTimerMax
                end

                -- reset values for bombs
                bomb.x = (love.graphics:getWidth() / 2) - (bomb.img:getWidth() / 2)
                bomb.y = -bomb.img:getHeight()

                bomb.spawn_timer = love.math.random(bomb.freq_min, bomb.freq_max)
            end
        else
            bomb.spawn_timer = bomb.spawn_timer - (1 * dt)
        end
    end
end

function check_powerups(dt)
    for i, power in ipairs(powerups) do
        local touched_player = 0

        if power.sec_to_spawn <= 0 then
            power.spawned = true
            power.spawn_timer = power.spawn_timer - (1 * dt)

            -- if powerup is still alive then check for collisions with players
            if power.spawn_timer > 0 then
                for j, player in ipairs(players) do
                    if check_collision(power.x,power.y,power.img:getWidth(),power.img:getHeight(),
                                       players[j].x + players[j].shapes.arm_x,
                                       players[j].y + players[j].shapes.arm_y,
                                       players[j].img:getWidth() + players[j].shapes.arm_img_width,
                                       players[j].img:getHeight() + players[j].shapes.arm_img_height) then

                        touched_player = j
                    end
                end
            end

            -- if powerup time to live is finished or got any power then
            -- remove the power
            if power.spawn_timer <= 0 or touched_player > 0 then
                if touched_player > 0 then
                    change_score(players[touched_player], power.value)
                    players[touched_player].powered = true
                    players[touched_player].bodyStateImg = players[touched_player].powerImg
                    players[touched_player].poweredTimer = players[touched_player].poweredTimerMax
                end

                -- put the powerup in a random position on y axis
                power.y = love.math.random(0, love.graphics:getHeight() - power.img:getHeight() - 50)
                power.spawned = false
                -- reset power timer
                power.spawn_timer = power.spawn_timer_max
                power.sec_to_spawn = love.math.random(power.freq_min, power.freq_max)
            end
        else
            power.sec_to_spawn = power.sec_to_spawn - (1 * dt)
        end
    end
end
