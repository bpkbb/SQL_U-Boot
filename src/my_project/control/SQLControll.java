package my_project.control;

import KAGO_framework.control.DatabaseController;
import KAGO_framework.model.abitur.datenbanken.mysql.QueryResult;
import my_project.view.Ausgabenformatierung;

public class SQLControll {

    private DatabaseController dbController;

    public SQLControll(){
        dbController = new DatabaseController();
        programmstart();
    }

    public void processSQLMitRueckgabe(String sql){
        String ergebnis = processSQL(sql);
        if(ergebnis.equals("Success")){
            String [][] ausgabe = dbController.getCurrentQueryResult().getData();
            String[][] tmp = new String[ausgabe.length+1][];
            tmp[0] = dbController.getCurrentQueryResult().getColumnNames();
            for(int i = 1; i<tmp.length; i++){
                tmp[i] = ausgabe[i-1];
            }
            new Ausgabenformatierung(tmp);
        }else{
            String[][] tmp = new String[1][1];
            tmp[0][0] = ergebnis;
            new Ausgabenformatierung(tmp);
        }
    }

    /**
     * Hilfsmethode, um aus den Daten einer queryResult (oder ähnlichem) einen String zu erzeugen.
     * @param attributes Die Spaltenüberschriften
     * @param result Die Tabelleninhalte
     * @return Tabellenähnlich formatierte Ausgabe
     */
    private String formatSQLOutput(String[] attributes, String[][] result){
        String formattedString = "";
        for(String attribute:attributes)
        {
            formattedString = formattedString + attribute + "; ";
        }
        formattedString = formattedString + "\n\n";
        for(String[] row:result){
            for(String entry:row){
                formattedString = formattedString + entry + "; ";
            }
            formattedString = formattedString + "\n";
        }
        return formattedString;
    }
    /**
     * Hilfsmethode für das Ausführen von SQL-Befehlen. Ruft intern formatSQLOutput auf.
     * @param statement Die auszuführende SQL-Anweisung
     * @return Verschiedene Ausgaben je nach Fall: 1) SQL-Abfrage: Tabellenähnlich formatiertes Ergebnis 2) SQL-Anweisung ohne Rückgabe: "Success" 3) Fehler etc.: Nähere Infos zum Fehler
     */
    private String processSQL(String statement) {
        if(dbController.isConnected()) {
            dbController.executeStatement(statement);
            QueryResult queryResult = dbController.getCurrentQueryResult();
            if(queryResult !=null) {
                return formatSQLOutput(queryResult.getColumnNames(), queryResult.getData());
            }else{
                String error = dbController.getErrorMessage();
                if(error !=null) {
                    return error;
                }else{
                    return "Success";
                }
            }
        }else{
            return "Connection not established.";
        }
    }

    public String getColumnName(){
        String[] attributes = dbController.getCurrentQueryResult().getColumnNames();
        String formattedString = "";
        for(String attribute:attributes) {
            formattedString = formattedString + attribute + "; ";
        }
        formattedString = formattedString + "\n\n";
        return formattedString;
    }


    public void programmstart() {
        if (dbController.connect()){
            loescheTabellen();
            erstelleTabellen();
        }
    }

    private void loescheTabellen() {
        System.out.println("Löschen " + processSQL("SHOW TABLES LIKE 'LN_UB_%'"));
        if(dbController.getCurrentQueryResult() != null && dbController.getCurrentQueryResult().getData().length>0){
            String[][] tmpAll= dbController.getCurrentQueryResult().getData();
            String tmpsql = "DROP TABLE " + tmpAll[0][0];
            for (int i = 1; i < tmpAll.length; i++) {
                tmpsql += ", " + tmpAll[i][0];
            }
            System.out.println("Löschenbefehl  " + tmpsql);
            processSQL("SET FOREIGN_KEY_CHECKS=0");
            processSQL(tmpsql);
            processSQL("SET FOREIGN_KEY_CHECKS=1");

        }
        System.out.println("Alte Tabellen und Datensätze vollständig entfernt");
    }

