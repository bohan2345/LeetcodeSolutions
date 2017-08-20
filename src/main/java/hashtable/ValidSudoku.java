package hashtable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
 * <p>
 * The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
 * Note:
 * A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.
 * <p>
 * Created by Bohan Zheng on 3/6/16.
 *
 * @author Bohan Zheng
 */
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> rowMap = buildMap();
        Map<Integer, Set<Character>> columnMap = buildMap();
        Map<Integer, Set<Character>> boxMap = buildMap();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c == '.') {
                    continue;
                }
                if (rowMap.get(i).contains(c)) {
                    return false;
                } else {
                    rowMap.get(i).add(c);
                }
                if (columnMap.get(j).contains(c)) {
                    return false;
                } else {
                    columnMap.get(j).add(c);
                }
                if (boxMap.get((i / 3) * 3 + j / 3).contains(c)) {
                    return false;
                } else {
                    boxMap.get((i / 3) * 3 + j / 3).add(c);
                }
            }
        }
        return true;
    }

    private Map<Integer, Set<Character>> buildMap() {
        Map<Integer, Set<Character>> map = new HashMap<>(9);
        for (int i = 0; i < 9; i++) {
            map.put(i, new HashSet<>());
        }
        return map;
    }
}
