package Main;

import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;

/**
 * Main application for RnH Comic Shop with serialization and exception handling.
 */
public class RnH_ComicShop {

    private static final String USERS_FILE = "users.dat";
    private static final String COMICS_FILE = "comics.dat";
    private static final String WISHLIST_FILE = "wishlist.dat";
    private static final String ADMIN_FILE = "admin.dat";

    private static ArrayList<UserLogin> ul;
    private static ArrayList<Comics> com;
    private static ArrayList<WishList> wl;
    private static AdminLogin al;

    public static void main(String[] args) {
        // Top-level try to ensure saveAll on unexpected errors
        try (Scanner sc = new Scanner(System.in)) {
            loadAll();

            while (true) {
                try {
                    System.out.println("=======Enter=======");
                    System.out.println("1.Register\n2.Login\n3.Exit");
                    System.out.println("===================");
                    System.out.print("Enter : ");
                    int op1 = safeNextInt(sc);
                    if (op1 == 1) {
                        handleRegister(sc);
                    } else if (op1 == 2) {
                        handleLogin(sc);
                    } else if (op1 == 3) {
                        saveAll();
                        System.out.println("Exiting... Data saved.");
                        break;
                    } else {
                        System.out.println("Invalid Choice");
                    }
                } catch (Exception e) {
                    // Handle any unexpected exceptions in loop, but keep app running
                    System.out.println("An error occurred: " + e.getMessage());
                    // optionally print stack trace for debugging:
                    // e.printStackTrace();
                }
            }
        } catch (Exception e) {
            // Final fallback — try to save before exit
            System.out.println("Fatal error: " + e.getMessage());
            saveAll();
        }
    }

    /* ----------------- User / Admin flows ----------------- */

    private static void handleRegister(Scanner sc) {
        sc.nextLine();
        System.out.print("Enter UserName : ");
        String name = sc.nextLine().trim();
        if (name.isEmpty()) {
            System.out.println("Username cannot be empty.");
            return;
        }
        boolean exists = false;
        for (UserLogin u : ul) {
            if (u.userName.equals(name)) {
                exists = true;
                break;
            }
        }

        if (exists) {
            System.out.println("This UserName already exist");
        } else {
            System.out.println("Enter Password : ");
            String Pass = sc.nextLine();
            UserLogin newUser = new UserLogin(name);
            newUser.setPass(Pass);
            ul.add(newUser);
            // save after registration
            saveUsers();
            System.out.println("Welcome " + name + "\n");
            userMenu(sc, newUser);
        }
    }

    private static void handleLogin(Scanner sc) {
        while (true) {
            System.out.println("1.Admin Login\n2.User Login\n3.Exit");
            int op2 = safeNextInt(sc);
            if (op2 == 1) {
                sc.nextLine();
                System.out.println("Enter Your name : ");
                String name = sc.nextLine();
                System.out.println("Enter password : ");
                String pass = sc.nextLine();
                boolean ok = ((al.userName1.equals(name) || al.userName2.equals(name)) && al.getPass().equals(pass));
                if (!ok) {
                    System.out.println("Invalid Name or Password");
                } else {
                    System.out.println("Welcome " + name + "\n");
                    adminMenu(sc);
                }
            } else if (op2 == 2) {
                sc.nextLine();
                System.out.println("Enter Your name : ");
                String name = sc.nextLine();
                System.out.println("Enter password : ");
                String pass = sc.nextLine();
                int found = -1;
                for (int i = 0; i < ul.size(); i++) {
                    if (ul.get(i).userName.equals(name) && ul.get(i).getPass() != null && ul.get(i).getPass().equals(pass)) {
                        found = i;
                        break;
                    }
                }
                if (found == -1) {
                    System.out.println("Invalid Name or Password");
                } else {
                    System.out.println("Welcome " + name);
                    userMenu(sc, ul.get(found));
                }
            } else if (op2 == 3) {
                break;
            } else {
                System.out.println("Invalid Choice");
            }
        }
    }