    private void erstelleTabellen(){
        System.out.println("BIN AM ERSTELLEN");
        System.out.println(processSQL("CREATE TABLE LN_UB_Hafen(" +
                "ID INTEGER NOT NULL," +
                "Name VARCHAR (40) NOT NULL," +
                "Land VARCHAR (50) NOT NULL," +
                "Koordinate1 INTEGER," +
                "Koordinate2 INTEGER," +
                "Bespaßung BOOLEAN, \n" +
                "PRIMARY KEY (ID));"));

        System.out.println(processSQL("CREATE TABLE LN_UB_UBoote(" +
                "Kennnummer INTEGER NOT NULL," +
                "Hafen INTEGER NOT NULL," +
                "Typ VARCHAR (5) NOT NULL," +
                "Verschollen BOOLEAN," +
                "Mission INTEGER NOT NULL," +
                "Koordinate1 INTEGER," +
                "Koordinate2 INTEGER, \n" +
                "PRIMARY KEY (Kennnummer));"));

        System.out.println(processSQL("CREATE TABLE LN_UB_Person(" +
                "ID INTEGER NOT NULL," +
                "Vorname VARCHAR (30) NOT NULL," +
                "Nachname VARCHAR (30) NOT NULL," +
                "UBootNummer INTEGER NOT NULL," +
                "Age INTEGER," +
                "Geschlecht VARCHAR (20) NOT NULL," +
                "Geburtstag VARCHAR (10) NOT NULL," +
                "Aktiv BOOLEAN," +
                "Land VARCHAR (50)," +
                "Stadt VARCHAR (50)," +
                "Straße VARCHAR (50)," +
                "Hausnummer INTEGER," +
                "PLZ INTEGER, \n" +
                "PRIMARY KEY (ID));"));

        System.out.println(processSQL("CREATE TABLE LN_UB_Mission(" +
                "ID INTEGER NOT NULL," +
                "Codename VARCHAR (30) NOT NULL," +
                "Beschreibung VARCHAR (100) NOT NULL," +
                "Status VARCHAR (25)," +
                "ChefID INTEGER NOT NULL, \n" +
                "PRIMARY KEY (ID));"));

        System.out.println(processSQL("CREATE TABLE LN_UB_MissionsFeind(" +
                "Mission INTEGER NOT NULL," +
                "Feind INTEGER NOT NULL, \n" +
                "PRIMARY KEY (Mission, Feind));"));

        System.out.println(processSQL("CREATE TABLE LN_UB_Feinde(" +
                "ID INTEGER NOT NULL," +
                "Name VARCHAR (25) NOT NULL," +
                "zStandort VARCHAR (50) NOT NULL," +
                "Koordinate1 INTEGER," +
                "Koordinate2 INTEGER," +
                "Grund VARCHAR (100)," +
                "Stärke INTEGER, \n" +
                "PRIMARY KEY (ID));"));

        System.out.println(processSQL("CREATE TABLE LN_UB_Typen(" +
                "Typ VARCHAR (5) NOT NULL," +
                "PS INTEGER NOT NULL," +
                "Größe INTEGER NOT NULL," +
                "maxPersonen INTEGER NOT NULL, \n" +
                "PRIMARY KEY(Typ));"));

        System.out.println(processSQL("ALTER TABLE LN_UB_UBoote \n" +
                "ADD CONSTRAINT FOREIGN KEY (Hafen) REFERENCES LN_UB_Hafen (ID);"));

        processSQL("ALTER TABLE LN_UB_UBoote \n" +
                "ADD CONSTRAINT FOREIGN KEY (Typ) REFERENCES LN_UB_Typen (Typ);");

        processSQL("ALTER TABLE LN_UB_Person \n" +
                "ADD CONSTRAINT FOREIGN KEY (UBootNummer) REFERENCES LN_UB_UBoote (Kennnummer);");

        processSQL("ALTER TABLE LN_UB_MissionsFeind \n" +
                "ADD CONSTRAINT FOREIGN KEY (Mission) REFERENCES LN_UB_Mission (ID);");

        processSQL("ALTER TABLE LN_UB_UBoote \n" +
                "ADD CONSTRAINT FOREIGN KEY (Feind) REFERENCES LN_UB_Feinde (ID);");
    }

}
