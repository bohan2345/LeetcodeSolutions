(function ($) {
    "use strict";

    function Tictactoe(player) {
        // 0 -> empty, 1 -> black, 2 -> white
        this.board = [[0, 0, 0], [0, 0, 0], [0, 0, 0]];
        this.currentPlayer = player;
    }

    Tictactoe.prototype = {
        /**
         * @param player: 0 -> black, 1 -> white
         * @param x
         * @param y
         */
        play: function (player, x, y) {
            this.board[x][y] = player + 1;

            if (!this.hasWinner(x, y)) {
                this.waitPlayer((player + 1) % 2);
            } else {
                this.end(player);
            }
        },
        waitPlayer: function (player) {
            clearInterval(this.interval);
            this.currentPlayer = player == 0 ? "black" : "red";
            this.interval = setInterval((function (self) {
                return function () {
                    self.waitPlayer((player + 1) % 2)
                };
            })(this), 10000);
        },
        hasWinner: function (x, y) {
            var val = this.board[x][y];
            var a = true;
            var b = true;
            for (var i = 0; i < 3; i++) {
                if (this.board[x][i] !== val) {
                    a = false;
                }
                if (this.board[i][y] !== val) {
                    b = false;
                }
            }
            if (x === y || x + y === 2) {
                var c = true;
                var d = true;
                for (var i = 0; i < 3; i++) {
                    if (this.board[i][i] !== val) {
                        c = false;
                    }
                    if (this.board[i][2 - i] !== val) {
                        d = false;
                    }
                }
            }
            return a || b || c || d;
        },
        end: function (player) {
            alert(player == 0 ? "black win" : "white win");
        }
    };

    window.onload = function () {
        var tictactoe = new Tictactoe("black");

        function placePiece(target) {
            var p = tictactoe.currentPlayer;
            $(target).css("background-color", p);
            var x = $(target).data("x");
            var y = $(target).data("y");
            if (p == "black") {
                tictactoe.play(0, x, y);
            } else {
                tictactoe.play(1, x, y);
            }
        }

        $("td").on("click", function () {
            placePiece(this);
        })
    };

})($);