    private static void userMenu(Scanner sc, UserLogin currentUser) {
        while (true) {
            System.out.println("======Main Menu======");
            System.out.println("1.Buy Comics\n2.search Comic & Buy\n3.Add Wishlist\n0.Exit");
            System.out.println("=====================");
            int op2 = safeNextInt(sc);
            if (op2 == 1) {
                if (com.isEmpty()) {
                    System.out.println("No comics available.");
                    continue;
                }
                for (int i = 0; i < com.size(); i++) {
                    System.out.println("******** Serial Number : " + i + " ********");
                    com.get(i).display();
                }
                System.out.println("Enter The Serial Number of the comic you want to buy : ");
                int o = safeNextInt(sc);
                if (o < 0 || o >= com.size()) {
                    System.out.println("Invalid serial number");
                } else {
                    com.get(o).display();
                    System.out.println("How many you want to Buy : ");
                    int num = safeNextInt(sc);
                    com.get(o).buy(num);
                    saveComics();
                }
            } else if (op2 == 2) {
                sc.nextLine();
                System.out.print("Enter The Comic Name : ");
                String key = sc.nextLine();
                int found = -1;
                for (int i = 0; i < com.size(); i++) {
                    if (com.get(i).comic.equalsIgnoreCase(key)) {
                        found = i;
                        break;
                    }
                }
                if (found == -1) {
                    System.out.println("Sorry we don't have That comic");
                } else {
                    com.get(found).display();
                    System.out.println("Press.......\n1 to Buy\n2 for go Back");
                    int op3 = safeNextInt(sc);
                    if (op3 == 1) {
                        System.out.println("How many you want to buy : ");
                        int odrNumber = safeNextInt(sc);
                        com.get(found).buy(odrNumber);
                        saveComics();
                    } else {
                        continue;
                    }
                }
            } else if (op2 == 3) {
                sc.nextLine();
                System.out.println("Enter The Comics Name : ");
                String comName = sc.nextLine();
                if (comName.trim().isEmpty()) {
                    System.out.println("Invalid name.");
                    continue;
                }
                boolean increased = false;
                for (WishList w : wl) {
                    if (w.name.equalsIgnoreCase(comName)) {
                        w.increaseDemand();
                        increased = true;
                        break;
                    }
                }
                if (!increased) {
                    wl.add(new WishList(comName));
                }
                saveWishlist();
            } else if (op2 == 0) {
                break;
            } else {
                System.out.println("Invalid Choice");
            }
        }
    }

    private static void adminMenu(Scanner sc) {
        while (true) {
            System.out.println("+++++Main Menu+++++");
            System.out.println("1.See All comics\n2.Add Comics\n3.Remove Comics\n4.Show WishList\n5.Update Price\n6.Update Admin Password\n0.Exit");
            System.out.println("+++++++++++++++++++");
            int op3 = safeNextInt(sc);
            sc.nextLine();
            if (op3 == 1) {
                if (com.isEmpty()) {
                    System.out.println("No comics available.");
                } else {
                    for (int i = 0; i < com.size(); i++) {
                        System.out.println("******** Serial Number : " + i + " ********");
                        com.get(i).display();
                    }
                }
            } else if (op3 == 2) {
                System.out.println("Enter comics Name : ");
                String comName = sc.nextLine();
                System.out.println("Enter Comic Genre : ");
                String genre = sc.nextLine();
                System.out.println("Enter Year : ");
                int year = safeNextInt(sc);
                sc.nextLine();
                System.out.println("Enter Language : ");
                String langu = sc.nextLine();
                System.out.println("Enter Rating(out of 10) : ");
                double rat = safeNextDouble(sc);
                sc.nextLine();
                System.out.println("Enter price :");
                double pri = safeNextDouble(sc);
                sc.nextLine();
                System.out.println("Enter Publisher Name : ");
                String pub = sc.nextLine();
                System.out.println("How Many Copies : ");
                int sto = safeNextInt(sc);
                com.add(new Comics(comName, genre, year, langu, rat, pri, pub, sto));
                // remove from wishlist if present
                for (int i = 0; i < wl.size(); i++) {
                    if (wl.get(i).name.equalsIgnoreCase(comName)) {
                        wl.remove(i);
                        i--;
                    }
                }
                saveComics();
                saveWishlist();
                System.out.println("Comic added.");
            } else if (op3 == 3) {
                System.out.println("Enter Comic Name : ");
                String comName = sc.nextLine();
                boolean removed = false;
                for (int i = 0; i < com.size(); i++) {
                    if (com.get(i).comic.equalsIgnoreCase(comName)) {
                        com.remove(i);
                        removed = true;
                        break;
                    }
                }
                if (removed) {
                    saveComics();
                    System.out.println("Comic removed.");
                } else {
                    System.out.println("Comic not found.");
                }
            } else if (op3 == 4) {
                if (wl.isEmpty()) {
                    System.out.println("Wishlist empty.");
                } else {
                    for (int i = 0; i < wl.size(); i++) {
                        wl.get(i).display();
                    }
                }
            } else if (op3 == 5) {
                System.out.println("Enter Comic Name : ");
                String comName = sc.nextLine();
                System.out.println("Enter new Price");
                double pre = safeNextDouble(sc);
                sc.nextLine();
                boolean updated = false;
                for (int i = 0; i < com.size(); i++) {
                    if (com.get(i).comic.equalsIgnoreCase(comName)) {
                        com.get(i).changePrice(pre);
                        updated = true;
                        break;
                    }
                }
                if (updated) {
                    saveComics();
                    System.out.println("Price updated.");
                } else {
                    System.out.println("Comic not found.");
                }
            } else if (op3 == 6) {
                System.out.println("Enter new admin password : ");
                String newP = sc.nextLine();
                al.setPass(newP);
                saveAdmin();
                System.out.println("Admin password updated.");
            } else if (op3 == 0) {
                break;
            } else {
                System.out.println("Invalid Choice");
            }
        }
    }

