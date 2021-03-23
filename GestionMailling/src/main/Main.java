    package main;
    import sn.isi.dao.DB;
    import sn.isi.dao.IClient;
    import sn.isi.dao.ClientImpl;
    import sn.isi.entities.Client;
    import java.util.List;
    import java.util.Scanner;
    public class Main {
        public static void main(String[] args) throws Exception {
            DB db = new DB();
            // IClient cl = (IClient) new ClientImpl();
            Client c1 = new Client();
            // cl.add(c1);
            Client c = null;
            String rep = null;
            String reponse = null;
            boolean bool = false;
            Scanner scanner = new Scanner(System.in);
            do {
                System.out.println("************$$$$$$$$$$$$$$  VEUILLEZ CHOISIR SVP DE 1 A 4 $$$$$$$$$$$$$$  **************");
                System.out.println("*******                           *1-CREATION CLIENT                      **************");
                System.out.println("*******                           *2-VISUALISATION DES CLIENTS            **************");
                System.out.println("*******                           *3-EDITER UN CLIENT                     **************");
                System.out.println("*******                           *4-RECHERCHER UN CLIEN*                 **************");
                System.out.println("************$$$$$$$$$$$$$$  $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$ **************");
                rep = scanner.nextLine();
                if (rep.equals("1") || rep.equals("2") || rep.equals("3") || rep.equals("4")) {
                    bool = true;
                } else {
                    System.out.println("choix non disponible veuillez recommancé SVP et choisir entre 1 et 4");
                }
            } while (bool == false);

           do {
            if (rep.equals("1")) {
                System.out.println("******************* £££££££££££££££ CREATION CLIENT £££££££££££££££ ********************");
                IClient client1 = new ClientImpl();
                Client client = new Client();
                System.out.println("Donner votre nom:");
                client.setNom(scanner.nextLine());
                System.out.println("Donner votre prenom:");
                client.setPrenom(scanner.nextLine());
                System.out.println("Donner votre email:");
                client.setEmail(scanner.nextLine());
                System.out.println("Donner votre password:");
                client.setPassword(scanner.nextLine());
                System.out.println("Donner votre tel:");
                client.setTel(scanner.nextLine());
                int ok = client1.add(client);
                List<Client> clients = client1.getAll();
            }
                System.out.println("voulez vous continuez A AJOUTER UN CLIENT? :O/N");
                reponse = scanner.nextLine();
          }while (reponse.equalsIgnoreCase("O"));

            if (rep.equals("2")) {
                System.out.println(" ££££££££££££££££££££££ LISTE(VISUALISATION) DES DONNEES DES CLIENTS ££££££££££££££££££ ");
                System.out.println("****************************************************************************************");
                IClient client1 = new ClientImpl();
                Client client = new Client();
                List<Client> clients = client1.getAll();
                for (Client cl : clients) {
                    System.out.println("*************************************************************************************");
                    System.out.println("id CLIENT: " +cl.getId());
                    System.out.println("nom CLIENT: " +cl.getNom());
                    System.out.println("prenom CLIENT: " +cl.getPrenom());
                    System.out.println("email CLIENT: " +cl.getEmail());
                    System.out.println("password CLIENT: " +cl.getPassword());
                    System.out.println("tel CLIENT: " +cl.getTel());
                    System.out.println("*************************************************************************************");
                }
            }

                if(rep.equals("3")) {
                System.out.println("******************* £££££££££££££££ EDITER CLIENT £££££££££££££££ **********************'*");
                System.out.println("Entrer l'ID  :");
                int idN = Integer.parseInt(scanner.nextLine());
                System.out.println("Entrer votre ancien ID :");
                int idA = Integer.parseInt(scanner.nextLine());
                if (idN == idA){
                    db.open();
                    String sql = "UPDATE client SET nom = ?, prenom = ?,email = ?, tel = ? WHERE id = ?";
                    db.init(sql);
                    //System.out.println("l'mail du client" +c.getEmail());
                    IClient clientdao = new ClientImpl();
                    Client client = new Client();
                    System.out.println("veuillez saisir le nom:");
                    client.setNom(scanner.nextLine());
                    System.out.println("veuillez saisir le prenom:");
                    client.setPrenom(scanner.nextLine());
                    System.out.println("veuillez saisir l'email:");
                    client.setEmail(scanner.nextLine());
                    System.out.println("veuillez saisir le tel:");
                    client.setTel(scanner.nextLine());
                    System.out.println("*************************************************************************************");
                    db.getPstm().setString(1, client.getNom());
                    db.getPstm().setString(2, client.getPrenom());
                    db.getPstm().setString(3, client.getEmail());
                    db.getPstm().setString(4, client.getTel());
                    db.getPstm().setInt(5,idA);
                    int ok = db.executeUpdate();
                    System.out.println(ok+"modifier avec succes");
                }else {
                    System.out.println("L'id du client a modifier n'existe pas !");
                }
            }
        }
     }






