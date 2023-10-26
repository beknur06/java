package all.in.one.UI.In;
import all.in.one.UI.service.bankService;
import java.util.Scanner;
import java.util.InputMismatchException;

public class bankConsole {
    bankService bankAccounts = new bankService();
    Scanner scanner = new Scanner(System.in);
    String loggedInUsername = null; // username того, кто вошел
    boolean loggedIn = false; // для отслеживания авторизации
    public static void main(String[] args) {
        System.out.print("_");
    }

    public void start(){
        for(;;){
            if(!loggedIn) {
                System.out.println("_______________________________");
                System.out.println("Выберите действие:");
                System.out.println("1. Регистрация");
                System.out.println("2. Авторизация");
                System.out.println("17. Выйти");
                System.out.println("_______________________________");
                int choice = 0;
                try {
                    choice = scanner.nextInt();
                    scanner.nextLine();
                } catch (InputMismatchException e) {
                    scanner.nextLine(); // Очищаем буфер ввода
                }
                if (choice == 1) {
                    System.out.print("Введите свое имя: ");
                    String name = scanner.nextLine();
                    System.out.print("Введите свою фамилию: ");
                    String surname = scanner.nextLine();
                    System.out.print("Введите имя пользователя: ");
                    String username = scanner.nextLine();
                    System.out.print("Введите пароль: ");
                    String password = scanner.nextLine();

                    bankAccounts.registerPlayer(username, password, name, surname);
                    continue;
                }
                if (choice == 2) {
                    System.out.print("Введите имя пользователя: ");
                    String username = scanner.nextLine();
                    System.out.print("Введите пароль: ");
                    String password = scanner.nextLine();

                    if(bankAccounts.loginPlayer(username, password)) {
                        loggedIn = true;
                        loggedInUsername = username;
                    }
                    continue;
                }
                if (choice == 17) {
                    System.exit(0);
                } else {
                    System.out.println("Неверный выбор. Пожалуйста, выберите снова.");
                }
            }
            else if(loggedInUsername.equals("admin")){
                 System.out.println("_______________________________");
                 System.out.println("Привет, Админ. Рад видеть вас!");
                 System.exit(0);
            }
            else{
                System.out.println("Ваша имя и фамилия: " + loggedInUsername);
                System.exit(0);
            }
        }

    }
}