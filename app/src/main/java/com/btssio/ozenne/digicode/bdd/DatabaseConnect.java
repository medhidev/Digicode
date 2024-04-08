package com.btssio.ozenne.digicode.bdd;

import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseConnect {
    // Variables de Connexion
    private static String IP = "192.168.1.25";
    private static String BDD = "mdll";
    private static String PORT = "3306"; // port par défaut BDD
    private static String user_bdd = "root";
    private static String pwd_bdd = "";
    private static String request = "SELECT * FROM code";

    public static void connect(){
        try {
            String url = "jdbc:mysql://"+ IP +":"+ PORT +"/"+ BDD;
            Connection conn = DriverManager.getConnection(url, user_bdd, pwd_bdd);

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(request); // résultat requête

            if (rs.next()){
                Log.d("connexion_test", rs.getString("wifi_key"));
            } else{
                Log.d("connexion_test", "no connexion");
            }


            // Passer le ResultSet à Kotlin pour le traitement
            DataCollect data = new DataCollect();
            data.processData(rs);

            // Fermeture de la connexion
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ResultSet getResultSet() {
        try {
            String url = "jdbc:mysql://"+ IP +":"+ PORT +"/"+ BDD;
            Connection conn = DriverManager.getConnection(url, user_bdd, pwd_bdd);

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(request);

            // Retourner le ResultSet
            return rs;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
