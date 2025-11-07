public static void main(String[] args) {
    PasswordChecker checker = new PasswordChecker();

    checker.setMinLength(6);
    checker.setMaxRepeats(2);

    System.out.println("Пароль '123123': " + checker.verify("12323"));
    System.out.println("Пароль 'abccba': " + checker.verify("abccba'"));
    System.out.println("Пароль 'Xcsmn223': " + checker.verify("Xcsmn223"));
    System.out.println("Пароль 'BMW21': " + checker.verify("BMW21"));
}
