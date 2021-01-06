package my_project.control;

import KAGO_framework.control.ViewController;

public class CentralControll {

    private ViewControll vC;
    private ViewController viewController;
    private SQLControll sqlControll;

    public CentralControll(ViewController viewController){
        this.viewController = viewController;
        vC = new ViewControll(viewController, this);
        sqlControll = new SQLControll();
    }

    public void eineTabelleAusgeben(int tabelle){
        if (tabelle == 0) {
            sqlControll.processSQLMitRueckgabe("SELECT * " +
                    "FROM LN_UB_Hafen");
        }else if (tabelle == 1){
            sqlControll.processSQLMitRueckgabe("SELECT * " +
                    "FROM LN_UB_UBoote");
        }else if (tabelle == 2){
            sqlControll.processSQLMitRueckgabe("SELECT * " +
                    "FROM LN_UB_Person");
        }else if (tabelle == 3){
            sqlControll.processSQLMitRueckgabe("SELECT * " +
                    "FROM LN_UB_Mission");
        }else if (tabelle == 4){
            sqlControll.processSQLMitRueckgabe("SELECT * " +
                    "FROM LN_UB_Feinde");
        }else if (tabelle == 5){
            sqlControll.processSQLMitRueckgabe("SELECT * " +
                    "FROM LN_UB_Typen");
        }
    }

    public void datensatzErstellen(int tabelle, String s01, String s02,String s03, String s04, String s05, String s06, String s07,String s08, String s09,String s10, String s11, String s12, String[] strings){
        if (tabelle == 0) {
            sqlControll.processSQL("INSERT INTO LN_UB_Hafen " +
                    "VALUES " +
                    "(" +s01+ ",'" +s02+ "','" +s03+ "'," +s04+ "," +s05+ ","+s06+") " +
                    ";");
            System.out.println(sqlControll.processSQL("SELECT * FROM LN_UB_Hafen WHERE ID = "+s01+";"));
        }else if (tabelle == 1){
            sqlControll.processSQL("INSERT INTO LN_UB_UBoote " +
                    "VALUES " +
                    "(" +s01+ "," +s02+ ",'" +s03+ "'," +s04+ "," +s05+ "," +s06+ "," +s07+ ") " +
                    ";");
            System.out.println(sqlControll.processSQL("SELECT * FROM LN_UB_UBoote WHERE Kennnummer = "+s01+";"));
        }else if (tabelle == 2){
            sqlControll.processSQL("INSERT INTO LN_UB_Person " +
                    "VALUES " +
                    "(" +s01+ ",'" +s02+ "','" +s03+ "'," +s04+ "," +s05+ ",'" +s06+ "','" +s07+ "'," +s08+ ",'" +s09+ "','" +s10+ "'," +s11+ "," +s12+ ") " +
                    ";");
            System.out.println(sqlControll.processSQL("SELECT * FROM LN_UB_Person WHERE ID = "+s01+";"));
        }else if (tabelle == 3){
            sqlControll.processSQL("INSERT INTO LN_UB_Mission " +
                    "VALUES " +
                    "(" +s01+ ",'" +s02+ "','" +s03+ "','" +s04+ "'," +s05+ ") " +
                    ";");
            for (int i = 0; i < strings.length; i++){
                sqlControll.processSQL("INSERT INTO LN_UB_MissionsFeind " +
                        "VALUES " +
                        "("+s01+","+strings[i]+") " +
                        ";");
            }
            System.out.println(sqlControll.processSQL("SELECT * FROM LN_UB_Mission WHERE ID = "+s01+";"));
        }else if (tabelle == 4){
            sqlControll.processSQL("INSERT INTO LN_UB_Feinde " +
                    "VALUES " +
                    "(" +s01+ ",'" +s02+ "','" +s03+ "'," +s04+ "," +s05+ ",'" +s06+ "'," +s07+ ") " +
                    ";");
            System.out.println(sqlControll.processSQL("SELECT * FROM LN_UB_Feinde WHERE ID = "+s01+";"));
        }else if (tabelle == 5){
            sqlControll.processSQL("INSERT INTO LN_UB_Typen " +
                    "VALUES " +
                    "('" +s01+ "'," +s02+ "," +s03+ "," +s04+ ") " +
                    ";");
            System.out.println(sqlControll.processSQL("SELECT * FROM LN_UB_Typen WHERE Typ = '"+s01+"';"));
        }
    }

