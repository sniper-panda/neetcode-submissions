class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        # Validate Rows
        for row in range(9):
            row_set = set()
            for col in range(9):
                if board[row][col] == '.':
                    continue

                if board[row][col] in row_set:
                    return False

                row_set.add(board[row][col])

        # Validate Columns
        for col in range(9):
            col_set = set()
            for row in range(9):
                if board[row][col] == '.':
                    continue

                if board[row][col] in col_set:
                    return False

                col_set.add(board[row][col])

        # Validate 3x3 Boxes
        for sr in range(0, 9, 3):
            er = sr + 2
            for sc in range(0, 9, 3):
                ec = sc + 2
                if not self.validBox(board, sr, er, sc, ec):
                    return False

        return True

    def validBox(self, board, sr, er, sc, ec):
        box_set = set()

        for row in range(sr, er + 1):
            for col in range(sc, ec + 1):
                if board[row][col] == '.':
                    continue

                if board[row][col] in box_set:
                    return False

                box_set.add(board[row][col])

        return True