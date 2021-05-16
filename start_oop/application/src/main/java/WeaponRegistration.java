import java.util.Scanner;

public class WeaponRegistration {

    public static void startApp() {
        System.out.println("It's program for control weapon licenses\n");
        WeaponService weaponService = new WeaponService();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Please select your next action by inputting next number: \n" +
                    "1 - Add new weapon \n" +
                    "2 - Edit existing weapon information by ID \n" +
                    "3 - Delete weapon by ID\n" +
                    "4 - View weapon's id, model and license number \n" +
                    "Input \"exit\" if u want to quit");

            switch (scanner.next()) {
                case "1": {
                    System.out.println("Enter weapon model and license number ");
                    Weapon newWeapon = new Weapon().setModel(scanner.next()).setLicenseNumber(scanner.nextInt());
                    weaponService.create(newWeapon);
                    System.out.println("New weapon added\n");
                    break;
                }
                case "2": {
                    System.out.println("Enter weapon ID:");
                    String id = scanner.next();
                    Weapon currentWeapon;
                    if ((currentWeapon = weaponService.read(id)) == null) {
                        System.out.println("Wrong id");
                        break;
                    }
                    System.out.println("1 - Edit weapon model \n" +
                            "2 - Edit weapon license number \n" +
                            "Input \"exit\" if u want to quit");
                    switch (scanner.next()) {
                        case "1": {
                            System.out.println("Enter new model:");
                            weaponService.update(currentWeapon.setModel(scanner.next()));
                            System.out.println("Information updated\n");
                            break;
                        }
                        case "2": {
                            System.out.println("Enter new license number:");
                            weaponService.update(currentWeapon.setLicenseNumber(scanner.nextInt()));
                            System.out.println("Information updated\n");
                            break;
                        }
                        case "exit": {
                            System.exit(0);
                        }
                        default:
                            break;
                    }
                    break;
                }
                case "3": {
                    System.out.println("Enter weapon ID:");
                    try {
                        weaponService.delete(scanner.next());
                    } catch (RuntimeException ex) {
                        System.err.println("Something wrong :(");
                    }
                    System.out.println("Weapon deleted\n");
                    break;
                }
                case "4": {
                    System.out.println(weaponService.read());
                    break;
                }
                case "exit": {
                    System.exit(0);
                }
                default:
                    break;
            }
            scanner.nextLine();
        }
    }
}