    public void sucheObjekt(int tabelle, int anzahl, String att01, String wert01, String att02, String wert02, String att03, String wert03, String att04, String wert04, String boo, String wertBoo){
        if (tabelle == 0) {
            if (anzahl == 1){
                System.out.println("SELECT * " +
                        "FROM LN_UB_Hafen " +
                        "WHERE " +att01+ " LIKE " +wert01+ ";");
                sqlControll.processSQLMitRueckgabe("SELECT * " +
                        "FROM LN_UB_Hafen " +
                        "WHERE " +att01+ " LIKE " +wert01+ ";");
            }else if (anzahl == 2){
                sqlControll.processSQLMitRueckgabe("SELECT * " +
                        "FROM LN_UB_Hafen " +
                        "WHERE " +att01+ " LIKE " +wert01+ " AND " +att02+ " LIKE " +wert02+ ";");
            }else if (anzahl == 3){
                sqlControll.processSQLMitRueckgabe("SELECT * " +
                        "FROM LN_UB_Hafen " +
                        "WHERE " +att01+ " LIKE " +wert01+ " AND " +att02+ " LIKE " +wert02+ " AND " +att03+ " LIKE " +wert03+";");
            }else if (anzahl == 4){
                sqlControll.processSQLMitRueckgabe("SELECT * " +
                        "FROM LN_UB_Hafen " +
                        "WHERE " +att01+ " LIKE " +wert01+ " AND " +att02+ " LIKE " +wert02+ " AND " +att03+ " LIKE " +wert03+ " AND " +att04+ " LIKE " +wert04+";");
            }else if (anzahl == 5){
                sqlControll.processSQLMitRueckgabe("SELECT * " +
                        "FROM LN_UB_Hafen " +
                        "WHERE " +att01+ " LIKE " +wert01+ " AND " +att02+ " LIKE " +wert02+ " AND " +att03+ " LIKE " +wert03+ " AND " +att04+ " LIKE " +wert04+ " AND " +boo+ " LIKE " +wertBoo+";");
            }
        }else if (tabelle == 1){
            if (anzahl == 1){

                sqlControll.processSQLMitRueckgabe("SELECT * " +
                        "FROM ((LN_UB_UBoote " +
                        "JOIN LN_UB_Hafen ON LN_UB_UBoote.Hafen = LN_UB_Hafen.ID) " +
                        "JOIN LN_UB_Typen ON LN_UB_UBoote.Typ = LN_UB_Typen.Typ) " +
                        "JOIN LN_UB_Mission ON LN_UB_UBoote.Mission = LN_UB_Mission.ID " +
                        "WHERE " +att01+ " LIKE " +wert01+ ";");
            }else if (anzahl == 2){
                sqlControll.processSQLMitRueckgabe("SELECT * " +
                        "FROM ((LN_UB_UBoote " +
                        "JOIN LN_UB_Hafen ON LN_UB_UBoote.Hafen = LN_UB_Hafen.ID) " +
                        "JOIN LN_UB_Typen ON LN_UB_UBoote.Typ = LN_UB_Typen.Typ) " +
                        "JOIN LN_UB_Mission ON LN_UB_UBoote.Mission = LN_UB_Mission.ID " +
                        "WHERE " +att01+ " LIKE " +wert01+ " AND " +att02+ " LIKE " +wert02+ ";");
            }else if (anzahl == 3){
                sqlControll.processSQLMitRueckgabe("SELECT * " +
                        "FROM ((LN_UB_UBoote " +
                        "JOIN LN_UB_Hafen ON LN_UB_UBoote.Hafen = LN_UB_Hafen.ID) " +
                        "JOIN LN_UB_Typen ON LN_UB_UBoote.Typ = LN_UB_Typen.Typ) " +
                        "JOIN LN_UB_Mission ON LN_UB_UBoote.Mission = LN_UB_Mission.ID " +
                        "WHERE " +att01+ " LIKE " +wert01+ " AND " +att02+ " LIKE " +wert02+ " AND " +att03+ " LIKE " +wert03+";");
            }else if (anzahl == 4){
                sqlControll.processSQLMitRueckgabe("SELECT * " +
                        "FROM ((LN_UB_UBoote " +
                        "JOIN LN_UB_Hafen ON LN_UB_UBoote.Hafen = LN_UB_Hafen.ID) " +
                        "JOIN LN_UB_Typen ON LN_UB_UBoote.Typ = LN_UB_Typen.Typ) " +
                        "JOIN LN_UB_Mission ON LN_UB_UBoote.Mission = LN_UB_Mission.ID " +
                        "WHERE " +att01+ " LIKE " +wert01+ " AND " +att02+ " LIKE " +wert02+ " AND " +att03+ " LIKE " +wert03+ " AND " +att04+ " LIKE " +wert04+";");
            }else if (anzahl == 5){
                sqlControll.processSQLMitRueckgabe("SELECT * " +
                        "FROM ((LN_UB_UBoote " +
                        "JOIN LN_UB_Hafen ON LN_UB_UBoote.Hafen = LN_UB_Hafen.ID) " +
                        "JOIN LN_UB_Typen ON LN_UB_UBoote.Typ = LN_UB_Typen.Typ) " +
                        "JOIN LN_UB_Mission ON LN_UB_UBoote.Mission = LN_UB_Mission.ID " +
                        "WHERE " +att01+ " LIKE " +wert01+ " AND " +att02+ " LIKE " +wert02+ " AND " +att03+ " LIKE " +wert03+ " AND " +att04+ " LIKE " +wert04+ " AND " +boo+ " LIKE " +wertBoo+";");
            }
        }else if (tabelle == 2){
            if (anzahl == 1){
                System.out.println("SELECT * " +
                        "FROM LN_UB_Person " +
                        "JOIN LN_UB_UBoote ON  LN_UB_Person.UBootNummer = LN_UB_UBoote.Kennnummer " +
                        "WHERE " +att01+ " LIKE " +wert01+ ";");
                sqlControll.processSQLMitRueckgabe("SELECT * " +
                        "FROM LN_UB_Person " +
                        "JOIN LN_UB_UBoote ON  LN_UB_Person.UBootNummer = LN_UB_UBoote.Kennnummer " +
                        "WHERE " +att01+ " LIKE " +wert01+ ";");
            }else if (anzahl == 2){
                sqlControll.processSQLMitRueckgabe("SELECT * " +
                        "FROM LN_UB_Person " +
                        "JOIN LN_UB_UBoote ON  LN_UB_Person.UBootNummer = LN_UB_UBoote.Kennnummer " +
                        "WHERE " +att01+ " LIKE " +wert01+ " AND " +att02+ " LIKE " +wert02+ ";");
            }else if (anzahl == 3){
                sqlControll.processSQLMitRueckgabe("SELECT * " +
                        "FROM LN_UB_Person " +
                        "JOIN LN_UB_UBoote ON  LN_UB_Person.UBootNummer = LN_UB_UBoote.Kennnummer " +
                        "WHERE " +att01+ " LIKE " +wert01+ " AND " +att02+ " LIKE " +wert02+ " AND " +att03+ " LIKE " +wert03+";");
            }else if (anzahl == 4){
                sqlControll.processSQLMitRueckgabe("SELECT * " +
                        "FROM LN_UB_Person " +
                        "JOIN LN_UB_UBoote ON  LN_UB_Person.UBootNummer = LN_UB_UBoote.Kennnummer " +
                        "WHERE " +att01+ " LIKE '" +wert01+ "' AND " +att02+ " LIKE '" +wert02+ "' AND " +att03+ " LIKE " +wert03+ " AND " +att04+ " LIKE " +wert04+";");
            }else if (anzahl == 5){
                sqlControll.processSQLMitRueckgabe("SELECT * " +
                        "FROM LN_UB_Person " +
                        "JOIN LN_UB_UBoote ON  LN_UB_Person.UBootNummer = LN_UB_UBoote.Kennnummer " +
                        "WHERE " +att01+ " LIKE " +wert01+ " AND " +att02+ " LIKE " +wert02+ " AND " +att03+ " LIKE " +wert03+ " AND " +att04+ " LIKE " +wert04+ " AND " +boo+ " LIKE " +wertBoo+";");
            }
        }else if (tabelle == 3){
            if (anzahl == 1){
                sqlControll.processSQLMitRueckgabe("SELECT * " +
                        "FROM LN_UB_Mission " +
                        "WHERE " +att01+ " LIKE " +wert01+ ";");
            }else if (anzahl == 2){
                sqlControll.processSQLMitRueckgabe("SELECT * " +
                        "FROM LN_UB_Mission " +
                        "WHERE " +att01+ " LIKE " +wert01+ " AND " +att02+ " LIKE " +wert02+ ";");
            }else if (anzahl == 3){
                sqlControll.processSQLMitRueckgabe("SELECT * " +
                        "FROM LN_UB_Mission " +
                        "WHERE " +att01+ " LIKE " +wert01+ " AND " +att02+ " LIKE " +wert02+ " AND " +att03+ " LIKE " +wert03+";");
            }else if (anzahl == 4){
                sqlControll.processSQLMitRueckgabe("SELECT * " +
                        "FROM LN_UB_Mission " +
                        "WHERE " +att01+ " LIKE " +wert01+ " AND " +att02+ " LIKE " +wert02+ " AND " +att03+ " LIKE " +wert03+ " AND " +att04+ " LIKE " +wert04+";");
            }
        }else if (tabelle == 4){
            if (anzahl == 1){
                sqlControll.processSQLMitRueckgabe("SELECT * " +
                        "FROM LN_UB_Feinde " +
                        "WHERE " +att01+ " LIKE " +wert01+ ";");
            }else if (anzahl == 2){
                sqlControll.processSQLMitRueckgabe("SELECT * " +
                        "FROM LN_UB_Feinde " +
                        "WHERE " +att01+ " LIKE " +wert01+ " AND " +att02+ " LIKE " +wert02+ ";");
            }else if (anzahl == 3){
                sqlControll.processSQLMitRueckgabe("SELECT * " +
                        "FROM LN_UB_Feinde " +
                        "WHERE " +att01+ " LIKE " +wert01+ " AND " +att02+ " LIKE " +wert02+ " AND " +att03+ " LIKE " +wert03+";");
            }else if (anzahl == 4){
                sqlControll.processSQLMitRueckgabe("SELECT * " +
                        "FROM LN_UB_Feinde " +
                        "WHERE " +att01+ " LIKE " +wert01+ " AND " +att02+ " LIKE " +wert02+ " AND " +att03+ " LIKE " +wert03+ " AND " +att04+ " LIKE " +wert04+";");
            }
        }else if (tabelle == 5){
            if (anzahl == 1){
                sqlControll.processSQLMitRueckgabe("SELECT * " +
                        "FROM LN_UB_Typen " +
                        "WHERE " +att01+ " LIKE " +wert01+ ";");
            }else if (anzahl == 2){
                sqlControll.processSQLMitRueckgabe("SELECT * " +
                        "FROM LN_UB_Typen " +
                        "WHERE " +att01+ " LIKE " +wert01+ " AND " +att02+ " LIKE " +wert02+ ";");
            }else if (anzahl == 3){
                sqlControll.processSQLMitRueckgabe("SELECT * " +
                        "FROM LN_UB_Typen " +
                        "WHERE " +att01+ " LIKE " +wert01+ " AND " +att02+ " LIKE " +wert02+ " AND " +att03+ " LIKE " +wert03+";");
            }else if (anzahl == 4){
                sqlControll.processSQLMitRueckgabe("SELECT * " +
                        "FROM LN_UB_Typen " +
                        "WHERE " +att01+ " LIKE " +wert01+ " AND " +att02+ " LIKE " +wert02+ " AND " +att03+ " LIKE " +wert03+ " AND " +att04+ " LIKE " +wert04+";");
            }
        }
    }
    
