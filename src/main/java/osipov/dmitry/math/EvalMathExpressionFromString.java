package osipov.dmitry.math;

import java.util.ArrayList;
import java.util.List;

public class EvalMathExpressionFromString {
    public static void main(String[] args) {
        String expression = "122 - 34 - 3 * (55 + 5 * (3 - 2)) * 2";
        System.out.println(eval(expression));
    }

    public static int eval(String expression) {
        List<Lexeme> lexemes = lexAnalyze(expression);
        LexemeBuffer buffer = new LexemeBuffer(lexemes);
        return expr(buffer);
    }

    private static int expr(LexemeBuffer buffer) {
        Lexeme lexeme = buffer.next();
        if (lexeme.type == LexemeType.EOF) {
            return 0;
        }

        buffer.back();
        return plusminus(buffer);
    }

    private static int plusminus(LexemeBuffer buffer) {
        int value = multdiv(buffer);
        while (true) {
            Lexeme lexeme = buffer.next();
            switch (lexeme.type) {
                case OP_PLUS:
                    value += multdiv(buffer);
                    break;
                case OP_MINUS:
                    value -= multdiv(buffer);
                    break;
                default:
                    buffer.back();
                    return value;
            }
        }
    }

    private static int multdiv(LexemeBuffer buffer) {
        int value = factor(buffer);
        while (true) {
            Lexeme lexeme = buffer.next();
            switch (lexeme.type) {
                case OP_MUL:
                    value *= factor(buffer);
                    break;
                case OP_DIV:
                    value /= factor(buffer);
                    break;
                default:
                    buffer.back();
                    return value;
            }
        }
    }

    private static int factor(LexemeBuffer buffer) {
        Lexeme lexeme = buffer.next();
        switch (lexeme.type) {
            case NUMBER:
                return Integer.parseInt(lexeme.value);
            case LEFT_BRACKET:
                int value = expr(buffer);
                lexeme = buffer.next();
                if (lexeme.type != LexemeType.RIGHT_BRACKET) {
                    throw new IllegalArgumentException("Unexpected token: " + lexeme.value +
                            " at position: " + buffer.pos);
                }
                return value;
            default:
                throw new IllegalArgumentException("Unexpected token: " + lexeme.value +
                        " at position: " + buffer.pos);
        }
    }

    private static List<Lexeme> lexAnalyze(String expression) {
        List<Lexeme> lexemes = new ArrayList<>();
        int pos = 0;
        while (pos < expression.length()) {
            char c = expression.charAt(pos);
            switch (c) {
                case '(':
                    lexemes.add(new Lexeme(LexemeType.LEFT_BRACKET, c));
                    pos++;
                    continue;
                case ')':
                    lexemes.add(new Lexeme(LexemeType.RIGHT_BRACKET, c));
                    pos++;
                    continue;
                case '+':
                    lexemes.add(new Lexeme(LexemeType.OP_PLUS, c));
                    pos++;
                    continue;
                case '-':
                    lexemes.add(new Lexeme(LexemeType.OP_MINUS, c));
                    pos++;
                    continue;
                case '*':
                    lexemes.add(new Lexeme(LexemeType.OP_MUL, c));
                    pos++;
                    continue;
                case '/':
                    lexemes.add(new Lexeme(LexemeType.OP_DIV, c));
                    pos++;
                    continue;
                default:
                    if (Character.isDigit(c)) {
                        var sb = new StringBuilder();
                        do {
                            sb.append(c);
                            pos++;
                            if (pos >= expression.length()) {
                                break;
                            }
                            c = expression.charAt(pos);
                        } while (Character.isDigit(c));
                        lexemes.add(new Lexeme(LexemeType.NUMBER, sb.toString()));
                    } else {
                        if (!Character.isWhitespace(c)) {
                            throw new IllegalArgumentException("Unexpected character: " + c);
                        }
                        pos++;
                    }
            }
        }
        lexemes.add(new Lexeme(LexemeType.EOF, ""));
        return lexemes;
    }

    private enum LexemeType {
        LEFT_BRACKET, RIGHT_BRACKET,
        OP_PLUS, OP_MINUS, OP_MUL, OP_DIV,
        NUMBER,
        EOF
    }

    private static class Lexeme {
        LexemeType type;
        String value;

        public Lexeme(LexemeType type, String value) {
            this.type = type;
            this.value = value;
        }

        public Lexeme(LexemeType type, Character c) {
            this.type = type;
            this.value = c.toString();
        }

        @Override
        public String toString() {
            return "Lexeme{" +
                    "type=" + type +
                    ", value='" + value + '\'' +
                    '}';
        }
    }

    private static class LexemeBuffer {
        private int pos;

        public List<Lexeme> lexemes;

        public LexemeBuffer(List<Lexeme> lexemes) {
            this.lexemes = lexemes;
        }

        public Lexeme next() {
            return lexemes.get(pos++);
        }

        public void back() {
            pos--;
        }
    }
}
