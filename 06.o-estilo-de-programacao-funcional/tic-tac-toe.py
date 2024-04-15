def create_board():
    return [["_" for _ in range(3)] for _ in range(3)]

def get_indexes(move):
    return list(map(lambda x: int(x) % 10, move))

def in_range(num, start, end):
    return start <= num <= end

def is_numeric(move):
    return all(map(lambda x: x.isdigit(), move))

def get_columns(board):
    return list(map(list, zip(*board)))

def get_primary_diagonal(board):
    return [board[i][i] for i in range(3)]

def get_secondary_diagonal(board):
    return [board[i][3 - i - 1] for i in range(3)]

def get_all_victory_possibilities(board):
    return board + get_columns(board) + [get_primary_diagonal(board), get_secondary_diagonal(board)]

def victory(possibility, last_player):
    return all(elem == last_player for elem in possibility)

def is_board_full(board):
    return all(elem != "_" for row in board for elem in row)

def get_elem(board, indexes):
    return board[indexes[0]][indexes[1]]

def show_board(board):
    for i, row in enumerate(board):
        print(" " + " | ".join(row))
        if i < 2:
            print("---|---|---")

def get_input(message):
    move = input(message)
    return str(int(move[0]) - 1) + str(int(move[1]) - 1)

def is_valid_move(board, indexes):
    return all(in_range(num, 0, 2) for num in indexes) and board[indexes[0]][indexes[1]] == "_"

def validate_input(input):
    return len(input) == 2 and is_numeric(input)

def make_move(board, player, move):
    new_board = [row[:] for row in board]
    new_board[move[0]][move[1]] = player
    return new_board

def winner(board, player):
    victory_possibilities = get_all_victory_possibilities(board)
    return any(victory(possibility, player) for possibility in victory_possibilities)

def choose_next_player(current_player):
    return "O" if current_player == "X" else "X"

def choose_next_board(victory, is_draw, new_board):
    return create_board() if victory or is_draw else new_board

def update_scores(victory, is_draw, scores, player):
    if victory:
        scores[player] += 1
    elif is_draw:
        scores["Draw"] += 1
    return scores

def wanna_play(victory, is_draw):
    if victory or is_draw:
        return input("Wanna play another game? (y/n)\n").lower() == "y"
    return True

def print_scores(scores):
    print("--- Scores ---")
    for player, score in scores.items():
        print(f"{player}: {score}")
    print("--------------")

def main():
    board = create_board()
    player = "X"
    scores = {"X": 0, "O": 0, "Draw": 0}
    playing = True

    while playing:
        show_board(board)
        move = get_input(f"\nMove for player {player}: ")
        if validate_input(move):
            indexes = get_indexes(move)
            if is_valid_move(board, indexes):
                new_board = make_move(board, player, indexes)
                victory_status = winner(new_board, player)
                is_draw = (not victory_status) and (is_board_full(new_board))
                next_player = choose_next_player(player)
                board = choose_next_board(victory_status, is_draw, new_board)
                scores = update_scores(victory_status, is_draw, scores, player)
                if victory_status:
                    show_board(new_board)
                    print(f"\nPlayer {player} is the winner")
                elif is_draw:
                    show_board(new_board)
                    print("\nNo one wins")
                playing = wanna_play(victory_status, is_draw)
                player = next_player
            else:
                print("Invalid move")
        else:
            print("Invalid input")
    
    print_scores(scores)

main()