    /* ----------------- helper I/O methods ----------------- */

    private static int safeNextInt(Scanner sc) {
        while (true) {
            try {
                String token = sc.next();
                return Integer.parseInt(token);
            } catch (NumberFormatException e) {
                System.out.print("Please enter a valid integer: ");
            }
        }
    }

    private static double safeNextDouble(Scanner sc) {
        while (true) {
            try {
                String token = sc.next();
                return Double.parseDouble(token);
            } catch (NumberFormatException e) {
                System.out.print("Please enter a valid number: ");
            }
        }
    }

    private static void loadAll() {
        try {
            ul = (ArrayList<UserLogin>) readObjectFromFile(USERS_FILE);
            if (ul == null) ul = new ArrayList<>();

            com = (ArrayList<Comics>) readObjectFromFile(COMICS_FILE);
            if (com == null) com = new ArrayList<>();

            wl = (ArrayList<WishList>) readObjectFromFile(WISHLIST_FILE);
            if (wl == null) wl = new ArrayList<>();

            AdminLogin loadedAdmin = (AdminLogin) readObjectFromFile(ADMIN_FILE);
            if (loadedAdmin == null) {
                al = new AdminLogin(); // default admin
            } else {
                al = loadedAdmin;
            }
        } catch (Exception e) {
            System.out.println("Error loading data: " + e.getMessage());
            // Ensure non-null collections to avoid NPE later
            if (ul == null) ul = new ArrayList<>();
            if (com == null) com = new ArrayList<>();
            if (wl == null) wl = new ArrayList<>();
            if (al == null) al = new AdminLogin();
        }
    }

    private static void saveAll() {
        writeObjectToFile(ul, USERS_FILE);
        writeObjectToFile(com, COMICS_FILE);
        writeObjectToFile(wl, WISHLIST_FILE);
        writeObjectToFile(al, ADMIN_FILE);
    }

    private static void saveUsers() {
        writeObjectToFile(ul, USERS_FILE);
    }

    private static void saveComics() {
        writeObjectToFile(com, COMICS_FILE);
    }

    private static void saveWishlist() {
        writeObjectToFile(wl, WISHLIST_FILE);
    }

    private static void saveAdmin() {
        writeObjectToFile(al, ADMIN_FILE);
    }

    private static Object readObjectFromFile(String fileName) {
        File f = new File(fileName);
        if (!f.exists()) return null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f))) {
            return ois.readObject();
        } catch (InvalidClassException ice) {
            System.out.println("Saved data format changed for " + fileName + ". Ignoring file.");
            return null;
        } catch (FileNotFoundException fnfe) {
            System.out.println("File not found: " + fileName);
            return null;
        } catch (IOException ioe) {
            System.out.println("I/O error while reading " + fileName + ": " + ioe.getMessage());
            return null;
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Class not found while reading " + fileName + ": " + cnfe.getMessage());
            return null;
        }
    }

    private static void writeObjectToFile(Object obj, String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(obj);
        } catch (FileNotFoundException fnfe) {
            System.out.println("Unable to create file " + fileName + ": " + fnfe.getMessage());
        } catch (IOException ioe) {
            System.out.println("I/O error while writing " + fileName + ": " + ioe.getMessage());
        }
    }
}