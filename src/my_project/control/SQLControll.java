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
        loescheTabellen();
        //erstelleTabellen();
    }

    private void loescheTabellen() {
        processSQL("SHOW TABLES LIKE 'JR_Kv_%'");
        if(dbController.getCurrentQueryResult() != null){
            String[][] tmpAll= dbController.getCurrentQueryResult().getData();
            String tmpsql = "DROP TABLE " + tmpAll[0];
            for (int i = 1; i < tmpAll.length; i++) {
                tmpsql += ", " + tmpAll[i][0];
            }
            processSQL(tmpsql);
        }

    }


        /*private void erstelleTabellen(){
            //neue Tabellen anlegen
            sql="CREATE TABLE MG_Fabrik(\n" +
                    "ID INTEGER NOT NULL,\n" +
                    "Name VARCHAR (40) NOT NULL,\n" +
                    "AktProduktion INTEGER,\n" +
                    "MaxProduktion INTEGER,\n" +
                    "KostenProStk INTEGER,\n" +
                    "Stadt VARCHAR (30),\n" +
                    "PRIMARY KEY (ID) )\n";
            ausführen(sql,"MG_Fabrik wurde neu erstellt");
            sql="CREATE TABLE MG_Stadt(\n" +
                    "Name VARCHAR (30) NOT NULL,\n" +
                    "Bevölkerung INTEGER,\n" +
                    "Lagerkapazität INTEGER,\n" +
                    "Angebot INTEGER,\n" +
                    "Nachfrage INTEGER,\n" +
                    "PRIMARY KEY (Name))\n";
            ausführen(sql,"MG_Stadt wurde neu erstellt");
            sql="CREATE TABLE MG_Straße(\n" +
                    "ID INTEGER NOT NULL,\n" +
                    "Kosten INTEGER,\n" +
                    "Dauer INTEGER,\n" +
                    "Art VARCHAR (8),\n" +
                    "Start VARCHAR(30),\n" +
                    "Ziel VARCHAR(30),\n" +
                    "PRIMARY KEY (ID))\n";
            ausführen(sql,"MG_Straße wurde neu erstellt");
            sql= "CREATE TABLE MG_Route(\n" +
                    "ID INTEGER NOT NULL,\n" +
                    "Stop INTEGER," +
                    "Straße INTEGER,\n" +
                    "Fabrik INTEGER,\n" +
                    "PRIMARY KEY (ID))";
            ausführen(sql,"MG_Route wurde neu erstellt");
            //Fremdschlüssel ergänzen
            sql="ALTER TABLE MG_Fabrik\n" +
                    "ADD CONSTRAINT fkf FOREIGN KEY(Stadt) REFERENCES MG_Stadt(Name)";
            ausführen(sql,"1:n Beziehug zwischen Fabrik und Stadt erzeugt");
            sql="ALTER TABLE MG_Straße\n" +
                    "ADD CONSTRAINT fkst FOREIGN KEY (Start) REFERENCES MG_Stadt(Name)";
            ausführen(sql,"1:n Beziehung zwischen Straße und Stadt erzeugt");
            sql="ALTER TABLE MG_Straße\n" +
                    "ADD CONSTRAINT fkst2 FOREIGN KEY (Ziel) REFERENCES MG_Stadt(Name)";
            ausführen(sql,"2:n Beziehung zwischen Straße und Stadt erzeugt");
            sql="ALTER TABLE MG_Route\n" +
                    "ADD CONSTRAINT fkr FOREIGN KEY (Straße) REFERENCES MG_Straße(ID)";
            ausführen(sql,"1:n Beziehung zwischen Straße und Route erzeugt");
            sql="ALTER TABLE MG_Route\n" +
                    "ADD CONSTRAINT fkr2 FOREIGN KEY (Fabrik) REFERENCES MG_Fabrik(ID)";
            ausführen(sql,"1:n Beziehung zwischen Fabrik und Route erzeugt");
            //Tabelle füllen:

            ausführen(sql,"London unter Städte hinzugefügt");
            String[] städte=new String[]{"Joshuandria","Lisa de Janeiro","Maxinopel","Renehausen","Knebopolis","AmbroCity","St. Iboburg","San Marcisco"};
            for(String stadt:städte){
                sql="INSERT INTO MG_Stadt (Name,Bevölkerung,Lagerkapazität,Angebot,Nachfrage)\n" +
                        "VALUES ('"+stadt+"',"+(int)(100000+Math.random()*(9900000))+","+(int)(100000+Math.random()*(9900000))+",0,0)";
                ausführen(sql,stadt+" wurde als Stadt hinzugefügt");
            }
            for(int i=0;i<16;i++){
                double r=Math.random();
                String art="";
                if(r>0.66){
                    art="LKW";
                }else if(r>0.33){
                    art="Flugzeug";
                }else{
                    art="Schiff";
                }
                int z=gibZahlAußer(i%8,7);
                sql="INSERT INTO MG_Straße (ID,Kosten,Dauer,Art,Start,Ziel)\n" +
                        "VALUES("+i+","+(int)(1000+Math.random()*99000)+","+(int)(1+Math.random()*9)+",'"+art+"','"
                        +städte[z]+"','"+städte[i%8]+"');";
                ausführen(sql,"Eine Straße von "+städte[z]+" bis "+städte[i%8]+" wurde erstellt");
            }

        }*/
}
