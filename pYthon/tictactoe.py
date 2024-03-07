import numpy as np
import random


def main():
    global TRACK, ARRAY_2D
    ARRAY_2D = [[0, 0, 0] for i in range(3)]
    TRACK = []

    while True:
        player_coordinates, ai_coordinates = get_coordinates()
        update_2d_array(player_coordinates, ai_coordinates)
        converted_list = convert_symbol(ARRAY_2D)
        display_gameboard(converted_list)

        win_list = get_win_possibilities()
        print(f"Track list:{TRACK}")
        win = check_win(win_list)

        if len(win):
            if win[0] == 1:
                print("Player wins.")
                break

            elif win[1] == 1:
                print("The bot wins.")
                break

        elif len(TRACK) >= 9:
            print("Draw.")
            break


def get_coordinates():
    while True:
        player_input = input("Row,Column: ").strip().split(",")
        player_coordinates = [int(i) - 1 for i in player_input]

        if player_coordinates not in TRACK:
            TRACK.append(player_coordinates)
            break

        elif player_coordinates in TRACK:
            print("That coordinate is already exist, please choose another one.")

    while True:

        ai_coordinates = []

        ai_x = random.randint(0, 2)
        ai_y = random.randint(0, 2)
        if len(TRACK) < 9:
            ai_coordinates.append(ai_x)
            ai_coordinates.append(ai_y)

        if ai_coordinates not in TRACK:
            TRACK.append(ai_coordinates)
            break

    return player_coordinates, ai_coordinates


def update_2d_array(player_coordinates, ai_coordinates):
    player_x = player_coordinates[0]
    player_y = player_coordinates[1]

    ARRAY_2D[player_x][player_y] = 1

    if len(ai_coordinates):
        ai_x = ai_coordinates[0]
        ai_y = ai_coordinates[1]

        print(f"The bot placed an 'O' at {ai_x+1,ai_y+1}.")

        ARRAY_2D[ai_x][ai_y] = -1


def convert_symbol(array):

    converted_list = []

    for sublist in ARRAY_2D:
        converted_sublist = []
        for i in sublist:
            if i == 1:
                converted_sublist.append("X")
            elif i == -1:
                converted_sublist.append("O")
            else:
                converted_sublist.append(" ")
        converted_list.append(converted_sublist)

    return converted_list


def display_gameboard(converted_list):

    vertical_line = " ---"
    for list in converted_list:
        print(vertical_line * 3)
        print(f"| {list[0]} | {list[1]} | {list[2]} |")
    print(vertical_line * 3)


def get_win_possibilities():
    matrix = np.array(ARRAY_2D)
    winning_possibilities = []

    transposed_matrix = matrix.transpose()

    for row in matrix.tolist():
        winning_possibilities.append(row)

    for row in transposed_matrix.tolist():
        winning_possibilities.append(row)

    main_diagonal = matrix.diagonal().tolist()
    winning_possibilities.append(main_diagonal)

    sub_diagonal = np.fliplr(matrix).diagonal().tolist()
    winning_possibilities.append(sub_diagonal)

    return winning_possibilities


def check_win(win_list):
    win = []
    for li in win_list:
        if li.count(1) == 3:
            win = [1, 0]

        elif li.count(-1) == 3:
            win = [0, 1]

    print(f"win list: {win}")
    return win


if __name__ == "__main__":
    main()