    public void veraendereObjekt(int tabelle, String attribut, String wozu, String id){
        if (tabelle == 0){
            System.out.println(sqlControll.processSQL("UPDATE LN_UB_Hafen SET " +attribut+ " = " +wozu+ " WHERE ID = '" +id+ "';"));
        }else if (tabelle == 1){
            sqlControll.processSQL("UPDATE LN_UB_UBoote SET " +attribut+ " = " +wozu+ " WHERE Kennnummer = '" +id+ "';");
        }else if (tabelle == 2){
            sqlControll.processSQL("UPDATE LN_UB_Person SET " +attribut+ " = " +wozu+ " WHERE ID = '" +id+ "';");
        }else if (tabelle == 3){
            sqlControll.processSQL("UPDATE LN_UB_Mission SET " +attribut+ " = " +wozu+ " WHERE ID = '" +id+ "';");
        }else if (tabelle == 4){
            sqlControll.processSQL("UPDATE LN_UB_Feinde SET " +attribut+ " = " +wozu+ " WHERE ID = '" +id+ "';");
        }else if (tabelle == 5){
            sqlControll.processSQL("UPDATE LN_UB_Typen SET " +attribut+ " = " +wozu+ " WHERE Typ = '" +id+ "';");
        }
    }

    public void loescheObjekt(int tabelle,String id){
        if (tabelle == 0){
            sqlControll.processSQL("DELETE FROM LN_UB_Hafen WHERE ID = '" +id+ "';");
        }else if (tabelle == 1){
            sqlControll.processSQL("DELETE FROM LN_UB_UBoote WHERE Kennnummer = '" +id+ "';");
        }else if (tabelle == 2){
            sqlControll.processSQL("DELETE FROM LN_UB_Person WHERE ID = '" +id+ "';");
        }else if (tabelle == 3){
            sqlControll.processSQL("DELETE FROM LN_UB_Mission WHERE ID = '" +id+ "';");
        }else if (tabelle == 4){
            sqlControll.processSQL("DELETE FROM LN_UB_Feinde WHERE ID = '" +id+ "';");
        }else if (tabelle == 5){
            sqlControll.processSQL("DELETE FROM LN_UB_Typen WHERE Typ = '" +id+ "';");
        }
    }

}
