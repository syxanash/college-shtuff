function loader()
    love.mouse.setVisible(false)
    love.window.setIcon(love.image.newImageData("assets/icon/icon.png"))

    -- set the max score available for the game
    max_score = 100
    -- set the score to reach in order to spawn first boss
    score_to_boss = 40

    keyboard_loader()
    background_loader()
    players_loader()
    bullets_loader()
    finalbanner_loader()

    -- load objects
    chomsky_loader()
    powerups_loader()
    bombs_loader()
    savescore_loader()
    kleenepower_loader()

    font = {
        game = love.graphics.newFont("assets/font/emulogic.ttf", 17),
        ammo = love.graphics.newFont("assets/font/04b.TTF", 30)
    }

    love.graphics.setFont(font.game)

    set_soundtrack()
end

function set_soundtrack()
    songs = {
        "VFever.mp3", "letitrun.mp3"
    }
    song = songs[love.math.random( #songs )]

    soundtrack = love.audio.newSource("assets/music/" .. song, "stream")
    soundtrack:setLooping(true)
    soundtrack:play()

    -- load final soundtrack to play when someone wins

    final_soundtrack = love.audio.newSource("assets/music/sanAndreas.mp3", "stream")
    final_soundtrack:setLooping(false)
end

function chomsky_loader()
    chomsky = {
        x = 0, y = 0, img = love.graphics.newImage("assets/chomsky.png"),
        bulletImg = love.graphics.newImage("assets/chomsky_bullet.png"),
        speed = 400,

        canShoot = true,
        canShootTimerMax = 0.23,
        canShootTimer = 0,

        bullet_direction = true,
        bullets_speed = 450,
        bullets = {},

        hit = false,
        hitTimerMax = 0.45,
        hitTimer = 0,

        life = 40,

        target = 0,
        spawned = false,
        defeated = false
    }

    -- setting initial values for chomsky
    chomsky.hitTimer = chomsky.hitTimerMax
    chomsky.canShootTimer = chomsky.canShootTimerMax
    chomsky.x = (love.graphics:getWidth() / 2) - (chomsky.img:getWidth() / 2)
    chomsky.y = -chomsky.img:getHeight()

    chomsky.target = love.math.random(0, love.graphics:getHeight() - chomsky.img:getHeight())
end

function kleenepower_loader()
    kleene = {
        x = 0, y = 0, img = love.graphics.newImage("assets/kleene_star.png"),
        bulletImg = love.graphics.newImage("assets/kleene_bullet.png"),
        speed = 300,

        -- sin function stuff
        counter = 0,
        sin_freq = 3,
        sin_ampl = 5,
        sin_sign = 0,

        spawn_timer = 0,
        freq_min = 60,
        freq_max = 120,
    }

    -- set initial values for kleene star
    kleene.spawn_timer = love.math.random(kleene.freq_min, kleene.freq_max)
    kleene.x = (love.graphics:getWidth() / 2) - (kleene.img:getWidth() / 2)
    kleene.y = -kleene.img:getHeight()
    kleene.sin_sign = love.math.random(0, 1) == 0 and 1 or -1
end

function bombs_loader()
    bombs = {
        {
            x = 0, y = 0, img = love.graphics.newImage("assets/forkbomb.png"),
            speed = 200,
            is_nuke = false,

            value = -5,

            spawn_timer = 0,
            freq_min = 5,
            freq_max = 10
        },

        {
            x = 0, y = 0, img = love.graphics.newImage("assets/stato_pozzo.png"),
            speed = 250,
            is_nuke = false,

            value = -10,

            spawn_timer = 0,
            freq_min = 10,
            freq_max = 20
        },

        -- nuke items hit both players if someone touch them
        {
            x = 0, y = 0, img = love.graphics.newImage("assets/y2k.png"),
            speed = 350,
            is_nuke = true,

            value = -10,

            spawn_timer = 0,
            freq_min = 75,
            freq_max = 90
        },

        {
            x = 0, y = 0, img = love.graphics.newImage("assets/shellshock.png"),
            speed = 400,
            is_nuke = true,

            value = -20,

            spawn_timer = 0,
            freq_min = 90,
            freq_max = 120
        },

        -- kinda of an easter egg :D

        {
            x = 0, y = 0, img = love.graphics.newImage("assets/oreo.png"),
            speed = 500,
            is_nuke = false,

            value = 50,

            spawn_timer = 0,
            freq_min = 1200,
            freq_max = 1800
        }
    }

    -- initial values for bombs
    for i, bomb in ipairs(bombs) do
        bomb.x = (love.graphics:getWidth() / 2) - (bomb.img:getWidth() / 2)
        bomb.y = -bomb.img:getHeight()

        bomb.spawn_timer = love.math.random(bomb.freq_min, bomb.freq_max)
    end
end

function savescore_loader()
    savescore = {
        x = 0, y = 0, img = love.graphics.newImage("assets/disk.png"),
        speed = 250,

        -- indicate the percentage of the player score to subtract
        perc_to_sub = 20,

        -- sin function stuff
        counter = 0,
        sin_freq = 3,
        sin_ampl = 6,
        sin_sign = 0,

        spawn_timer = 0,
        freq_min = 50,
        freq_max = 60,
    }

    -- set initial values for savescore
    savescore.spawn_timer = love.math.random(savescore.freq_min, savescore.freq_max)
    savescore.x = (love.graphics:getWidth() / 2) - (savescore.img:getWidth() / 2)
    savescore.y = -savescore.img:getHeight()
    savescore.sin_sign = love.math.random(0, 1) == 0 and 1 or -1
end

function finalbanner_loader()
    -- loading hint for keyboard usage
    final_banner = {
        x = 0, y = 0, img = love.graphics.newImage("assets/final_banner.png"),
        alpha = 255,

        display = false,
        displayTimerMax = 5,
        displayTimer = 0,

        fadeOutTimerMax = 2,
        fadeOutTimer = 0,
    }

    final_banner.x = (love.graphics:getWidth() / 2) - (final_banner.img:getWidth() / 2)
    final_banner.y = (love.graphics:getHeight() / 2) - (final_banner.img:getHeight() / 2)
end

function keyboard_loader()
    -- loading hint for keyboard usage
    keyboard_hints = {
        x = 0, y = 0, img = love.graphics.newImage("assets/keyboard.png"),
        alpha = 255,

        display = true,
        displayTimerMax = 5,
        displayTimer = 0,

        fadeOutTimerMax = 2,
        fadeOutTimer = 0,
    }

    keyboard_hints.displayTimer = keyboard_hints.displayTimerMax
    keyboard_hints.fadeOutTimer = keyboard_hints.fadeOutTimerMax

    keyboard_hints.x = (love.graphics:getWidth() / 2) - (keyboard_hints.img:getWidth() / 2)
    keyboard_hints.y = (love.graphics:getHeight() / 2) - (keyboard_hints.img:getHeight() / 2)
end

function powerups_loader()
    powerups = {
        {
            x = 0, y = 0, img = love.graphics.newImage("assets/pumping_lemma.png"),

            value = 5,

            spawn_timer_max = 2.5,
            spawn_timer = 0,
            spawned = false,

            sec_to_spawn = 0,
            freq_min = 5,
            freq_max = 10
        },

        {
            x = 0, y = 0, img = love.graphics.newImage("assets/turing-award.png"),

            value = 20,

            spawn_timer_max = 2,
            spawn_timer = 0,
            spawned = false,

            sec_to_spawn = 0,
            freq_min = 50,
            freq_max = 60
        },

        {
            x = 0, y = 0, img = love.graphics.newImage("assets/sugar.png"),

            value = 10,

            spawn_timer_max = 3,
            spawn_timer = 0,
            spawned = false,

            sec_to_spawn = 0,
            freq_min = 10,
            freq_max = 20
        }
    }

    -- initial settings for powerups
    for i, power in ipairs(powerups) do
        power.x = (love.graphics:getWidth() / 2) - (power.img:getWidth() / 2)
        power.y = love.math.random(0, love.graphics:getHeight() - power.img:getHeight() - 50)

        power.sec_to_spawn = love.math.random(power.freq_min, power.freq_max)
        power.spawn_timer = power.spawn_timer_max
    end
end

function bullets_loader()
    bullet_collision = {
        x = 0, y = 0, img = love.graphics.newImage("assets/explosion.png"),

        collided = false,
        hitTimerMax = 0.2,
        hitTimer = 0
    }

    bullet_collision.hitTimer = bullet_collision.hitTimerMax
end

function background_loader()
    danger_tape_img = love.graphics.newImage("assets/danger-tape.png")

    -- paused object is used when player sets paused state
    paused_object = {
        x = 0, y = 0, img = love.graphics.newImage("assets/paused.png")
    }
    -- set paused object on the center of the screen
    paused_object.x = (love.graphics:getWidth() / 2) - (paused_object.img:getWidth() / 2)
    paused_object.y = (love.graphics:getHeight() / 2) - (paused_object.img:getHeight() / 2)

    -- mute object will appear when user stops playing soundtrack
    mute_object = {
        x = 0, y = 0, img = love.graphics.newImage("assets/mute.png")
    }
    -- set the object on the left down corner
    mute_object.x = 20
    mute_object.y = love.graphics:getHeight() - mute_object.img:getHeight() - 20

    -- nuke is displayed when a user hits a bomb
    nuke = {
        x = 0, y = 0, img = love.graphics.newImage("assets/nuke.png"),
        alpha = 255,

        display = false,
        displayTimerMax = 2,
        displayTimer = 0,

        fadeOutTimerMax = 2,
        fadeOutTimer = 0,
    }

    -- set initial values for nuke exploision
    nuke.fadeOutTimer = nuke.fadeOutTimerMax
    nuke.displayTimer = nuke.displayTimerMax
    nuke.x = (love.graphics:getWidth() / 2) - (nuke.img:getWidth() / 2)
    nuke.y = (love.graphics:getHeight() / 2) - (nuke.img:getHeight() / 2)

    bg = {
        x = 0, y = 0, img = love.graphics.newImage("assets/bg.jpg"),

        bombed = false,
        bombedTimerMax = 0,
        bombedTimer = 0
    }

    -- se the bombed timer max as the sum of the fadeouttimer and displaytimer of nuke image
    bg.bombedTimerMax = nuke.displayTimerMax + nuke.fadeOutTimerMax
    bg.bombedTimer = bg.bombedTimerMax
end

function players_loader()
    player_hit_img = love.graphics.newImage("assets/blood.png")
    player_won_img = love.graphics.newImage("assets/alan-turing.png")

    -- power shape is used for when checking for
    -- collisions with power ups, body instead is used
    -- when checking collisions with bullets

    players = {
        {
            name = "Nick",
            x = 0, y = 0, speed = 350,
            img = love.graphics.newImage("assets/nick.png"),
            anim = newAnimation(love.graphics.newImage("assets/nick_anim.png"), 156, 264, 0.15, 0),

            shapes = {
                arm_x = 0,
                arm_y = 97,
                arm_img_width = 0,
                arm_img_height = -240,

                body_x = 0,
                body_y = 0,
                body_img_width = -82,
                body_img_height = 0
            },

            has_kleene = false,
            kleeneTimerMax = 7,
            kleeneTimer = 0,

            maxBullets = 15,
            bulletCounter = 0,
            reloadTimerMax = 1,
            reloadTimer = 0,

            canShoot = true,
            canShootTimerMax = 0.24,
            canShootTimer = 0,

            bulletImg = love.graphics.newImage("assets/epsilon.png"),

            hit = false,
            hitTimerMax = 0.45,
            hitTimer = 0,

            powerImg = love.graphics.newImage("assets/nick_power.png"),
            downImg = love.graphics.newImage("assets/nick_down.png"),
            bodyStateImg = "",

            powered = false,
            poweredTimerMax = 1.5,
            poweredTimer = 0,

            won = false,
            score = 0,
            min_score = 0,

            bullets = {},
            bullets_speed = 470
        },

        {
            name = "Johnny",
            x = 0, y = 0, speed = 350,
            img = love.graphics.newImage("assets/johnny.png"),
            anim = newAnimation(love.graphics.newImage("assets/johnny_anim.png"), 156, 260, 0.15, 0),

            shapes = {
                arm_x = 0,
                arm_y = 90,
                arm_img_width = 0,
                arm_img_height = -235,

                body_x = 82,
                body_y = 0,
                body_img_width = -82,
                body_img_height = 0
            },

            has_kleene = false,
            kleeneTimerMax = 7,
            kleeneTimer = 0,

            maxBullets = 15,
            bulletCounter = 0,
            reloadTimerMax = 1,
            reloadTimer = 0,

            canShoot = true,
            canShootTimerMax = 0.24,
            canShootTimer = 0,

            bulletImg = love.graphics.newImage("assets/lambda.png"),

            hit = false,
            hitTimerMax = 0.45,
            hitTimer = 0,

            powerImg = love.graphics.newImage("assets/johnny_power.png"),
            downImg = love.graphics.newImage("assets/johnny_down.png"),
            bodyStateImg = "",

            powered = false,
            poweredTimerMax = 1.5,
            poweredTimer = 0,

            won = false,
            score = 0,
            min_score = 0,

            bullets = {},
            bullets_speed = 470
        }
    }

    -- resetting hit timers, shoot and powerup timers for both players

    for i, player in ipairs(players) do
        player.anim:setMode("loop")
        player.poweredTimer = player.poweredTimerMax
        player.hitTimer = player.hitTimerMax
        player.canShootTimer = player.canShootTimerMax
    end

    -- set initial positions for each player

    players[1].x = 10
    players[1].y = (love.graphics:getHeight() / 2) - (players[1].img:getHeight() / 2)

    players[2].x = love.graphics:getWidth() - 10 - players[2].img:getWidth()
    players[2].y = (love.graphics:getHeight() / 2) - (players[2].img:getHeight() / 2)
end
