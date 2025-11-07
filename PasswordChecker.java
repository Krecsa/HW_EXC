public class PasswordChecker {
    private int minLength = -1;
    private int maxRepeats = -1;

    public void setMinLength(int minLength) {
        if (minLength < 0) {
            throw new IllegalArgumentException("Минимальная длина не может быть отрицательной");
        }
        this.minLength = minLength;
    }

    public void setMaxRepeats(int maxRepeats) {
        if (maxRepeats <= 0) {
            throw new IllegalArgumentException("Максимальное количество повторов должно быть положительным");
        }
        this.maxRepeats = maxRepeats;
    }

    public boolean verify(String password) {
        if (minLength == -1 || maxRepeats == -1) {
            throw new IllegalStateException("Не установлены параметры проверки пароля");
        }
        if (password == null || password.isEmpty() || password.length() < minLength) {
            return false;
        }

        char prevChar = password.charAt(0);
        int repeats = 1;

        for (int i = 1; i < password.length(); i++) {
            char curChar = password.charAt(i);
            if (curChar == prevChar) {
                repeats++;
                if (repeats > maxRepeats) {
                    return false;
                }
            } else {
                repeats = 1;
                prevChar = curChar;
            }
        }
        return true;
    }
}