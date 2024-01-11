import random
import pygame
from pygame.constants import QUIT, K_DOWN, K_UP, K_RIGHT, K_LEFT

pygame.init()

FPS = pygame.time.Clock()
FONT = pygame.font.SysFont('Arial', 24)
HEIGHT = 800
WIDTH = 1200
COLOR_BLACK = (0, 0, 0)

main_display = pygame.display.set_mode((WIDTH, HEIGHT))
score = 0
playing = True

bg = pygame.transform.scale(pygame.image.load('images/background.png'), (WIDTH, HEIGHT))
bg_1 = 0
bg_2 = bg.get_width()
bg_move = 3

def create_player():
    player_size = (60, 60)
    player = pygame.transform.scale(pygame.image.load('images/player.png').convert_alpha(), player_size)
    player_rect = pygame.Rect(WIDTH/10, HEIGHT/2, *player_size)
    player_move_vertical = [0, 5]
    player_move_horizontal = [5, 0]
    return player, player_rect, player_move_vertical, player_move_horizontal

def update_player(player_rect, player_move_vertical, player_move_horizontal):
    keys = pygame.key.get_pressed()
    if keys[K_DOWN] and player_rect.bottom < HEIGHT:
        player_rect.move_ip(*player_move_vertical)
    if keys[K_UP] and player_rect.top > 0:
        player_rect.move_ip(player_move_vertical[0], -player_move_vertical[1])
    if keys[K_RIGHT] and player_rect.right < WIDTH:
        player_rect.move_ip(*player_move_horizontal)
    if keys[K_LEFT] and player_rect.left > 0:
        player_rect.move_ip(-player_move_horizontal[0], player_move_horizontal[1])
    return player_rect

def create_enemy():
    enemy_size = (75, 75)
    enemy = pygame.transform.scale(pygame.image.load('images/enemy.png').convert_alpha(), enemy_size)
    enemy_rect = pygame.Rect(WIDTH, random.randint(0, HEIGHT), *enemy_size)
    enemy_move = [random.randint(-9, -5), 0]
    return [enemy, enemy_rect, enemy_move]

def create_bonus():
    bonus_size = (75, 75)
    bonus = pygame.transform.scale(pygame.image.load('images/bonus.png').convert_alpha(), bonus_size)
    bonus_rect = pygame.Rect(random.randint(0, WIDTH), 0, *bonus_size)
    bonus_move = [0, random.randint(5, 9)]
    return [bonus, bonus_rect, bonus_move]

player, player_rect, player_move_vertical, player_move_horizontal = create_player()
CREATE_ENEMY = pygame.USEREVENT + 1
CREATE_BONUS = pygame.USEREVENT + 2

pygame.time.set_timer(CREATE_ENEMY, 1200)
pygame.time.set_timer(CREATE_BONUS, 2400)

enemies = []
bonuses = []

while playing:
    FPS.tick(60)
    for event in pygame.event.get():
        if event.type == QUIT:
            playing = False
        if event.type == CREATE_ENEMY:
            enemies.append(create_enemy())
        if event.type == CREATE_BONUS:
            bonuses.append(create_bonus())

    bg_1 -= bg_move
    bg_2 -= bg_move
    if bg_1 < -bg.get_width():
        bg_1 = bg.get_width()
    if bg_2 < -bg.get_width():
        bg_2 = bg.get_width()

    main_display.blit(bg, (bg_1, 0))
    main_display.blit(bg, (bg_2, 0))

    main_display.blit(FONT.render(str(score), True, COLOR_BLACK), (WIDTH - 50, 20))

    player_rect = update_player(player_rect, player_move_vertical, player_move_horizontal)
    main_display.blit(player, player_rect)

    for enemy in enemies:
        enemy[1] = enemy[1].move(enemy[2])
        main_display.blit(enemy[0], enemy[1])
        if player_rect.colliderect(enemy[1]):
            playing = False
    for bonus in bonuses:
        bonus[1] = bonus[1].move(bonus[2])
        main_display.blit(bonus[0], bonus[1])
        if player_rect.colliderect(bonus[1]):
            bonuses.pop(bonuses.index(bonus))
            score += 1

    for enemy in enemies:
        if enemy[1].left < 0:
            enemies.pop(enemies.index(enemy))
    for bonus in bonuses:
        if bonus[1].bottom > HEIGHT:
            bonuses.pop(bonuses.index(bonus))

    pygame.display.flip()
